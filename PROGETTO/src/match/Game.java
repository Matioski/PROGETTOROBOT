package match;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import board.GameBoard;

/**
 * Main class of the game
 * @author Mattia Rosselli
 *
 */
public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame game = new JFrame();
		game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		game.setSize(800, 500);
		game.setTitle("Robot Apocalypse");
		JPanel intro = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		BufferedImage immagine = null;
		String projectPath = System.getProperty("user.dir");
		try {
			immagine = ImageIO.read(new File(projectPath + "\\src\\match\\logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
		JLabel picLabel = new JLabel(new ImageIcon(immagine));
		intro.add(picLabel, c);
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		JButton nuovo = new JButton("New Game");
		nuovo.setPreferredSize(new Dimension(100, 50));
		nuovo.setBackground(new Color(169, 125, 66));
		nuovo.setForeground(Color.white);
		intro.setBackground(Color.BLACK);
		JButton load = new JButton("Load Game");
		load.setForeground(Color.white);
		load.setPreferredSize(new Dimension(100, 50));
		load.setBackground(new Color(169, 125, 66));
		intro.add(nuovo, c);
		c.gridy = 2;
		c.insets = new Insets(10, 0, 10, 0);
		File saveTeam = new File("team.dat");
		File saveBoard = new File("board.dat");
		if (!saveTeam.exists() || !saveBoard.exists())
			load.setEnabled(false);
		GameOption op = new GameOption();

		nuovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				game.getContentPane().removeAll();

				JPanel option = op.selectMode();

				game.add(option);
				game.setVisible(true);

			}

		});
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				op.setNuo(false);
			}
		});
		intro.add(load, c);
		game.add(intro);
		game.setVisible(true);
		if (op.getNuo()) {
			while (!op.getChosen()) {
				if (!op.getNuo()) {
					if (saveBoard.exists() && saveTeam.exists()) {
						FileInputStream fileStreamTeam;
						FileInputStream fileStreamBoard;
						try {
							fileStreamTeam = new FileInputStream(saveTeam);
							ObjectInputStream team = new ObjectInputStream(fileStreamTeam);
							ArrayList<Team> dataTeam = (ArrayList<Team>) team.readObject();
							fileStreamTeam.close();
							fileStreamBoard = new FileInputStream(saveBoard);
							ObjectInputStream board = new ObjectInputStream(fileStreamBoard);
							GameBoard dataBoard = (GameBoard) board.readObject();
							fileStreamTeam.close();
							game.dispose();
							Match match = new Match(dataTeam, dataBoard);
							match.play();
						} catch (FileNotFoundException e) {

							e.printStackTrace();
						} catch (IOException e) {

							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			game.dispose();
			Match match = new Match(op.getTeam(), op.getBoard());
			match.play();
		} else {

		}
	}

}
