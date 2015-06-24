/**
 * 
 */
package chapter20;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author jslapnicka
 * @Date & @Time 8. 12. 2014 2014 15:16:53 
 */
@SuppressWarnings("serial")
public class PE2039_DragTree extends JApplet {

	private JLabel jlblDepth = new JLabel("Enter the depth:");
	private JTextField jtfDepth = new JTextField(5);
	private DrawTree tree = new DrawTree();

	public PE2039_DragTree() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		panel.add(jlblDepth);
		panel.add(jtfDepth);

		// Register listener
		jtfDepth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tree.setOrder(Integer.parseInt(jtfDepth.getText()));
			}
		});

		add(tree, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}


	class DrawTree extends JPanel {

		private int depth;
		private int xCenter;
		private int branch = 100;
		private int bottom;
		private double sizeFactor = 0.57999999999999996D;
		private double angleFactor = 0.62831853071795862D;
		private boolean dragged = false;

		public DrawTree() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {

				@Override
				public void mouseDragged(MouseEvent e) {
					dragged = true;
					setCoordinations(e.getX(), e.getY());
				}
			});
			
			addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseExited(MouseEvent e) {
					dragged = false;
				}
			});
		}

		public void setOrder(int newDepth) {
			this.depth = newDepth;
			repaint();
		}

		public void setCoordinations(int x, int y) {
			xCenter = x;
			bottom = y + 40;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {

			if (!dragged) {
				xCenter = getWidth() / 2;
				bottom = getHeight() - 20;
			}

			super.paintComponent(g);

			drawTree(g, xCenter, bottom, branch, 1.5707963267948966D, depth);
		}

		public void drawTree(Graphics g, int x1, int y1, double length, double angle, int depth) {

			if (depth >= 0) {
				int x2 = (int)((double)x1 + Math.cos(angle) * length);
				int y2 = (int)((double)y1 - Math.sin(angle) * length);
				g.drawLine(x1, y1, x2, y2);
				drawTree(g, x2, y2, length * sizeFactor, angle + angleFactor, depth - 1);
				drawTree(g, x2, y2, length * sizeFactor, angle - angleFactor, depth - 1);
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE2039_DragTree applet = new PE2039_DragTree();
		JFrame frame = new JFrame();

		frame.add(applet);
		frame.setSize(350, 350);
		frame.setTitle("Exercise20_39");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
