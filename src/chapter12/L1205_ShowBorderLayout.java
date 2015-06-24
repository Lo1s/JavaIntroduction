/**
 * 
 */
package chapter12;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 23. 7. 2014 2014 13:33:08 
 */
public class L1205_ShowBorderLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1205_ShowBorderLayout() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		add(new JButton("East"), BorderLayout.EAST);
		add(new JButton("South"), BorderLayout.SOUTH);
		add(new JButton("West"), BorderLayout.WEST);
		add(new JButton("North"), BorderLayout.NORTH);
		add(new JButton("Center"), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1205_ShowBorderLayout frame = new L1205_ShowBorderLayout();
		
		frame.setTitle("ShowBorderLayout");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
