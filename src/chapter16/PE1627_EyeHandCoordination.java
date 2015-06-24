/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1011_Circle2D;

/**
 * @author jslapnicka
 * @Date & @Time 16. 9. 2014 2014 16:29:56 
 */
@SuppressWarnings("serial")
public class PE1627_EyeHandCoordination extends JFrame {

	/**
	 * @param args
	 */

	public PE1627_EyeHandCoordination() {
		// TODO Auto-generated constructor stub
		add(new DrawCircles());
	}

	class DrawCircles extends JPanel {

		private int radius = 10;
		private int counter = 0;
		private boolean firstClick = true;
		private long start;
		private long end;
		private long timeElapsed;
		private PE1011_Circle2D circle;

		public DrawCircles() {
			// TODO Auto-generated constructor stub


			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1 && counter < 20) {
						if (firstClick && circle.contains(e.getX(), e.getY())) {
							start = System.currentTimeMillis();
							firstClick = false;
						}
						if (circle.contains((double)e.getX(), (double)e.getY())) {
							System.out.println("Hit !");
							counter++;
							repaint();
						}
					}
				}
			});


		}


		@Override
		protected void paintComponent(Graphics g) {

			// Generate random color
			int red = 0 + (int)(Math.random() * (255 + 0) + 1);
			int green = 0 + (int)(Math.random() * (255 + 0) + 1);
			int blue = 0 + (int)(Math.random() * (255 + 0) + 1);
			Color color = new Color(red, green, blue);

			// Generate random coordinations for the circle
			int xCircle = radius + (int)(Math.random() * ((getWidth() - radius) - radius) + 1);
			int yCircle = radius + (int)(Math.random() * ((getHeight() - radius) - radius) + 1);
			circle = new PE1011_Circle2D((double)xCircle, (double)yCircle, (double)radius);
			// Create coordinations for the final text message
			Font font = new Font("TimesRoman", Font.PLAIN, 12);
			FontMetrics fm = getFontMetrics(font);
			int xString = getWidth() / 2 - fm.stringWidth("Time spent: " + timeElapsed + " milliseconds") / 2;
			int yString = 30;

			super.paintComponent(g);

			if (counter < 20) {
				g.setColor(color);
				g.fillOval(xCircle - radius, yCircle - radius, 2 * radius, 2 * radius);
			} else {
				end = System.currentTimeMillis();
				timeElapsed = end - start;
				g.drawString("Time spent: " + timeElapsed + " milliseconds", xString, yString);
			}


		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1627_EyeHandCoordination();
		frame.setTitle("Exercise16_27");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
