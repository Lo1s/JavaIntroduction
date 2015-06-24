/**
 * 
 */
package chapter16;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 15. 9. 2014 2014 7:42:51 
 */
@SuppressWarnings("serial")
public class PE1616_FlashingLabel extends JFrame {

	/**
	 * @param args
	 */

	public PE1616_FlashingLabel() {
		// TODO Auto-generated constructor stub
		add(new FlashingLabel());
	}

	class FlashingLabel extends JPanel {
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				repaint();
				System.out.println("Tick");
			}
		});
		boolean isBlank = true;;

		public FlashingLabel() {
			// TODO Auto-generated constructor stub
			timer.start();
		}

		@Override
		protected void paintComponent(Graphics g) {
			String message = "Welcome to Java !";
			Font font = new Font(message, Font.BOLD, 20);
			FontMetrics fm = getFontMetrics(font);

			super.paintComponent(g);
			if (isBlank)
				g.drawString(message, getWidth() / 2 - (fm.stringWidth(message) / 2), getHeight() / 2 - fm.getAscent() / 2);
			isBlank = !isBlank;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1616_FlashingLabel();
		frame.setTitle("Exercise16_16");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
