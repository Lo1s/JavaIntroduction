/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 10. 10. 2014 2014 12:19:23 
 */
@SuppressWarnings("serial")
public class PE1809_ConvertNumbers extends JApplet {

	JTextField jtfDecimal = new JTextField(20);
	JTextField jtfHex = new JTextField(20);
	JTextField jtfBinary = new JTextField(20);
	
	JLabel jlblDecimal = new JLabel("Decimal");
	JLabel jlblHex = new JLabel("Hex");
	JLabel jlblBinary = new JLabel("Binary");
	
	public PE1809_ConvertNumbers() {
		// TODO Auto-generated constructor stub
		JPanel p1 = new JPanel(new GridLayout(3, 1));
		JPanel p2 = new JPanel(new GridLayout(3, 1));
		
		p1.add(jlblBinary);
		p1.add(jlblHex);
		p1.add(jlblDecimal);
	
		p2.add(jtfBinary);
		p2.add(jtfHex);
		p2.add(jtfDecimal);
		
		// Register listeners
		jtfBinary.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int decimal = Integer.parseInt(jtfBinary.getText(), 2);
				jtfDecimal.setText(decimal + "");
				jtfHex.setText(Integer.toHexString(decimal));
			}
		});
		jtfHex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int decimal = Integer.parseInt(jtfHex.getText(), 16);
				jtfDecimal.setText(decimal + "");
				jtfBinary.setText(Integer.toBinaryString(decimal));
			}
		});
		jtfDecimal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtfBinary.setText(Integer.toBinaryString(Integer.parseInt(jtfDecimal.getText())));
				jtfHex.setText(Integer.toHexString(Integer.parseInt(jtfDecimal.getText())));
			}
		});
		
		add(p1, BorderLayout.WEST);
		add(p2, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1809_ConvertNumbers convertNumbers = new PE1809_ConvertNumbers();
		
		frame.add(convertNumbers);
		frame.setTitle("Exercise18_09");
		frame.setSize(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
