/**
 * 
 */
package chapter12;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 14:00:08 
 */
public class PE1214_DisplayRandom01 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public PE1214_DisplayRandom01() {
		setLayout(new GridLayout(10, 10));
				
		for (int i = 0; i < 100; i++) {
			Integer number = new Integer((int)(Math.random() * (2 - 0)));
			add(new JLabel(number.toString(), JLabel.CENTER));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1214_DisplayRandom01();
		frame.pack();
		frame.setTitle("Grid");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
