/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 10:00:29 
 */
@SuppressWarnings("serial")
public class PE1611_DisplayCharacter extends JFrame {

	private DisplayCharacter displayCharacter = new DisplayCharacter();
	
	/**
	 * @param args
	 */
	
	public PE1611_DisplayCharacter() {
		// TODO Auto-generated constructor stub
		add(displayCharacter);
		displayCharacter.setFocusable(true);
	}
	
	class DisplayCharacter extends JPanel {
		char input;
		private int x;
		private int y;
		
		public DisplayCharacter() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					x = e.getX();
					y = e.getY();
				}
			});
			
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (!e.isActionKey())
						input = e.getKeyChar();
					repaint();
				}
			});
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawString(input + "", x, y);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1611_DisplayCharacter();
		frame.setTitle("Exercise16_11");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
