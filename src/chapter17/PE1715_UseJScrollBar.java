/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * @author jslapnicka
 * @Date & @Time 1. 10. 2014 2014 10:39:12 
 */
@SuppressWarnings("serial")
public class PE1715_UseJScrollBar extends JFrame {

	/**
	 * @param args
	 */
	
	// Create JLabels
	JLabel jlblShowColors = new JLabel("Show Colors");
	JLabel jlblRed = new JLabel("Red");
	JLabel jlblGreen = new JLabel("Green");
	JLabel jlblBlue = new JLabel("Blue");
	
	// Create JScrollBars
	JScrollBar jscbRed = new JScrollBar(JScrollBar.HORIZONTAL);
	JScrollBar jscbGreen = new JScrollBar(JScrollBar.HORIZONTAL);
	JScrollBar jscbBlue = new JScrollBar(JScrollBar.HORIZONTAL);
	
	// Create a Titled Border
	TitledBorder titledBorder = new TitledBorder("Choose colors");
	
	public PE1715_UseJScrollBar() {
		// TODO Auto-generated constructor stub
		// Set up the display label
		jlblShowColors.setVerticalAlignment(JLabel.CENTER);
		jlblShowColors.setHorizontalAlignment(JLabel.CENTER);
		
		// Set up JScrollBars
		int minimum = 0;
		int maximum = 255;
		int average = (maximum - minimum) / 2;
		
		jscbRed.setMinimum(minimum);
		jscbRed.setMaximum(maximum);
		jscbRed.setValue(average);
		jscbGreen.setMinimum(minimum);
		jscbGreen.setMaximum(maximum);
		jscbGreen.setValue(average);
		jscbBlue.setMinimum(minimum);
		jscbBlue.setMaximum(maximum);
		jscbBlue.setValue(average);
		
		// Put the label into the panel
		JPanel jpShowColors = new JPanel(new BorderLayout());
		jpShowColors.add(jlblShowColors, BorderLayout.CENTER);
		
		// Put color labels into the panel
		JPanel jpColorLabels = new JPanel(new GridLayout(3, 1));
		jpColorLabels.add(jlblRed);
		jpColorLabels.add(jlblGreen);
		jpColorLabels.add(jlblBlue);
		
		// Put JScrollBars into the panel
		JPanel jpScrollBars = new JPanel(new GridLayout(3, 1));
		jpScrollBars.add(jscbRed);
		jpScrollBars.add(jscbGreen);
		jpScrollBars.add(jscbBlue);
		
		// Put scroll bars and description labels into one panel
		JPanel jpChooseColors = new JPanel(new BorderLayout());
		jpChooseColors.add(jpColorLabels, BorderLayout.WEST);
		jpChooseColors.add(jpScrollBars, BorderLayout.CENTER);
		jpChooseColors.setBorder(titledBorder);
		
		// Register listener
		MyAdjustmentListener listener = new MyAdjustmentListener();
		jscbRed.addAdjustmentListener(listener);
		jscbGreen.addAdjustmentListener(listener);
		jscbBlue.addAdjustmentListener(listener);
		
		// Add items into the frame
		setLayout(new GridLayout(2, 1));
		add(jpShowColors);
		add(jpChooseColors);
		
	}
	
	class MyAdjustmentListener implements AdjustmentListener {
		
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			int red = jscbRed.getValue();
			int green = jscbGreen.getValue();
			int blue = jscbBlue.getValue();
			Color color = new Color(red, green, blue);
			jlblShowColors.setForeground(color);				
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1715_UseJScrollBar();
		frame.setTitle("Exercise17_15");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
