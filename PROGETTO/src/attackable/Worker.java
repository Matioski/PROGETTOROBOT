package attackable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import board.Position;
import graphics.WorkerComponent;
import item.AttackWeapon;
import item.ChargingItem;
import item.DefenseWeapon;
import item.Item;
import item.RepairingItem;
import item.Weapon;


public class Worker extends Robot<Item> {
	private  ChargingItem chargingItem;
	private RepairingItem repairingItem;
	public Worker(String name,String team,double strength){
		super( name, team, strength);
		chargingItem=null;
		repairingItem=null;
	}
	public void pick(Item item) {
   	    if(item.getClass().getName().contains("ChargingItem")) chargingItem=(ChargingItem)item;
   	    else if(item.getClass().getName().contains("RepairingItem")) repairingItem=(RepairingItem)item;
   	                        }
	@Override
	public void drop(Item item) {
		// TODO Auto-generated method stub
		
	}
	public void charge(){

	}
	public void repair(){

	}
	
               
	@Override
	public WorkerComponent getComponent(Dimension dF,Dimension dA){
		WorkerComponent tempComp  = new WorkerComponent(super.getPosition(),super.getHealth(),dF,dA);
		return tempComp;
	}
}
