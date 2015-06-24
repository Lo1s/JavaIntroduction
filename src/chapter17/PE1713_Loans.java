/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.*;

/**
 * @author jslapnicka
 * @Date & @Time 30. 9. 2014 2014 9:28:04 
 */
@SuppressWarnings("serial")
public class PE1713_Loans extends JFrame {

	/**
	 * @param args
	 */
	
	// Create JTextArea
	JTextArea jtaOutput = new JTextArea();
	
	// Create JLabels
	JLabel jlblLoanAmount = new JLabel("Loan Amount");
	JLabel jlblNumberOfYears = new JLabel("Number of Years");
	
	// Create JTextFields
	JTextField jtfLoanAmount = new JTextField(5);
	JTextField jtfNumberOfYears = new JTextField(2);
	
	// Create JButton
	JButton jbtShowTable = new JButton("Show Table");
	
	// Data field
	double amount;
	double interestRate = 5.0;
	int years;
	double increment = 1.000 / 8.000;
	
	public PE1713_Loans() {
		// TODO Auto-generated constructor stub
		// Create a panel for the input data
		JPanel jpInput = new JPanel(new FlowLayout());
		jpInput.add(jlblLoanAmount);
		jpInput.add(jtfLoanAmount);
		jpInput.add(jlblNumberOfYears);
		jpInput.add(jtfNumberOfYears);
		jpInput.add(jbtShowTable);
		
		// Put text area into the scroll pane
		JScrollPane scrolPane = new JScrollPane(jtaOutput);
		
		// Register listeners
		jtfLoanAmount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				amount = Double.parseDouble(jtfLoanAmount.getText());
			}
		});
		jtfNumberOfYears.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				years = Integer.parseInt(jtfNumberOfYears.getText());
			}
		});
		jbtShowTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder builder = new StringBuilder();
				builder.append("Interest rate\t\t" + "Monthly Payment\t  " + "Total Payment" + "\n");
				while (interestRate <= 8.0) {
					double monthlyInterestRate = interestRate / 1200;
					double monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
					double totalPayment = monthlyPayment * years * 12;

					
					builder.append(String.format("%2.3f%1s" + "\t\t%3.2f" + "\t\t  %5.2f\n", 
							interestRate, "%", monthlyPayment, totalPayment));
					interestRate = interestRate + increment;
				}
				jtaOutput.setText(builder.toString());
			}
		});
		
		// Add panel and text field into the frame
		
		add(jpInput, BorderLayout.NORTH);
		add(scrolPane, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1713_Loans();
		frame.setTitle("Exercise17_13");
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
