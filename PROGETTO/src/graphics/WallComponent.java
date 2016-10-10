package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import board.Position;
import positionable.Wall;

/**
 * Class that manage wall Components
 * @author Mattia Rosselli
 *
 */
public class WallComponent extends JComponent {
	private Position pos;

	private Dimension dimension;

	/**
	 * Creates a wall component with defined dimensions
	 * @param wall Object
	 * @param dFrame frame dimension
	 * @param dArray array dimension
	 */
	public WallComponent(Wall wall, Dimension dFrame, Dimension dArray) {
		super();

		pos = wall.getPosition();

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
			immagine = ImageIO.read(new File(projectPath + "\\src\\board\\download.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
		
		g2.drawImage(immagine, 0, 0, (dimension.width), (dimension.height), null);

	}
}