/**
 * 
 */
package chapter12;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author jslapnicka
 * @Date & @Time 23. 7. 2014 2014 15:26:37 
 */
public class L1207_TestSwingCommonFeatures extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1207_TestSwingCommonFeatures() {
		// Create the first panel for three buttons
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
		JButton jbtLeft = new JButton("Left");
		JButton jbtCenter = new JButton("Center");
		JButton jbtRight = new JButton("Right");
		jbtLeft.setBackground(Color.WHITE);
		jbtCenter.setForeground(Color.GREEN);
		jbtRight.setToolTipText("This is the Right button");
		p1.add(jbtLeft);
		p1.add(jbtCenter);
		p1.add(jbtRight);
		p1.setBorder(new TitledBorder("Three Buttons"));
		p1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		
		// Create Font and line border
		Font largeFont = new Font("TimesRoman", Font.BOLD, 20);
		Border lineBorder = new LineBorder(Color.BLACK, 2);
		
		// Create the second panel for two labels
		JPanel p2 = new JPanel(new GridLayout(1, 2, 5, 5));
		JLabel jlblRed = new JLabel("Red");
		JLabel jlblOrange = new JLabel("Orange");
		jlblRed.setForeground(Color.RED);
		jlblOrange.setForeground(Color.ORANGE);
		jlblRed.setFont(largeFont);
		jlblOrange.setFont(largeFont);
		jlblRed.setBorder(lineBorder);
		jlblOrange.setBorder(lineBorder);
		p2.add(jlblRed);
		p2.add(jlblOrange);
		p2.setBorder(new TitledBorder("Two Labels"));
		
		// Add two panels i nto the frame
		setLayout(new GridLayout(2, 1, 5, 5));
		add(p1);
		add(p2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1207_TestSwingCommonFeatures();
		frame.setTitle("TestSwingCommonFeatures");
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

}
