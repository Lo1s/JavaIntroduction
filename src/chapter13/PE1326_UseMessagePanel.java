/**
 * 
 */
package chapter13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 6. 8. 2014
 * 23:14:25
 */
public class PE1326_UseMessagePanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PE1326_UseMessagePanel() {
		L1308_MessagePanel mp1 = new L1308_MessagePanel("Java");
		L1308_MessagePanel mp2 = new L1308_MessagePanel("HTML");
		L1308_MessagePanel mp3 = new L1308_MessagePanel("Tomcat");
		L1308_MessagePanel mp4 = new L1308_MessagePanel("PHP");
		
		mp1.setCentered(true);
		mp2.setCentered(true);
		mp3.setCentered(true);
		mp4.setCentered(true);
		
		mp1.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		mp2.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		mp3.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		mp4.setFont(new Font("TimesRoman", Font.ITALIC, 15));
		
		mp2.setBackground(Color.CYAN);
		mp4.setBackground(Color.GREEN);
		
		JPanel p1 = new JPanel(new GridLayout(3, 1));
		p1.add(mp2);
		p1.add(mp3);
		p1.add(mp4);
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(mp1, BorderLayout.WEST);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1326_UseMessagePanel();
		frame.setTitle("Exercise13_26");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
