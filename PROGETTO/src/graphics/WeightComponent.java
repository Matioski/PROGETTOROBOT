package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Class that manage weight components
 * @author Mattia Rosselli
 *
 */
public class WeightComponent extends JComponent {
	private double weight;
	private double width;

	/**
	 * Constructs a weight component with the given weight
	 * @param w weight
	 * @param width width
	 */
	public WeightComponent(double w, double width) {
		super();

		weight = w;

		this.width = width;

	}

	@Override
	public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D.Double coloredBar = new Rectangle2D.Double(2D, 7D, ((width - 4) / 100F * weight), 3F);
		
		g2.setPaint(Color.GRAY);
		g2.fill(coloredBar);
		g2.draw(coloredBar);
	}
}
