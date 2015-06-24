/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 9. 9. 2014 2014 15:57:43 
 */
@SuppressWarnings("serial")
public class L1608_MoveMessageDemo extends JFrame {

	public L1608_MoveMessageDemo() {
		// TODO Auto-generated constructor stub
		MovableMessagePanel p = new MovableMessagePanel("Welcome to Java !");
		add(p);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1608_MoveMessageDemo frame = new L1608_MoveMessageDemo();
		frame.setTitle("MoveMessageDemo");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Inner class: MovableMessagePanel draws a message
	static class MovableMessagePanel extends JPanel {
		private String message = "Welcome to Java !";
		private int x = 20;
		private int y = 20;

		/** Construct a panel to draw string s */
		public MovableMessagePanel(String s) {
			message = s;
			addMouseMotionListener(new MouseMotionListener() {

				@Override 
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
				}

				@Override /** Handle mouse-dragged event */
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					x = e.getX();
					y = e.getY();
					repaint();					
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(message, x, y);
		}
	}

}
