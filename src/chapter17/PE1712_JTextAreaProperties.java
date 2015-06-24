/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

/**
 * @author jslapnicka
 * @Date & @Time 30. 9. 2014 2014 8:57:44 
 */
@SuppressWarnings("serial")
public class PE1712_JTextAreaProperties extends JFrame {

	/**
	 * @param args
	 */
	
	// Create JTextArea
	JTextArea jtaViewer = new JTextArea();
	
	// Create JCheckBox and JRadioButtons
	JCheckBox jchkbWrap = new JCheckBox("Wrap");
	
	JRadioButton jrbWrapChar = new JRadioButton("Wrap Characters");
	JRadioButton jrbWrapWords = new JRadioButton("Wrap Words");
	
	public PE1712_JTextAreaProperties() {
		// TODO Auto-generated constructor stub
		// Create a Titled Border
		TitledBorder titledBorder = new TitledBorder("Wrap Options");
		
		// Create a group for radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(jrbWrapChar);
		group.add(jrbWrapWords);
				
		// Create a panel for the properties
		JPanel jpProperties = new JPanel(new FlowLayout());
		jpProperties.add(jchkbWrap);
		jpProperties.add(jrbWrapWords);
		jpProperties.add(jrbWrapChar);
		jpProperties.setBorder(titledBorder);
		
		// Add Text area to the scroll pane
		JScrollPane scrollPane = new JScrollPane(jtaViewer);
		
		// Default settings
		jtaViewer.setWrapStyleWord(false);
		jtaViewer.setLineWrap(false);
				
		// Register listeners
		jchkbWrap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jchkbWrap.isSelected()) {
					jtaViewer.setLineWrap(true);
					jrbWrapChar.setSelected(true);
				} else
					jtaViewer.setLineWrap(false);
			}
		});
		jrbWrapChar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jrbWrapChar.isSelected())
					jtaViewer.setWrapStyleWord(false);
			}
		});
		jrbWrapWords.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jrbWrapWords.isSelected())
					jtaViewer.setWrapStyleWord(true);
			}
		});
		
		// Add JTextField and properties to the frame
		add(scrollPane, BorderLayout.CENTER);
		add(jpProperties, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1712_JTextAreaProperties();
		frame.setTitle("Exercise17_12");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
