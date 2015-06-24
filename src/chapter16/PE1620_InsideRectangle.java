/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1013_MyRectangle2D;

/**
 * @author jslapnicka
 * @Date & @Time 15. 9. 2014 2014 10:00:42 
 */
@SuppressWarnings("serial")
public class PE1620_InsideRectangle extends JFrame{

	/**
	 * @param args
	 */
	
	public PE1620_InsideRectangle() {
		// TODO Auto-generated constructor stub
		add(new DrawRectangle());
	}
	
	class DrawRectangle extends JPanel {
		int width = 100;
		int height = 40;
		int xRectangle = 100;
		int yRectangle = 60;
		int x;
		int y;
		boolean inside = false;
		PE1013_MyRectangle2D rectangle = new PE1013_MyRectangle2D((double)xRectangle, (double)yRectangle, width, height);
		
		public DrawRectangle() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					if (rectangle.contains((double)x, (double)y))
						inside = true;
					else
						inside = false;
					repaint();
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawRect(xRectangle - width / 2, yRectangle - height / 2, width, height);
			
			if (inside)
				g.drawString("Mouse point is in the rectangle", x, y);
			else
				g.drawString("Mouse point is not in the rectangle", x, y);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1620_InsideRectangle();
		frame.setTitle("Exercise16_20");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
