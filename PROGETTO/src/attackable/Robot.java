package attackable;

import java.awt.Dimension;
import positionable.Positionable;

import javax.swing.JComponent;
import item.Useable;

public abstract class Robot <T extends Useable> extends Attackable  {
	private double energy,strength;
	private String team,name;
	public Robot(String name,String team,double strength){
		this.name=name;
		this.team=team;
		this.energy=100;
		super.setHealth(100);
		this.strength=strength;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Double getEnergy(){
		return energy;
	}
	public void setEnergy(double energy){
		this.energy=energy;
	}
	public double getStrength(){
		return strength;
	}
	public void setStrength(double strength){
		this.strength=strength;
	}
	public String getTeamName(){
		return team;
	}
	public double getHealth(){
		return super.getHealth();
	}
	public void setHealth(double h){
		super.setHealth(h);
	}
	public void pushObstacle(){

	}
	public void pullObstacle(){

	}
	public abstract void drop(T item);
	public abstract void pick(T item);

	@Override
	public abstract JComponent getComponent(Dimension dF,Dimension dA);
}