package positionable;

import java.awt.Dimension;

import javax.swing.JComponent;

import board.Position;

public class Box extends Positionable {

	public Box(Position pos) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
	}
	

	class BoxComponent extends JComponent {
		// private Position pos;

		// private Dimension dimension;
		public BoxComponent(Position newPos, Dimension dFrame, Dimension dArray) {
			super();

			// pos=newPos;

			// Double height,width;
			// width = (dFrame.getWidth()/(dArray.getWidth()+1));
			// height = (dFrame.getHeight()/(dArray.getHeight()+1));
			// dimension = new Dimension(width.intValue(),height.intValue());

		}
		// public void paintComponent(Graphics g) {

		// TODO Auto-generated constructor stub
		// Recover Graphics2D
		// Graphics2D g2 = (Graphics2D) g;
		// Construct a rectangle and draw it

		// String projectPath = System.getProperty("user.dir");

		/*
		 * BufferedImage sfondoBox = null; try { sfondoBox = ImageIO.read(new
		 * File(projectPath + "\\src\\board\\road.jpg")); } catch (IOException
		 * e) { // TODO Auto-generated catch block
		 * 
		 * }
		 */
		// g2.drawImage(sfondoBox, 0 , 0,(dimension.width),(dimension.height),
		// null);

		// g2.drawImage(sfondoBox, 50*pos.getX() , 50*pos.getY(),50,50, null);

		// g2.drawImage(immagine, 50*pos.getX() , 50*pos.getY(),50,50, null);
		// }
	}

	@Override
	public BoxComponent getComponent(Dimension dF, Dimension dA) {
		BoxComponent tempComp = new BoxComponent(super.getPosition(), dF, dA);
		return tempComp;
	}

	/*
	 * class BoxComponent extends JComponent { private Position pos; public
	 * BoxComponent(Position newPos){ super(); pos=newPos; } public void
	 * paintComponent(Graphics g) {
	 * 
	 * // TODO Auto-generated constructor stub
	 * 
	 * // Recover Graphics2D Graphics2D g2 = (Graphics2D) g; // Construct a
	 * rectangle and draw it Rectangle2D.Double box = new
	 * Rectangle2D.Double(0,0,50,50); BufferedImage immagine = null; String
	 * projectPath = System.getProperty("user.dir"); try { immagine =
	 * ImageIO.read(new File(projectPath + "\\src\\board\\road.jpg")); } catch
	 * (IOException e) { // TODO Auto-generated catch block
	 * 
	 * } g2.drawImage(immagine, 0 , 0,50,50, null); // g2.drawImage(immagine,
	 * 50*pos.getX() , 50*pos.getY(),50,50, null);
	 * 
	 * 
	 * } } public BoxComponent getComponent(){ BoxComponent tempComp = new
	 * BoxComponent(super.getPosition()); return tempComp; }
	 */

}
