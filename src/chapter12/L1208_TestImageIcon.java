/**
 * 
 */
package chapter12;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 24. 7. 2014 2014 8:22:12 
 */
public class L1208_TestImageIcon extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon usIcon = new ImageIcon("C://Java//site//image//us.gif");
	private ImageIcon myIcon = new ImageIcon("C://Java//site//image//my.jpg");
	private ImageIcon frIcon = new ImageIcon("C://Java//site//image//fr.gif");
	private ImageIcon ukIcon = new ImageIcon("C://Java//site//image//uk.gif");
	
	public L1208_TestImageIcon() {
		setLayout(new GridLayout(1, 4, 5, 5));
		add(new JLabel(usIcon));
		add(new JLabel(myIcon));
		add(new JButton(frIcon));
		add(new JButton(ukIcon));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1208_TestImageIcon();
		frame.setTitle("TestImageIcon");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

}
