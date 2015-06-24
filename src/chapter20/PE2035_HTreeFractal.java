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
 * @Date & @Time 8. 12. 2014 2014 7:51:17 
 */
@SuppressWarnings("serial")
public class PE2035_HTreeFractal extends JApplet {

	private JLabel jlblOrder = new JLabel("Enter an order:");
	private JTextField jtfOrder = new JTextField(5);
	private DrawHTree drawHTree = new DrawHTree();

	public PE2035_HTreeFractal() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		panel.add(jlblOrder);
		panel.add(jtfOrder);

		// Register listener
		jtfOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawHTree.setOrder(Integer.parseInt(jtfOrder.getText()));
				repaint();
			}
		});

		add(drawHTree, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}

	class DrawHTree extends JPanel {
		private int order;
		private int xCenter;
		private int yCenter;
		private final int LINE = 100;

		public void setOrder(int newOrder) {
			this.order = newOrder;
		}

		@Override
		protected void paintComponent(Graphics g) {

			xCenter = getWidth() / 2;
			yCenter = getHeight() / 2;

			super.paintComponent(g);

			drawHTree(g, order, xCenter, yCenter, LINE);
		}

		public void drawHTree(Graphics g, int order, int xCenter, int yCenter, int line) {
			g.drawLine(xCenter - line / 2, yCenter, xCenter + line / 2, yCenter);
			g.drawLine(xCenter - line / 2, yCenter - line / 2, xCenter - line / 2, yCenter + line / 2);
			g.drawLine(xCenter + line / 2, yCenter - line / 2, xCenter + line / 2, yCenter + line / 2);
			if (order > 0) {
				drawHTree(g, order - 1, xCenter - line / 2, yCenter  - line / 2 , line / 2);
				drawHTree(g, order - 1, xCenter + line / 2, yCenter - line / 2, line / 2);
				drawHTree(g, order - 1, xCenter - line / 2, yCenter + line / 2, line / 2);
				drawHTree(g, order - 1, xCenter + line / 2, yCenter + line / 2, line / 2);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE2035_HTreeFractal applet = new PE2035_HTreeFractal();
		JFrame frame = new JFrame();
		frame.add(applet);
		frame.setTitle("Exercise20_35");
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
