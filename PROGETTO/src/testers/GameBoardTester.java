package testers;

import javax.swing.JFrame;
import javax.swing.JPanel;

import board.GameBoard;
import board.Position;
import board.ResizeMapListener;
import graphics.GameBoardGraphics;

public class GameBoardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y;
		x = 20;
		y = 10;
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setTitle("BoardGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoard board = new GameBoard(x, y);
		board.fill();
		GameBoardGraphics boardGraphics = new GameBoardGraphics(board, x, y);
		JPanel boardPanel = boardGraphics.getFrame(frame.getSize());

		frame.add(boardPanel, 0);
		frame.addComponentListener(new ResizeMapListener(boardPanel, frame, boardGraphics));
		// boardPanel.setSize((x+1)*50, (y+1)*50);
		// frame.setSize(boardPanel.getMinimumSize());
		// frame.setResizable(false);
		frame.setVisible(true);
		System.out.println(board);
		GameBoard test = board.clone();
		System.out.println(test);
		System.out.println(board.equals(test));

		System.out.println(board.equals(test));
		System.out.println(test);
		System.out.println(board.getPositionable(new Position(0, 1)).equals(test.getPositionable(new Position(0, 1))));
	}

}
