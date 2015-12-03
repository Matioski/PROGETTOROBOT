package board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Obstacle extends Positionable {

	public Obstacle() {
		// TODO Auto-generated constructor stub
	}
	class ObstacleComponent extends JComponent {
		private Position pos;
		public ObstacleComponent(Position newPos){
			super();
			pos.setX(newPos.getX());
			pos.setY(newPos.getY());
		}
		public void paintComponent(Graphics g) {
			
			// TODO Auto-generated constructor stub
			// Recover Graphics2D
			Graphics2D g2 = (Graphics2D) g;
			// Construct a rectangle and draw it
			
				 BufferedImage immagine = null;
				try {
					immagine = ImageIO.read(new File("C:\\Users\\Mattia\\Desktop\\download.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
			
				g2.drawImage(immagine, 100*pos.getX() , 100*pos.getY(),100,100, null);
		}
	}
}
