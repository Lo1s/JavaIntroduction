package chapter18;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import chapter10.L1002_Loan;

/**
 * @author jslapnicka
 * @Date & @Time 9. 9. 2014 2014 15:34:07 
 */
@SuppressWarnings("serial")
public class PE1801_LoanCalculatorApplet extends JApplet {

	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfNumberOfYears = new JTextField();
	private JTextField jtfLoanAmount = new JTextField();
	private JTextField jtfMonthlyPayment = new JTextField();
	private JTextField jtfTotalPayment = new JTextField();
	
	private JButton jbtComputeLoan = new JButton("Compute Payment");
	
	public PE1801_LoanCalculatorApplet() {
		// TODO Auto-generated constructor stub
		
		// Panel p1 to hold labels and text fields 
		JPanel p1 = new JPanel(new GridLayout(5, 2));
		p1.add(new JLabel("Annual Interest Rate"));
		p1.add(jtfAnnualInterestRate);
		p1.add(new JLabel("Number of Years"));
		p1.add(jtfNumberOfYears);
		p1.add(new JLabel("Loan Amount"));
		p1.add(jtfLoanAmount);
		p1.add(new JLabel("Monthly Payment"));
		p1.add(jtfMonthlyPayment);
		p1.add(new JLabel("Total Payment"));
		p1.add(jtfTotalPayment);
		p1.setBorder(new TitledBorder("Enter loan amount, interest rate, and years"));
		
		// Panel p2 to hold the button
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeLoan);
		
		// Add the panels to the frame
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		// Register listener
		jbtComputeLoan.addActionListener(new ButtonListener());
	}
		
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Get values from the text fields
			double interest = Double.parseDouble(jtfAnnualInterestRate.getText());
			int year = Integer.parseInt(jtfNumberOfYears.getText());
			double loanAmount = Double.parseDouble(jtfLoanAmount.getText());
			
			// Create a loan object
			L1002_Loan loan = new L1002_Loan(interest, year, loanAmount);
			
			// Display monthly payment and total payment
			jtfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
			jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1801_LoanCalculatorApplet applet = new PE1801_LoanCalculatorApplet();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Listing 16.7");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

}
