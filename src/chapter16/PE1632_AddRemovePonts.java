/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1011_Circle2D;

/**
 * @author jslapnicka
 * @Date & @Time 18. 9. 2014 2014 7:55:56 
 */
@SuppressWarnings("serial")
public class PE1632_AddRemovePonts extends JFrame {

	/**
	 * @param args
	 */

	public PE1632_AddRemovePonts() {
		// TODO Auto-generated constructor stub
		add(new DrawPoints());
	}

	class DrawPoints extends JPanel {
		int x;
		int y;
		int radius = 5;
		boolean paint;
		ArrayList<PE1011_Circle2D> points = new ArrayList<PE1011_Circle2D>();

		public DrawPoints() {
			// TODO Auto-generated constructor stub
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						x = e.getX();
						y = e.getY();
						paint = false;
						repaint();
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						x = e.getX();
						y = e.getY();
						paint = true;
						repaint();
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			
			if (paint) {
				points.add(new PE1011_Circle2D((double)x, (double)y, (double)radius));
				for (int i = 0; i < points.size(); i++) {
					g.drawOval((int)(points.get(i).getX()), (int)(points.get(i).getY()), radius, radius);
				}
			} else {
				for (int i = 0; i < points.size(); i++) {
					if (points.get(i).contains((double)x, (double)y)) {
						points.remove(i);
						System.out.println("--size = " + points.size());
					}
				}
				for (int i = 0; i < points.size(); i++) {
					g.drawOval((int)(points.get(i).getX()), (int)(points.get(i).getY()), radius, radius);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1632_AddRemovePonts();
		frame.setTitle("Exercise16_32");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
