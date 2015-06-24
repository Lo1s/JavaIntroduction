/**
 * 
 */
package chapter12;


import java.awt.FlowLayout;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 13:14:13 
 */
public class PE1212_UseLabels extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public PE1212_UseLabels() {
		setLayout(new FlowLayout());
		
		ImageIcon usFlag = new ImageIcon("C://Java//site//image//usIcon.gif");
				
		JLabel jlbl1 = new JLabel(usFlag);
		jlbl1.setText("US");
		jlbl1.setHorizontalTextPosition(JLabel.CENTER);
		jlbl1.setVerticalTextPosition(JLabel.BOTTOM);
		
		JLabel jlbl2 = new JLabel(usFlag);
		jlbl2.setText("US");
		jlbl2.setHorizontalTextPosition(JLabel.RIGHT);
		
		JLabel jlbl3 = new JLabel(usFlag);
		jlbl3.setText("US");
		jlbl3.setHorizontalTextPosition(JLabel.LEFT);
		
		JLabel jlbl4 = new JLabel(usFlag);
		jlbl4.setText("US");
		jlbl4.setHorizontalTextPosition(JLabel.CENTER);
		jlbl4.setVerticalTextPosition(JLabel.TOP);
		
		add(jlbl1);
		add(jlbl2);
		add(jlbl3);
		add(jlbl4);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1212_UseLabels();
		frame.setTitle("UseLabels");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
