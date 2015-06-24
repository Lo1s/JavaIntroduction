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

import chapter10.PE1011_Circle2D;

/**
 * @author jslapnicka
 * @Date & @Time 16. 9. 2014 2014 12:28:10 
 */
@SuppressWarnings("serial")
public class PE1625_HitBalloons extends JFrame {

	/**
	 * @param args
	 */

	public PE1625_HitBalloons() {
		// TODO Auto-generated constructor stub
		add(new HitBalloons());
	}

	class HitBalloons extends JPanel {
		private int xBalloon;
		private int yBalloon;
		private int radiusBalloon = 10;
		private int radiusSmallBalloons = 6;
		private int xLine1;
		private int yLine1;
		private int xLine2;
		private int yLine2;
		private int xCenter;
		private int angleGun = 90;
		private int angleFireBall = 90;
		private boolean drawBalloon = true;
		private int xFireBall;
		private int yFireBall;
		private int radiusFireBall = 5;
		private Timer timer;
		private double moveFireBall = 50;
		private PE1011_Circle2D fireCircle;
		private PE1011_Circle2D balloonCircle;
		private boolean hit = false;
		private boolean fired = false;
		private int numberOfHits = 0;
		private int countDown = 180;

		public HitBalloons() {
			// TODO Auto-generated constructor stub
			timer = new Timer(100, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					// Shoot the ball !
					countDown--;
					if (countDown == 0)
						System.exit(0);
					moveFireBall += 5;
					repaint();
				}
			});

			setFocusable(true);
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					hit = false;
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						angleGun += 5;
						if (!fired)
							angleFireBall = angleGun;
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						angleGun -= 5;
						if (!fired)
							angleFireBall = angleGun;
					} else if (e.getKeyCode() == KeyEvent.VK_UP) {
						fired = true;
						timer.start();
					}
					repaint();
					drawBalloon = false;
				}
			});
		}


		protected void paintComponent(Graphics g) {

			xCenter = getWidth() / 2;
			if (drawBalloon) {
				xBalloon = 2 * radiusBalloon + (int)(Math.random() * ((getWidth() - 2 * radiusBalloon) + 1));
				yBalloon = 2 * radiusBalloon + (int)(Math.random() * (((getHeight() - 40) - 2 * radiusBalloon) + 1));
			}
			if (!hit) {
				xLine1 = xCenter;
				yLine1 = getHeight();
				xLine2 = (int)((double)xCenter + 30D * Math.cos(Math.toRadians(angleGun)));
				yLine2 = (int)((double)getHeight() - 30D * Math.sin(Math.toRadians(angleGun)));
				xFireBall = (int)((double)xCenter + moveFireBall * Math.cos(Math.toRadians(angleFireBall))) - radiusFireBall;
				yFireBall = (int)((double)getHeight() - moveFireBall * Math.sin(Math.toRadians(angleFireBall)));
				// Miss
				if (xFireBall > getWidth() || xFireBall < 0 || yFireBall < 0) {
					moveFireBall = 50;
					hit = true;
					timer.stop();
					fired = false;
				}
				balloonCircle = new PE1011_Circle2D((double)xBalloon, (double)yBalloon, (double)radiusBalloon);
				fireCircle = new PE1011_Circle2D((double)xFireBall, (double)yFireBall, (double)radiusFireBall);
			} else {
				xLine1 = 0;
				xLine2 = 0;
				yLine1 = 0;
				yLine2 = 0;
				xFireBall = 0;
				yFireBall = 0;
				balloonCircle = new PE1011_Circle2D();
				fireCircle = new PE1011_Circle2D();
			}

			super.paintComponent(g);

			if (!fireCircle.overlaps(balloonCircle) || hit) {
				// Draw Balloon
				g.drawOval(xBalloon, yBalloon, 2 * radiusBalloon, 2 * radiusBalloon);
				// Draw fire ball
				g.fillOval(xFireBall, yFireBall, 2 * radiusFireBall, 2 * radiusFireBall);
			} else {
				// Debris
				for (int i = 0; i < 4; i++) {
					g.drawOval(xBalloon + (-50 + (int)(Math.random() * (50 - (-50)) + 1)), 
							yBalloon + (-50 + (int)(Math.random() * (50 - (-50)) + 1)), radiusSmallBalloons, radiusSmallBalloons);
				}
				moveFireBall = 50;
				hit = true;
				numberOfHits++;
				timer.stop();
				xBalloon = 2 * radiusBalloon + (int)(Math.random() * ((getWidth() - 2 * radiusBalloon) + 1));
				yBalloon = 2 * radiusBalloon + (int)(Math.random() * (((getHeight() - 40) - 2 * radiusBalloon) + 1));
				fired = false;
			}

			// Draw Gun
			g.drawLine(xLine1, yLine1, xLine2, yLine2);
			g.drawLine(xLine1 - 1, yLine1, xLine2 - 1, yLine2);
			g.drawLine(xLine1 - 2, yLine1, xLine2 - 2, yLine2);
			g.drawLine(xLine1 + 1, yLine1, xLine2 + 1, yLine2);
			g.drawLine(xLine1 + 2, yLine1, xLine2 + 2, yLine2);
			
			// Draw number of hits and countdown
			g.drawString("Countdown to termination: " + countDown, 5, getHeight() - 25);
			g.drawString("Number of hits: " + numberOfHits, 5, getHeight() - 10);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1625_HitBalloons();
		frame.setTitle("Exercise16_25");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
