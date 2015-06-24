/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chapter13.L1310_StillClock;

/**
 * @author jslapnicka
 * @Date & @Time 26. 9. 2014 2014 9:11:03 
 */
@SuppressWarnings("serial")
public class PE1707_SetClockTime extends JFrame {

	/**
	 * @param args
	 */
	
	// Create a StillClock instance
	L1310_StillClock clock = new L1310_StillClock();
	
	// Create JLabels for hour, minute and second
	JLabel jlblHour = new JLabel("Hour");
	JLabel jlblMinute = new JLabel("Minute");
	JLabel jlblSecond = new JLabel("Second");
	
	// Create JTextFields for hour, minute and second
	JTextField jtfHour = new JTextField(2);
	JTextField jtfMinute = new JTextField(2);
	JTextField jtfSecond = new JTextField(2);
		
	public PE1707_SetClockTime() {
		// TODO Auto-generated constructor stub
		
		// Create a line border
		LineBorder lineBorder = new LineBorder(Color.BLACK);
		
		// Create a panel for hours, minutes and seconds and add labels with text fields to it
		JPanel pToolBar = new JPanel(new FlowLayout());
		pToolBar.add(jlblHour);
		pToolBar.add(jtfHour);
		pToolBar.add(jlblMinute);
		pToolBar.add(jtfMinute);
		pToolBar.add(jlblSecond);
		pToolBar.add(jtfSecond);
		pToolBar.setBorder(lineBorder);
		
		clock.setBorder(lineBorder);
		
		// Register listeners
		jtfHour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.setHour(Integer.valueOf(jtfHour.getText()));
				clock.repaint();
			}
		});
		jtfMinute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.setMinute(Integer.valueOf(jtfMinute.getText()));
				clock.repaint();
			}
		});
		jtfSecond.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clock.setSecond(Integer.valueOf(jtfSecond.getText()));
				clock.repaint();
			}
		});
		
		// Add panels to the Frame
		setLayout(new BorderLayout(2, 2));
		add(clock, BorderLayout.CENTER);
		add(pToolBar, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1707_SetClockTime();
		frame.setTitle("Exercise17_07");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
