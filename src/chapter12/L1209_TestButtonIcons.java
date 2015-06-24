/**
 * 
 */
package chapter12;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 24. 7. 2014 2014 8:53:04 
 */
public class L1209_TestButtonIcons extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1209_TestButtonIcons() {
		ImageIcon usIcon = new ImageIcon("C://Java//site//image//usIcon.gif");
		ImageIcon caIcon = new ImageIcon("C://Java//site//image//caIcon.gif");
		ImageIcon ukIcon = new ImageIcon("C://Java//site//image//ukIcon.gif");
		
		JButton jbt = new JButton("Click it", usIcon);
		jbt.setPressedIcon(caIcon);
		jbt.setRolloverIcon(ukIcon);
		
		add(jbt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1209_TestButtonIcons();
		frame.setTitle("ButtonIcons");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
