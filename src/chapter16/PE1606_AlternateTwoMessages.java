/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 13:53:31 
 */
@SuppressWarnings("serial")
public class PE1606_AlternateTwoMessages extends JFrame {

	public PE1606_AlternateTwoMessages() {
		// TODO Auto-generated constructor stub
		add(new RotateMessages(), BorderLayout.CENTER);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1606_AlternateTwoMessages();
		frame.setTitle("Exercise16_06");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	class RotateMessages extends JPanel {
		String message1 = "Java is fun";
		String message2 = "Java is powerful";
		Font font = new Font("TimesRoman", Font.BOLD, 12);
		FontMetrics fm = getFontMetrics(font);
		int xCoordinate = 140 - fm.stringWidth(message1) / 2;
		int yCoordinate = 100;
		boolean isMessage1 = true;
		
		public RotateMessages() {
			// TODO Auto-generated constructor stub
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
										
					if ((e.getX() >= xCoordinate && e.getX() <= (xCoordinate + fm.stringWidth(message1)))
							&& (e.getY() >= (yCoordinate - fm.getAscent()) && e.getY() <= yCoordinate))
						isMessage1();
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
						
		public void isMessage1() {
			if (isMessage1)
				isMessage1 = false;
			else
				isMessage1 = true;
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.setFont(font);
			if (!isMessage1)
				g.drawString(message1, xCoordinate, yCoordinate);
			else
				g.drawString(message2, xCoordinate, yCoordinate);
		}
	}
}
