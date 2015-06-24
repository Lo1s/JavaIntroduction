/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author jslapnicka
 * @Date & @Time 26. 9. 2014 2014 8:22:21 
 */
@SuppressWarnings("serial")
public class PE1706_ConverterMilesKilometers extends JFrame {

	/**
	 * @param args
	 */

	// Create Text Fields for miles and kilometers
	JTextField jtfMiles = new JTextField(20);
	JTextField jtfKilometers = new JTextField(20);

	// Create JLabels for miles and kilometers
	JLabel jlblMile = new JLabel("Mile");
	JLabel jlblKilometer = new JLabel("Kilometer");

	public PE1706_ConverterMilesKilometers() {
		// TODO Auto-generated constructor stub

		// Create a LineBorder
		LineBorder lineBorder = new LineBorder(Color.BLACK);

		// Set up labels
		jlblMile.setHorizontalTextPosition(JLabel.LEFT);
		jlblMile.setVerticalTextPosition(JLabel.CENTER);
		jlblKilometer.setHorizontalTextPosition(JLabel.LEFT);
		jlblKilometer.setVerticalTextPosition(JLabel.CENTER);

		// Create panel for labels and add to it
		JPanel pLabels = new JPanel(new GridLayout(2, 1, 1, 1));
		pLabels.add(jlblMile);
		pLabels.add(jlblKilometer);
		pLabels.setBorder(lineBorder);

		// Set up Text Fields and add them to the panel
		jtfMiles.setBorder(lineBorder);
		jtfKilometers.setBorder(lineBorder);
		JPanel pTextFields = new JPanel(new GridLayout(2, 1, 1, 1));
		pTextFields.add(jtfMiles);
		pTextFields.add(jtfKilometers);

		// Register listeners
		jtfMiles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String mileString = jtfMiles.getText();
				// Check if only numbers are entered
				try {
					for (int i = 0; i < mileString.length(); i++) 
						if ((mileString.charAt(i) < '0' || mileString.charAt(i) > '9') 
								&& mileString.charAt(i) != '.')
							throw new NumberFormatException();
					Double miles = new Double(mileString);
					double kilometers = miles * 1.60934;
					jtfKilometers.setText(String.valueOf(kilometers));
				}
				catch (NumberFormatException ex) {
					javax.swing.JOptionPane.showMessageDialog(null, "Please enter only numbers for conversion", 
							"Faulty input", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		jtfKilometers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String kilometersString = jtfKilometers.getText();
				// Check if only numbers are entered
				try {
					for (int i = 0; i < kilometersString.length(); i++)
						if ((kilometersString.charAt(i) < '0' || kilometersString.charAt(i) > '9') 
								&& kilometersString.charAt(i) != '.')
							throw new NumberFormatException();
					Double kilometers = new Double(kilometersString);
					double miles = kilometers / 1.60934;
					jtfMiles.setText(String.valueOf(miles));
				}
				catch (NumberFormatException ex) {
					javax.swing.JOptionPane.showMessageDialog(null, "Please enter only numbers for conversion", 
							"Faulty input", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// Add panels to the Frame
		setLayout(new BorderLayout(1, 1));
		add(pLabels, BorderLayout.WEST);
		add(pTextFields, BorderLayout.EAST);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1706_ConverterMilesKilometers frame = new PE1706_ConverterMilesKilometers();
		frame.setTitle("Exercise17_06");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
