package board;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ResizeMapListener extends ComponentAdapter {
	private GameBoard lol;
	private JFrame fram;
	private JPanel panel;

	public ResizeMapListener(JPanel p, JFrame frame, GameBoard board) {
		lol = board;
		fram = frame;
		panel = p;

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// Recalculate the variable you mentioned

		fram.remove(panel);
		fram.add(lol.getFrame(fram.getSize()), 0);
		fram.repaint();

		fram.setVisible(true);

	}
}