package board;

import javax.swing.JComponent;

public abstract class Positionable extends Componentable{

	public Position getPosition(){
		return pos;
	}	
	public void setPosition(Position newPos){
		pos=newPos;
	}
	public abstract JComponent getComponent();
	private Position pos;
}
