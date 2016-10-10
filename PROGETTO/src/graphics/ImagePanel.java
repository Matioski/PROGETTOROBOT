package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class that create a Panel with an image background
 * @author Mattia Rosselli
 *
 */
public class ImagePanel extends JPanel {

	private Image img;


	/**
	 * Create Image Panel with given Image
	 * @param img Image
	 */
	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	/**
	 * Create Image Panel with given Image and layout
	 * @param layout Layout manager
	 * @param img Image
	 */
	public ImagePanel(LayoutManager layout, String img) {

		super(layout);

		this.img = new ImageIcon(img).getImage();

		setLayout(layout);

		// TODO Auto-generated constructor stub
	}

	/**
	 * Create Image Panel with the Image at the given  path
	 * @param img Path of the Image
	 */
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int iw = img.getWidth(this);
		int ih = img.getHeight(this);
		if (iw > 0 && ih > 0) {
			for (int x = 0; x < getWidth(); x += iw) {
				for (int y = 0; y < getHeight(); y += ih) {
					g.drawImage(img, x, y, iw, ih, this);
				}
			}
		}
	}

}
