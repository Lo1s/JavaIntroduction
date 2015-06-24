/**
 * 
 */
package chapter16;


import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1011_Circle2D;

/**
 * @author jslapnicka
 * @Date & @Time 22. 9. 2014 2014 7:51:03 
 */
@SuppressWarnings("serial")
public class PE1639_BoundingRectangle extends JFrame {

	/**
	 * @param args
	 */

	public PE1639_BoundingRectangle() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1, 2));
		add(new InstructionPanel());
		add(new BoundingRectangle());
	}
	class BoundingRectangle extends JPanel {
		private int xCircle;
		private int yCircle;
		private int radiusCircle = 20;
		boolean paint;
		ArrayList<PE1011_Circle2D> points = new ArrayList<PE1011_Circle2D>();

		private int maxX = 170;
		private int minX = 20;
		private int maxY = 110;
		private int minY = 30;

		public BoundingRectangle() {
			// TODO Auto-generated constructor stub
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						xCircle = e.getX();
						yCircle = e.getY();
						paint = false;
						repaint();
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						xCircle = e.getX();
						yCircle = e.getY();
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
				points.add(new PE1011_Circle2D((double)xCircle, (double)yCircle, (double)radiusCircle));
				for (int i = 0; i < points.size(); i++) {
					g.drawOval((int)(points.get(i).getX()), (int)(points.get(i).getY()), radiusCircle, radiusCircle);
				}
				// Draw a bounding rectangle
				if (points.size() > 0) {
					maxX = (int)points.get(0).getX();
					minX = (int)points.get(0).getX();
					maxY = (int)points.get(0).getY();
					minY = (int)points.get(0).getY();
				}
				
				for (int j = 0; j < points.size(); j++) {
					if (maxX < (int)points.get(j).getX())
						maxX = (int)points.get(j).getX();
					if (minX > (int)points.get(j).getX())
						minX = (int)points.get(j).getX();
					if (maxY < (int)points.get(j).getY())
						maxY = (int)points.get(j).getY();
					if (minY > (int)points.get(j).getY())
						minY = (int)points.get(j).getY();
				}
				g.drawRect(minX, minY, (maxX - minX) + radiusCircle, (maxY - minY) + radiusCircle);
			} else {
				for (int i = 0; i < points.size(); i++) {
					if (points.get(i).contains((double)xCircle, (double)yCircle)) {
						points.remove(i);
					}
				}
				for (int i = 0; i < points.size(); i++) {
					g.drawOval((int)(points.get(i).getX()), (int)(points.get(i).getY()), radiusCircle, radiusCircle);
				}
				if (points.size() > 0) {
					maxX = (int)points.get(0).getX();
					minX = (int)points.get(0).getX();
					maxY = (int)points.get(0).getY();
					minY = (int)points.get(0).getY();
				}
				for (int j = 0; j < points.size(); j++) {
					if (maxX < (int)points.get(j).getX())
						maxX = (int)points.get(j).getX();
					if (minX > (int)points.get(j).getX())
						minX = (int)points.get(j).getX();
					if (maxY < (int)points.get(j).getY())
						maxY = (int)points.get(j).getY();
					if (minY > (int)points.get(j).getY())
						minY = (int)points.get(j).getY();
				}
				g.drawRect(minX, minY, (maxX - minX) + radiusCircle, (maxY - minY) + radiusCircle);

			}

		}
	}

	class InstructionPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawRect(20, 30, 180, 80);
			g.drawString("INSTRUCTIONS", 35, 50);
			g.drawString("Add:", 35, 70);
			g.drawString("Remove:", 35, 90);
			g.drawString("Left Click", 110, 70);
			g.drawString("Right Click", 110, 90);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1639_BoundingRectangle();
		frame.setTitle("Exercise16_39");
		frame.setSize(450, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
