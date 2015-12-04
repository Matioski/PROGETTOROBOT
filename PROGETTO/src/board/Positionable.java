package board;

import java.awt.Dimension;

import javax.swing.JComponent;

public abstract class Positionable {

	public Position getPosition(){
		return pos;
	}	
	public void setPosition(Position newPos){
		pos=newPos;
	}
	public abstract JComponent getComponent(Dimension dF,Dimension dA);
	private Position pos;
}
