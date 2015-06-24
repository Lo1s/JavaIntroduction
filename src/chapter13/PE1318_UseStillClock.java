/**
 * 
 */
package chapter13;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author hydRa
 * 5. 8. 2014
 * 21:09:07
 */
public class PE1318_UseStillClock extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1318_UseStillClock() {
		setLayout(new GridLayout(1, 2));
		add(new L1310_StillClock(4, 20, 45));
		add(new L1310_StillClock(22, 46, 15));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1318_UseStillClock();
		frame.setTitle("Exercise13_18");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
