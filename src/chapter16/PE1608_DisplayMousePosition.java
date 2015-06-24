/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 15:48:48 
 */
@SuppressWarnings("serial")
public class PE1608_DisplayMousePosition extends JFrame {

	public PE1608_DisplayMousePosition() {
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
			addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					isPressed = true;
					setX(e.getX());
					setY(e.getY());
					repaint();
					coordination = "(" + x + ", " + y + ")";
				}
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
		JFrame frame = new PE1608_DisplayMousePosition();
		frame.setTitle("Exercise16_08");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
