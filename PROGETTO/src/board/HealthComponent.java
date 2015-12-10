package board;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class HealthComponent extends JComponent {
	private double health;
	private double width;
	

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
		// Construct a rectangle and draw it


		/*
		 * BufferedImage sfondoBox = null; try { sfondoBox =
		 * ImageIO.read(new File(projectPath + "\\src\\board\\road.jpg")); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * 
		 * }
		 */
		// final JLabel label = new JLabel("Label");
		// label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// g2.draw(label);

		//Rectangle2D.Double bar = new Rectangle2D.Double(2, 2, ((width) - 4), 3);

		Rectangle2D.Double coloredBar = new Rectangle2D.Double(2D, 2D, ((width - 4) / 100F * health),3F);
				// g2.drawImage(sfondoBox, 0 ,
				// 0,(dimension.width),(dimension.height), null);

				g2.setPaint(Color.BLACK);
				//g2.fill(bar);
				//g2.draw(bar);
				if (health >= (100F * 50F / 100F))
					g2.setPaint(Color.GREEN);
				else if (health > (100F / 100F * 25F) && health < (100F / 100F * 50F))
					g2.setPaint(Color.YELLOW);
				else if (health < (100F / 100F * 25F))
					g2.setPaint(Color.RED);
				g2.fill(coloredBar);
				g2.draw(coloredBar);

				// g2.drawImage(sfondoBox, 50*pos.getX() , 50*pos.getY(),50,50,
				// null);

				// g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50,
				// null);
	}
}
