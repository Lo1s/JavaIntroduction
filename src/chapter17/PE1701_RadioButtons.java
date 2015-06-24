/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 10:46:36 
 */
@SuppressWarnings("serial")
public class PE1701_RadioButtons extends JFrame {

	/**
	 * @param args
	 */
	
	// Create the radio buttons
	private JRadioButton jrbRed = new JRadioButton("Red");
	private JRadioButton jrbYellow = new JRadioButton("Yellow");
	private JRadioButton jrbWhite = new JRadioButton("White");
	private JRadioButton jrbGray = new JRadioButton("Gray");
	private JRadioButton jrbGreen = new JRadioButton("Green");
	
	// Create a message panel
	private L1308_MessagePanel messagePanel = new L1308_MessagePanel();
	
	// Create a buttons for moving with the message to the right and left
	private JButton jbtRight = new JButton("=>");
	private JButton jbtLeft = new JButton("<=");
	
	public PE1701_RadioButtons() {
		// TODO Auto-generated constructor stub
		// Create a panel for the radio buttons and add to it
		JPanel jpRadioButtons = new JPanel(new GridLayout(1, 5));
		jpRadioButtons.add(jrbRed);
		jpRadioButtons.add(jrbYellow);
		jpRadioButtons.add(jrbWhite);
		jpRadioButtons.add(jrbGray);
		jpRadioButtons.add(jrbGreen);
		jpRadioButtons.setBorder(new TitledBorder("Select Message Panel Background"));
		
		// Add radio buttons to the ButtonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(jrbRed);
		group.add(jrbYellow);
		group.add(jrbWhite);
		group.add(jrbGray);
		group.add(jrbGreen);
		
		// Default settings set to white background
		jrbWhite.setSelected(true);
		messagePanel.setBackground(Color.WHITE);
		
		// Create a panel for the JButtons and add to it
		JPanel jpJButtons = new JPanel(new FlowLayout());
		jpJButtons.add(jbtLeft);
		jpJButtons.add(jbtRight);
		
		// Register listeners for the JButtons
		jbtLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double minimum = 10;
				double x = messagePanel.getXCoordinate();
				if (x > minimum) {
					x -= 10;
					messagePanel.setXCoordinate((int)x);
				}
			}
		});
		jbtRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double maximum = messagePanel.getWidth() - 10;
				double x = messagePanel.getXCoordinate();
				if (x < maximum) {
					x += 10;
					messagePanel.setXCoordinate((int)x);
				}
			}
		});
		
		// Register listeners for the JRadioButtons
		jrbRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				messagePanel.setBackground(Color.RED);
			}
		});
		jrbYellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messagePanel.setBackground(Color.YELLOW);
			}
		});
		jrbWhite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				messagePanel.setBackground(Color.WHITE);
			}
		});
		jrbGray.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messagePanel.setBackground(Color.GRAY);
			}
		});
		jrbGreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messagePanel.setBackground(Color.GREEN);
			}
		});
				
		// Add components to the frame
		add(jpRadioButtons, BorderLayout.NORTH);
		add(messagePanel, BorderLayout.CENTER);
		add(jpJButtons, BorderLayout.SOUTH);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1701_RadioButtons();
		frame.setTitle("Exercise17_01");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
