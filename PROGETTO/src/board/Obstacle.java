package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import board.Wall.WallComponent;

public class Obstacle extends Positionable {

	public Obstacle(Position pos) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
	}
	class ObstacleComponent extends JComponent {
		private Position pos;
		public ObstacleComponent(Position newPos){
			super();
			pos=newPos;
		}
		public void paintComponent(Graphics g) {
			
			// TODO Auto-generated constructor stub
			// Recover Graphics2D
			Graphics2D g2 = (Graphics2D) g;
			// Construct a rectangle and draw it
			
				 BufferedImage immagine = null;
				 String projectPath = System.getProperty("user.dir");
					try {
						immagine = ImageIO.read(new File(projectPath + "\\bin\\board\\download.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
				BufferedImage  sfondoBox = null;
				try {
					sfondoBox = ImageIO.read(new File(projectPath + "\\bin\\board\\road.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
			//	final JLabel label = new JLabel("Label");
			 //   label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    
			 //   g2.draw(label);
				g2.drawImage(sfondoBox, 0 , 0,50,50, null);
				g2.drawImage(immagine, 0 , 0,50,50, null);		
				//g2.drawImage(sfondoBox, 50*pos.getX() , 50*pos.getY(),50,50, null);
			
				//g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50, null);
		}
	}
	public ObstacleComponent getComponent(){
		ObstacleComponent tempComp  = new ObstacleComponent(super.getPosition());
		return tempComp;
	}
}
