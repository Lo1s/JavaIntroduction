/**
 * 
 */
package chapter13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 30. 7. 2014 2014 8:48:00 
 */
public class L1309_DisplayClock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public L1309_DisplayClock() {
		L1310_StillClock clock = new L1310_StillClock();
		
		L1308_MessagePanel messagePanel = new L1308_MessagePanel(clock.getHour() + ":"
		+ (clock.getMinute() < 10 ? "0" + clock.getMinute() : clock.getMinute()) + ":" + clock.getSecond());
		
		messagePanel.setCentered(true);
		messagePanel.setForeground(Color.blue);
		messagePanel.setFont(new Font("Courier", Font.BOLD, 16));
		
		add(clock);
		add(messagePanel, BorderLayout.SOUTH);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1309_DisplayClock frame = new L1309_DisplayClock();
		frame.setTitle("DisplayClock");
		frame.setSize(300, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
