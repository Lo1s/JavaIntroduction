/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import chapter10.PE1008_Tax;

/**
 * @author jslapnicka
 * @Date & @Time 8. 10. 2014 2014 15:03:22 
 */
@SuppressWarnings("serial")
public class PE1807_FinancialApplication extends JApplet {

	/** Create UI */
	// Titled Border
	private TitledBorder taxBorder = new TitledBorder("Select Tax Status");
	
	// Radio Buttons
	JRadioButton jrbSingle = new JRadioButton("Single fillers");
	JRadioButton jrbMarriedJointly = new JRadioButton("Married filling jointly or qualifying widow(er)");
	JRadioButton jrbMarriedSeparately = new JRadioButton("Married filling separately");
	JRadioButton jrbHeadOfHouseHold = new JRadioButton("Head of HouseHold");
	
	// Labels
	JLabel jlblIncome = new JLabel("Taxable income");
	JLabel jlblTax = new JLabel("Tax");
	JTextArea jtaInfo = new JTextArea();
	
	// Text Fields
	JTextField jtfIncome = new JTextField(25);
	JTextField jtfTax = new JTextField(25);
	
	// Button
	JButton jbtComputeTax = new JButton("Compute Tax");
	
	// Tax status legend
	String[] taxStatusLegend = new String[4];
	
	// Object for Tax calculation
	PE1008_Tax taxCalc = new PE1008_Tax();
	int fillingStatus;
	
	public PE1807_FinancialApplication() {
		// TODO Auto-generated constructor stub
		// Create button group for radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(jrbSingle);
		group.add(jrbMarriedJointly);
		group.add(jrbMarriedSeparately);
		group.add(jrbHeadOfHouseHold);
		
		// Set up tax status legend
		taxStatusLegend[0] = "Single Fillers\n"
				+ "Taxable Income\n"
				+ "Up to $27050\n"
				+ "$27051 - $65550\n"
				+ "$65551 - $136750\n"
				+ "$136751 - $297350\n"
				+ "$297351 or more";
		taxStatusLegend[1] = "Married Fillers Jointly\n"
				+ "Taxable Income\n"
				+ "Up to $45200\n"
				+ "$45201 - $109250\n"
				+ "$109251 - $166500\n"
				+ "$166501 - $297350\n"
				+ "$297351 or more";
		taxStatusLegend[2] = "Married Fillers Separately\n"
				+ "Taxable Income\n"
				+ "Up to $22600\n"
				+ "$22601 - 54625\n"
				+ "$54626 - $83250\n"
				+ "$83251 - $148675\n"
				+ "$148676 or more";
		taxStatusLegend[3] = "Head of HouseHold\n"
				+ "Taxable Income\n"
				+ "Up to $36250\n"
				+ "$36251 - 93650\n"
				+ "$93651 - 151650\n"
				+ "$151651 - 297350\n"
				+ "$297351 or more";
		
		// Default settings
		jrbSingle.setSelected(true);
		jtaInfo.setText(taxStatusLegend[0]);
		
		// Add items to the panels
		JPanel jpRadioButtons = new JPanel(new GridLayout(4, 1));
		jpRadioButtons.add(jrbSingle);
		jpRadioButtons.add(jrbMarriedJointly);
		jpRadioButtons.add(jrbMarriedSeparately);
		jpRadioButtons.add(jrbHeadOfHouseHold);
		JPanel jpTaxStatus = new JPanel(new BorderLayout());
		jpTaxStatus.add(jpRadioButtons, BorderLayout.CENTER);
		jpTaxStatus.add(jtaInfo, BorderLayout.EAST);
		jpTaxStatus.setBorder(taxBorder);
		JPanel jpIncome = new JPanel(new BorderLayout());
		jpIncome.add(jlblIncome, BorderLayout.WEST);
		jpIncome.add(jtfIncome, BorderLayout.EAST);
		JPanel jpTax = new JPanel(new BorderLayout());
		jpTax.add(jlblTax, BorderLayout.WEST);
		jpTax.add(jtfTax, BorderLayout.EAST);
		JPanel jpInputOutput = new JPanel(new GridLayout(2, 1));
		jpInputOutput.add(jpIncome);
		jpInputOutput.add(jpTax);
		JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jpButton.add(jbtComputeTax);
		
		// Register listeners
		jrbSingle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (jrbSingle.isSelected()) {
					jtaInfo.setText(taxStatusLegend[0]);
					fillingStatus = 0;
				}
			}
		});
		jrbMarriedJointly.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbMarriedJointly.isSelected()) {
					jtaInfo.setText(taxStatusLegend[1]);
					fillingStatus = 1;
				}
			}
		});
		jrbMarriedSeparately.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbMarriedSeparately.isSelected()) {
					jtaInfo.setText(taxStatusLegend[2]);
					fillingStatus = 2;
				}
			}
		});
		jrbHeadOfHouseHold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbHeadOfHouseHold.isSelected()) {
					jtaInfo.setText(taxStatusLegend[3]);
					fillingStatus = 3;
				}
			}
		});
		jbtComputeTax.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taxCalc.setFillingStatus(fillingStatus);
				taxCalc.setTaxableIncome(Double.parseDouble(jtfIncome.getText()));
				jtfTax.setText(taxCalc.getTax() + "");
			}
		});
		
		// Add items to the Applet
		add(jpTaxStatus, BorderLayout.NORTH);
		add(jpInputOutput, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1807_FinancialApplication applet = new PE1807_FinancialApplication();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Exercise18_07");
		frame.setSize(410, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
