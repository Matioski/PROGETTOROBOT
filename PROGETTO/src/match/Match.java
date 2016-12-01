package match;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import board.GameBoard;
import graphics.GameBoardGraphics;
import graphics.InfoGraphic;

/**
 * Class that manage all the match
 * @author Mattia Rosselli
 *
 */
public class Match implements Serializable {

	private ArrayList<Team> team;
	private GameBoard board;
	private JFrame frame;

	/**
	 * creates a new match
	 * @param teams Teams to insert
	 * @param gB GameBoard to generate
	 */
	public Match(ArrayList<Team> teams, GameBoard gB) {

		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setTitle("Robot Apocalypse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = gB;
		team = teams;
		board.fill();
		for (Team t : team) {
			for (int i = 0; i < t.getSize(); i++) {
				board.addPositionableRandomly(t.getController(i).getRobot());
			}
		}
	}


	/**
	 * Methods that has to be invoked in order to play
	 */
	public void play() {
		GameBoardGraphics boardGraphics = new GameBoardGraphics(board, board.getWidth(), board.getHeight());
		Round m = new Round(team, boardGraphics);

		JPanel boardPanel = boardGraphics.getFrame(frame.getSize());
		// frame.addComponentListener(new ResizeMapListener(boardPanel, frame,
		// boardGraphics));
		frame.addComponentListener(new ResizeMapListener(boardPanel, frame, boardGraphics));
		InfoGraphic info = new InfoGraphic(boardGraphics, team);

		while (m.teamDead() == null) {
			m.fillControllers();
			do {
				JPanel moves;

				moves = m.nextController();

				frame.getContentPane().removeAll();
				frame.add(boardPanel, BorderLayout.CENTER);
				frame.add(moves, BorderLayout.SOUTH);
				frame.add(info, BorderLayout.WEST);
				frame.getContentPane().validate();
				frame.getContentPane().repaint();
				frame.setVisible(true);
				synchronized (m.getCurrent().getCon()) {

					try {

						moves = m.getCurrent();
						m.getCurrent().getCon().wait();

						frame.getContentPane().remove(moves);

						frame.add(moves, BorderLayout.SOUTH);

						frame.setVisible(true);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					;
				}

				if (m.allChosen()) {
					m.performRandom();

					boardPanel = boardGraphics.getFrame(frame.getSize());
					frame.getContentPane().removeAll();

					info.update();
					frame.add(info, BorderLayout.WEST);
					frame.add(boardPanel, BorderLayout.CENTER);
					frame.add(moves, BorderLayout.SOUTH);

					frame.setVisible(true);
				}

			} while (!m.getPerformed());
			boardPanel = boardGraphics.getFrame(frame.getSize());
			File fileT = new File("team.dat");
			File fileB = new File("board.dat");
			try {
				FileOutputStream fileStream;
				fileStream = new FileOutputStream(fileT);
				ObjectOutputStream dataTeam = new ObjectOutputStream(fileStream);

				dataTeam.writeObject(m.getTeams());
				fileStream.close();
				fileStream = new FileOutputStream(fileB);
				ObjectOutputStream dataBoard = new ObjectOutputStream(fileStream);

				dataBoard.writeObject(board);
				fileStream.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		JOptionPane.showMessageDialog(null, m.teamDead(), m.teamDead() + " is dead ", JOptionPane.INFORMATION_MESSAGE);
		frame.getContentPane().removeAll();
		JPanel fine = new JPanel();
		JLabel vincitore = new JLabel();
		String winner = null;
		for (Team t : team) {
			if (!t.allDeads())
				winner = t.getName();
		}
		vincitore.setText(winner + " hai sconfitto " + m.teamDead() + "!");
		vincitore.setFont(new Font("Calibri", Font.PLAIN, 24));
		vincitore.setForeground(Color.RED);
		BufferedImage immagine = null;
		String projectPath = System.getProperty("user.dir");
		try {
			immagine = ImageIO.read(new File(projectPath + "\\src\\match\\winner.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
		JLabel picLabel = new JLabel(new ImageIcon(immagine));
		File fileT = new File("team.dat");
		File fileB = new File("board.dat");
		if(fileT.exists()){
			fileT.delete();
		}
		if(fileB.exists()){
			fileB.delete();
		}
		
		fine.setBackground(Color.BLACK);
		picLabel.setBackground(Color.BLACK);
		vincitore.setBackground(Color.BLACK);
		fine.add(picLabel, BorderLayout.CENTER);
		fine.add(vincitore, BorderLayout.SOUTH);
		frame.add(fine, BorderLayout.CENTER);
		fine.validate();
		fine.repaint();
		frame.setVisible(true);
	}

}
