/**
 * 
 */
package chapter16;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 9:20:46 
 */
@SuppressWarnings("serial")
public class PE1610_DisplayString extends JFrame {

	DisplayString displayString = new DisplayString();

	public PE1610_DisplayString() {
		// TODO Auto-generated constructor stub
		add(displayString);
		displayString.setFocusable(true);
	}

	class DisplayString extends JPanel {

		StringBuilder message = new StringBuilder();

		public DisplayString() {
			// TODO Auto-generated constructor stub

			addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					if (!e.isActionKey())
						message.append(e.getKeyChar() + "");
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
						repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {	
			super.paintComponent(g);

			Font font = new Font("TimesRoman", Font.PLAIN, 12);
			FontMetrics fm = getFontMetrics(font);
			int stringWidth = fm.stringWidth(message.toString());
			int stringAscent = fm.getAscent();
			int xCenter = getWidth() / 2 - stringWidth / 2;
			int yCenter = getHeight() / 2 - stringAscent / 2;

			g.drawString(message.toString(), xCenter, yCenter);
			if(message.length() > 0)
				message.delete(0, message.length() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1610_DisplayString();
		frame.setTitle("Exercise16_10");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
