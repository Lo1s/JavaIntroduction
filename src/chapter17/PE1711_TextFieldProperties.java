/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

/**
 * @author jslapnicka
 * @Date & @Time 29. 9. 2014 2014 15:19:43 
 */
@SuppressWarnings("serial")
public class PE1711_TextFieldProperties extends JFrame {

	/**
	 * @param args
	 */

	// Create JTextFields
	int columns = 25;
	JTextField jtfInput = new JTextField(columns);
	JTextField jtfColumns = new JTextField(5);

	// Create JRadioButtons
	JRadioButton jrbLeft = new JRadioButton("Left");
	JRadioButton jrbCenter = new JRadioButton("Center");
	JRadioButton jrbRight = new JRadioButton("Right");

	public PE1711_TextFieldProperties() {
		// TODO Auto-generated constructor stub
		// Add radio buttons into the group
		ButtonGroup group = new ButtonGroup();
		group.add(jrbLeft);
		group.add(jrbCenter);
		group.add(jrbRight);

		// Create borders
		LineBorder lineBorder = new LineBorder(Color.BLACK);
		TitledBorder titledBorder = new TitledBorder("Horizontal Alignment");

		// Create panel for the radio buttons
		JPanel jpRadioButtons = new JPanel(new GridLayout(1, 3));
		jpRadioButtons.add(jrbLeft);
		jpRadioButtons.add(jrbCenter);
		jpRadioButtons.add(jrbRight);
		jpRadioButtons.setBorder(titledBorder);

		// Create panel for the text fields
		JLabel jlblColumns = new JLabel("Column Size");
		jlblColumns.setHorizontalTextPosition(JLabel.RIGHT);
		JPanel jpColumns = new JPanel();
		jpColumns.add(jlblColumns);
		jpColumns.add(jtfColumns);
		jpColumns.setBorder(lineBorder);

		JLabel jlblTextField = new JLabel("Text Field");
		jlblTextField.setHorizontalTextPosition(JLabel.RIGHT);

		// Create panel for input text field and label
		JPanel jpInput = new JPanel(new FlowLayout());
		jpInput.add(jlblTextField);
		jtfInput.setText("Type anything");
		jtfInput.setHorizontalAlignment(JTextField.CENTER);
		jpInput.add(jtfInput);

		// Register listeners
		jrbLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if  (jrbLeft.isSelected())
					jtfInput.setHorizontalAlignment(JTextField.LEFT);
			}
		});
		jrbCenter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jrbCenter.isSelected())
					jtfInput.setHorizontalAlignment(JTextField.CENTER);
			}
		});
		jrbRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jrbRight.isSelected())
					jtfInput.setHorizontalAlignment(JTextField.RIGHT);
			}
		});
		
		jtfColumns.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtfInput.setColumns(Integer.parseInt(jtfColumns.getText()));
				validate();
			}
		});

		jpInput.revalidate();
		// Create panel for all items
		setLayout(new FlowLayout());
		add(jpInput, BorderLayout.NORTH);
		add(jpRadioButtons);
		add(jpColumns);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1711_TextFieldProperties();
		frame.setTitle("Exercise17_11");
		frame.setSize(380, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
