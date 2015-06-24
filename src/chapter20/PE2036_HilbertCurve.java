/**
 * 
 */
package chapter20;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 8. 12. 2014 2014 8:59:52 
 */
@SuppressWarnings("serial")
public class PE2036_HilbertCurve extends JApplet {

	private JLabel jlblOrder = new JLabel("Enter an order: ");
	private JTextField jtfOrder = new JTextField(5);
	private DrawHilberCurve drawHilbertCurve = new DrawHilberCurve();

	public PE2036_HilbertCurve() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		panel.add(jlblOrder);
		panel.add(jtfOrder);

		// Register listener
		jtfOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawHilbertCurve.setOrder(Integer.parseInt(jtfOrder.getText()));
				repaint();
			}
		});

		add(drawHilbertCurve, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	class DrawHilberCurve extends JPanel {

		private int order = 1;
		private int xCenter;
		private int yCenter;
		private int length;

		public DrawHilberCurve() {
			// TODO Auto-generated constructor stub
		}

		public void setOrder(int newOrder) {
			this.order = newOrder;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {


			super.paintComponent(g);
			
			length = Math.min(getWidth(), getHeight());
			
			for (int i = 0; i < order; i++)
				length /= 2;

			// Reset start cursor position
			xCenter = length / 2;
			yCenter = length / 2;
			
			upperU(g, order);
		}

		private void upperU(Graphics g, int order) {
			if (order > 0) {
				leftU(g, order - 1);
				lineNewPosition(g, 0, length);
				upperU(g, order - 1);
				lineNewPosition(g, length, 0);
				upperU(g, order - 1);
				lineNewPosition(g, 0, -length);
				rightU(g, order - 1);
			}
		}

		private void leftU(Graphics g, int order) {
			if (order > 0) {
				upperU(g, order - 1);
				lineNewPosition(g, length, 0);
				leftU(g, order - 1);
				lineNewPosition(g, 0, length);
				leftU(g, order - 1);
				lineNewPosition(g, -length, 0);
				downU(g, order - 1);
			}
		}

		private void rightU(Graphics g, int order) {
			if (order > 0) {
				downU(g, order - 1);
				lineNewPosition(g, -length, 0);
				rightU(g, order - 1);
				lineNewPosition(g, 0, -length);
				rightU(g, order - 1);
				lineNewPosition(g, length, 0);
				upperU(g, order - 1);
			}
		}

		private void downU(Graphics g, int order) {
			if (order > 0) {
				rightU(g, order - 1);
				lineNewPosition(g, 0, -length);
				downU(g, order - 1);
				lineNewPosition(g, -length, 0);
				downU(g, order - 1);
				lineNewPosition(g, 0, length);
				leftU(g, order - 1);
			}
		}

		public void lineNewPosition(Graphics g, int deltaX, int deltaY) {
			g.drawLine(xCenter, yCenter, xCenter + deltaX, yCenter + deltaY);
			xCenter += deltaX;
			yCenter += deltaY;
		}
	}

	@Override
	public void init() {
		setSize(250, 250);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE2036_HilbertCurve applet = new PE2036_HilbertCurve();

		frame.add(applet);
		frame.setTitle("Exercise20_36");
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
