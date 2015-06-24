/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import java.awt.event.*;

import chapter13.L1303_FigurePanel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 12:04:22 
 */
@SuppressWarnings("serial")
public class PE1702_SelectGeometricFigures extends JFrame {

	/**
	 * @param args
	 */
	
	// Create a FigurePanel
	private L1303_FigurePanel figurePanel = new L1303_FigurePanel();
	
	// Create radio buttons
	private JRadioButton jrbLine = new JRadioButton("Line");
	private JRadioButton jrbRectangle = new JRadioButton("Rectangle");
	private JRadioButton jrbOval = new JRadioButton("Oval");
	
	// Create a check box
	private JCheckBox jchkbFilled = new JCheckBox("Filled");
	
	public PE1702_SelectGeometricFigures() {
		// TODO Auto-generated constructor stub
		// Create a panel for radio buttons and check box
		JPanel panelButtons = new JPanel(new GridLayout(1, 4));
		panelButtons.add(jrbLine);
		panelButtons.add(jrbRectangle);
		panelButtons.add(jrbOval);
		panelButtons.add(jchkbFilled);
		panelButtons.setBorder(new LineBorder(Color.BLACK));
		
		// Group the radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(jrbLine);
		group.add(jrbRectangle);
		group.add(jrbOval);
		
		// Set default settings
		jrbOval.setSelected(true);
		figurePanel.setType(L1303_FigurePanel.OVAL);
		jchkbFilled.setSelected(true);
		figurePanel.setFilled(true);
		repaint();
		
		// Register listeners for radio buttons
		jrbLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				figurePanel.setType(L1303_FigurePanel.LINE);
				repaint();
			}
		});
		jrbOval.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				figurePanel.setType(L1303_FigurePanel.OVAL);
				repaint();
			}
		});
		jrbRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				figurePanel.setType(L1303_FigurePanel.RECTANGLE);
				repaint();
			}
		});
		
		// Register listener for check box
		jchkbFilled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jchkbFilled.isSelected())
					figurePanel.setFilled(true);
				else
					figurePanel.setFilled(false);
				repaint();
			}
		});
		
		// Set border for figurePanel
		figurePanel.setBorder(new LineBorder(Color.BLACK));
		
		// Add panels to the frame
		add(figurePanel, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1702_SelectGeometricFigures frame = new PE1702_SelectGeometricFigures();
		frame.setTitle("Exercise17_02");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
