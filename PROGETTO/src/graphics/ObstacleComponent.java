package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import attackable.Obstacle;

/**
 * Component of an Obstacle
 * @author Mattia Rosselli
 *
 */
public class ObstacleComponent extends JComponent {

	private double heal;
	private Dimension dimension;
	private double weight;

	/**
	 * Creates new Component for the given Obstacle
	 * @param fig Obstacle
	 */
	public ObstacleComponent(Obstacle fig) {
		super();
		heal = fig.getHealth();
		weight = fig.getWeight();
	}
	/**
	 * Creates new Component for the given Obstacle
	 * @param ob Obstacle
	 * @param dFrame Frame dimension
	 * @param dArray Array dimension
	 */
	public ObstacleComponent(Obstacle ob, Dimension dFrame, Dimension dArray) {
		super();
		weight = ob.getWeight();
		heal = ob.getHealth();
		Double height, width;
		width = (dFrame.getWidth() / (dArray.getWidth() + 1));
		height = (dFrame.getHeight() / (dArray.getHeight() + 1));
		dimension = new Dimension(width.intValue(), height.intValue());

	}



	@Override
	public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
	

		BufferedImage immagine = null;
		String projectPath = System.getProperty("user.dir");
		try {
			immagine = ImageIO.read(new File(projectPath + "\\src\\board\\obstacle.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}

		
		g2.drawImage(immagine, 0, 0, (dimension.width), (dimension.height), null);
		new HealthComponent(heal, dimension.getWidth()).paintComponent(g2);
		new WeightComponent(weight, dimension.getWidth()).paintComponent(g2);

	
	}
}