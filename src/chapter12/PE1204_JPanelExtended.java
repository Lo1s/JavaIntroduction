/**
 * 
 */
package chapter12;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 24. 7. 2014 2014 13:54:48 
 */
public class PE1204_JPanelExtended extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1204_JPanelExtended();
		JPanel p1 = new JPanelExtended("Button 1", "Button 2", "Button 3");
		JPanel p2 = new JPanelExtended("Button 4", "Button 5", "Button 6");
		
		frame.setLayout(new BorderLayout());
		
		frame.add(p1, BorderLayout.SOUTH);
		frame.add(p2, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class JPanelExtended extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JPanelExtended(String s1, String s2, String s3) {
		setLayout(new GridLayout(2, 2));;
		add(new JButton(s1));
		add(new JButton(s2));
		add(new JButton(s3));
	}
	
}