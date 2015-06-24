/**
 * 
 */
package chapter18;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chapter13.L1310_StillClock;

/**
 * @author jslapnicka
 * @Date & @Time 15. 10. 2014 2014 13:16:59 
 */
@SuppressWarnings("serial")
public class PE1814_GroupOfClock extends JApplet {

	// Create clocks and the global buttons
	AnimatedClock clock1 = new AnimatedClock();
	AnimatedClock clock2 = new AnimatedClock();
	AnimatedClock clock3 = new AnimatedClock();
	
	JButton jbtResumeAll = new JButton("Resume All");
	JButton jbtSuspendAll = new JButton("Suspend All");
	
	public PE1814_GroupOfClock() {
		// TODO Auto-generated constructor stub
		JPanel jpGlobalButtons = new JPanel();
		jpGlobalButtons.add(jbtResumeAll);
		jpGlobalButtons.add(jbtSuspendAll);
		
		// Register listeners
		jbtResumeAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clock1.resume();
				clock2.resume();
				clock3.resume();
			}
		});
		jbtSuspendAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clock1.suspend();
				clock2.suspend();
				clock3.suspend();
			}
		});
		
		add(clock1, BorderLayout.WEST);
		add(clock2, BorderLayout.CENTER);
		add(clock3, BorderLayout.EAST);
		add(jpGlobalButtons, BorderLayout.SOUTH);
	}
	
	class AnimatedClock extends JApplet	{
		
		private L1310_StillClock clock = new L1310_StillClock();
		private JButton jbtSuspend = new JButton("Suspend");
		private JButton jbtResume = new JButton("Resume");
		private Timer timer;
		
		public AnimatedClock() {
			// TODO Auto-generated constructor stub
			// Register listeners for the timer and the buttons
			timer = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					clock.setCurrentTime();
					clock.repaint();
				}
			});		
			jbtSuspend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					suspend();
				}
			});
			jbtResume.addActionListener(new ActionListener() { 
				
				@Override
				public void actionPerformed(ActionEvent e) {
					resume();
				}
			});
			
			timer.start();
			JPanel jpButtons = new JPanel();
			jpButtons.add(jbtSuspend);
			jpButtons.add(jbtResume);
			
			// Add items to the frame
			add(clock, BorderLayout.CENTER);
			add(jpButtons, BorderLayout.SOUTH);
		}
		
		public void suspend() {
			timer.stop();
		}
		
		public void resume() {
			timer.start();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1814_GroupOfClock applet = new PE1814_GroupOfClock();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Exercise18_14");
		frame.setSize(600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
