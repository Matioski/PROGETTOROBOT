package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Draws graphically the Strength
 * @author Mattia Rosselli
 *
 */
public class StrengthComponent extends JComponent {
	private double strength;
	private double width;

	/**
	 * Creates a new strength component
	 * @param s Strength
	 * @param width Width
	 */
	public StrengthComponent(double s, double width) {
		super();

		strength = s;

		this.width = width;

	}

	@Override
	public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double coloredBar = new Rectangle2D.Double(2D, 7D, ((width - 4) / 100F * strength), 3F);
		
		g2.setPaint(Color.CYAN);		
		g2.fill(coloredBar);
		g2.draw(coloredBar);

	}
}
