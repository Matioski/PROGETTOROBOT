

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;
public class GraficTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		final int FRAME_HEIGHT = 300;
		final int FRAME_WIDTH = 400;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Circle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		double rad=0;
		
		class CircleComponent extends JComponent {
			private double radius;
			public CircleComponent(double r){
				super();
				radius=r;
			}
			public void paintComponent(Graphics g) {
				
				// TODO Auto-generated constructor stub
				// Recover Graphics2D
				Graphics2D g2 = (Graphics2D) g;
				// Construct a rectangle and draw it
				Ellipse2D.Double box = new Ellipse2D.Double(5,5,radius*2,radius*2);
					g2.draw(box);
			}
			public void changeRad(Double d){
				radius=d;
			}
		}
		

		JFrame inputframe = new JFrame();

		inputframe.setSize(400, 100);
		inputframe.setTitle("Circle");
		inputframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel inputpane= new JPanel(new GridLayout(3,1));
		JLabel radia = new JLabel("Radius: ");
		JTextField inputrad = new JTextField();
		JButton send= new JButton("Send");
		
		class RadMouseListener implements MouseListener{

			private CircleComponent circle = new CircleComponent(0);
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				circle.changeRad(Double.parseDouble(inputrad.getText()));
				
				
				circle.repaint();
					
				
				frame.setVisible(false);
				frame.setVisible(true);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		}

		RadMouseListener clickrad= new RadMouseListener();
		frame.add(clickrad.circle);
		send.addMouseListener(clickrad);
		inputpane.add(radia);
		inputpane.add(inputrad);
		inputpane.add(send);
		inputframe.add(inputpane);
		inputframe.setVisible(true);
		frame.setVisible(true);
		
		
		
	}
}

