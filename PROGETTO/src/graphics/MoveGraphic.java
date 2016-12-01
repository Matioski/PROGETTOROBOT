package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import match.Controller;
import match.Move;

/**
 * Class that creates the panel for the possible move of a controller
 * @author Mattia Rosselli
 *
 */

public class MoveGraphic {
	private GameBoardGraphics board;
	private Controller con;
	private Move move;

	
	/**
	 * Create new MoveGraphic with given move, Grafic board and Controller.
	 * @param m Move
	 * @param gB Graphic GameBoard
	 * @param con Controller
	 */
	public MoveGraphic(Move m, GameBoardGraphics gB, Controller con) {
		super();
		board = gB;
		this.con = con;
		move = m;

	}
	
	/**
	 * Method that returns the Panel of the Move given
	 * @return Panel of the given Move.
	 */
	public JPanel getPanel() {
		JPanel finished = new JPanel(new GridLayout(1, 2));
		finished.setSize(300, 200);
		if (move.getAction().equals("PUSH") || move.getAction().equals("PULL") || move.getAction().contains("MOVE")) {
			finished.add(board.getPositionableComponent(move.getSender().getX(), move.getSender().getY(),
					finished.getSize(), new Dimension(2, 1)));
		} else if (move.getAction().equals("TRUNK")) {
			finished.add(new TrunkComponent(finished.getSize(), new Dimension(2, 1)));
		} else {
			finished.add(board.getPositionableComponent(move.getTarget().getX(), move.getTarget().getY(),
					finished.getSize(), new Dimension(2, 1)));
		}
		JPanel labels = new JPanel(new GridLayout(3, 1));
		labels.add(new JLabel(move.getAction()));
		labels.add(new JLabel(move.getSender().toString().substring(14)));
		labels.add(new JLabel(move.getTarget().toString().substring(14)));

		finished.add(labels);
		finished.setBorder(new LineBorder(Color.BLACK, 2));
		finished.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				synchronized (con) {
					con.chooseNext(move);

					con.notifyAll();
				}
			}
		});
		return finished;
	}
}
