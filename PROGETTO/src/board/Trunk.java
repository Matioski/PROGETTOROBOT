package board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import board.Box.BoxComponent;
import board.Wall.WallComponent;

public class Trunk extends Positionable {

	public Trunk(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}
	class TrunkComponent extends JComponent {
		private Position pos;
		
		private Dimension dimension;
		
		public TrunkComponent(Position newPos, Dimension dFrame,Dimension dArray ){
			super();
			
			pos=newPos;
			
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
						immagine = ImageIO.read(new File(projectPath + "\\src\\board\\trunk.png"));
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

				
				g2.drawImage(sfondoBox, 0 , 0,(dimension.width),(dimension.height), null);
				g2.drawImage(immagine, 0 , 0,(dimension.width),(dimension.height), null);
							
				//g2.drawImage(sfondoBox, 50*pos.getX() , 50*pos.getY(),50,50, null);
			
				//g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50, null);
		}
	}
	public TrunkComponent getComponent(Dimension dF,Dimension dA){
		TrunkComponent tempComp  = new TrunkComponent(super.getPosition(),dF,dA);
		return tempComp;
	}

}

