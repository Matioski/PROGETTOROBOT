package positionable;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import board.Position;
import graphics.TrunkComponent;

public class Trunk extends Positionable {

	public Trunk(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}



	@Override
	public TrunkComponent getComponent(Dimension dF, Dimension dA) {
		TrunkComponent tempComp = new TrunkComponent(super.getPosition(), dF, dA);
		return tempComp;
	}

}
