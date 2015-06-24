package hdR;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
public class Colors extends JFrame {

	// Create JLabels
	private int redValue;
	private int greenValue;
	private int blueValue;
	JLabel jlblRed = new JLabel("Red");
	JLabel jlblGreen = new JLabel("Green");
	JLabel jlblBlue = new JLabel("Blue");
	JLabel jlblRedValue = new JLabel(redValue + "");
	JLabel jlblGreenValue = new JLabel(greenValue + "");
	JLabel jlblBlueValue = new JLabel(blueValue + "");

	// Create JScrollBars
	JSlider jsldRed = new JSlider(JSlider.HORIZONTAL);
	JSlider jsldGreen = new JSlider(JSlider.HORIZONTAL);
	JSlider jsldBlue = new JSlider(JSlider.HORIZONTAL);

	// Create a Titled Border
	TitledBorder titledBorder = new TitledBorder("Choose colors");

	// Create a panel
	JPanel jpShowColors;
	JPanel jpValues;

	public Colors() {
		// TODO Auto-generated constructor stub
		jpShowColors = new JPanel();
		jpShowColors.setBackground(Color.BLACK);

		// Set up JScrollBars
		int minimum = 0;
		int maximum = 255;

		jsldRed.setMinimum(minimum);
		jsldRed.setMaximum(maximum);
		jsldRed.setValue(minimum);
		jsldRed.setMinorTickSpacing(5);
		jsldRed.setMajorTickSpacing(25);
		jsldRed.setPaintTicks(true);
		jsldRed.setPaintLabels(true);
		jsldGreen.setMinimum(minimum);
		jsldGreen.setMaximum(maximum);
		jsldGreen.setValue(minimum);
		jsldGreen.setMinorTickSpacing(5);
		jsldGreen.setMajorTickSpacing(25);
		jsldGreen.setPaintTicks(true);
		jsldGreen.setPaintLabels(true);
		jsldBlue.setMinimum(minimum);
		jsldBlue.setMaximum(maximum);
		jsldBlue.setValue(minimum);
		jsldBlue.setMinorTickSpacing(5);
		jsldBlue.setMajorTickSpacing(25);
		jsldBlue.setPaintTicks(true);
		jsldBlue.setPaintLabels(true);
		redValue = 0;
		greenValue = 0;
		blueValue = 0;
		
		// Put the color values into the label
		JLabel jlblRedValueTitle = new JLabel("Red value: ");
		jlblRedValueTitle.setForeground(Color.RED);
		JLabel jlblGreenValueTitle = new JLabel("Green value: ");
		jlblGreenValueTitle.setForeground(Color.GREEN);
		JLabel jlblBlueValueTitle = new JLabel("Blue value: ");
		jlblBlueValueTitle.setForeground(Color.BLUE);
		jlblRedValue.setForeground(Color.RED);
		jlblGreenValue.setForeground(Color.GREEN);
		jlblBlueValue.setForeground(Color.BLUE);
		jpValues = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		jpValues.add(jlblRedValueTitle);
		jpValues.add(jlblRedValue);
		jpValues.add(jlblGreenValueTitle);
		jpValues.add(jlblGreenValue);
		jpValues.add(jlblBlueValueTitle);
		jpValues.add(jlblBlueValue);
		
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
		
		add(jpValues, BorderLayout.NORTH);
		add(jpShowColors, BorderLayout.CENTER);
		add(jpChooseColors, BorderLayout.SOUTH);

	}

	class MyChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			redValue = jsldRed.getValue();
			greenValue = jsldGreen.getValue();
			blueValue = jsldBlue.getValue();
			Color color = new Color(redValue, greenValue, blueValue);
			jpShowColors.setBackground(color);
			jlblRedValue.setText(redValue + "");
			jlblGreenValue.setText(greenValue + "");
			jlblBlueValue.setText(blueValue + "");
			repaint();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Colors();
		frame.setTitle("Colors");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}