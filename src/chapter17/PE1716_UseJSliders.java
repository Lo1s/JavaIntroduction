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
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;;



/**
 * @author jslapnicka
 * @Date & @Time 2. 10. 2014 2014 8:07:12 
 */
@SuppressWarnings("serial")
public class PE1716_UseJSliders extends JFrame {

	// Create JLabels
		JLabel jlblShowColors = new JLabel("Show Colors");
		JLabel jlblRed = new JLabel("Red");
		JLabel jlblGreen = new JLabel("Green");
		JLabel jlblBlue = new JLabel("Blue");
		
		// Create JScrollBars
		JSlider jsldRed = new JSlider(JSlider.HORIZONTAL);
		JSlider jsldGreen = new JSlider(JSlider.HORIZONTAL);
		JSlider jsldBlue = new JSlider(JSlider.HORIZONTAL);
				
		// Create a Titled Border
		TitledBorder titledBorder = new TitledBorder("Choose colors");
		
		public PE1716_UseJSliders() {
			// TODO Auto-generated constructor stub
			// Set up the display label
			jlblShowColors.setVerticalAlignment(JLabel.CENTER);
			jlblShowColors.setHorizontalAlignment(JLabel.CENTER);
			
			// Set up JScrollBars
			int minimum = 0;
			int maximum = 255;
			int average = (maximum - minimum) / 2;
			
			jsldRed.setMinimum(minimum);
			jsldRed.setMaximum(maximum);
			jsldRed.setValue(average);
			jsldRed.setMinorTickSpacing(5);
			jsldRed.setMajorTickSpacing(25);
			jsldRed.setPaintTicks(true);
			jsldRed.setPaintLabels(true);
			jsldGreen.setMinimum(minimum);
			jsldGreen.setMaximum(maximum);
			jsldGreen.setValue(average);
			jsldGreen.setMinorTickSpacing(5);
			jsldGreen.setMajorTickSpacing(25);
			jsldGreen.setPaintTicks(true);
			jsldGreen.setPaintLabels(true);
			jsldBlue.setMinimum(minimum);
			jsldBlue.setMaximum(maximum);
			jsldBlue.setValue(average);
			jsldBlue.setMinorTickSpacing(5);
			jsldBlue.setMajorTickSpacing(25);
			jsldBlue.setPaintTicks(true);
			jsldBlue.setPaintLabels(true);
			
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
			jpScrollBars.add(jsldRed);
			jpScrollBars.add(jsldGreen);
			jpScrollBars.add(jsldBlue);
			
			// Put scroll bars and description labels into one panel
			JPanel jpChooseColors = new JPanel(new BorderLayout());
			jpChooseColors.add(jpColorLabels, BorderLayout.WEST);
			jpChooseColors.add(jpScrollBars, BorderLayout.CENTER);
			jpChooseColors.setBorder(titledBorder);
			
			// Register listener
			MyChangeListener listener = new MyChangeListener();
			jsldRed.addChangeListener(listener);
			jsldGreen.addChangeListener(listener);
			jsldBlue.addChangeListener(listener);
			
			// Add items into the frame
			setLayout(new GridLayout(2, 1));
			add(jpShowColors);
			add(jpChooseColors);
			
		}
		
		class MyChangeListener implements ChangeListener {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int red = jsldRed.getValue();
				int green = jsldGreen.getValue();
				int blue = jsldBlue.getValue();
				Color color = new Color(red, green, blue);
				jlblShowColors.setForeground(color);				
			}
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			JFrame frame = new PE1716_UseJSliders();
			frame.setTitle("Exercise17_16");
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}

	}
