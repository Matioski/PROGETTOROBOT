package board;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GameBoard {
	private ArrayList<ArrayList<Positionable>> outer = new ArrayList<ArrayList<Positionable>>();
    private ArrayList<Positionable> inner = new ArrayList<Positionable>(); 
    private int height;
    private int width;
	public GameBoard(int x, int y){
		height=x;
		width=y;
		Random rand = new Random();
		int random ; 
		// for every row
		for ( int i = 0  ; i < height ; i++){
			// for every column
			inner=new ArrayList<Positionable>(); 
			outer.add(inner);
			for ( int j = 0 ; j < width ; j++){
				// generate a random number between 0 include and 100 exclusive.
				random = rand.nextInt(100);
				// five percent means 5/100 so if random is a number less than five percent
				if ( random < 5 ){ // generate a Obstacle
					
					
					outer.get(i).add(new Obstacle(new Position(i,j))) ; 
					random = rand.nextInt(100);
				}
				// 10 percent is between 10/100, so if random is between ten digits
				else if( random >= 5 && random < 15 ){
					
					// generate obstacle
					outer.get(i).add(new Wall(new Position(i,j))) ; 
					random = rand.nextInt(100);
				}
				// else 
				else { // fill with empty
					outer.get(i).add(new Box(new Position(i,j))) ; 
					random = rand.nextInt(100);
				}
			}
		}
		
	}
	public Boolean isObstacle(Position pos){
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().equals("Obstacle"))flag=true;
		return flag;
	}
	public Boolean isEmpty(Position pos){
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().equals("Box"))flag=true;
		return flag;
	}
	public Boolean isWall(Position pos){
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().equals("Wall"))flag=true;
		return flag;
	}
	public JPanel getFrame(){
		ImagePanel map = new ImagePanel(new GridLayout(width,height),"C:\\Users\\Mattia\\Desktop\\grass.jpg");
		
		//map.setSize((width+1)*50, (height+1)*50);
		//map.setTitle("BoardGame");
		//map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for ( int i = 0  ; i < height ; i++){
			
			for ( int j = 0 ; j < width ; j++){
				map.add(outer.get(i).get(j).getComponent());
				 
			}
		
		
		}
		return map;
	}
}


