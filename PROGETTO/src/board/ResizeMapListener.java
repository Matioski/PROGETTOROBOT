package board;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.GameBoardGraphics;

/**
 * Listener that resize automatically all the content of a frame.
 * @author Mattia Rosselli
 *
 */

public class ResizeMapListener extends ComponentAdapter {
	private GameBoardGraphics lol;
	private JFrame fram;
	private JPanel panel;

	/**
	 * Create a new resize listener for the board.
	 * @param p Panel to resize
	 * @param frame Frame to resize
	 * @param board GameBoard to draw
	 */
	public ResizeMapListener(JPanel p, JFrame frame, GameBoardGraphics board) {
		lol = board;
		fram = frame;
		panel = p;

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// Recalculate the variable you mentioned

		fram.remove(panel);
		fram.add(lol.getFrame(fram.getSize()), BorderLayout.CENTER);
		fram.repaint();

		fram.setVisible(true);

	}
}