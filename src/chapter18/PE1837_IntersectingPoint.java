/**
 * 
 */
package chapter18;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 11. 11. 2014 2014 12:45:56 
 */
@SuppressWarnings("serial")
public class PE1837_IntersectingPoint extends JApplet {

	
	
	public PE1837_IntersectingPoint() {
		// TODO Auto-generated constructor stub
		add(new InterSectingPoint());
	}
	
	class InterSectingPoint extends JPanel {
		
		private Vertex[] vertices = new Vertex[4];
		
		public InterSectingPoint() {
			// TODO Auto-generated constructor stub
			vertices[0] = new Vertex(20, 20);
			vertices[1] = new Vertex(56, 130);
			vertices[2] = new Vertex(100, 20);
			vertices[3] = new Vertex(16, 130);
			
			addMouseMotionListener(new MouseMotionAdapter() {
				
				@Override
				public void mouseDragged(MouseEvent e) {
					for (int i = 0; i < vertices.length; i++) {
						if (vertices[i].contains(new Point(e.getX(), e.getY()))) {
							vertices[i].setX(e.getX());
							vertices[i].setY(e.getY());
						}
					}
					repaint();
				}
			});
		}
		
		public Point intersectingPoint(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
			double a = (y1 - y2);
		    double b = -(x1 - x2);
		    double c = (y3 - y4);
		    double d = -(x3 - x4);
		    double e = ((y1 - y2) * x1 - (x1 - x2) * y1);
		    double f = ((y3 - y4) * x3 - (x3 - x4) * y3);
		    double denominator = a * d - b * c;
		    double x = (e * d - b * f) / denominator;
		    double y = (a * f - e * c) / denominator;
		    
		    if ((a * x + b * y) == e && (c * x + d * y) == f) {
		    	return new Point((int)x, (int)y);
		    } else 
		    	return new Point(-1, -1);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			g.drawLine(vertices[0].getX(), vertices[0].getY(), vertices[1].getX(), vertices[1].getY());
			g.drawLine(vertices[2].getX(), vertices[2].getY(), vertices[3].getX(), vertices[3].getY());
			
			for (int i = 0; i < vertices.length; i++) {
				g.fillOval(vertices[i].getX() - vertices[i].RADIUS / 4, vertices[i].getY() - vertices[i].RADIUS / 4, 
						vertices[i].RADIUS / 2, vertices[i].RADIUS / 2);
			}
			
			Point intersectingPoint = intersectingPoint(vertices[0].getX(), vertices[0].getY(), vertices[1].getX(), vertices[1].getY(), 
					vertices[2].getX(), vertices[2].getY(), vertices[3].getX(), vertices[3].getY());
			
			if (intersectingPoint.getX() != -1 && intersectingPoint.getY() != -1)
				g.fillOval((int)(intersectingPoint.getX() - vertices[0].RADIUS / 4), (int)(intersectingPoint.getY() - vertices[0].RADIUS / 4), 
						vertices[0].RADIUS / 2, vertices[0].RADIUS / 2);
		}
	}
	
	static class Vertex {
		
		final int RADIUS = 20;
		int x, y;
		
		public Vertex() {
			// TODO Auto-generated constructor stub
		}
		
		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Vertex(Point p) {
			this(p.x, p.y);
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		public void setX(int newX) {
			this.x = newX;
		}
		
		public void setY(int newY) {
			this.y = newY;
		}
		
		@Override
		public boolean equals(Object o) {
			Vertex c = (Vertex)o;
			return (this.x == c.getX()) && (this.y == c.getY());
		}
		
		public static double getDistance(int x1, int y1 , int x2, int y2) {
			return ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		}
		
		public double getDistance(Vertex c) {
			return getDistance(this.x, this.y, c.getX(), c.getY());
		}
		
		public static double getDistance(Vertex a, Vertex b) {
			return getDistance(a.getX(), a.getY(), b.getY(), b.getY());
		}
		
		public boolean contains(Point p) {
			return getDistance(this.x, this.y, p.x, p.y) <= RADIUS;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1837_IntersectingPoint applet = new PE1837_IntersectingPoint();
		
		frame.add(applet);
		frame.setTitle("Exercise18_37");
		frame.setSize(250, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
