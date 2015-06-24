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
public class PE1828_TwoCirclesIntersect extends JApplet {

	// Create the UI
	private DrawCircle circle = new DrawCircle();
	private TitledBorder titledBorder1 = new TitledBorder("Enter circle 1 info");
	private TitledBorder titledBorder2 = new TitledBorder("Enter circle 2 info");
	private JLabel jlblCenterX1 = new JLabel("Center X:");
	private JLabel jlblCenterY1 = new JLabel("Center Y:");
	private JLabel jlblRadius1 = new JLabel("Radius:");
	private JLabel jlblCenterX2 = new JLabel("Center X:");
	private JLabel jlblCenterY2 = new JLabel("Center Y:");
	private JLabel jlblRadius2 = new JLabel("Radius:");	
	private JTextField jtfCenterX1 = new JTextField(3);
	private JTextField jtfCenterY1 = new JTextField(3);
	private JTextField jtfRadius1 = new JTextField(3);
	private JTextField jtfCenterX2 = new JTextField(3);
	private JTextField jtfCenterY2 = new JTextField(3);
	private JTextField jtfRadius2 = new JTextField(3);
	private JButton jbtRedrawCircles = new JButton("Redraw Circles");
	private JPanel jpC1 = new JPanel(new GridLayout(3, 2));
	private JPanel jpC2 = new JPanel(new GridLayout(3, 2));
	private JPanel jpSettings = new JPanel(new GridLayout(1, 2));
	private JPanel jpBottom = new JPanel(new BorderLayout());

	public PE1828_TwoCirclesIntersect() {
		// TODO Auto-generated constructor stub
		// Arranging layout of the components used for the settings defined by the user
		jpC1.add(jlblCenterX1);
		jpC1.add(jtfCenterX1);
		jpC1.add(jlblCenterY1);
		jpC1.add(jtfCenterY1);
		jpC1.add(jlblRadius1);
		jpC1.add(jtfRadius1);
		jpC1.setBorder(titledBorder1);
		jpC2.add(jlblCenterX2);
		jpC2.add(jtfCenterX2);
		jpC2.add(jlblCenterY2);
		jpC2.add(jtfCenterY2);
		jpC2.add(jlblRadius2);
		jpC2.add(jtfRadius2);
		jpC2.setBorder(titledBorder2);
		jpSettings.add(jpC1);
		jpSettings.add(jpC2);
		jpBottom.add(jpSettings, BorderLayout.CENTER);
		jpBottom.add(jbtRedrawCircles, BorderLayout.SOUTH);

		// Register listeners
		jbtRedrawCircles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (!jtfCenterX1.getText().isEmpty())
					circle.c1.setX(Integer.parseInt(jtfCenterX1.getText()));
				if (!jtfCenterY1.getText().isEmpty())
					circle.c1.setY(Integer.parseInt(jtfCenterY1.getText()));
				if (!jtfCenterX2.getText().isEmpty())
					circle.c2.setX(Integer.parseInt(jtfCenterX2.getText()));
				if (!jtfCenterY2.getText().isEmpty())
					circle.c2.setY(Integer.parseInt(jtfCenterY2.getText()));
				if (!jtfRadius1.getText().isEmpty())
					circle.c1.setRadius(Integer.parseInt(jtfRadius1.getText()));
				if (!jtfRadius2.getText().isEmpty())
					circle.c2.setRadius(Integer.parseInt(jtfRadius2.getText()));
				repaint();
			}
		});

		circle.setBorder(new LineBorder(Color.BLACK));
		// Add items into the frame
		add(circle, BorderLayout.CENTER);
		add(jpBottom, BorderLayout.SOUTH);
	}

	class Circle2D {
		private int x;
		private int y;
		private int radius;

		public Circle2D() {
			this.x = 0;
			this.y = 0;
			this.radius = 1;
		}

		public Circle2D(int x, int y, int radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		public void setX(int newX) {
			this.x = newX;
		}

		public void setY(int newY) {
			this.y = newY;
		}

		public void setRadius(int newRadius) {
			this.radius = newRadius;
		}

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}


		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @return the radius
		 */
		public int getRadius() {
			return radius;
		}

		public double getArea() {
			return Math.PI * Math.pow(this.radius, 2);
		}

		public double getPerimeter() {
			return Math.PI * this.radius * 2;
		}

		public boolean contains(int x, int y)	{
			return ((x > this.getX() - this.getRadius() && x < this.getX() + this.radius
					&& y > this.getY() - this.getRadius() && y < this.getY() + this.getRadius()));
		}

		public boolean contains(Circle2D circle) {
			double d = distance(x, y, circle.x, circle.y);
			return d + circle.radius <= radius;
		}

		public boolean overlaps(Circle2D circle) {
			return distance(this.x, this.y, circle.x, circle.y) <= this.radius + circle.radius;
		}
	}

	class DrawCircle extends JPanel {
		private String status;
		private Circle2D c1 = new Circle2D(40, 40, 30);
		private Circle2D c2 = new Circle2D(240, 40, 30);

		public DrawCircle() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {
					System.out.println(c1.contains(e.getX(), e.getY()));
					if (c1.contains(e.getX(), e.getY())) {
						System.out.println("mouse x: " + e.getX() + "\nmouse y: " + e.getY());
						c1.setX(e.getX());
						c1.setY(e.getY());
						jtfCenterX1.setText(c1.getX() + "");
						jtfCenterY1.setText(c1.getY() + "");
						jtfRadius1.setText(c1.getRadius() + "");
					} else if (c2.contains(e.getX(), e.getY())) {
						c2.setX(e.getX());
						c2.setY(e.getY());
						jtfCenterX2.setText(c2.getX() + "");
						jtfCenterY2.setText(c2.getY() + "");
						jtfRadius2.setText(c2.getRadius() + "");
					}
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawOval(c1.getX() - c1.getRadius(), c1.getY() - c1.getRadius(), 2 * c1.getRadius(), 2 * c1.getRadius());
			g.drawString("c1", c1.getX(), c1.getY());
			g.drawOval(c2.getX() - c2.getRadius(), c2.getY() - c2.getRadius(), 2 * c2.getRadius(), 2 * c2.getRadius());
			g.drawString("c2", c2.getX(), c2.getY());

			if (c1.overlaps(c2))
				status = "Two circles intersect";
			else
				status = "Two circles does not intersect";
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
		PE1828_TwoCirclesIntersect applet = new PE1828_TwoCirclesIntersect();
		frame.add(applet);

		frame.setTitle("Exercise18_28");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
