/**
 * 
 */
package chapter12;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 23. 7. 2014 2014 12:39:37 
 */
public class L1203_ShowFlowLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1203_ShowFlowLayout() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		add(new JLabel("First Name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last Name"));
		add(new JTextField(8));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1203_ShowFlowLayout frame = new L1203_ShowFlowLayout();
		frame.setTitle("ShowFlowLayout");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
