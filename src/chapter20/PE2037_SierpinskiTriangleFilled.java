/**
 * 
 */
package chapter20;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * @author jslapnicka
 * @Date & @Time 8. 12. 2014 2014 13:15:43 
 */
@SuppressWarnings("serial")
public class PE2037_SierpinskiTriangleFilled extends JApplet {

	private JTextField jtfOrder = new JTextField("0", 5); // Order
	private SierpinskiTriangle trianglePanel = new SierpinskiTriangle();
	
	public PE2037_SierpinskiTriangleFilled() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter an order: "));
		panel.add(jtfOrder);
		jtfOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Add Sierpinski triangle panel to the applet
		add(trianglePanel);
		add(panel, BorderLayout.SOUTH);
		
		// Register a listener
		jtfOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trianglePanel.setOrder(Integer.parseInt(jtfOrder.getText()));
			}
		});
	}
	
	
	static class SierpinskiTriangle extends JPanel {
		private int order = 0;
		
		/** Set a new order */
		public void setOrder(int order) {
			this.order = order;
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			// Select three points in proportion to the panel size
			Point p1 = new Point(getWidth() / 2, 10);
			Point p2 = new Point(10, getHeight() - 10);
			Point p3 = new Point(getWidth() - 10, getHeight() - 10);
			
			displayTriangles(g, order, p1, p2, p3);
		}
		
		private static void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3) {
			if (order == 0) {
				// Draw a triangle to connect three points
				Polygon p = new Polygon();
				p.addPoint(p1.x, p1.y);
				p.addPoint(p2.x, p2.y);
				p.addPoint(p3.x, p3.y);
				
				g.fillPolygon(p);
				
			}
			else {
				// Get the midpoint on each edge of thte triangle
				Point p12 = midpoint(p1, p2);
				Point p23 = midpoint(p2, p3);
				Point p31 = midpoint(p3, p1);
				
				// Recursively display three triangles
				displayTriangles(g, order - 1, p1, p12, p31);
				displayTriangles(g, order - 1, p12, p2, p23);
				displayTriangles(g, order - 1, p31, p23, p3);
			}
		}
		
		private static Point midpoint(Point p1, Point p2) {
			return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE2037_SierpinskiTriangleFilled applet = new PE2037_SierpinskiTriangleFilled();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Exercise20_37");
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
