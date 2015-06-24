/**
 * 
 */
package chapter12;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 13:48:11 
 */
public class PE1213_Display54Cards extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public PE1213_Display54Cards() {
		setLayout(new GridLayout(6, 9));
		
		for (int i = 1; i <= 54; i++) {
			add(new JLabel(new ImageIcon("C://Java//site/image//card//" + i + ".png")));
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1213_Display54Cards();
		frame.setTitle("54Cards");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
