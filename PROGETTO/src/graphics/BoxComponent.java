package graphics;

import java.awt.Dimension;

import javax.swing.JComponent;

import board.Position;
import positionable.Box;

/**
 * Create a BoxComponent
 * @author Mattia Rosselli
 *
 */

public class BoxComponent extends JComponent {
	private Position pos;

	
	/**
	 * Create a Component from a Box
	 * @param box Box to draw
	 */
	public BoxComponent(Box box) {
		super();
		pos = box.getPosition();
	}
	/**
	 * Create a Component from a Box calculating dimension.
	 * @param box Box to draw
	
	 * @param dFrame Dimension Frame
	 * @param dArray Dimension Array
	 */
	public BoxComponent(Box box, Dimension dFrame, Dimension dArray) {
		super();
		pos = box.getPosition();
	}
	
}
