package match;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.GameBoardGraphics;

/**
 * Listener used to resize all the componets of a frame when added to it
 * @author Mattia Rosselli
 *
 */
class ResizeMapListener extends ComponentAdapter {
	private GameBoardGraphics lol;
	private JFrame fram;
	private JPanel panel;

	/**
	 * Creates a resize listener specific for the game
	 * @param p
	 * @param frame
	 * @param board
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
		fram.add(lol.getFrame(fram.getSize()), 0);
		fram.validate();

		fram.repaint();

		fram.setVisible(true);

	}
}