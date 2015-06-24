/**
 * 
 */
package chapter20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 26. 11. 2014 2014 14:38:37 
 */
@SuppressWarnings("serial")
public class PE2027_KochSnowflake extends JFrame {

	private JTextField jtfOrder = new JTextField(5);
	private DrawSnowflake snowflake = new DrawSnowflake();
	
	public PE2027_KochSnowflake() {
		// TODO Auto-generated constructor stub
		JPanel jpOrder = new JPanel();
		jpOrder.add(new JLabel("Enter an order: "));
		jpOrder.add(jtfOrder);
		
		add(snowflake, BorderLayout.CENTER);
		add(jpOrder, BorderLayout.SOUTH);
		
		// Register listener
		jtfOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				snowflake.setOrder(Integer.parseInt(jtfOrder.getText()));
			}
		});
		
	}
	
	static class DrawSnowflake extends JPanel {
		
		private int order = 0;
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			int side = (int)((double)Math.min(getWidth(), getHeight()) * 0.80000000000000004D);
            int triangleHeight = (int)((double)side * Math.sin(Math.toRadians(60D)));
            Point p1 = new Point(getWidth() / 2, 10);
            Point p2 = new Point(getWidth() / 2 - side / 2, 10 + triangleHeight);
            Point p3 = new Point(getWidth() / 2 + side / 2, 10 + triangleHeight);
			
			g.setColor(Color.BLUE);
			
			drawSnowflake(g, order, p1, p2);
			drawSnowflake(g, order, p2, p3);
			drawSnowflake(g, order, p3, p1);
		}
		
		public void setOrder(int order) {
			this.order = order;
			repaint();
		}
		
		private static void drawSnowflake(Graphics g, int order, Point p1, Point p2) {
			if (order == 0) {
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
			} else {
				int deltaX = p2.x - p1.x;
				int deltaY = p2.y - p1.y;
				Point x = new Point(p1.x + deltaX / 3, p1.y + deltaY / 3);
				Point y = new Point(p1.x + (2 * deltaX) / 3, p1.y + (2 * deltaY) / 3);
				Point z = new Point((int)((double)((p1.x + p2.x) / 2) + (Math.cos(Math.toRadians(30D)) * (double)(p1.y - p2.y)) / 3D), 
						(int)((double)((p1.y + p2.y) / 2) + (Math.cos(Math.toRadians(30D)) * (double)(p2.x - p1.x)) / 3D));
				
				drawSnowflake(g, order - 1, p1, x);
				drawSnowflake(g, order - 1, x, z);
				drawSnowflake(g, order - 1, z, y);
				drawSnowflake(g, order - 1, y, p2);
			}
				
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE2027_KochSnowflake frame = new PE2027_KochSnowflake();
		frame.setTitle("Exercise20_27");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
