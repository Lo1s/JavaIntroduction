/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import chapter13.L1310_StillClock;


/**
 * @author jslapnicka
 * @Date & @Time 16. 9. 2014 2014 12:21:27 
 */
@SuppressWarnings("serial")
public class PE1624_ControlClock extends JFrame {

	private L1310_StillClock clock = new L1310_StillClock();
	JButton jbtStart = new JButton("Start");
	JButton jbtStop = new JButton("Stop");
	// Create a timer with delay 1000ms
	Timer timer = new Timer(1000, new TimerListener());

	public PE1624_ControlClock() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(jbtStart);
		panel.add(jbtStop);
		add(clock, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.start();
			}
		});
		
		jbtStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.stop();
			}
		});


	}

	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Set new time and repaint the clock to display current time
			clock.setCurrentTime();
			clock.repaint();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1624_ControlClock();
		frame.setTitle("Listing 16.12");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
