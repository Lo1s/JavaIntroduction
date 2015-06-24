/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 10:11:39 
 */
@SuppressWarnings("serial")
public class PE1604_SimpleCalculator extends JFrame {

	// Buttons
	private JButton jbtAdd = new JButton("Add");
	private JButton jbtSubtract = new JButton("Subtract");
	private JButton jbtMultiply = new JButton("Multiply");
	private JButton jbtDivide = new JButton("Divide");

	// Text fields
	private JTextField jtfNumber1 = new JTextField();
	private JTextField jtfNumber2 = new JTextField();
	private JTextField jtfResult = new JTextField();

	// Panels
	JPanel panelButtons = new JPanel(new FlowLayout());
	JPanel panelInput = new JPanel(new GridLayout(1, 4));

	
	public PE1604_SimpleCalculator() {
		// TODO Auto-generated constructor stub
		// Adding key mnemonics
		jbtAdd.setMnemonic('A');
		jbtSubtract.setMnemonic('S');
		jbtMultiply.setMnemonic('M');
		jbtDivide.setMnemonic('D');

		// Creating panel and adding the buttons to it
		panelButtons.add(jbtAdd);
		panelButtons.add(jbtSubtract);
		panelButtons.add(jbtMultiply);
		panelButtons.add(jbtDivide);

		// Creating second panel and adding the labels with text fields to it
		panelInput.add(new JLabel("Number 1"));
		panelInput.add(jtfNumber1);
		panelInput.add(new JLabel("Number 2"));
		panelInput.add(jtfNumber2);
		panelInput.add(new JLabel("Result"));
		panelInput.add(jtfResult);
		
		// Listener for buttons
		TextFieldListener listener = new TextFieldListener();
		jbtAdd.addActionListener(listener);
		jbtSubtract.addActionListener(listener);
		jbtMultiply.addActionListener(listener);
		jbtDivide.addActionListener(listener);
		
		jtfNumber1.addActionListener(listener);
		jtfNumber2.addActionListener(listener);
				
		add(panelInput, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
	}

	class TextFieldListener implements ActionListener {
		double number1;
		double number2;
		double result;

		@Override
		public void actionPerformed(ActionEvent e) {
			number1 = Double.valueOf(jtfNumber1.getText());
			number2 = Double.valueOf(jtfNumber2.getText());
			
			if (e.getSource() == jbtAdd)
				jtfResult.setText((number1 + number2) + "");
			else if (e.getSource() == jbtSubtract)
				jtfResult.setText((number1 - number2) + "");
			else if (e.getSource() == jbtMultiply)
				jtfResult.setText((number1 * number2) + "");
			else if (e.getSource() == jbtDivide)
				jtfResult.setText((number1 / number2) + "");
			panelButtons.requestFocusInWindow();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1604_SimpleCalculator();
		frame.setTitle("Exercise16_04");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
