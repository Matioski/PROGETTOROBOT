package positionable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import board.Position;
import positionable.Wall.WallComponent;

public class Obstacle extends Positionable {

	public Obstacle(Position pos,double h) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
		health=h;
	}
class ObstacleComponent extends JComponent {
		private Position pos;
		private double heal;
		private Dimension dimension;
		
		public ObstacleComponent(Position newPos, double h, Dimension dFrame,Dimension dArray ){
			super();
			
			pos=newPos;
			heal=h;
			Double height,width;
			width = (dFrame.getWidth()/(dArray.getWidth()+1));
			height = (dFrame.getHeight()/(dArray.getHeight()+1));
			dimension = new Dimension(width.intValue(),height.intValue());
			
			
		}
		public void paintComponent(Graphics g) {
			
			// TODO Auto-generated constructor stub
			// Recover Graphics2D
			Graphics2D g2 = (Graphics2D) g;
			// Construct a rectangle and draw it
			
				 BufferedImage immagine = null;
				 String projectPath = System.getProperty("user.dir");
					try {
						immagine = ImageIO.read(new File(projectPath + "\\src\\board\\download.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
				BufferedImage  sfondoBox = null;
				try {
					sfondoBox = ImageIO.read(new File(projectPath + "\\src\\board\\road.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
				}
			//	final JLabel label = new JLabel("Label");
			 //   label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    
			 //   g2.draw(label);

				Rectangle2D.Double bar = new Rectangle2D.Double(2, 2, ((dimension.width)-4), 3);
				
				
				Rectangle2D.Double coloredBar = new Rectangle2D.Double(2D, 2D, ((dimension.getWidth())-4)/46F*heal, 3F);
				g2.drawImage(sfondoBox, 0 , 0,(dimension.width),(dimension.height), null);
				g2.drawImage(immagine, 0 , 0,(dimension.width),(dimension.height), null);
				g2.setPaint(Color.BLACK);
				g2.fill(bar);
				g2.draw(bar);
				if(heal>=(46F*50F/100F))
					g2.setPaint(Color.GREEN);
				else if(heal>(46F/100F*25F) && heal <(46F/100F*50F))
					g2.setPaint(Color.YELLOW);
				else if (heal<(46F/100F*25F))
					g2.setPaint(Color.RED);
				g2.fill(coloredBar);
				g2.draw(coloredBar);
				
			
				//g2.drawImage(sfondoBox, 50*pos.getX() , 50*pos.getY(),50,50, null);
			
				//g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50, null);
		}
	}
	public ObstacleComponent getComponent(Dimension dF,Dimension dA){
		ObstacleComponent tempComp  = new ObstacleComponent(super.getPosition(),health,dF,dA);
		return tempComp;
	}
	private double health;

}
