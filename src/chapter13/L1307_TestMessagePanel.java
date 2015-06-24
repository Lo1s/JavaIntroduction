/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;


/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 13:08:00 
 */
public class L1307_TestMessagePanel extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public L1307_TestMessagePanel() {
		L1308_MessagePanel messagePanel1 = new L1308_MessagePanel("Welcome to java !");
		L1308_MessagePanel messagePanel2 = new L1308_MessagePanel("Java is fun");
		L1308_MessagePanel messagePanel3 = new L1308_MessagePanel("Java is cool");
		L1308_MessagePanel messagePanel4 = new L1308_MessagePanel("I love Java");
		
		messagePanel1.setFont(new Font("SansSerif", Font.ITALIC, 20));
		messagePanel2.setFont(new Font("Courier", Font.BOLD, 20));
		messagePanel3.setFont(new Font("Times", Font.ITALIC, 20));
		messagePanel4.setFont(new Font("Californian FB", Font.PLAIN, 20));
		
		messagePanel1.setBackground(Color.RED);
		messagePanel2.setBackground(Color.CYAN);
		messagePanel3.setBackground(Color.GREEN);
		messagePanel4.setBackground(Color.WHITE);
		
		messagePanel1.setCentered(true);
		
		setLayout(new GridLayout(2, 2));
		add(messagePanel1);
		add(messagePanel2);
		add(messagePanel3);
		add(messagePanel4);
	}
	
	public static void main(String[] args) {
		L1307_TestMessagePanel frame = new L1307_TestMessagePanel();
		frame.setSize(300, 200);
		frame.setTitle("TestMessagePanel");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
