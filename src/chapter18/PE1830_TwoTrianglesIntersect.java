/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;


import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import chapter10.PE1004_MyPoint;



/**
 * @author jslapnicka
 * @Date & @Time 30. 10. 2014 2014 8:23:21 
 */
@SuppressWarnings("serial")
public class PE1830_TwoTrianglesIntersect extends JApplet {

	// Create the UI
	private DrawTriangle triangle = new DrawTriangle();
	private TitledBorder titledBorder1 = new TitledBorder("Enter triangle 1 info");
	private TitledBorder titledBorder2 = new TitledBorder("Enter triangle 2 info");
	private JLabel jlblP1X1 = new JLabel("p1.x:");
	private JLabel jlblP1Y1 = new JLabel("p1.y:");
	private JLabel jlblP2X1 = new JLabel("p2.x:");
	private JLabel jlblP2Y1 = new JLabel("p2.y:");
	private JLabel jlblP3X1 = new JLabel("p3.x:");
	private JLabel jlblP3Y1 = new JLabel("p3.y:");
	private JLabel jlblP1X2 = new JLabel("p1.x:");
	private JLabel jlblP1Y2 = new JLabel("p1.y:");
	private JLabel jlblP2X2 = new JLabel("p2.x:");
	private JLabel jlblP2Y2 = new JLabel("p2.y:");
	private JLabel jlblP3X2 = new JLabel("p3.x:");
	private JLabel jlblP3Y2 = new JLabel("p3.y:");
	private JTextField jtfP1X1 = new JTextField(3);
	private JTextField jtfP1Y1 = new JTextField(3);
	private JTextField jtfP2X1 = new JTextField(3);
	private JTextField jtfP2Y1 = new JTextField(3);
	private JTextField jtfP3X1 = new JTextField(3);
	private JTextField jtfP3Y1 = new JTextField(3);
	private JTextField jtfP1X2 = new JTextField(3);
	private JTextField jtfP1Y2 = new JTextField(3);
	private JTextField jtfP2X2 = new JTextField(3);
	private JTextField jtfP2Y2 = new JTextField(3);
	private JTextField jtfP3X2 = new JTextField(3);
	private JTextField jtfP3Y2 = new JTextField(3);
	private JButton jbtRedrawCircles = new JButton("Redraw Triangles");
	private JPanel jpR1 = new JPanel(new GridLayout(6, 2));
	private JPanel jpR2 = new JPanel(new GridLayout(6, 2));
	private JPanel jpSettings = new JPanel(new GridLayout(1, 2));
	private JPanel jpBottom = new JPanel(new BorderLayout());

	public PE1830_TwoTrianglesIntersect() {
		// TODO Auto-generated constructor stub
		// Arranging layout of the components used for the settings defined by the user
		jpR1.add(jlblP1X1);
		jpR1.add(jtfP1X1);
		jpR1.add(jlblP1Y1);
		jpR1.add(jtfP1Y1);
		jpR1.add(jlblP2X1);
		jpR1.add(jtfP2X1);
		jpR1.add(jlblP2Y1);
		jpR1.add(jtfP2Y1);
		jpR1.add(jlblP3X1);
		jpR1.add(jtfP3X1);
		jpR1.add(jlblP3Y1);
		jpR1.add(jtfP3Y1);
		jpR1.setBorder(titledBorder1);
		jpR2.add(jlblP1X2);
		jpR2.add(jtfP1X2);
		jpR2.add(jlblP1Y2);
		jpR2.add(jtfP1Y2);
		jpR2.add(jlblP2X2);
		jpR2.add(jtfP2X2);
		jpR2.add(jlblP2Y2);
		jpR2.add(jtfP2Y2);
		jpR2.add(jlblP3X2);
		jpR2.add(jtfP3X2);
		jpR2.add(jlblP3Y2);
		jpR2.add(jtfP3Y2);
		jpR2.setBorder(titledBorder2);
		jpSettings.add(jpR1);
		jpSettings.add(jpR2);
		jpBottom.add(jpSettings, BorderLayout.CENTER);
		jpBottom.add(jbtRedrawCircles, BorderLayout.SOUTH);

		// Register listeners
		jbtRedrawCircles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!jtfP1X1.getText().isEmpty() && !jtfP1Y1.getText().isEmpty())
					triangle.t1.setP1(new PE1004_MyPoint(Integer.parseInt(jtfP1X1.getText()), Integer.parseInt(jtfP1Y1.getText())));
				if (!jtfP2X1.getText().isEmpty() && !jtfP2Y1.getText().isEmpty())
					triangle.t1.setP2(new PE1004_MyPoint(Integer.parseInt(jtfP2X1.getText()), Integer.parseInt(jtfP2Y1.getText())));
				if (!jtfP3X1.getText().isEmpty() && !jtfP3Y1.getText().isEmpty())
					triangle.t1.setP3(new PE1004_MyPoint(Integer.parseInt(jtfP3X1.getText()), Integer.parseInt(jtfP3Y1.getText())));
				if (!jtfP1X2.getText().isEmpty() && !jtfP1Y2.getText().isEmpty())
					triangle.t2.setP1(new PE1004_MyPoint(Integer.parseInt(jtfP1X2.getText()), Integer.parseInt(jtfP1Y2.getText())));
				if (!jtfP2X2.getText().isEmpty() && !jtfP2Y2.getText().isEmpty())
					triangle.t2.setP2(new PE1004_MyPoint(Integer.parseInt(jtfP2X2.getText()), Integer.parseInt(jtfP2Y2.getText())));
				if (!jtfP3Y2.getText().isEmpty() && !jtfP3Y2.getText().isEmpty())
					triangle.t2.setP3(new PE1004_MyPoint(Integer.parseInt(jtfP3X2.getText()), Integer.parseInt(jtfP3Y2.getText())));
				repaint();
			}
		});

		triangle.setBorder(new LineBorder(Color.BLACK));
		// Add items into the frame
		add(triangle, BorderLayout.CENTER);
		add(jpBottom, BorderLayout.SOUTH);
	}

	class Triangle2D {
		private PE1004_MyPoint p1, p2, p3;

		public Triangle2D() {
			// TODO Auto-generated constructor stub
			this.p1 = new PE1004_MyPoint(0, 0);
			this.p2 = new PE1004_MyPoint(1, 1);
			this.p3 = new PE1004_MyPoint(2, 5);
		}

		public Triangle2D(PE1004_MyPoint p1, PE1004_MyPoint p2, PE1004_MyPoint p3) {
			this.p1 = p1;
			this.p2 = p2;
			this.p3 = p3;
		}

		public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
			this.p1 = new PE1004_MyPoint(x1, y1);
			this.p2 = new PE1004_MyPoint(x2, y2);
			this.p3 = new PE1004_MyPoint(x3, y3);		
		}

		/**
		 * @return the p1
		 */
		public PE1004_MyPoint getP1() {
			return p1;
		}

		/**
		 * @param p1 the p1 to set
		 */
		public void setP1(PE1004_MyPoint p1) {
			this.p1 = p1;
		}

		/**
		 * @return the p2
		 */
		public PE1004_MyPoint getP2() {
			return p2;
		}

		/**
		 * @param p2 the p2 to set
		 */
		public void setP2(PE1004_MyPoint p2) {
			this.p2 = p2;
		}

		/**
		 * @return the p3
		 */
		public PE1004_MyPoint getP3() {
			return p3;
		}

		/**
		 * @param p3 the p3 to set
		 */
		public void setP3(PE1004_MyPoint p3) {
			this.p3 = p3;
		}

		public double getArea() {
			double side1 = p1.distance(p2);
			double side2 = p1.distance(p3);
			double side3 = p3.distance(p2);

			double s = (side1 + side2 + side3) / 2D;
			return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		}

		public double getPerimeter() {
			return p1.distance(p2) + p1.distance(p3) + p3.distance(p2);
		}

		public boolean contains(PE1004_MyPoint p) {
			// Creating max/min values for the X and Y
			double maxX = Math.max(p1.getX(), Math.max(p2.getX(), p3.getX()));
			double minX = Math.min(p1.getX(), Math.min(p2.getX(), p3.getX()));
			double maxY = Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()));
			double minY = Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()));

			if (p.getX() < minX || p.getX() > maxX || p.getY() < minY || p.getY() > maxY)
				return false;	// Outside the bounding rectangle of the triangle

			Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
			Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

			if (side1.contains(p.getX(), p.getY()) || side2.contains(p.getX(), p.getY()) || side3.contains(p.getX(), p.getY()))
				return true;	// On the border of the line

			double topY = -10;
			if (p.getX() == p1.getX()) {
				topY = p1.getY();
			} 
			else if (p.getX() == p2.getX()) {
				topY = p2.getY();
			} 
			else if (p.getX() == p3.getX()) {
				topY = p3.getY();
			} 

			Line2D line;
			if (p.getY() < topY) 
				line = new Line2D.Double(p.getX(), p.getY(), p.getX(), minY);
			else  
				line = new Line2D.Double(p.getX(), p.getY(), p.getX(), maxY);

			int hits = 0;
			if (line.intersectsLine(side1))
				hits++;

			if (line.intersectsLine(side2))
				hits++;

			if (line.intersectsLine(side3))
				hits++;

			if (hits % 2 == 0) 
				return false;
			else 
				return true;
		}

		public boolean contains(Triangle2D t) {
			return contains(t.p1) && contains(t.p2) && contains(t.p3);
		}

		/** Return true if a triangle overlaps with this triangle */
		public boolean overlaps(Triangle2D t) {    
			// Two triangles overlap if one is inside the other or a side in
			// one triangle intersects a side in the other triangle
			Line2D line1 = new Line2D.Double(t.getP1().getX(), t.getP1().getY(), t.getP2().getX(), t.getP2().getY());
			Line2D line2 = new Line2D.Double(t.getP1().getX(), t.getP1().getY(), t.getP3().getX(), t.getP3().getY());
			Line2D line3 = new Line2D.Double(t.getP2().getX(), t.getP2().getY(), t.getP3().getX(), t.getP3().getY());

			Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
			Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

			return contains(t) || t.contains(this) ||
					line1.intersectsLine(side1) || 
					line1.intersectsLine(side2) || 
					line1.intersectsLine(side3) || 
					line2.intersectsLine(side1) || 
					line2.intersectsLine(side2) || 
					line2.intersectsLine(side3) ||
					line3.intersectsLine(side1) || 
					line3.intersectsLine(side2) || 
					line3.intersectsLine(side3);
		}	
	}

	class DrawTriangle extends JPanel {
		private String status;
		private Triangle2D t1 = new Triangle2D(10, 10, 30, 50, 59, 30);
		private Triangle2D t2 = new Triangle2D(60, 50, 34, 2, 163, 26);

		public DrawTriangle() {
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			Polygon p1 = new Polygon();
			p1.addPoint((int)t1.getP1().getX(), (int)t1.getP1().getY());
			p1.addPoint((int)t1.getP2().getX(), (int)t1.getP2().getY());
			p1.addPoint((int)t1.getP3().getX(), (int)t1.getP3().getY());
			g.drawString("t1", (int)t1.getP1().getX(), (int)t1.getP1().getY());
			Polygon p2 = new Polygon();
			p2.addPoint((int)t2.getP1().getX(), (int)t2.getP1().getY());
			p2.addPoint((int)t2.getP2().getX(), (int)t2.getP2().getY());
			p2.addPoint((int)t2.getP3().getX(), (int)t2.getP3().getY());
			g.drawString("t2", (int)t2.getP1().getX(), (int)t2.getP1().getY());

			g.drawPolygon(p1);
			g.drawPolygon(p2);
			
			if (t1.overlaps(t2))
				status = "Two triangles intersect";
			else
				status = "Two triangles does not intersect";
			Font font = new Font("TimesRoman", Font.BOLD, 10);
			FontMetrics fm = getFontMetrics(font);
			g.setFont(font);
			g.drawString(status, (getWidth() / 2) - (fm.stringWidth(status) / 2), 10);
		}
	}

	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1830_TwoTrianglesIntersect applet = new PE1830_TwoTrianglesIntersect();
		frame.add(applet);

		frame.setTitle("Exercise18_30");
		frame.setSize(300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
