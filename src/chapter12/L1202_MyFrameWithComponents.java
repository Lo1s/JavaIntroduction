/**
 * 
 */
package chapter12;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 23. 7. 2014 2014 12:35:45 
 */
public class L1202_MyFrameWithComponents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("MyFrameWithComponents");
		
		//
		JButton jbtOK = new JButton("OK");
		frame.add(jbtOK);
		
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
