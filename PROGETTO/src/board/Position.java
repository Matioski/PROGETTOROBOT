package board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



import javax.swing.JComponent;

public class Position {
	public Position (int newX, int newY){
		setX(newX);
		setY(newY);
	}
	public void setX(int newX){
		x=newX;
	}
	public void setY(int newY){
		y=newY;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
		
	}

	private int x;
	private int y;
	
	
}
