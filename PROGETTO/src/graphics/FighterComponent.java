package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import attackable.Fighter;

/**
 * Draw a Fighter with relate components.
 * @author Mattia Rosselli
 *
 */
public class FighterComponent extends JComponent {
	private Fighter fighter;
	private double heal;
	private double strength;
	private Dimension dimension;
	private String team;
	private double energy;

	/**
	 * Create the component of a given Fighter
	 * @param fig Fighter to draw
	 * @param dFrame Frame Dimension
	 * @param dArray Array Dimension
	 */
	public FighterComponent(Fighter fig, Dimension dFrame, Dimension dArray) {
		super();
		energy = fig.getEnergy();
		strength = fig.getStrength();
		heal = fig.getHealth();
		Double height, width;
		width = (dFrame.getWidth() / (dArray.getWidth() + 1));
		height = (dFrame.getHeight() / (dArray.getHeight() + 1));
		dimension = new Dimension(width.intValue(), height.intValue());
		team = fig.getTeam();

	}



	@Override
	public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		

		BufferedImage immagine = null;
		String projectPath = System.getProperty("user.dir");
		try {
			if (heal > 0)
				immagine = ImageIO.read(new File(projectPath + "\\src\\attackable\\fighter.png"));
			else
				immagine = ImageIO.read(new File(projectPath + "\\src\\attackable\\dead.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
		g2.drawImage(immagine, 0, 0, (dimension.width), (dimension.height), null);
		new HealthComponent(heal, dimension.getWidth()).paintComponent(g2);
		new StrengthComponent(strength, dimension.getWidth()).paintComponent(g2);
		new TeamComponent(team, dimension.getWidth()).paintComponent(g2);
		new EnergyComponent(energy, dimension.getWidth()).paintComponent(g2);
	}
}