/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 7:57:36 
 */
@SuppressWarnings("serial")
public class PE1609_DrawLines extends JFrame {

	private DrawLines drawLines = new DrawLines();
	
	public PE1609_DrawLines() {
		// TODO Auto-generated constructor stub

		add(drawLines);
		drawLines.setFocusable(true);
	}


	class DrawLines extends JPanel {
		private int xCoordinate;
		private int yCoordinate;
		private int xCoordinate2;
		private int yCoordinate2;
		private boolean firstTime;

		public DrawLines() {
			// TODO Auto-generated constructor stub
			firstTime = true;
			addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						xCoordinate = xCoordinate2;
						yCoordinate = yCoordinate2;
						yCoordinate2 -= 10;
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						xCoordinate = xCoordinate2;
						yCoordinate = yCoordinate2;
						yCoordinate2 += 10;
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						xCoordinate = xCoordinate2;
						yCoordinate = yCoordinate2;
						xCoordinate2 -= 10;
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						xCoordinate = xCoordinate2;
						yCoordinate = yCoordinate2;
						xCoordinate2 += 10;
					}
						
					repaint();
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			
			
			if (firstTime) {
				xCoordinate2 = xCoordinate = getWidth() / 2;
				yCoordinate2 = yCoordinate = getHeight() / 2;
				firstTime = false;
			}
			g.drawLine(xCoordinate, yCoordinate, xCoordinate2, yCoordinate2);
		}
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1609_DrawLines();
		frame.setTitle("Exercise16_09");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
