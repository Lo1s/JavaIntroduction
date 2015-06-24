/**
 * 
 */
package chapter12;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 8:41:16 
 */
public class PE1208_SwingCommonFeatures extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public PE1208_SwingCommonFeatures() {
		
		setLayout(new GridLayout(2, 3));
		
		LineBorder border = new LineBorder(Color.yellow);
		Font font = new Font("TimesRoman", Font.BOLD, 20);
		
		JLabel jlbl1 = new JLabel("black");
		jlbl1.setBackground(Color.white);
		jlbl1.setForeground(Color.black);
		jlbl1.setBorder(border);
		jlbl1.setFont(font);
		jlbl1.setToolTipText(getTitle());
		
		JLabel jlbl2 = new JLabel("blue");
		jlbl2.setBackground(Color.white);
		jlbl2.setForeground(Color.blue);
		jlbl2.setBorder(border);
		jlbl2.setFont(font);
		jlbl2.setToolTipText(getTitle());
		
		JLabel jlbl3 = new JLabel("cyan");
		jlbl3.setBackground(Color.white);
		jlbl3.setForeground(Color.cyan);
		jlbl3.setBorder(border);
		jlbl3.setFont(font);
		jlbl3.setToolTipText(getTitle());
		
		JLabel jlbl4 = new JLabel("green");
		jlbl4.setBackground(Color.white);
		jlbl4.setForeground(Color.green);
		jlbl4.setBorder(border);
		jlbl4.setFont(font);
		jlbl4.setToolTipText(getTitle());
		
		JLabel jlbl5 = new JLabel("magenta");
		jlbl5.setBackground(Color.white);
		jlbl5.setForeground(Color.magenta);
		jlbl5.setBorder(border);
		jlbl5.setFont(font);
		jlbl5.setToolTipText(getTitle());
		
		JLabel jlbl6 = new JLabel("orange");
		jlbl6.setBackground(Color.white);
		jlbl6.setForeground(Color.orange);
		jlbl6.setBorder(border);
		jlbl6.setFont(font);
		jlbl6.setToolTipText(getTitle());
		
		add(jlbl1);
		add(jlbl2);
		add(jlbl3);
		add(jlbl4);
		add(jlbl5);
		add(jlbl6);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1208_SwingCommonFeatures();
		frame.setTitle("SwingCommonFeatures");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
