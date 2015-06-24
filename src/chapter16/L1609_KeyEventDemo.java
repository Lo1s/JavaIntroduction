/**
 * 
 */
package chapter16;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 10. 9. 2014 2014 10:26:10 
 */
@SuppressWarnings("serial")
public class L1609_KeyEventDemo extends JFrame {

	private KeyBoardPanel keyboardPanel = new KeyBoardPanel();
	
	public L1609_KeyEventDemo() {
		add(keyboardPanel);
		
		keyboardPanel.setFocusable(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1609_KeyEventDemo frame = new L1609_KeyEventDemo();
		frame.setTitle("Listing16.9");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	static class KeyBoardPanel extends JPanel {
		
		private int x = 100;
		private int y = 100;
		private char keyChar = 'A';
		
		public KeyBoardPanel() {
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_DOWN: y += 10; break;
					case KeyEvent.VK_UP: y -= 10; break;
					case KeyEvent.VK_LEFT: x -= 10; break;
					case KeyEvent.VK_RIGHT: x += 10; break;
					default: keyChar = e.getKeyChar();
					}
					
					repaint();
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			g.drawString(String.valueOf(keyChar), x, y);
		}
	}
}
