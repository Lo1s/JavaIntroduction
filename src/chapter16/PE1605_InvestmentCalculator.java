/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 13:09:20 
 */
@SuppressWarnings("serial")
public class PE1605_InvestmentCalculator extends JFrame {

	private JTextField jtfInvestmentAmount = new JTextField();
	private JTextField jtfYears = new JTextField();
	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfFutureValue = new JTextField();

	private JButton jbtCalculate = new JButton("Calculate");

	public PE1605_InvestmentCalculator() {
		// TODO Auto-generated constructor stub
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("Investment Amount"));
		p1.add(jtfInvestmentAmount);
		p1.add(new JLabel("Years"));
		p1.add(jtfYears);
		p1.add(new JLabel("Annual Interest Rate"));
		p1.add(jtfAnnualInterestRate);
		p1.add(new JLabel("Future Value"));
		p1.add(jtfFutureValue);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtCalculate);

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		jtfInvestmentAmount.addActionListener(new TextFieldListener());
		jtfYears.addActionListener(new TextFieldListener());
		jtfAnnualInterestRate.addActionListener(new TextFieldListener());
		jbtCalculate.addActionListener(new TextFieldListener());
	}

	class TextFieldListener implements ActionListener {
		double investmentAmount;
		double years;
		double annualInterestRate;
		double futureValue;

		@Override
		public void actionPerformed(ActionEvent e) {
			investmentAmount = Double.valueOf(jtfInvestmentAmount.getText());
			years = Double.valueOf(jtfYears.getText());
			annualInterestRate = Double.valueOf(jtfAnnualInterestRate.getText());

			if (e.getSource() == jbtCalculate) {
				futureValue = investmentAmount * Math.pow((1 + annualInterestRate / 1200), years * 12);
				jtfFutureValue.setText(String.format("%.2f", futureValue));
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1605_InvestmentCalculator();
		frame.setTitle("Exercise16_05");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
