package chapter18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.Timer;

import chapter13.L1310_StillClock;

/**
 * @author jslapnicka
 * @Date & @Time 10. 9. 2014 2014 14:43:14 
 */
@SuppressWarnings("serial")
public class PE1802_ClockAnimationApplet extends JApplet {

	private L1310_StillClock clock = new L1310_StillClock();
	
	public PE1802_ClockAnimationApplet() {
		add(clock);
		
		// Create a timer with delay 1000ms
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
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
		JFrame frame = new JFrame();
		PE1802_ClockAnimationApplet applet =new PE1802_ClockAnimationApplet();
		frame.add(applet);
		
		frame.setTitle("Listing 16.12");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
