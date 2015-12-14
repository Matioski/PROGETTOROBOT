package attackable;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

import board.Position;
import graphics.FighterComponent;
import item.AttackWeapon;
import item.DefenseWeapon;
import item.Weapon;

public class Fighter extends Robot<Weapon> {
	private  AttackWeapon attackWeapon;
	private DefenseWeapon defenseWeapon;


	public Fighter(String name,String team,double strength){
		super( name, team, strength);
		attackWeapon=null;
		defenseWeapon=null;
	}
	public void attack(){

	}
	public double getAttack(){
		return attackWeapon.getAttack();
	}
	public double getDefense(){
		return defenseWeapon.getDefense();
	}

	public void pick(Weapon item) {
   	    if(item.getClass().getName().contains("DefenseWeapon")) defenseWeapon=(DefenseWeapon)item;
   	    else if(item.getClass().getName().contains("DefenseWeapon")) attackWeapon=(AttackWeapon)item;
   	                        }
               
	@Override
	public FighterComponent getComponent(Dimension dF,Dimension dA){
		FighterComponent tempComp  = new FighterComponent(super.getPosition(),super.getHealth(),dF,dA);
		return tempComp;
	}
	@Override
	public void drop(Weapon item) {
		// TODO Auto-generated method stub
		
	}
	
	
   	    
	
}
