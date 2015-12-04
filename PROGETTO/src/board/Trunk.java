package board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import board.Box.BoxComponent;

public class Trunk extends Positionable {

	public Trunk(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}
class TrunkComponent extends JComponent {
	private Position pos;
	public TrunkComponent(Position newPos){
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
			g2.drawImage(sfondoBox, 0 , 0,50,50, null);
			g2.drawImage(immagine, 0 , 0,50,50, null);			
		
	}
}
	public TrunkComponent getComponent(){
		TrunkComponent tempComp  = new TrunkComponent(super.getPosition());
		return tempComp;
	}


}
