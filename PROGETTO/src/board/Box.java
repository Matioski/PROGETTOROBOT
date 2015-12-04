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

public class Box extends Positionable {

	public Box(Position pos) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
	}
	class BoxComponent extends JComponent {
		private Position pos;
	public BoxComponent(Position newPos){
		super();
		pos=newPos;
	}
	public void paintComponent(Graphics g) {
		
		// TODO Auto-generated constructor stub
		
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		// Construct a rectangle and draw it
		Rectangle2D.Double box = new Rectangle2D.Double(0,0,50,50);
		 BufferedImage immagine = null;
		 String projectPath = System.getProperty("user.dir");
			try {
				immagine = ImageIO.read(new File(projectPath + "\\src\\board\\road.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
			g2.drawImage(immagine, 0 , 0,50,50, null);
	//		g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50, null);
			
		
	}
}
	public BoxComponent getComponent(){
		BoxComponent tempComp  = new BoxComponent(super.getPosition());
		return tempComp;
	}


}
