/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 15. 9. 2014 2014 10:56:23 
 */
@SuppressWarnings("serial")
public class PE1622_BeanMachineAnimation extends JFrame {

	/**
	 * @param args
	 */

	public PE1622_BeanMachineAnimation() {
		// TODO Auto-generated constructor stub
		add(new BeanMachine());
	}

	class BeanMachine extends JPanel {

		private int[] beanMachine = new int[8];
		final static int HGAP = 20;
		final static int VGAP = 20;
		final static int RADIUS = 5;
		final static int LENGTH_OF_SLOTS = 40;
		final static int NUMBER_OF_SLOTS = 8;
		final static int NUMBER_OF_BALLS = 10;
		final static int NUMBER_OF_ROWS = 7;
		final static int LENGTH_OF_OPENNING = 15;
		final static int Y_FOR_FIRST_NAIL = 50;
		final static int RED_BALL_START_Y = Y_FOR_FIRST_NAIL - RADIUS;
		final static int BOTTOM = Y_FOR_FIRST_NAIL + VGAP * 7 + LENGTH_OF_SLOTS;
		private int yRed = RED_BALL_START_Y;

		private int moveHorizontally;
		private Timer timer;
		private int countRows = 0;
		private int ball = 0;
		private int slot = 0;
		private int[] position = new int[8];
		private boolean hide = false;
		public BeanMachine() {
			// TODO Auto-generated constructor stub
			// Creating timer
			timer = new Timer(800, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub					
					countRows++;
					if (countRows <= NUMBER_OF_ROWS) {
						hide = false;
						generateBeanMachine();
						if (beanMachine[countRows] == 0) {
							goLeft();
						} else {
							goRight();
							slot++;
						}
						goDown();
					} else {
						position[slot]++;
						slot = 0;
						hide = true;
						countRows = 0;
						moveHorizontally = 0;
						yRed = RED_BALL_START_Y;
						ball++;
						if (NUMBER_OF_BALLS == ball)
							timer.stop();
					}
					repaint();		
				}

			});
			timer.start();
		}

		public void generateBeanMachine() {
			for (int i = 0; i < beanMachine.length; i++) {
				beanMachine[i] = hdR.mtd.getRandomNumber(0, 1);
			}
		}

		public void goLeft() {
			moveHorizontally -= HGAP / 2;
		}

		public void goRight() {
			moveHorizontally += HGAP / 2;
		}

		public void goDown() {
			yRed += VGAP;
		}

		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			int xCenter = getWidth() / 2;
			/** Draw the Bean Machine */
			// Bottom horizontal line
			g.drawLine(xCenter - HGAP / 2 * NUMBER_OF_SLOTS, BOTTOM, 
					xCenter + HGAP / 2 * NUMBER_OF_SLOTS, BOTTOM);
			// Vertical lines for slots
			for (int i = 0; i <= HGAP * NUMBER_OF_SLOTS; i = i + HGAP) {
				g.drawLine(xCenter - HGAP / 2 * NUMBER_OF_SLOTS + i, BOTTOM - LENGTH_OF_SLOTS,
						xCenter - HGAP / 2 * NUMBER_OF_SLOTS + i, BOTTOM);
			}
			// Side lines of the tube
			g.drawLine(xCenter - HGAP / 2 * NUMBER_OF_SLOTS, BOTTOM - LENGTH_OF_SLOTS,
					xCenter - HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS);
			g.drawLine(xCenter - HGAP / 2 * NUMBER_OF_SLOTS + HGAP * NUMBER_OF_SLOTS,
					BOTTOM - LENGTH_OF_SLOTS, xCenter + HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS);
			// Entrance
			g.drawLine(xCenter - HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter - HGAP / 2, 
					Y_FOR_FIRST_NAIL - RADIUS - LENGTH_OF_OPENNING);
			g.drawLine(xCenter + HGAP / 2, Y_FOR_FIRST_NAIL + RADIUS, xCenter + HGAP / 2, 
					Y_FOR_FIRST_NAIL - RADIUS - LENGTH_OF_OPENNING);
			// Bumpers
			int shift = - HGAP / 2;
			g.setColor(Color.GREEN);
			for (int i = 7; i >= 1; i--) {
				shift += HGAP / 2;
				for (int j = i; j > 0; j--) {
					g.fillOval(xCenter - HGAP / 2 * NUMBER_OF_SLOTS + (j * HGAP) - RADIUS + shift, 
							BOTTOM - LENGTH_OF_SLOTS - ((NUMBER_OF_SLOTS - (i + 1)) * VGAP) - RADIUS, 2 * RADIUS, 2 * RADIUS);
				}
			}

			/** Draw the animated ball */

			if (!hide || (yRed == RED_BALL_START_Y && ball != NUMBER_OF_BALLS)) {
				g.setColor(Color.RED);
				g.fillOval(xCenter - RADIUS + moveHorizontally, yRed, 2 * RADIUS, 2 * RADIUS);
			}
			/** Draw balls in the slots */
			for (int pos = 0; pos < position.length; pos++) {
				for (int ball = 0; ball < position[pos]; ball++) {
					g.setColor(Color.RED);
					g.fillOval(xCenter - HGAP / 2 * NUMBER_OF_SLOTS + (pos * HGAP) + RADIUS,
							BOTTOM - RADIUS * 2 * ball - RADIUS * 2, 2 * RADIUS, 2 * RADIUS);
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1622_BeanMachineAnimation();
		frame.setTitle("Exercise16_22");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
