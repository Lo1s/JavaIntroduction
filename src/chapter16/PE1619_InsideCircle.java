/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 15. 9. 2014 2014 9:07:14 
 */
@SuppressWarnings("serial")
public class PE1619_InsideCircle extends JFrame {


	public PE1619_InsideCircle() {
		// TODO Auto-generated constructor stub
		add(new DrawCircle());
	}

	class DrawCircle extends JPanel {
		private boolean inside = false;
		int xCircle = 100;
		int yCircle = 60;
		int radius = 50;
		int x;
		int y;

		public DrawCircle() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					isInside(x, y);
					repaint();
				}

				@Override
				public void mouseDragged(MouseEvent e) {

				}
			});
		}

		public void isInside(int x, int y) {
			if ((x > xCircle - radius) && (x < xCircle + radius) && (y > yCircle - radius) 
					&& (y < yCircle + radius))
				inside = true;
			else
				inside = false;

		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawOval(xCircle - radius, yCircle - radius, 2 * radius, 2 * radius);

			if (inside)
				g.drawString("Mouse point is in the circle", x, y);
			else
				g.drawString("Mouse point is not in the circle", x, y);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1619_InsideCircle();
		frame.setTitle("Exercise16_19");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
