/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 14. 10. 2014 2014 10:50:59 
 */
@SuppressWarnings("serial")
public class PE1812_GroupOfFans extends JApplet{

	// Creating UI
	JButton jbtStartAll = new JButton("Start All");
	JButton jbtStopAll = new JButton("Stop All");
	
	// Creating Fans
	PE1811_FanControl fan1 = new PE1811_FanControl();
	PE1811_FanControl fan2 = new PE1811_FanControl();
	PE1811_FanControl fan3 = new PE1811_FanControl();
	
	
	public PE1812_GroupOfFans() {
		// TODO Auto-generated constructor stub
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtStartAll);
		jpButtons.add(jbtStopAll);
		
		// Register listeners
		jbtStartAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fan1.fan.resume();
				fan2.fan.resume();
				fan3.fan.resume();
			}
		});
		jbtStopAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fan1.fan.suspend();
				fan2.fan.suspend();
				fan3.fan.suspend();
			}
		});
		
		add(fan1, BorderLayout.EAST);
		add(fan2, BorderLayout.CENTER);
		add(fan3, BorderLayout.WEST);
		add(jpButtons, BorderLayout.SOUTH);

	}
	
	public void init() {
		
	}
	
	public void start() {
		
	}
	
	public void stop() {
		
	}
	
	public void destroy() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1812_GroupOfFans applet = new PE1812_GroupOfFans();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("Exercise18_12");
		frame.setSize(700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
