package positionable;

import java.awt.Dimension;

import javax.swing.JComponent;

import board.Position;
import graphics.BoxComponent;

public class Box extends Positionable {

	public Box(Position pos) {
		// TODO Auto-generated constructor stub
		super.setPosition(pos);
	}

	public BoxComponent getComponent(Dimension dF, Dimension dA) {
		BoxComponent tempComp = new BoxComponent(super.getPosition(), dF, dA);
		return tempComp;
	}

}
