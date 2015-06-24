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
 * @Date & @Time 15. 9. 2014 2014 8:40:35 
 */
@SuppressWarnings("serial")
public class PE1618_MoveCircle extends JFrame {

	/**
	 * @param args
	 */
		
	public PE1618_MoveCircle() {
		// TODO Auto-generated constructor stub
		add(new MoveCircle());
	}
	
	class MoveCircle extends JPanel {
		int x;
		int y;
		int radius;
		int moveY;
		int moveX;
		int changeRadius;
		
		public MoveCircle() {
			// TODO Auto-generated constructor stub
			setFocusable(true);
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
						System.out.println("Up pressed!");
						moveY -= 10;
						repaint();
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						System.out.println("Down pressed!");
						moveY += 10;
						repaint();
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("Left pressed!");
						moveX -= 10;
						repaint();
					} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("Right pressed!");
						moveX += 10;
						repaint();
					} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
						System.out.println("0 pressed !");
						changeRadius += 5;
						repaint();
					} else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
						System.out.println("1 pressed !");
						changeRadius -= 5;
						repaint();
					}
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			radius = 10 + changeRadius;
			x = getWidth() / 2 - radius + moveX;
			y = getHeight() / 2 - radius + moveY;
			
			super.paintComponent(g);			
			g.fillOval(x, y, 2 * radius, 2 * radius);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1618_MoveCircle();
		frame.setTitle("Exercise16_18");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
