/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 14:31:25 
 */
@SuppressWarnings("serial")
public class PE1615_RacingCar extends JFrame {

	/**
	 * @param args
	 */

	private RacingCar rC = new RacingCar();

	public PE1615_RacingCar() {
		// TODO Auto-generated constructor stub
		add(rC);
	}

	public class RacingCar extends JPanel {
		private boolean firstTime = true;
		private int xWheel1;
		private int yWheel1;
		private int xWheel2;
		private int yWheel2;
		private int wheelRadius = 10;
		private int bodyX1;
		private int bodyWidth = 50;
		private int bodyY1;
		private int bodyHeight = 10;
		// Roof
		Polygon p;
		private int roofPX1;
		private int roofPY1;
		private int roofPX2;
		private int roofPY2;
		private int roofPX3;
		private int roofPY3;
		private int roofPX4;
		private int roofPY4;
		private int panelWidth;
		Timer timer;
		int speed = 10;

		public RacingCar() {
			// TODO Auto-generated constructor stub
			setFocusable(true);
			timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if ((bodyX1 + bodyWidth) + 10 < panelWidth) {
						xWheel1 += 10;
						xWheel2 += 10;
						bodyX1 += 10;
						roofPX1 += 10;
						roofPX2 += 10;
						roofPX3 += 10;
						roofPX4 += 10;
						p = new Polygon();
						p.addPoint(roofPX1, roofPY1);
						p.addPoint(roofPX2, roofPY2);
						p.addPoint(roofPX3, roofPY3);
						p.addPoint(roofPX4, roofPY4);
					} else {
						firstTime = true;
					}
					repaint();
				}
			});
			timer.start();
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					timer.stop();
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					timer.start();
				}
			});
			
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int delay = timer.getDelay();
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						timer.setDelay(delay > 100 ? delay - 100 : 1);
						speed += 5;
					}
					else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						timer.setDelay(delay < Integer.MAX_VALUE - 100 ? delay + 100 : Integer.MAX_VALUE);
						speed -= 5;
					}
				}
			});
		}
		
		public void setSpeed(int setSpeed) {
			timer.setDelay(setSpeed);
			System.out.println("invoked");
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			panelWidth = getWidth();
			/** Draw Car */
			if (firstTime) {
				// Starting coordination for wheels
				xWheel1 = 20;
				yWheel1 = getHeight() - wheelRadius;

				xWheel2 = xWheel1 + 20;
				yWheel2 = yWheel1;
				// Starting coordination for body
				bodyX1 = 10;
				bodyY1 = yWheel1 - 10;
				// Starting coordination for roof
				roofPX1 = xWheel1;
				roofPY1 = bodyY1;
				roofPX2 = roofPX1 + 10;
				roofPY2 = roofPY1 - 10;
				roofPX3 = xWheel2;
				roofPY3 = roofPY2;
				roofPX4 = roofPX3 + 10;
				roofPY4 = roofPY1;
				p = new Polygon();
				p.addPoint(roofPX1, roofPY1);
				p.addPoint(roofPX2, roofPY2);
				p.addPoint(roofPX3, roofPY3);
				p.addPoint(roofPX4, roofPY4);
				firstTime = false;
			}
			
			// Draw Wheels
			g.setColor(Color.BLACK);
			g.fillOval(xWheel1, yWheel2, wheelRadius, wheelRadius);
			g.fillOval(xWheel2, yWheel2, wheelRadius, wheelRadius);
			// Draw Body
			g.setColor(Color.CYAN);
			g.fillRect(bodyX1, bodyY1, bodyWidth, bodyHeight);
			// Draw Roof
			g.setColor(Color.BLUE);
			g.fillPolygon(p);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1615_RacingCar();
		frame.setTitle("Exercise16_15");
		frame.setSize(500, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
