package board;

public abstract class Positionable {

	public Position getPosition(){
		return pos;
	}	
	public void setPosition(Position newPos){
		pos.setX(newPos.getX());
		pos.setY(newPos.getY());
	}
	private Position pos;
}
