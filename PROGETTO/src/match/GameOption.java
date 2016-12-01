package match;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import attackable.Fighter;
import attackable.Worker;
import board.GameBoard;

/**
 * Class that manages the game options
 * @author Mattia Rosselli
 *
 */


public class GameOption {
	private boolean gameMode;
	private boolean nuo;
	private ArrayList<Team> teams;
	private int width;
	private int height;
	private boolean chosen;

	/**
	 * New istance of GameOption
	 */
	public GameOption() {
		// TODO Auto-generated constructor stub
		chosen = false;
		nuo = true;
	}

	/**
	 * Get the panel with team Option
	 * @return Panel to choose team options
	 */
	public JPanel createTeam() {
		JPanel teamPanel = new JPanel(new GridBagLayout());
		teamPanel.setBackground(Color.black);
		teams = new ArrayList<Team>();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		JLabel tLabel = new JLabel("Player 1 select a team:");
		tLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		tLabel.setForeground(Color.RED);
		c.gridy++;
		teamPanel.add(tLabel, c);
		ButtonGroup tRadio = new ButtonGroup();
		JRadioButton green = new JRadioButton("GREEN");
		green.setForeground(Color.GREEN);
		green.setBackground(Color.BLACK);
		JRadioButton yellow = new JRadioButton("YELLOW");
		yellow.setForeground(Color.YELLOW);
		yellow.setBackground(Color.BLACK);
		JRadioButton red = new JRadioButton("RED");
		red.setForeground(Color.RED);
		red.setBackground(Color.BLACK);
		JRadioButton pink = new JRadioButton("PINK");
		pink.setForeground(Color.PINK);
		pink.setBackground(Color.BLACK);
		tRadio.add(green);
		tRadio.add(pink);
		tRadio.add(yellow);
		tRadio.add(red);
		JPanel tRadioPanel = new JPanel();
		tRadioPanel.setBackground(Color.BLACK);
		tRadioPanel.add(green);
		tRadioPanel.add(yellow);
		tRadioPanel.add(red);
		tRadioPanel.add(pink);
		green.setSelected(true);
		c.gridy++;
		teamPanel.add(tRadioPanel, c);
		JLabel fLabel = new JLabel("Digit the name of your Fighter:");
		fLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		fLabel.setForeground(Color.RED);
		JTextField fName = new JTextField("Fighter1");
		fName.setToolTipText("Digit name");
		JLabel wLabel = new JLabel("Digit the name of your Worker:");
		wLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		wLabel.setForeground(Color.RED);
		JTextField wName = new JTextField("Worker1");
		wName.setToolTipText("Digit name");
		c.gridy++;
		teamPanel.add(fLabel, c);
		c.gridy++;
		teamPanel.add(fName, c);
		c.gridy++;
		teamPanel.add(wLabel, c);
		c.gridy++;
		teamPanel.add(wName, c);
		if (gameMode) {

			JButton continua = new JButton("Start Match!");
			continua.setBackground(new Color(169, 125, 66));
			continua.setForeground(Color.white);
			continua.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Team team1 = null;
					if (green.isSelected())
						team1 = new Team("GREEN");
					else if (yellow.isSelected())
						team1 = new Team("YELLOW");
					else if (red.isSelected())
						team1 = new Team("RED");
					else if (pink.isSelected())
						team1 = new Team("PINK");
					team1.addController(new Controller(new Fighter(fName.getText())));
					team1.addController(new Controller(new Worker(wName.getText())));
					Team team2 = null;
					if (!green.isSelected())
						team2 = new Team("GREEN");
					else if (!yellow.isSelected())
						team2 = new Team("YELLOW");
					else if (!red.isSelected())
						team2 = new Team("RED");
					else if (!pink.isSelected())
						team2 = new Team("PINK");

					team2.addController(new AutomatedController(new Fighter("Fighter-PC")));
					team2.addController(new AutomatedController(new Worker("Worker-PC")));
					teams.add(team1);
					teams.add(team2);
					chosen = true;

				}

			});
			c.gridy++;
			teamPanel.add(continua, c);
		} else {
			GridBagConstraints b = new GridBagConstraints();
			b.fill = GridBagConstraints.BOTH;
			b.insets = new Insets(10, 10, 0, 0);
			b.gridx = 1;
			JLabel tLabel1 = new JLabel("Player 2 select a team:");
			tLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
			tLabel1.setForeground(Color.RED);
			b.gridy++;
			teamPanel.add(tLabel1, b);
			ButtonGroup tRadio1 = new ButtonGroup();
			JRadioButton green1 = new JRadioButton("GREEN");
			green1.setForeground(Color.GREEN);
			green1.setBackground(Color.BLACK);
			JRadioButton yellow1 = new JRadioButton("YELLOW");
			yellow1.setForeground(Color.YELLOW);
			yellow1.setBackground(Color.BLACK);
			JRadioButton red1 = new JRadioButton("RED");
			red1.setForeground(Color.RED);
			red1.setBackground(Color.BLACK);
			JRadioButton pink1 = new JRadioButton("PINK");
			pink1.setForeground(Color.PINK);
			pink1.setBackground(Color.BLACK);
			tRadio1.add(green1);
			tRadio1.add(pink1);
			tRadio1.add(yellow1);
			tRadio1.add(red1);
			JPanel tRadioPanel1 = new JPanel();
			tRadioPanel1.setBackground(Color.BLACK);
			tRadioPanel1.add(green1);
			tRadioPanel1.add(yellow1);
			tRadioPanel1.add(red1);
			tRadioPanel1.add(pink1);
			yellow1.setSelected(true);
			b.gridy++;
			teamPanel.add(tRadioPanel1, b);
			JLabel fLabel1 = new JLabel("Digit the name of your Fighter:");
			fLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
			fLabel1.setForeground(Color.RED);
			JTextField fName1 = new JTextField("Fighter2");
			fName1.setToolTipText("Digit name");
			JLabel wLabel1 = new JLabel("Digit the name of your Worker:");
			wLabel1.setFont(new Font("Calibri", Font.PLAIN, 24));
			wLabel1.setForeground(Color.RED);
			JTextField wName1 = new JTextField("Worker2");
			wName1.setToolTipText("Digit name");
			b.gridy++;
			teamPanel.add(fLabel1, b);
			b.gridy++;
			teamPanel.add(fName1, b);
			b.gridy++;
			teamPanel.add(wLabel1, b);
			b.gridy++;
			teamPanel.add(wName1, b);
			JButton continua = new JButton("Start Match!");
			continua.setBackground(new Color(169, 125, 66));
			continua.setForeground(Color.white);
			continua.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Team team1 = null;
					if (green.isSelected())
						team1 = new Team("GREEN");
					else if (yellow.isSelected())
						team1 = new Team("YELLOW");
					else if (red.isSelected())
						team1 = new Team("RED");
					else if (pink.isSelected())
						team1 = new Team("PINK");
					team1.addController(new Controller(new Fighter(fName.getText())));
					team1.addController(new Controller(new Worker(wName.getText())));
					Team team2 = null;
					if (green1.isSelected())
						team2 = new Team("GREEN");
					else if (yellow1.isSelected())
						team2 = new Team("YELLOW");
					else if (red1.isSelected())
						team2 = new Team("RED");
					else if (pink1.isSelected())
						team2 = new Team("PINK");

					team2.addController(new Controller(new Fighter(fName1.getText())));
					team2.addController(new Controller(new Worker(wName1.getText())));
					teams.add(team1);
					teams.add(team2);
					chosen = true;

				}

			});
			b.gridy++;
			teamPanel.add(continua, b);
		}
		return teamPanel;
	}

	/**
	 * Returns a new GameBoard
	 * @return  A GameBoard
	 */
	public GameBoard getBoard() {
		return new GameBoard(width, height);
	}

	/**
	 * Returns a boolean that indicates if all options have been chosen
	 * @return a flag that indicates if everything has been chosen
	 */
	public boolean getChosen() {

		return chosen;
	}

	/**
	 * @return false if the match is 1VS1
	 */
	public boolean getMode() {
		return gameMode;
	}
	
	/**
	 * Get a flag that indicates if it's a new game
	 
	 * @return flag that indicates if it's a new game
	 */
	public boolean getNuo() {
		return nuo;
	}
	
	/**
	 * Get the team list
	 * @return team list
	 */
	public ArrayList<Team> getTeam() {
		return teams;
	}

	/**
	 * Returns a panel to choose  game options
	 * @return a JPanel to choose game options
	 */
	public JPanel selectMode() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		JPanel modePanel = new JPanel(new GridBagLayout());
		modePanel.setBackground(Color.black);
		ButtonGroup mode = new ButtonGroup();
		JRadioButton vs = new JRadioButton("1 VS 1");
		JRadioButton pc = new JRadioButton("1 VS PC");
		vs.setForeground(Color.WHITE);
		pc.setForeground(Color.WHITE);
		vs.setBackground(Color.BLACK);
		pc.setBackground(Color.BLACK);
		c.insets = new Insets(10, 0, 0, 0);

		c.anchor = GridBagConstraints.CENTER;
		JPanel radio = new JPanel();
		JLabel info = new JLabel("Seleziona the mode:");
		info.setFont(new Font("Calibri", Font.PLAIN, 24));
		info.setForeground(Color.RED);
		info.setBackground(Color.BLACK);
		modePanel.add(info, c);
		c.gridy = 1;
		mode.add(vs);
		mode.add(pc);
		vs.setSelected(true);
		radio.add(vs);
		radio.add(pc);
		radio.setBackground(Color.BLACK);
		modePanel.add(radio, c);
		JLabel taglia = new JLabel("Digit field dimension:");
		taglia.setFont(new Font("Calibri", Font.PLAIN, 24));
		taglia.setForeground(Color.RED);
		taglia.setBackground(Color.BLACK);
		JPanel misure = new JPanel(new GridLayout(2, 2));
		JLabel xLabel = new JLabel("Width(min:5):");
		xLabel.setForeground(Color.WHITE);
		JLabel yLabel = new JLabel("Height(min:5):");
		yLabel.setForeground(Color.WHITE);
		misure.add(xLabel);
		misure.add(yLabel);
		JTextField x = new JTextField("10");
		x.setToolTipText("Larghezza");
		JTextField y = new JTextField("10");
		y.setToolTipText("Lunghezza");
		c.gridy++;
		modePanel.add(taglia, c);
		c.gridy++;
		misure.setBackground(Color.BLACK);
		misure.add(x);
		misure.add(y);
		modePanel.add(misure, c);
		JButton continua = new JButton("Continue");
		continua.setBackground(new Color(169, 125, 66));
		continua.setForeground(Color.white);
		continua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (vs.isSelected())
					gameMode = false;
				else
					gameMode = true;
				int tempx = (int) Double.parseDouble(x.getText());
				int tempy = (int) Double.parseDouble(y.getText());

				width = tempx > 5 ? tempx : 5;
				height = tempy > 5 ? tempy : 5;
				modePanel.removeAll();
				JPanel teamPanel = createTeam();
				modePanel.add(teamPanel);
				modePanel.validate();
				modePanel.repaint();

			}

		});
		c.gridy++;
		modePanel.add(continua, c);
		return modePanel;
	}

	public void setNuo(boolean flag) {
		nuo = flag;
		;
	}
}
