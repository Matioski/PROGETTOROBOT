package robot;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import board.Position;


public class Worker extends Robot {
	ArrayList<ChargingItem> chargingItem=new ArrayList<ChargingItem>();
	ArrayList<RepairingItem> repairingItem=new ArrayList<RepairingItem>();
	public Worker(String name,String team,double strength){
		super( name, team, strength);
	}

	public void charge(){

	}
	public void repair(){

	}
	class WorkerComponent extends JComponent {
		private Position pos;
		private double heal;
		private Dimension dimension;

		public WorkerComponent(Position newPos, double h, Dimension dFrame,Dimension dArray ){
			super();

			pos=newPos;
			heal=h;
			Double height,width;
			width = (dFrame.getWidth()/(dArray.getWidth()+1));
			height = (dFrame.getHeight()/(dArray.getHeight()+1));
			dimension = new Dimension(width.intValue(),height.intValue());


		}

		@Override
		public void paintComponent(Graphics g) {

			// TODO Auto-generated constructor stub
			// Recover Graphics2D
			Graphics2D g2 = (Graphics2D) g;
			// Construct a rectangle and draw it

			BufferedImage immagine = null;
			String projectPath = System.getProperty("user.dir");
			try {
				immagine = ImageIO.read(new File(projectPath + "\\src\\robot\\robot.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
			/*	BufferedImage  sfondoBox = null;
			try {
				sfondoBox = ImageIO.read(new File(projectPath + "\\src\\board\\road.jpg"));
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block

			}
			g2.drawImage(sfondoBox, 0 , 0,(dimension.width),(dimension.height), null);*/
			g2.drawImage(immagine, 0 , 0,(dimension.width),(dimension.height), null);
		}
	}
	@Override
	public WorkerComponent getComponent(Dimension dF,Dimension dA){
		WorkerComponent tempComp  = new WorkerComponent(super.getPosition(),super.getHealth(),dF,dA);
		return tempComp;
	}
}
