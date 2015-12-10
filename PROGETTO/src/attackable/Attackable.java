package attackable;

import java.awt.Dimension;
import positionable.Positionable;

import javax.swing.JComponent;

import board.Position;

public abstract class Attackable extends Positionable {
      private double health;
      
      
      public void setHealth(double h){
    	health=h;  
      }
      public double getHealth(){
    	  return health;
      }
      public void setPosition(Position pos){
    	super.setPosition(pos);
      }
      public void takeDamage(double damage){
    	  setHealth(getHealth()-damage);
      }
      @Override
  	public abstract JComponent getComponent(Dimension dF,Dimension dA);
}
