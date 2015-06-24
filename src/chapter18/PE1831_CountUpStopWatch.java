/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 30. 10. 2014 2014 17:12:58 
 */
@SuppressWarnings("serial")
public class PE1831_CountUpStopWatch extends JApplet {

	private JButton jbtStart = new JButton("Start");
	private JButton jbtClear = new JButton("Clear");
	private JLabel jlblTime = new JLabel("00:00:00");
	private JPanel jpButtons = new JPanel();
	private Font font = new Font("Ariel", Font.BOLD, 40);
	private Timer timer;
	private int countSeconds = 0;
	private int countMinutes = 0;
	private int countHours = 0;
	private String secondsString = "";
	private String minutesString = "";
	private String hoursString = "";

	public PE1831_CountUpStopWatch() {
		// TODO Auto-generated constructor stub
		jpButtons.add(jbtStart);
		jpButtons.add(jbtClear);
		jlblTime.setFont(font);
		jlblTime.setHorizontalAlignment(JLabel.CENTER);


		// Register listeners
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				countSeconds++;
				if (countSeconds == 60) {
					countSeconds = 0;
					countMinutes++;
					if (countMinutes == 60) {
						countMinutes = 0;
						countHours++;
						if (countHours == 24) {
							countHours = 0;
							countMinutes = 0;
							countSeconds = 0;
						}
					}
				}
				secondsString = (countSeconds < 10) ? "0" + countSeconds : "" + countSeconds;
				minutesString = (countMinutes < 10) ? "0" + countMinutes : "" + countMinutes;
				hoursString = (countHours < 10) ? "0" + countHours : "" + countHours;

				jlblTime.setText(hoursString + ":" + minutesString + ":" + secondsString);				
				repaint();
			}
		});
		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jbtStart.getText().equals("Start")) {
					timer.start();
					jbtStart.setText("Pause");
				} else if (jbtStart.getText().equals("Pause")) {
					timer.stop();
					jbtStart.setText("Resume");
				} else if (jbtStart.getText().equals("Resume")) {
					timer.start();
					jbtStart.setText("Pause");
				}
				repaint();
			}
		});
		jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timer.stop();
				jbtStart.setText("Start");
				countSeconds = 0;
				countMinutes = 0;
				countHours = 0;
				jlblTime.setText("00:00:00");
				repaint();
			}
		});


		add(jlblTime, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.SOUTH);

	}

	@Override
	public void init() {
		setSize(200, 100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1831_CountUpStopWatch applet = new PE1831_CountUpStopWatch();
		frame.add(applet);

		frame.setTitle("Exercise18_31");
		frame.setSize(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
