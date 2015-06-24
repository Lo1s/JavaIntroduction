/**
 * 
 */
package chapter12;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 24. 7. 2014 2014 14:42:21 
 */
public class PE1205_DisplayLabels extends JFrame {

	private static final long serialVersionUID = 1L;

	public PE1205_DisplayLabels() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(4, 1));

		// Create border
		Border border = new LineBorder(Color.BLACK);

		JLabel jlbl1 = new JLabel("Department of Computer Science");
		jlbl1.setHorizontalTextPosition(JLabel.LEFT);
		jlbl1.setBorder(border);
		JLabel jlbl2 = new JLabel("School of Computing");
		jlbl2.setHorizontalTextPosition(JLabel.LEFT);
		jlbl2.setBorder(border);
		JLabel jlbl3 = new JLabel("Armstrong Atlantic State University");
		jlbl3.setHorizontalTextPosition(JLabel.LEFT);
		jlbl3.setBorder(border);
		JLabel jlbl4 = new JLabel("Tel: (912)921-6440");
		jlbl4.setBorder(border);

		add(jlbl1);
		add(jlbl2);
		add(jlbl3);
		add(jlbl4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1205_DisplayLabels();
		frame.setTitle("PE1205_DisplayLabels");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

}
