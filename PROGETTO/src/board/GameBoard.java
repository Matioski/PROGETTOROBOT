package board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import positionable.Box;
import positionable.Obstacle;
import positionable.Positionable;
import positionable.Trunk;
import positionable.Wall;



public class GameBoard {
	private ArrayList<ArrayList<Positionable>> outer = new ArrayList<ArrayList<Positionable>>();
    private ArrayList<Positionable> inner = new ArrayList<Positionable>(); 
    private int width;
    private int height;
	public GameBoard(int x, int y){
		width=x;
		height=y;
		Random rand = new Random();
		int random ; 
		// for every row
		for ( int i = 0  ; i < width ; i++){
			// for every column
			inner=new ArrayList<Positionable>(); 
			outer.add(inner);
			for ( int j = 0 ; j < height ; j++){
				// generate a random number between 0 include and 100 exclusive.
				random = rand.nextInt(100);
				// five percent means 5/100 so if random is a number less than five percent
				if ( random < 7 ){ // generate a Obstacle
					if(i!=0){
						if(this.isWall(new Position(i-1,j)) ) {
							outer.get(i).add(new Box(new Position(i,j))) ;  
							continue;
						}
					}
					else if(j!=0){
						if(this.isWall(new Position(i,j-1)) ) {
							outer.get(i).add(new Box(new Position(i,j))) ;  
							continue;
						}
					}
					
					outer.get(i).add(new Wall(new Position(i,j))) ; 
					
				}
				// 10 percent is between 10/100, so if random is between ten digits
				else if( random >= 7 && random < 17 ){
					
					// generate obstacle

					Random randh = new Random();
					
					outer.get(i).add(new Obstacle(new Position(i,j),randh.nextInt(46))) ;
					
				}
				// else 
				else { // fill with empty
					outer.get(i).add(new Box(new Position(i,j))) ; 
					
				}
				random = rand.nextInt(100);
			}
		}

		Position temp=new Position(rand.nextInt(width-1),rand.nextInt(height-1));
		
		while(true){
			
			if(this.isEmpty(temp)){
				outer.get(temp.getX()).set(temp.getY(),new Trunk(temp));
				break;
			}
			temp=new Position(rand.nextInt(width-1),rand.nextInt(height-1));
		}
		
	}
	public Boolean isObstacle(Position pos){
		if(!(pos.getX()>=0 && pos.getX()<width) ||!(pos.getY()>=0 && pos.getY()<height) ) return false;
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().contains("Obstacle"))flag=true;
		return flag;
	}
	public Boolean isTrunk(Position pos){
		if(!(pos.getX()>=0 && pos.getX()<width) ||!(pos.getY()>=0 && pos.getY()<height) ) return false;
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().contains("Trunk"))flag=true;
		return flag;
	}
	public Boolean isEmpty(Position pos){
		if(!(pos.getX()>=0 && pos.getX()<width) ||!(pos.getY()>=0 && pos.getY()<height) ) return false;
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().contains("Box"))flag=true;
		return flag;
	}
	public Boolean isWall(Position pos){
		if(!(pos.getX()>=0 && pos.getX()<width) ||!(pos.getY()>=0 && pos.getY()<height) ) return false;
		Boolean flag=false;
		if(outer.get(pos.getX()).get(pos.getY()).getClass().getName().contains("Wall"))flag=true;
		return flag;
	}
	public JPanel getFrame(Dimension dF){
		String projectPath = System.getProperty("user.dir");
		ImagePanel map = new ImagePanel(new GridLayout(height,width),projectPath + "\\src\\board\\grass.jpg");
		
		//map.setSize((width+1)*50, (height+1)*50);
		//map.setTitle("BoardGame");
		//map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for ( int i = 0  ; i < width ; i++){
			
			for ( int j = 0 ; j < height ; j++){
				map.add(outer.get(i).get(j).getComponent(dF,new Dimension(width,height)));
				 
			}
		
		
		}
		map.setSize(new Dimension(((dF.width)/(width+1)),((dF.height)/(height+1))));
		return map;
	}
}


