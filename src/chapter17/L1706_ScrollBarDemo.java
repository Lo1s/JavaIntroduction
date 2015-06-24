/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 8:39:36 
 */
@SuppressWarnings("serial")
public class L1706_ScrollBarDemo extends JFrame {

	
	// Create a horizontal and vertical scroll bars
	JScrollBar jscbHort = new JScrollBar(JScrollBar.HORIZONTAL);
	JScrollBar jscbVert = new JScrollBar(JScrollBar.VERTICAL);
	
	// Create a MessagePanel
	L1308_MessagePanel messagePanel = new L1308_MessagePanel();
	
	public L1706_ScrollBarDemo() {
		// TODO Auto-generated constructor stub
		// Add scroll bars and message panel to the frame
		setLayout(new BorderLayout());
		add(messagePanel, BorderLayout.CENTER);
		add(jscbHort, BorderLayout.SOUTH);
		add(jscbVert, BorderLayout.EAST);
		
		// Register listeners for the scroll bars
		jscbHort.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// getValue() and getMaximum() return int but for
				// better precision, use double
				double value = jscbHort.getValue();
				double maximumValue = jscbHort.getMaximum();
				double newX = (value * messagePanel.getWidth() / maximumValue);
				messagePanel.setXCoordinate((int)newX);
			}
		});
		jscbVert.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// getValue() and getMaximum() return int but for
				// better precision, use double
				double value = jscbVert.getValue();
				double maximumValue = jscbVert.getMaximum();
				double newY = (value * messagePanel.getHeight() / maximumValue);
				messagePanel.setYCoordinate((int)newY);
			}
		});
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1706_ScrollBarDemo frame = new L1706_ScrollBarDemo();
		frame.setTitle("ScrollBarDemo");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
