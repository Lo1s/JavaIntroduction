/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 13:01:43 
 */
public class L1306_TestCenterMessage extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public L1306_TestCenterMessage() {
		CenterMessage messagePanel = new CenterMessage();
		add(messagePanel);
		messagePanel.setBackground(Color.white);
		messagePanel.setFont(new Font("Californian FB", Font.BOLD, 30));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1306_TestCenterMessage frame = new L1306_TestCenterMessage();
		frame.setSize(300, 150);
		frame.setTitle("CenterMessage");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class CenterMessage extends JPanel {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		FontMetrics fm = g.getFontMetrics();
		
		int stringWidth = fm.stringWidth("Welcome to Java !");
		int stringAscent = fm.getAscent();
		
		int xCoordinate = getWidth() / 2 - stringWidth /2;
		int yCoordinate = getHeight() / 2 + stringAscent / 2;		
		
		g.drawString("Welcome to Java !", xCoordinate, yCoordinate);
	}
	
}
