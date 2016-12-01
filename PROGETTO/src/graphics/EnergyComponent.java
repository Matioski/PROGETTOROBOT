package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Draw an EnergyComponent
 * @author Mattia Rosselli
 *
 */
public class EnergyComponent extends JComponent {
	private double energy;
	private double width;

	/**
	 * Create the energy Component with given energy
	 * @param e energy
	 * @param width width
	 */
	public EnergyComponent(double e, double width) {
		super();

		energy = e;

		this.width = width;

	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;	

		Rectangle2D.Double coloredBar = new Rectangle2D.Double(2D, 12D, ((width - 4) / 100F * energy), 3F);
		
		g2.setPaint(Color.MAGENTA);
		g2.fill(coloredBar);
		g2.draw(coloredBar);

	}
}
