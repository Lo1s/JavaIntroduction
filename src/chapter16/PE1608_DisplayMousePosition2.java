/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 15:50:02 
 */
@SuppressWarnings("serial")
public class PE1608_DisplayMousePosition2 extends JFrame {

	public PE1608_DisplayMousePosition2() {
		// TODO Auto-generated constructor stub
		DisplayPosition position = new DisplayPosition();
		add(position);
	}

	class DisplayPosition extends JPanel {

		int x;
		int y;
		String coordination;
		boolean isPressed = false;

		public DisplayPosition() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					isPressed = true;
					setX(e.getX());
					setY(e.getY());
					repaint();
					coordination = "(" + x + ", " + y + ")";
				}
			});

			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					isPressed = false;
					repaint();
				}

			});
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (isPressed)
				g.drawString(coordination, x, y);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1608_DisplayMousePosition2();
		frame.setTitle("Exercise16_08_part2");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}