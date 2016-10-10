package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Component  that draws the Health of an Attackable
 * @author Mattia Rosselli
 *
 */
public class HealthComponent extends JComponent {
	private double health;
	private double width;

	/**
	 * Create a new HealthComponent with given health
	 * @param h Health
	 * @param width Panel width
	 */
	public HealthComponent(double h, double width) {
		super();

		health = h;

		this.width = width;

	}

	@Override
	public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D.Double coloredBar = new Rectangle2D.Double(2D, 2D, ((width - 4) / 100F * health), 3F);
		

		g2.setPaint(Color.RED);
		
		if (health >= (100F * 50F / 100F))
			g2.setPaint(Color.GREEN);
		else if (health > (100F / 100F * 25F) && health < (100F / 100F * 50F))
			g2.setPaint(Color.YELLOW);
		else if (health < (100F / 100F * 25F))
			g2.setPaint(Color.RED);
		g2.fill(coloredBar);
		g2.draw(coloredBar);

	
	}
}
