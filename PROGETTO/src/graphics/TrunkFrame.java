package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import item.AttackWeapon;
import item.AttackWeaponCollection;
import item.DefenseItem;
import item.DefenseItemCollection;
import item.DefenseWeapon;
import item.DefenseWeaponCollection;
import item.RepairingItem;
import item.RepairingItemCollection;
import match.Controller;

/**
 * Class that manages the frame to chose Usables to equip
 * @author Mattia Rosselli
 *
 */

public class TrunkFrame extends JFrame {

	/**
	 * creates a trunk frame and wait for the choosing of the Usable
	 * @param con Controller
	 */
	public TrunkFrame(Controller con) {
		synchronized (con) {
			setSize(400, 400);
			this.setTitle("TRUNK");
			this.setLayout(new GridLayout(1, 2));
			if (con.getRobot().getClass().getName().contains("Fighter")) {
				if (con.getClass().getName().contains("Automated")) {
					Random rand = new Random();
					if (rand.nextBoolean())
						getAttackWeapons(con);
					else
						getDefenseWeapons(con);
				} else {
					this.add(getAttackWeapons(con));
					this.add(getDefenseWeapons(con));
				}
			}
			if (con.getRobot().getClass().getName().contains("Worker")) {
				if (con.getClass().getName().contains("Automated")) {
					Random rand = new Random();
					if (rand.nextBoolean())
						getRepairingItems(con);
					else
						getDefenseItems(con);
				} else {
					this.add(getRepairingItems(con));
					this.add(getDefenseItems(con));
				}
			}

		}

	}

	/**
	 * Get a panel with 3 random AttackWeapon
	 * @param con Controller
	 * @return the panel of the Trunk with AttackWeapon
	 */
	public JPanel getAttackWeapons(Controller con) {
		if (!con.getClass().getName().contains("Automated")) {
			JPanel finished = new JPanel(new GridLayout(3, 2));
			String projectPath = System.getProperty("user.dir");
			AttackWeaponCollection att = new AttackWeaponCollection();
			for (int i = 0; i < 3; i++) {
				Random rand = new Random();

				AttackWeapon temp = att.getWeapon(rand.nextInt(att.getSize() - 1) + 1);
				JLabel images = new JLabel();
				images.setIcon(new ImageIcon(projectPath + "\\src\\item\\" + temp.getName() + ".png"));
				finished.add(images);
				
				JPanel labels = new JPanel(new GridLayout(2, 1));

				labels.add(new JLabel(temp.getName()));
				labels.add(new JLabel("ATK" + temp.getAttack()));
				finished.add(labels);
				finished.setBorder(new LineBorder(Color.BLACK, 1));
				finished.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent me) {
						synchronized (con) {

							con.getRobot().pick(temp);
							setVisible(false);
							con.notifyAll();
						}
					}
				});
			}
			return finished;
		}
		synchronized (con) {

			Random rand = new Random();
			con.getRobot().pick(new AttackWeaponCollection().getWeapon(rand.nextInt(5)));
			setVisible(false);
			con.notifyAll();
		}

		return null;
	}

	/**
	  * Get a panel with 3 random DefenseItems
	 * @param con Controller
	 * @return the panel of the Trunk with DefenseItems
	 */
	public JPanel getDefenseItems(Controller con) {
		if (!con.getClass().getName().contains("Automated")) {
			JPanel finished = new JPanel(new GridLayout(3, 2));
			String projectPath = System.getProperty("user.dir");
			DefenseItemCollection rep = new DefenseItemCollection();
			for (int i = 0; i < 3; i++) {
				Random rand = new Random();

				DefenseItem temp = rep.getItem(rand.nextInt(rep.getSize() - 1) + 1);
				JLabel images = new JLabel();
				images.setIcon(new ImageIcon(projectPath + "\\src\\item\\" + temp.getName() + ".png"));
				finished.add(images);
				

				JPanel labels = new JPanel(new GridLayout(2, 1));

				labels.add(new JLabel(temp.getName()));
				labels.add(new JLabel("DEF" + temp.getDefense()));
				finished.add(labels);
				finished.setBorder(new LineBorder(Color.BLACK, 1));
				finished.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent me) {
						synchronized (con) {

							con.getRobot().pick(temp);
							setVisible(false);
							con.notifyAll();
						}
					}
				});
			}
			return finished;
		}
		synchronized (con) {

			Random rand = new Random();
			con.getRobot().pick(new RepairingItemCollection().getItem(rand.nextInt(5)));
			setVisible(false);
			con.notifyAll();
		}

		return null;
	}

	/**
 * Get a panel with 3 random DefenseWeapon
	 * @param con Controller
	 * @return the panel of the Trunk with DefenseWeapon
	 */
	public JPanel getDefenseWeapons(Controller con) {
		if (!con.getClass().getName().contains("Automated")) {
			JPanel finished = new JPanel(new GridLayout(3, 2));
			String projectPath = System.getProperty("user.dir");
			DefenseWeaponCollection rep = new DefenseWeaponCollection();
			for (int i = 0; i < 3; i++) {
				Random rand = new Random();

				DefenseWeapon temp = rep.getWeapon(rand.nextInt(rep.getSize() - 1) + 1);
				JLabel images = new JLabel();
				images.setIcon(new ImageIcon(projectPath + "\\src\\item\\" + temp.getName() + ".png"));
				finished.add(images);
				

				JPanel labels = new JPanel(new GridLayout(2, 1));

				labels.add(new JLabel(temp.getName()));
				labels.add(new JLabel("DEF" + temp.getDefense()));
				finished.add(labels);
				finished.setBorder(new LineBorder(Color.BLACK, 1));
				finished.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent me) {
						synchronized (con) {

							con.getRobot().pick(temp);
							setVisible(false);
							con.notifyAll();
						}
					}
				});
			}
			return finished;
		}
		synchronized (con) {

			Random rand = new Random();
			con.getRobot().pick(new DefenseWeaponCollection().getWeapon(rand.nextInt(5)));
			setVisible(false);
			con.notifyAll();
		}

		return null;
	}

	/**
 * Get a panel with 3 random RepairingItems
	 * @param con Controller
	 * @return the panel of the Trunk with RepairingItems
	 */
	public JPanel getRepairingItems(Controller con) {
		if (!con.getClass().getName().contains("Automated")) {
			JPanel finished = new JPanel(new GridLayout(3, 2));
			String projectPath = System.getProperty("user.dir");
			RepairingItemCollection rep = new RepairingItemCollection();
			for (int i = 0; i < 3; i++) {
				Random rand = new Random();

				RepairingItem temp = rep.getItem(rand.nextInt(rep.getSize() - 1) + 1);
				JLabel images = new JLabel();
				images.setIcon(new ImageIcon(projectPath + "\\src\\item\\" + temp.getName() + ".png"));
				finished.add(images);
				

				JPanel labels = new JPanel(new GridLayout(2, 1));

				labels.add(new JLabel(temp.getName()));
				labels.add(new JLabel("REP" + temp.getRepairingRate()));
				finished.add(labels);
				finished.setBorder(new LineBorder(Color.BLACK, 1));
				finished.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent me) {
						synchronized (con) {

							con.getRobot().pick(temp);
							setVisible(false);
							con.notifyAll();

						}
					}
				});
			}
			return finished;
		}
		synchronized (con) {

			Random rand = new Random();
			con.getRobot().pick(new RepairingItemCollection().getItem(rand.nextInt(5)));
			setVisible(false);
			con.notifyAll();
		}

		return null;
	}


}
