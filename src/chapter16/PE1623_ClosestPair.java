/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 16. 9. 2014 2014 10:48:25 
 */
@SuppressWarnings("serial")
public class PE1623_ClosestPair extends JFrame {

	/**
	 * @param args
	 */

	public PE1623_ClosestPair() {
		// TODO Auto-generated constructor stub
		add(new PaintPoints());
	}

	class PaintPoints extends JPanel {
		private int x;
		private int y;
		private ArrayList<Point> points = new ArrayList<Point>();
		boolean drawable = false;
		private double minDistance = 1000;
		private Point closestA = new Point();
		private Point closestB = new Point();

		public PaintPoints() {
			// TODO Auto-generated constructor stub
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					points.add(new Point(x, y));
					drawable = true;
					// Get the closest pair
					for (int i = 0; i < points.size() && points.size() > 1; i++) {
						for (int j = i + 1; j < points.size(); j++) {
							if (points.get(i).distance(points.get(j)) < minDistance) {
								minDistance = points.get(i).distance(points.get(j));
								closestA = points.get(i);
								closestB = points.get(j);
							}
						}
					}
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			
			for (int i = 0; i < points.size(); i++) {
				if (points.get(i).equals((Point)closestA) || points.get(i).equals((Point)closestB))
						g.fillOval((int)points.get(i).x, (int)points.get(i).y, 8, 8);
				else
					g.drawOval(points.get(i).x, points.get(i).y, 8, 8);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1623_ClosestPair();
		frame.setTitle("Exercise16_09");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
