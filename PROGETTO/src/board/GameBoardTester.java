package board;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		x=20;
		y=10;
		JFrame frame=new JFrame();
		frame.setSize((x+1)*50, (y+1)*50);
		frame.setTitle("BoardGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard board=new GameBoard(x,y);
		JPanel boardPanel=board.getFrame();
		frame.add(boardPanel);
		boardPanel.setSize((x+1)*50, (y+1)*50);
		frame.setSize(boardPanel.getSize());
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
