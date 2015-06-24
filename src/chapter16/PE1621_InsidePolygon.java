/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 15. 9. 2014 2014 10:38:25 
 */
@SuppressWarnings("serial")
public class PE1621_InsidePolygon extends JFrame {

	/**
	 * @param args
	 */
	
	public PE1621_InsidePolygon() {
		// TODO Auto-generated constructor stub
		add(new DrawPolygon());
	}
	
	class DrawPolygon extends JPanel {
		Polygon p = new Polygon();
		int x;
		int y;
		boolean inside  = false;
		
		public DrawPolygon() {
			// TODO Auto-generated constructor stub
			p.addPoint(40, 20);
			p.addPoint(70, 40);
			p.addPoint(60, 80);
			p.addPoint(45, 45);
			p.addPoint(20, 60);
			
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					if (p.contains(x, y))
						inside = true;
					else
						inside = false;
					repaint();
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			g.drawPolygon(p);
			
			g.drawString(inside ? "Mouse point is in the polygon" : "Mouse point is not in the polygon", x, y);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1621_InsidePolygon();
		frame.setTitle("Exercise16_20");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

}
