package board;

import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class HealthComponent extends JComponent {

	public HealthComponent() {
		super();
		// TODO Auto-generated constructor stub
		Rectangle2D.Double bar = new Rectangle2D.Double(2, 2, 46, 5);
		Rectangle2D.Double coloredBar = new Rectangle2D.Double(2, 2, 46, 5);
	}

}
