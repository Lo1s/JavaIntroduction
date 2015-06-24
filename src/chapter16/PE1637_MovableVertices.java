/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1011_Circle2D;

/**
 * @author jslapnicka
 * @Date & @Time 19. 9. 2014 2014 10:59:40 
 */
@SuppressWarnings("serial")
public class PE1637_MovableVertices extends JFrame {

	/**
	 * @param args
	 */
	
	public PE1637_MovableVertices() {
		// TODO Auto-generated constructor stub
		add(new MovableVertices());
	}
	
	class MovableVertices extends JPanel {
		int circleRadius = 20;
		int xCircle1 = 20;
		int yCircle1 = 20;
		int xCircle2 = 120;
		int yCircle2 = 50;
		PE1011_Circle2D circle1;
		PE1011_Circle2D circle2;
		
		public MovableVertices() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if (distance(xCircle1, xCircle2, yCircle1, yCircle2) > 70) {
						if (circle1.contains(e.getX(), e.getY()) && (distance(e.getX(), e.getY(),
								(int)circle2.getX(), (int)circle2.getY())) > 70) {
							xCircle1 = e.getX();
							yCircle1 = e.getY();
						} else if (circle2.contains(e.getX(), e.getY()) && (distance(e.getX(), e.getY(),
								(int)circle1.getX(), (int)circle1.getY())) > 70) {
							xCircle2 = e.getX();
							yCircle2 = e.getY();
						}
						repaint();
					}
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// Draw two circles
			g.setColor(Color.GRAY);
			g.fillOval(xCircle1 - circleRadius, yCircle1 - circleRadius, 2 * circleRadius, 2 * circleRadius);
			circle1 = new PE1011_Circle2D((double)xCircle1, (double)yCircle1, (double)circleRadius);
			g.fillOval(xCircle2 - circleRadius, yCircle2 - circleRadius, 2 * circleRadius, 2 *circleRadius);
			circle2 = new PE1011_Circle2D((double)xCircle2, (double)yCircle2, (double)circleRadius);
			
			// Draw the connecting line
			g.setColor(Color.BLACK);
			g.drawLine(xCircle1, yCircle1, xCircle2, yCircle2);
			
			// Draw the distance string
			g.drawString(distance(xCircle1, xCircle2, yCircle1, yCircle2) + "", (xCircle1 + xCircle2) / 2,
					(yCircle1 + yCircle2) / 2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1637_MovableVertices();
		frame.setTitle("Exercise16_37");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static int distance(int x1, int x2, int y1, int y2) {
		return (int)(Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
	}

}
