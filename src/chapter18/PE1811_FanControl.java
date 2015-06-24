/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 * @author jslapnicka
 * @Date & @Time 14. 10. 2014 2014 11:06:43 
 */
@SuppressWarnings("serial")
public class PE1811_FanControl extends JApplet {

	// Creating UI
	JButton jbtStart = new JButton("Start");
	JButton jbtStop = new JButton("Stop");
	JButton jbtReverse = new JButton("Reverse");
	JScrollBar jscbSpeed = new JScrollBar(JScrollBar.HORIZONTAL);
	
	// Creating Fan
	PE1811_Fan fan = new PE1811_Fan();
	
	@Override
	public void init() {

	}

	@Override
	public void start() {

	}

	public PE1811_FanControl() {
		// TODO Auto-generated constructor stub
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtStart);
		jpButtons.add(jbtStop);
		jpButtons.add(jbtReverse);

		// Set up ScrollBar
		jscbSpeed.setMaximum(500);
		jscbSpeed.setMinimum(0);
		jscbSpeed.setValue((jscbSpeed.getMaximum() - jscbSpeed.getMinimum()) / 2);

		// Register listeners
		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fan.resume();
			}
		});
		jbtStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fan.suspend();
			}
		});
		jbtReverse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fan.reverse();
			}
		});
		jscbSpeed.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int delay = fan.getDelay();
				delay = jscbSpeed.getValue();
				System.out.println(delay);
				fan.setSpeed(delay);
			}
		});

		add(jpButtons,BorderLayout.NORTH);
		add(fan, BorderLayout.CENTER);
		add(jscbSpeed, BorderLayout.SOUTH);
	}

}
