/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 19. 9. 2014 2014 9:58:29 
 */
@SuppressWarnings("serial")
public class PE1635_BallOnCurve extends JFrame {

	/**
	 * @param args
	 */

	public PE1635_BallOnCurve() {
		// TODO Auto-generated constructor stub
		add(new BallOnCurve());
	}

	class BallOnCurve extends JPanel {
		int counter = -170;
		int xBall = counter;
		int yBall = 100 - (int)(50 * Math.sin((counter / 100.0) * 2 * Math.PI));
		int radiusBall = 5;
		Timer timer;
		

		public BallOnCurve() {
			// TODO Auto-generated constructor stub
			timer = new Timer(100, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (counter <= 170) {	
						xBall = counter + 200;
						yBall = 100 - (int)(50 * Math.sin((counter / 100.0) * 2 * Math.PI));
						counter++;
						repaint();
					} else
						counter = -170;
				}
			});
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1)
						timer.start();
					else if (e.getButton() == MouseEvent.BUTTON3)
						timer.stop();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			// Draw Sine
			Polygon p = new Polygon();

			for (int x = -170; x <= 170; x++) {
				p.addPoint(x + 200, 100 - (int)(50 * Math.sin((x / 100.0) * 2 * Math.PI)));
			}

			g.setColor(Color.RED);
			g.drawPolyline(p.xpoints, p.ypoints, p.npoints);

			int xCenter = 200;
			int yCenter = 100;
			g.setColor(Color.BLACK);
			g.drawLine(10, yCenter, 390, yCenter);
			g.drawLine(xCenter, 180, xCenter, 30);
			g.drawLine(390, yCenter, 380, yCenter - 10);
			g.drawLine(390, yCenter, 380, yCenter + 10);
			g.drawLine(xCenter, 30, xCenter - 10, 40);
			g.drawLine(xCenter, 30, xCenter + 10, 40);

			g.drawString("X", 390, yCenter - 20);
			g.drawString("Y", xCenter + 20, 30);

			String pi = "\u03c0";
			g.drawString(-2 + pi, 100, 120);
			g.drawString(2 + pi, 300, 120);
			g.drawString("-" + pi, 150, 120);
			g.drawString(pi, 250, 120);
			g.drawString("0", 190, 120);

			// DrawBall
			g.fillOval(xBall - radiusBall, yBall - radiusBall, 2 * radiusBall, 2 * radiusBall);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1635_BallOnCurve();
		frame.setTitle("Exercise16_35");
		frame.setSize(420, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
