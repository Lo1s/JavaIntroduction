/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 18. 9. 2014 2014 9:26:07 
 */
@SuppressWarnings("serial")
public class PE1633_Pendulum extends JFrame {

	public PE1633_Pendulum() {
		// TODO Auto-generated constructor stub
		add(new DrawPendulum());
	}

	class DrawPendulum extends JPanel {
		int xHandle;
		int yHandle;
		int xHandle2;
		int yHandle2;
		int angle = 90;
		int leftAngle = 60;
		int rightAngle = 120;
		int pendulumRadius = 200;
		int xBall;
		int yBall;
		int radiusBall = 10;
		int radiusHandler = 4;
		Timer timer;
		int delay = 500;

		public DrawPendulum() {
			// TODO Auto-generated constructor stub
			timer = new Timer(delay, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (angle < rightAngle || angle == leftAngle) {
						angle += 5;
						rightAngle = 120;
					} else { 
						angle -=5;
						rightAngle = leftAngle;
					}
					repaint();
				}
			});
			timer.start();
			
			setFocusable(true);
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						delay = timer.getDelay();
						delay -= 10;
						timer.setDelay(delay);
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						delay = timer.getDelay();
						delay += 10;
						timer.setDelay(delay);
					} else if (e.getKeyCode() == KeyEvent.VK_S) {
						timer.stop();
					} else if (e.getKeyCode() == KeyEvent.VK_R) {
						timer.start();
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			int xCenter = getWidth() / 2;
			xHandle = xCenter + radiusHandler;
			yHandle = 20 + radiusHandler;
			xHandle2 = (int)((double)(getHeight() - yHandle - 20) * Math.tan(Math.toRadians(angle)));
			xHandle2 = xHandle + (int)((double)pendulumRadius * Math.cos(Math.toRadians(angle)));
			yHandle2 = yHandle + (int)((double)pendulumRadius * Math.sin(Math.toRadians(angle)));
			xBall = xHandle2;
			yBall = yHandle2;

			super.paintComponent(g);

			// Draw holder
			g.fillOval(xCenter, 20, 2 * radiusHandler, 2 * radiusHandler);

			// Draw handle
			g.drawLine(xHandle, yHandle, xHandle2, yHandle2);

			// Draw ball
			g.fillOval(xBall - radiusBall, yBall - radiusBall, 2 * radiusBall, 2 * radiusBall);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1633_Pendulum();
		frame.setTitle("Exercise16_33");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
