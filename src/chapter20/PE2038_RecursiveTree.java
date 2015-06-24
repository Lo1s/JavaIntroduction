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
 * @Date & @Time 8. 12. 2014 2014 13:22:06 
 */
@SuppressWarnings("serial")
public class PE2038_RecursiveTree extends JApplet {

	private JLabel jlblDepth = new JLabel("Enter the depth:");
	private JTextField jtfDepth = new JTextField(5);
	private DrawTree tree = new DrawTree();
	
	public PE2038_RecursiveTree() {
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
		
		public DrawTree() {
			// TODO Auto-generated constructor stub
		}
		
		public void setOrder(int newDepth) {
			this.depth = newDepth;
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			xCenter = getWidth() / 2;
			bottom = getHeight() - 20;
			
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
		JFrame frame = new JFrame();
		PE2038_RecursiveTree applet = new PE2038_RecursiveTree();
		
		frame.add(applet);
		frame.setTitle("Exercise20_38");
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
