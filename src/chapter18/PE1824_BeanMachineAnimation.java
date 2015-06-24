/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;



/**
 * @author jslapnicka
 * @Date & @Time 23. 10. 2014 2014 10:06:05 
 */
@SuppressWarnings("serial")
public class PE1824_BeanMachineAnimation extends JApplet {

	private JLabel jlblNumberOfSlots = new JLabel("Number of Slots");
	private JTextField jtfNumberOfSlots = new JTextField(2);
	private JButton jbtStart = new JButton("Start");
	private JButton jbtStop = new JButton("Stop");
	private BeanMachine beanMachine = new BeanMachine();

	public PE1824_BeanMachineAnimation() {
		// TODO Auto-generated constructor stub
		JPanel jpSettings = new JPanel();
		jpSettings.add(jlblNumberOfSlots);
		jpSettings.add(jtfNumberOfSlots);
		jpSettings.add(jbtStart);
		jpSettings.add(jbtStop);

		// Register listeners
		jtfNumberOfSlots.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				beanMachine.setNumberOfSlots(Integer.parseInt(jtfNumberOfSlots.getText()));
				repaint();
			}
		});
		
		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				beanMachine.firstTime = true;
				beanMachine.timer.start();
			}
		});
		jbtStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				beanMachine.timer.stop();
			}
		});

		add(beanMachine);
		add(jpSettings, BorderLayout.SOUTH);
	}

	class BeanMachine extends JPanel {

		final static int HGAP = 20;
		final static int VGAP = 20;
		final static int RADIUS = 5;
		final static int LENGTH_OF_SLOTS = 40;
		int number_of_slots = 8;
		final static int NUMBER_OF_BALLS = 10;
		int number_of_rows = number_of_slots - 1;
		final static int LENGTH_OF_OPENNING = 15;
		final static int Y_FOR_FIRST_NAIL = 50;
		int red_ball_start_Y;
		int bottom;
		private int yRed = red_ball_start_Y;
		private int[] beanMachine;

		private int moveHorizontally;
		private Timer timer;
		private int countRows = 0;
		private int ball = 0;
		private int slot = 0;
		private int[] position = new int[8];
		private boolean hide = false;
		private boolean firstTime = true;
		public BeanMachine() {
			// TODO Auto-generated constructor stub
			// Creating timer
			timer = new Timer(800, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub					
					firstTime = false;
					countRows++;
					if (countRows <= number_of_rows) {
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
						yRed = red_ball_start_Y;
						ball++;
						if (NUMBER_OF_BALLS == ball)
							timer.stop();
					}
					repaint();		
				}

			});
		}

		public void setNumberOfSlots(int slots) {
			this.number_of_slots = slots;
			this.number_of_rows = number_of_slots - 1;
			this.beanMachine = new int[number_of_slots];
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

			bottom = getHeight() - 40;
			red_ball_start_Y = (bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP)) - 20 + RADIUS;
			if (firstTime)
				yRed = red_ball_start_Y;
			
			super.paintComponent(g);



			int xCenter = getWidth() / 2;
			/** Draw the Bean Machine */
			// Bottom horizontal line
			g.drawLine(xCenter - HGAP / 2 * number_of_slots, bottom, 
					xCenter + HGAP / 2 * number_of_slots, bottom);
			// Vertical lines for slots
			for (int i = 0; i <= HGAP * number_of_slots; i = i + HGAP) {
				g.drawLine(xCenter - HGAP / 2 * number_of_slots + i, bottom - LENGTH_OF_SLOTS,
						xCenter - HGAP / 2 * number_of_slots + i, bottom);
			}
			// Side lines of the tube
			g.drawLine(xCenter - HGAP / 2 * number_of_slots, bottom - LENGTH_OF_SLOTS,
					xCenter - HGAP / 2, bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP));
			g.drawLine(xCenter - HGAP / 2 * number_of_slots + HGAP * number_of_slots,
					bottom - LENGTH_OF_SLOTS, xCenter + HGAP / 2, bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP));
			// Entrance
			g.drawLine(xCenter - HGAP / 2, (bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP)) - 20, 
					xCenter - HGAP / 2, bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP));
			g.drawLine(xCenter + HGAP / 2, (bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP)) - 20, 
					xCenter + HGAP / 2, bottom - LENGTH_OF_SLOTS - ((number_of_slots - (1)) * VGAP));
			// Bumpers
			int shift = - HGAP / 2;
			g.setColor(Color.GREEN);
			for (int i = number_of_rows; i >= 1; i--) {
				shift += HGAP / 2;
				for (int j = i; j > 0; j--) {
					g.fillOval(xCenter - HGAP / 2 * number_of_slots + (j * HGAP) - RADIUS + shift, 
							bottom - LENGTH_OF_SLOTS - ((number_of_slots - (i + 1)) * VGAP) - RADIUS, 2 * RADIUS, 2 * RADIUS);
				}
			}

			/** Draw the animated ball */
			if (!hide || (yRed == red_ball_start_Y && ball != NUMBER_OF_BALLS)) {
				g.setColor(Color.RED);
				g.fillOval(xCenter - RADIUS + moveHorizontally, yRed, 2 * RADIUS, 2 * RADIUS);
			}
			/** Draw balls in the slots */
			for (int pos = 0; pos < position.length; pos++) {
				for (int ball = 0; ball < position[pos]; ball++) {
					g.setColor(Color.RED);
					g.fillOval(xCenter - HGAP / 2 * number_of_slots + (pos * HGAP) + RADIUS,
							bottom - RADIUS * 2 * ball - RADIUS * 2, 2 * RADIUS, 2 * RADIUS);
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1824_BeanMachineAnimation applet = new PE1824_BeanMachineAnimation();
		frame.add(applet);
		frame.setTitle("Exercise16_22");
		frame.setSize(300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
