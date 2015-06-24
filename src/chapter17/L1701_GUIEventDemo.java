/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 24. 9. 2014 2014 12:56:05 
 */
@SuppressWarnings("serial")
public class L1701_GUIEventDemo extends JFrame {

	/**
	 * @param args
	 */
	
	private JLabel jlblMessage = new JLabel("Hello", JLabel.CENTER);
	
	// Create check boxes to se the font of the message
	private JCheckBox jchkbBold = new JCheckBox("Bold");
	private JCheckBox jchkItalic = new JCheckBox("Italic");
	
	// Create three radio buttons to set message colors
	private JRadioButton jrbRed = new JRadioButton("Red");
	private JRadioButton jrbGreen = new JRadioButton("Green");
	private JRadioButton jrbBlue = new JRadioButton("Blue");
	
	// Create a text field for setting a new message
	private JTextField jtfMessage = new JTextField(10);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1701_GUIEventDemo frame = new L1701_GUIEventDemo();
		frame.setTitle("GUIEventDemo");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public L1701_GUIEventDemo() {
		// TODO Auto-generated constructor stub
		jlblMessage.setBorder(new LineBorder(Color.BLACK, 2));
		add(jlblMessage, BorderLayout.CENTER);
		
		// Create a panel to hold check boxes
		JPanel jpCheckBoxes = new JPanel();
		jpCheckBoxes.setLayout(new GridLayout(2, 1));
		jpCheckBoxes.add(jchkbBold);
		jpCheckBoxes.add(jchkItalic);
		add(jpCheckBoxes, BorderLayout.EAST);
		
		// Create a panel to hold radio buttons
		JPanel jpRadioButtons = new JPanel();
		jpRadioButtons.setLayout(new GridLayout(3, 1));
		jpRadioButtons.add(jrbRed);
		jpRadioButtons.add(jrbGreen);
		jpRadioButtons.add(jrbBlue);
		add(jpRadioButtons, BorderLayout.WEST);
		
		// Create a radio button group to group three buttons
		ButtonGroup group = new ButtonGroup();
		group.add(jrbRed);
		group.add(jrbGreen);
		group.add(jrbBlue);
		
		// Set initial message color to blue
		jrbBlue.setSelected(true);
		jlblMessage.setForeground(Color.BLUE);
		
		// Create panel to hold label and text field
		JPanel jpTextField = new JPanel();
		jpTextField.setLayout(new BorderLayout(5, 0));
		jpTextField.add(new JLabel("Enter a message:"), BorderLayout.WEST);
		jpTextField.add(jtfMessage, BorderLayout.CENTER);
		jtfMessage.setHorizontalAlignment(JTextField.RIGHT);
		add(jpTextField, BorderLayout.NORTH);
		
		// Set mnemonic keys for check boxes and radio buttons
		jrbRed.setMnemonic('e');
		jrbGreen.setMnemonic('G');
		jrbBlue.setMnemonic('u');
		jchkbBold.setMnemonic('B');
		jchkItalic.setMnemonic('I');
		
		// Register listeners with check boxes
		jchkbBold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setNewFont();
				System.out.println("Bold !");
			}
		});
		jchkItalic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setNewFont();
				System.out.println("Italic !");
			}
		});
		
		// Register listeners with radio buttons
		jrbRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlblMessage.setForeground(Color.RED);
			}
		});
		jrbGreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlblMessage.setForeground(Color.GREEN);
			}
		});
		jrbBlue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlblMessage.setForeground(Color.BLUE);
			}
		});
		
		// Register listener for text field
		jtfMessage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jlblMessage.setText(jtfMessage.getText());
				jlblMessage.requestFocusInWindow();
			}
		});
	}
	
	private void setNewFont() {
		// Determine a font style
		int fontStyle = Font.PLAIN;
		fontStyle += (jchkbBold.isSelected() ? Font.BOLD : Font.PLAIN);
		fontStyle += (jchkItalic.isSelected() ? Font.ITALIC : Font.PLAIN);
		
		// Set new font for a message
		Font font = jlblMessage.getFont();
		jlblMessage.setFont(new Font(font.getName(), fontStyle, font.getSize()));
	}
	
}
