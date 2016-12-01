package graphics;

import javax.swing.JComponent;

import board.Position;

/**
 * Abstract Class of all the positionable component that can be drawn.
 * @author Mattia Rosselli
 *
 */
public abstract class PositionableComponent extends JComponent {
	Position pos;

	public PositionableComponent(Position position) {
		pos = position;
	}

}
