package board;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ResizeMapListener extends ComponentAdapter {
	private JPanel pan;
	private JFrame fram;
	private GameBoard lol;
	public ResizeMapListener(JPanel pane,JFrame fram,GameBoard board){
		pan=board.getFrame(fram.getSize());
		fram.add(pan);
	}
    public void componentResized(ComponentEvent e) {
        //Recalculate the variable you mentioned
    	pan.repaint();
    	
    }
}