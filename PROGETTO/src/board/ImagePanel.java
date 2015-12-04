package board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	public ImagePanel() {
		// TODO Auto-generated constructor stub
	}

	public ImagePanel(LayoutManager layout,String img) {
		
		super(layout);
		
		 this.img = new ImageIcon(img).getImage();
	    Dimension size = new Dimension(this.img.getWidth(null), this.img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(layout);
		
		
		// TODO Auto-generated constructor stub
	}

	public ImagePanel(boolean isDoubleBuffered,String img) {
		super(isDoubleBuffered);
		
		// TODO Auto-generated constructor stub
	}

	public ImagePanel(LayoutManager layout, boolean isDoubleBuffered,String img) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	private Image img;

		  public ImagePanel(String img) {
		    this(new ImageIcon(img).getImage());
		  }

		  public ImagePanel(Image img) {
		    this.img = img;
		    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		  }

}



