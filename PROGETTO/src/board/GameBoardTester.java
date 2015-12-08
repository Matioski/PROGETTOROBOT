package board;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y;
		x = 30;
		y = 20;
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setTitle("BoardGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard board = new GameBoard(x, y);
		JPanel boardPanel = board.getFrame(frame.getSize());

		frame.add(boardPanel, 0);
		frame.addComponentListener(new ResizeMapListener(boardPanel, frame, board));
		// boardPanel.setSize((x+1)*50, (y+1)*50);
		// frame.setSize(boardPanel.getMinimumSize());
		// frame.setResizable(false);
		frame.setVisible(true);

	}

}
