/**
 * 
 */
package chapter12;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 24. 7. 2014 2014 15:24:39 
 */
public class PE1206_DisplayIcons extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1206_DisplayIcons() {
		setLayout(new BorderLayout());
		
		ImageIcon ukFlag = new ImageIcon("C://Java//site//image//uk.gif");
		ImageIcon fraFlag = new ImageIcon("C://Java//site//image//fr.gif");
		ImageIcon norFlag = new ImageIcon("C://Java//site//image//norway.gif");
		ImageIcon malFlag = new ImageIcon("C://Java//site//image//my.jpg");
		
		JPanel p1 = new JPanel(new GridLayout(2, 2));
		JLabel jlbl1 = new JLabel(ukFlag);
		JLabel jlbl2 = new JLabel(fraFlag);
		JLabel jlbl3 = new JLabel(norFlag);
		JLabel jlbl4 = new JLabel(malFlag);
		
		p1.add(jlbl1);
		p1.add(jlbl2);
		p1.add(jlbl3);
		p1.add(jlbl4);
		
		add(p1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1206_DisplayIcons();
		
		frame.setTitle("PE1206_DisplayIcons");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
