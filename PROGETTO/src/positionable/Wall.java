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
import graphics.WallComponent;

public class Wall extends Positionable {

	public Wall(Position pos) {
		super.setPosition(pos);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public WallComponent getComponent(Dimension dF, Dimension dA) {
		WallComponent tempComp = new WallComponent(super.getPosition(), dF, dA);
		return tempComp;
	}

}
