package board;

import javax.swing.JFrame;

public class GameBoardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		frame.setSize((10+1)*50, (10+1)*50);
		frame.setTitle("BoardGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard board=new GameBoard(10,10);
		frame.add(board.getFrame());
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
