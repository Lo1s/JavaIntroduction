/**
 * 
 */
package chapter18;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1004_MyPoint;
import chapter10.PE1012_Triangle2D;


/**
 * @author jslapnicka
 * @Date & @Time 11. 11. 2014 2014 8:15:55 
 */
@SuppressWarnings("serial")
public class PE1836_DisplayAngles extends JApplet {

	private Triangle triangle = new	Triangle();

	public PE1836_DisplayAngles() {
		// TODO Auto-generated constructor stub
		add(triangle);
	}


	class Triangle extends JPanel {

		private PE1012_Triangle2D triangle = new PE1012_Triangle2D();
		private Vertex[] vertices = new Vertex[3];

		public Triangle() {
			// TODO Auto-generated constructor stub
			vertices[0] = new Vertex(20, 20);
			vertices[1] = new Vertex(120, 20);
			vertices[2] = new Vertex(50, 100);
						
			// Register listener
			addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {
					if (vertices[0].contains(new Point(e.getX(), e.getY()))) {
						vertices[0].setX(e.getX());
						vertices[0].setY(e.getY());
					} else if (vertices[1].contains(new Point(e.getX(), e.getY()))) {
						vertices[1].setX(e.getX());
						vertices[1].setY(e.getY());
					} else if (vertices[2].contains(new Point(e.getX(), e.getY()))) {
						vertices[2].setX(e.getX());
						vertices[2].setY(e.getY());
					}			
					repaint();
				}

				@Override
				public void mouseMoved(MouseEvent e) {
					if (triangle.contains(new PE1004_MyPoint(e.getX(), e.getY())))
						setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					else
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			// Sides
			double sideA = vertices[1].getDistance(vertices[2]);
			double sideB = vertices[0].getDistance(vertices[2]);
			double sideC = vertices[0].getDistance(vertices[1]);

			// Calculate angles
			double alpha = Math.acos((sideA * sideA - sideB * sideB - sideC * sideC) / (-2 * sideB * sideC));
			double beta = Math.acos((sideB * sideB - sideA * sideA - sideC * sideC) / (-2 * sideA * sideC));
			double gamma = Math.acos((sideC * sideC - sideB * sideB - sideA * sideA) / (-2 * sideA * sideB));

			triangle.setP1(new PE1004_MyPoint(vertices[0].getX(), vertices[0].getY()));
			triangle.setP2(new PE1004_MyPoint(vertices[1].getX(), vertices[1].getY()));
			triangle.setP3(new PE1004_MyPoint(vertices[2].getX(), vertices[2].getY()));

			super.paintComponent(g);

			Polygon p = new Polygon();
			p.addPoint(vertices[0].getX(), vertices[0].getY());
			p.addPoint(vertices[1].getX(), vertices[1].getY());
			p.addPoint(vertices[2].getX(), vertices[2].getY());

			g.drawPolygon(p);
			for (int i = 0; i < vertices.length; i++) {
				g.fillOval(vertices[i].getX() - vertices[i].RADIUS / 4, vertices[i].getY() - vertices[i].RADIUS / 4,
						vertices[i].RADIUS / 2, vertices[i].RADIUS / 2);
			}
			g.drawString((int)Math.toDegrees(alpha) + "", vertices[0].getX(), vertices[0].getY());
			g.drawString((int)Math.toDegrees(beta) + "", vertices[1].getX(), vertices[1].getY());
			g.drawString((int)Math.toDegrees(gamma) + "", vertices[2].getX(), vertices[2].getY());
		}
	}

	static class Vertex {
		final int RADIUS = 10;
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

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			Vertex c = (Vertex)o;
			return c.getX() == x && c.getY() == y;
		}

		public static double getDistance(double x1, double y1, double x2, double y2) {
			return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		}

		public double getDistance(Vertex c) {
			return getDistance(this.x, this.y, c.getX(), c.getY());
		}

		public static double getDistance(Vertex c1, Vertex c2) {
			return getDistance(c1.getX(), c1.getY(), c2.getX(), c2.getY());
		}
		
		public boolean contains(Point p) {
			return getDistance(this.x , this.y, p.getX(), p.getY()) <= RADIUS;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1836_DisplayAngles applet = new PE1836_DisplayAngles();

		frame.add(applet);
		frame.setTitle("Exercise18_36");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
