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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;




/**
 * @author jslapnicka
 * @Date & @Time 30. 10. 2014 2014 8:23:21 
 */
@SuppressWarnings("serial")
public class PE1829_TwoRectanglesIntersect extends JApplet {

	// Create the UI
	private DrawRectangle rectangle = new DrawRectangle();
	private TitledBorder titledBorder1 = new TitledBorder("Enter rectangle 1 info");
	private TitledBorder titledBorder2 = new TitledBorder("Enter rectangle 2 info");
	private JLabel jlblCenterX1 = new JLabel("Center X:");
	private JLabel jlblCenterY1 = new JLabel("Center Y:");
	private JLabel jlblWidth1 = new JLabel("Width:");
	private JLabel jlblHeight1 = new JLabel("Height:");
	private JLabel jlblCenterX2 = new JLabel("Center X:");
	private JLabel jlblCenterY2 = new JLabel("Center Y:");
	private JLabel jlblWidth2 = new JLabel("Width:");
	private JLabel jlblHeight2 = new JLabel("Height:");
	private JTextField jtfCenterX1 = new JTextField(3);
	private JTextField jtfCenterY1 = new JTextField(3);
	private JTextField jtfWidth1 = new JTextField(3);
	private JTextField jtfHeight1 = new JTextField(3);
	private JTextField jtfCenterX2 = new JTextField(3);
	private JTextField jtfCenterY2 = new JTextField(3);
	private JTextField jtfWidth2 = new JTextField(3);
	private JTextField jtfHeight2 = new JTextField(3);
	private JButton jbtRedrawCircles = new JButton("Redraw Rectangles");
	private JPanel jpR1 = new JPanel(new GridLayout(4, 2));
	private JPanel jpR2 = new JPanel(new GridLayout(4, 2));
	private JPanel jpSettings = new JPanel(new GridLayout(1, 2));
	private JPanel jpBottom = new JPanel(new BorderLayout());

	public PE1829_TwoRectanglesIntersect() {
		// TODO Auto-generated constructor stub
		// Arranging layout of the components used for the settings defined by the user
		jpR1.add(jlblCenterX1);
		jpR1.add(jtfCenterX1);
		jpR1.add(jlblCenterY1);
		jpR1.add(jtfCenterY1);
		jpR1.add(jlblWidth1);
		jpR1.add(jtfWidth1);
		jpR1.add(jlblHeight1);
		jpR1.add(jtfHeight1);
		jpR1.setBorder(titledBorder1);
		jpR2.add(jlblCenterX2);
		jpR2.add(jtfCenterX2);
		jpR2.add(jlblCenterY2);
		jpR2.add(jtfCenterY2);
		jpR2.add(jlblWidth2);
		jpR2.add(jtfWidth2);
		jpR2.add(jlblHeight2);
		jpR2.add(jtfHeight2);
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
				if (!jtfCenterX1.getText().isEmpty())
					rectangle.r1.setX(Integer.parseInt(jtfCenterX1.getText()));
				if (!jtfCenterY1.getText().isEmpty())
					rectangle.r1.setY(Integer.parseInt(jtfCenterY1.getText()));
				if (!jtfCenterX2.getText().isEmpty())
					rectangle.r2.setX(Integer.parseInt(jtfCenterX2.getText()));
				if (!jtfCenterY2.getText().isEmpty())
					rectangle.r2.setY(Integer.parseInt(jtfCenterY2.getText()));
				if (!jtfWidth1.getText().isEmpty())
					rectangle.r1.setWidth(Integer.parseInt(jtfWidth1.getText()));
				if (!jtfWidth2.getText().isEmpty())
					rectangle.r2.setWidth(Integer.parseInt(jtfWidth2.getText()));
				if (!jtfHeight1.getText().isEmpty())
					rectangle.r1.setHeight(Integer.parseInt(jtfHeight1.getText()));
				if (!jtfHeight2.getText().isEmpty())
					rectangle.r2.setHeight(Integer.parseInt(jtfHeight2.getText()));
				repaint();
			}
		});

		rectangle.setBorder(new LineBorder(Color.BLACK));
		// Add items into the frame
		add(rectangle, BorderLayout.CENTER);
		add(jpBottom, BorderLayout.SOUTH);
	}

	class Rectangle2D {
		private double x;
		private double y;
		private double width;
		private double height;

		public Rectangle2D() {
			this.x = 0;
			this.y = 0;
			this.width = 1;
			this.height = 1;
		}

		public Rectangle2D(double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		/**
		 * @return the x
		 */
		public double getX() {
			return x;
		}

		/**
		 * @param x the x to set
		 */
		public void setX(double x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public double getY() {
			return y;
		}

		/**
		 * @param y the y to set
		 */
		public void setY(double y) {
			this.y = y;
		}

		/**
		 * @return the width
		 */
		public double getWidth() {
			return width;
		}

		/**
		 * @param width the width to set
		 */
		public void setWidth(double width) {
			this.width = width;
		}

		/**
		 * @return the height
		 */
		public double getHeight() {
			return height;
		}

		/**
		 * @param height the height to set
		 */
		public void setHeight(double height) {
			this.height = height;
		}

		public double getArea() {
			return this.width * this.height;
		}

		public double getPerimeter() {
			return 2 * this.width + 2 * this.height;
		}

		public boolean contains(double x, double y) {
			return Math.abs(x - this.x) <= width / 2D && Math.abs(y - this.y) <= height / 2D;	
		}

		public boolean contains(Rectangle2D r) {
			return (r.x + r.width / 2 < this.x + this.width / 2 && r.y + r.height / 2 < this.y + this.height / 2) && (r.x - r.width / 2 > this.x - this.width / 2 && r.y  - r.height / 2 > this.y - this.height / 2);
		}

		public boolean overlaps(Rectangle2D r) {
			// Creating points A. B. C, D for the first triangle
			Point2D A1 = new Point2D.Double(this.x - this.width / 2, this.y - this.height / 2);
			Point2D B1 = new Point2D.Double(this.x + this.width / 2, this.y - this.height / 2);
			Point2D C1 = new Point2D.Double(this.x + this.width / 2, this.y + this.height / 2);
			Point2D D1 = new Point2D.Double(this.x - this.width / 2, this.y + this.height / 2);

			// Creating points A, B, C, D for the second (passed) triangle
			Point2D A2 = new Point2D.Double(r.x - r.width / 2, r.y - r.height / 2);
			Point2D B2 = new Point2D.Double(r.x + r.width / 2, r.y - r.height / 2);
			Point2D C2 = new Point2D.Double(r.x + r.width / 2, r.y + r.height / 2);
			Point2D D2 = new Point2D.Double(r.x - r.width / 2, r.y + r.height / 2);

			// Creating sides for the first triangle
			Line2D sideAr1 = new Line2D.Double(A1, B1);
			Line2D sideBr1 = new Line2D.Double(B1, C1);
			Line2D sideCr1 = new Line2D.Double(C1, D1);
			Line2D sideDr1 = new Line2D.Double(D1, A1);

			// Creating sides for the second triangle
			Line2D sideAr2 = new Line2D.Double(A2, B2);
			Line2D sideBr2 = new Line2D.Double(B2, C2);
			Line2D sideCr2 = new Line2D.Double(C2, D2);
			Line2D sideDr2 = new Line2D.Double(D2, A2);

			return (sideAr1.intersectsLine(sideAr2) || 
					sideAr1.intersectsLine(sideBr2) || 
					sideAr1.intersectsLine(sideCr2) ||
					sideAr1.intersectsLine(sideDr2) ||
					sideBr1.intersectsLine(sideAr2) ||
					sideBr1.intersectsLine(sideBr2) ||
					sideBr1.intersectsLine(sideCr2) ||
					sideBr1.intersectsLine(sideDr2) ||
					sideCr1.intersectsLine(sideAr2) ||
					sideCr1.intersectsLine(sideBr2) ||
					sideCr1.intersectsLine(sideCr2) ||
					sideCr1.intersectsLine(sideDr2) ||
					sideDr1.intersectsLine(sideAr2) ||
					sideDr1.intersectsLine(sideBr2) ||
					sideDr1.intersectsLine(sideCr2) ||
					sideDr1.intersectsLine(sideDr2));
		}		

	}

	class DrawRectangle extends JPanel {
		private String status;
		private Rectangle2D r1 = new Rectangle2D(40, 40, 60, 60);
		private Rectangle2D r2 = new Rectangle2D(240, 40, 60, 60);

		public DrawRectangle() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {
					System.out.println(r1.contains(e.getX(), e.getY()));
					if (r1.contains(e.getX(), e.getY())) {
						System.out.println("mouse x: " + e.getX() + "\nmouse y: " + e.getY());
						r1.setX(e.getX());
						r1.setY(e.getY());
						jtfCenterX1.setText(r1.getX() + "");
						jtfCenterY1.setText(r1.getY() + "");
						jtfWidth1.setText(r1.getWidth() + "");
						jtfHeight1.setText(r1.getHeight() + "");
					} else if (r2.contains(e.getX(), e.getY())) {
						r2.setX(e.getX());
						r2.setY(e.getY());
						jtfCenterX2.setText(r2.getX() + "");
						jtfCenterY2.setText(r2.getY() + "");
						jtfWidth2.setText(r2.getWidth() + "");
						jtfHeight2.setText(r2.getHeight() + "");
					}
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawRect((int)(r1.getX() - r1.getWidth() / 2), (int)(r1.getY() - r1.getHeight() / 2), 
					(int)r1.getWidth(), (int)r1.getHeight());
			g.drawString("r1", (int)r1.getX(), (int)r1.getY());
			g.drawRect((int)(r2.getX() - r2.getWidth() / 2), (int)(r2.getY() - r2.getHeight() / 2), 
					(int)r2.getWidth(), (int)r2.getHeight());
			g.drawString("r2", (int)r2.getX(), (int)r2.getY());

			if (r1.overlaps(r2))
				status = "Two rectangles intersect";
			else
				status = "Two rectangles does not intersect";
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
		PE1829_TwoRectanglesIntersect applet = new PE1829_TwoRectanglesIntersect();
		frame.add(applet);

		frame.setTitle("Exercise18_29");
		frame.setSize(300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
