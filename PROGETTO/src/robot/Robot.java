package robot;

import java.awt.Dimension;
import positionable.Positionable;

import javax.swing.JComponent;


public abstract class Robot extends Attackable {
	private double energy,strength,health;
	private String team,name;
	public Robot(String name,String team,double strength){
		this.name=name;
		this.team=team;
		this.energy=100;
		this.health=100;
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
	public void setStrength(){
		this.strength=strength;
	}
	public String getTeamName(){
		return team;
	}
	public double getHealth(){
		return health;
	}
	public void setHealth(){
		this.health=health;
	}
	public void pushObstacle(){

	}
	public void pullObstacle(){

	}
	public void drop(){

	}
	public void pick(){

	}

	@Override
	public abstract JComponent getComponent(Dimension dF,Dimension dA);
}