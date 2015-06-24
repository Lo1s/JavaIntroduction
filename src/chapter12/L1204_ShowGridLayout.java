/**
 * 
 */
package chapter12;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 23. 7. 2014 2014 13:25:18 
 */
public class L1204_ShowGridLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1204_ShowGridLayout() {
		setLayout(new GridLayout(3, 2, 5, 5));
		
		add(new JLabel("First Name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last Name"));
		add(new JTextField(8));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1204_ShowGridLayout frame = new L1204_ShowGridLayout();
		
		frame.setTitle("ShowGridLayout");
		frame.setSize(200, 125);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
