package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * Component of the team logo
 * @author Mattia Rosselli
 *
 */
public class TeamComponent extends JComponent {
	private String name;
	private double width;

	/**
	 * Create a new logo for the given team
	 * @param n Team Name
	 * @param width Width
	 */
	public TeamComponent(String n, double width) {
		super();

		name = n;

		this.width = width;

	}

	@Override
	public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double coloredCircle = new Ellipse2D.Double(2D, 30D, ((width - 4) / 10), ((width - 4) / 10));
			g2.setPaint(Color.WHITE);


		if (name.equals("GREEN"))
			g2.setPaint(Color.GREEN);
		else if (name.equals("YELLOW"))
			g2.setPaint(Color.YELLOW);
		else if (name.equals("PINK"))
			g2.setPaint(Color.PINK);
		else if (name.equals("RED"))
			g2.setPaint(Color.RED);
		g2.fill(coloredCircle);
		g2.draw(coloredCircle);

	}
}
