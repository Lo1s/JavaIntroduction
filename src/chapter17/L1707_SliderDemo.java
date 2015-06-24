/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 9:24:03 
 */
@SuppressWarnings("serial")
public class L1707_SliderDemo extends JFrame {

	/**
	 * @param args
	 */
	
	// Create horizontal and vertical sliders
	JSlider jsldHort = new JSlider(JSlider.HORIZONTAL);
	JSlider jsldVert = new JSlider(JSlider.VERTICAL);
	
	// Create a message panel
	private L1308_MessagePanel messagePanel = new L1308_MessagePanel();
	
	public L1707_SliderDemo() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout(5, 5));
		add(messagePanel, BorderLayout.CENTER);
		add(jsldVert, BorderLayout.EAST);
		add(jsldHort, BorderLayout.SOUTH);
		
		// Set properties for the sliders
		jsldHort.setMaximum(50);
		jsldHort.setPaintLabels(true);
		jsldHort.setPaintTicks(true);
		jsldHort.setMajorTickSpacing(10);
		jsldHort.setMinorTickSpacing(1);
		jsldHort.setPaintTrack(false);
		jsldVert.setInverted(true);
		jsldVert.setMaximum(10);
		jsldVert.setPaintLabels(true);
		jsldVert.setPaintTicks(true);
		jsldVert.setMajorTickSpacing(10);
		jsldVert.setMinorTickSpacing(1);
		
		// Register listeners for the sliders
		jsldHort.addChangeListener(new ChangeListener() {
			@Override /** Handle scroll bar adjustment value */
			public void stateChanged(ChangeEvent e) {
				// getValue() and getMaximum return int, but for better
				// precision, use double
				double value = jsldHort.getValue();
				double maximumValue = jsldHort.getMaximum();
				double newX = (value * messagePanel.getWidth() / maximumValue);
				messagePanel.setXCoordinate((int)newX);
			}
		});
		jsldVert.addChangeListener(new ChangeListener() {
			@Override /** Handle scroll bar adjustment value */
			public void stateChanged(ChangeEvent e) {
				// getValue() and getMaximum() return int, but for better
				// precision, use double
				double value = jsldVert.getValue();
				double maximumValue = jsldVert.getMaximum();
				double newY = (value * messagePanel.getHeight() / maximumValue);
				messagePanel.setYCoordinate((int)newY);
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1707_SliderDemo frame = new L1707_SliderDemo();
		frame.setTitle("SliderDemo");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
