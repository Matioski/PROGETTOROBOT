package match;

import board.Position;

public class Move {
private String action;
private Position target;
    public Move(){
	
                 }
    public String getAction(){
    	return action;
    }
    public Position getTarget(){
    	return target;
    }
    public void setAction(String action){
    	this.action=action;
    }
    public void setTarget(Position target ){
    	this.target=target;
    }

}
