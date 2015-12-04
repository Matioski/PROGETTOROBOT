package board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;



public class Wall extends Positionable {

	public Wall(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}
	class WallComponent extends JComponent {
		private Position pos;
		public WallComponent(Position newPos){
			super();
			pos=newPos;
		}
		public void paintComponent(Graphics g) {
			
			// TODO Auto-generated constructor stub
			// Recover Graphics2D
			Graphics2D g2 = (Graphics2D) g;
			// Construct a rectangle and draw it
			
				 BufferedImage immagine = null;
				try {
					immagine = ImageIO.read(new File("C:\\Users\\Mattia\\Desktop\\images.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
				BufferedImage  sfondoBox = null;
				try {
					sfondoBox = ImageIO.read(new File("C:\\Users\\Mattia\\Desktop\\road.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
				g2.drawImage(sfondoBox, 0 , 0,50,50, null);
				g2.drawImage(immagine, 0 , 0,50,50, null);	
				//g2.drawImage(sfondoBox, 50*pos.getX() , 50*pos.getY(),50,50, null);
				//g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50, null);
		}
	}
	public WallComponent getComponent(){
		WallComponent tempComp  = new WallComponent(super.getPosition());
		return tempComp;
	}

}
