package board;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		frame.setSize((10+1)*50, (10+1)*50);
		frame.setTitle("BoardGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard board=new GameBoard(10,10);
		JPanel boardPanel=board.getFrame();
		frame.add(boardPanel);
		boardPanel.setSize((10+1)*50, (10+1)*50);
		frame.setSize(boardPanel.getSize());
		//frame.setResizable(false);
		frame.setVisible(true);
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
	}

}
