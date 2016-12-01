package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import attackable.Fighter;
import attackable.Robot;
import attackable.Worker;
import match.Team;

/**
 * Panel with the stats of the teams
 * @author Mattia Rosselli
 *
 */
public class InfoGraphic extends JPanel {
	private GameBoardGraphics gB;
	private ArrayList<Team> team;

	/**
	 * Create the InfoGraphic for the teams on the Board
	 * @param gameB GameBoard
	 * @param teams Teams
	 */
	public InfoGraphic(GameBoardGraphics gameB, ArrayList<Team> teams) {
		super();
		this.setBackground(Color.BLACK);
		gB = gameB;
		team = teams;
		this.update();
	}

	/**
	 * Get the new stats of the component
	 */
	public void update() {
		this.removeAll();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		Robot r;
		int j = 1;
		c.gridy = 0;
		JLabel title = new JLabel("Robots");
		title.setForeground(Color.RED);
		title.setFont(new Font("Calibri", Font.PLAIN, 24));
		this.add(title);
		for (Team t : team) {
			JPanel teamPanel = new JPanel(new GridLayout(t.getSize(), 1));
			teamPanel.setBackground(Color.black);
			for (int i = 0; i < t.getSize(); i++) {
				r = t.getController(i).getRobot();
				JPanel rob = new JPanel(new GridLayout(1, 2));
				JPanel labels = new JPanel(new GridLayout(6, 1));
				JLabel name = new JLabel(t.getController(i).getRobot().getName());
				JLabel health = new JLabel("Health:" + r.getHealth());
				JLabel strength = new JLabel("Strength:" + r.getStrength());
				JLabel energy = new JLabel("Energy:" + r.getEnergy());
				labels.add(name);
				labels.add(health);
				labels.add(strength);
				labels.add(energy);
				if (r.getClass().getName().contains("Fighter")) {
					Fighter temp = (Fighter) r;
					JLabel stats = new JLabel("ATK:" + temp.getAttack() + "DEF:" + temp.getDefense());
					labels.add(stats);
					JLabel pos = new JLabel("Pos:" + temp.getPosition().getX() + " ; " + temp.getPosition().getY());
					labels.add(pos);
					rob.add(new FighterComponent(temp, new Dimension(600, 300), new Dimension(6, 1)));
					rob.add(labels);
					rob.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				} else {
					Worker temp = (Worker) r;
					JLabel stats = new JLabel("REP:" + temp.getReapairingRate() + "DEF:" + temp.getDefense());
					labels.add(stats);
					JLabel pos = new JLabel("Pos:" + temp.getPosition().getX() + " ; " + temp.getPosition().getY());
					labels.add(pos);
					rob.add(new WorkerComponent(temp, new Dimension(600, 300), new Dimension(6, 1)));
					rob.add(labels);

					rob.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				}

				teamPanel.add(rob);
			}
			if (t.getController(0).getClass().getName().contains("Automated")) {
				teamPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED),t.getName() + "-PC"));
			} else
				teamPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED),t.getName()));
			c.gridy = j;
			j++;
			this.add(teamPanel, c);
		}
	}

}
