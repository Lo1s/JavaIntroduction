/**
 * 
 */
package chapter18;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 21. 10. 2014 2014 14:45:52 
 */
@SuppressWarnings("serial")
public class PE1821_AlarmClock extends JApplet {

	private JCheckBox jchkbAlarm = new JCheckBox("Alarm");
	private JButton jbtSetAlarm = new JButton("Set Alarm");
	private JButton jbtSnooze = new JButton("Snooze");
	private JButton jbtAlarmTime = new JButton("Alarm Time");
	private JLabel jlblHourTitle = new JLabel("Hour");
	private JLabel jlblMinuteTitle = new JLabel("Minute");
	private JLabel jlblSecondTitle = new JLabel("Second");
	private JLabel jlblHourDigit = new JLabel();
	private JLabel jlblMinuteDigit = new JLabel();
	private JLabel jlblSecondDigit = new JLabel();
	private JLabel jlblColonH = new JLabel(":");
	private JLabel jlblColonM = new JLabel(":");
	private JPanel jpDisplay;

	private JFrame frameSetAlarm = new JFrame();
	private JLabel jlblTitle = new JLabel("Enter Hour, Minute and Second");
	private JLabel jlblSetHour = new JLabel("Hour");
	private JLabel jlblSetMinute = new JLabel("Minute");
	private JLabel jlblSetSecond = new JLabel("Second");
	private JTextField jtfHour = new JTextField(10);
	private JTextField jtfMinute = new JTextField(10);
	private JTextField jtfSecond = new JTextField(10);
	private JButton jbtOK = new JButton("OK");
	private JButton jbtCancel = new JButton("Cancel");

	private AudioClip audioClip;

	private boolean isAlarm = false;
	private Calendar calendar = new GregorianCalendar();
	private Timer timer;
	private Timer timerAlarm;
	private String hourClock;
	private String minuteClock;
	private String secondClock;
	private String hourAlarm = "00";
	private String minuteAlarm = "00";
	private String secondAlarm = "00";
	private boolean flash = true;
	private boolean isSnoozed = true;

	public PE1821_AlarmClock() {
		// TODO Auto-generated constructor stub
		/** Set up Alarm display */
		LineBorder lineBorder = new LineBorder(Color.BLACK, 1);
		Font fontDigit = new Font("TimesRoman", Font.BOLD, 35);
		setClock();
		jchkbAlarm.setHorizontalAlignment(JCheckBox.CENTER);
		audioClip = newAudioClip(getClass().getResource("audio/alarm.mid"));

		JPanel jpToolBar = new JPanel(new GridLayout(2, 2));
		jpToolBar.add(jchkbAlarm);
		jpToolBar.add(jbtSetAlarm);
		jpToolBar.add(jbtAlarmTime);
		jpToolBar.add(jbtSnooze);

		jlblHourTitle.setHorizontalAlignment(JLabel.CENTER);
		jlblMinuteTitle.setHorizontalAlignment(JLabel.CENTER);
		jlblSecondTitle.setHorizontalAlignment(JLabel.CENTER);

		jlblHourDigit.setHorizontalAlignment(JLabel.CENTER);
		jlblHourDigit.setVerticalAlignment(JLabel.CENTER);
		jlblHourDigit.setFont(fontDigit);
		jlblMinuteDigit.setHorizontalAlignment(JLabel.CENTER);
		jlblMinuteDigit.setVerticalAlignment(JLabel.CENTER);
		jlblMinuteDigit.setFont(fontDigit);
		jlblSecondDigit.setHorizontalAlignment(JLabel.CENTER);
		jlblSecondDigit.setVerticalAlignment(JLabel.CENTER);
		jlblSecondDigit.setFont(fontDigit);
		jlblColonH.setHorizontalAlignment(JLabel.CENTER);
		jlblColonH.setFont(fontDigit);
		jlblColonM.setHorizontalAlignment(JLabel.CENTER);
		jlblColonM.setFont(fontDigit);

		jpDisplay = new JPanel(new GridLayout(1, 5));
		jpDisplay.add(jlblHourDigit);
		jpDisplay.add(jlblColonH);
		jpDisplay.add(jlblMinuteDigit);
		jpDisplay.add(jlblColonM);
		jpDisplay.add(jlblSecondDigit);
		jpDisplay.setBorder(lineBorder);

		JPanel jpTitle = new JPanel(new GridLayout(1, 5));
		jpTitle.add(jlblHourTitle);
		jpTitle.add(new JLabel());
		jpTitle.add(jlblMinuteTitle);
		jpTitle.add(new JLabel());
		jpTitle.add(jlblSecondTitle);
		jpTitle.setBorder(lineBorder);

		/** Set up Alarm settings */
		JPanel jpLabels = new JPanel(new GridLayout(3, 1));
		jpLabels.add(jlblSetHour);
		jpLabels.add(jlblSetMinute);
		jpLabels.add(jlblSetSecond);

		JPanel jpTextFields = new JPanel(new GridLayout(3, 1));
		jpTextFields.add(jtfHour);
		jpTextFields.add(jtfMinute);
		jpTextFields.add(jtfSecond);

		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtOK);
		jpButtons.add(jbtCancel);

		frameSetAlarm.add(jlblTitle, BorderLayout.NORTH);
		frameSetAlarm.add(jpLabels, BorderLayout.WEST);
		frameSetAlarm.add(jpTextFields, BorderLayout.CENTER);
		frameSetAlarm.add(jpButtons, BorderLayout.SOUTH);

		/** Register listeners for main frame */
		jbtSetAlarm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameSetAlarm.setTitle("Set Alarm");
				frameSetAlarm.setSize(200, 150);
				frameSetAlarm.setLocationRelativeTo(null);
				frameSetAlarm.setVisible(true);
			}
		});
		jbtAlarmTime.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (isSnoozed) {
					timer.stop();
					jlblHourDigit.setText(hourAlarm);
					jlblMinuteDigit.setText(minuteAlarm);
					jlblSecondDigit.setText(secondAlarm);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (isSnoozed) {
					setClock();
					timer.start();
				}
			}
		});				

		jbtSnooze.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				isSnoozed = true;
				audioClip.stop();
				timerAlarm.stop();
				timer.start();
			}
		});

		jchkbAlarm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jchkbAlarm.isSelected())
					isAlarm = true;
				else
					isAlarm = false;
			}
		});
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jlblHourDigit.setForeground(Color.BLACK);
				jlblMinuteDigit.setForeground(Color.BLACK);
				jlblSecondDigit.setForeground(Color.BLACK);
				jlblColonH.setForeground(Color.BLACK);
				jlblColonM.setForeground(Color.BLACK);
				setClock();
				jpDisplay.repaint();

				if (alarmCheck())
					timerAlarm.start();
			}
		});
		timerAlarm = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jlblHourDigit.setForeground(Color.RED);
				jlblMinuteDigit.setForeground(Color.RED);
				jlblSecondDigit.setForeground(Color.RED);
				jlblColonH.setForeground(Color.RED);
				jlblColonM.setForeground(Color.RED);

				if (!flash) {
					jlblHourDigit.setText(hourAlarm);
					jlblMinuteDigit.setText(minuteAlarm);
					jlblSecondDigit.setText(secondAlarm);
					flash = true;
				} else {
					jlblHourDigit.setText("");
					jlblMinuteDigit.setText("");
					jlblSecondDigit.setText("");
					flash = false;
				}
			}
		});

		timer.start();
		// Register listeners for the second frame (Set Alarm)
		jbtOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAlarm();
			}
		});
		jbtCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameSetAlarm.setVisible(false);
			}
		});

		add(jpTitle, BorderLayout.NORTH);
		add(jpDisplay, BorderLayout.CENTER);
		add(jpToolBar, BorderLayout.SOUTH);
	}

	/** Check if Alarm is triggered */
	public boolean alarmCheck() {
		if (Integer.parseInt(hourAlarm) == Integer.parseInt(hourClock) 
				&& Integer.parseInt(minuteAlarm) == Integer.parseInt(minuteClock)
				&& Integer.parseInt(secondAlarm) == Integer.parseInt(secondClock) && isAlarm) {
			timer.stop();
			isSnoozed = false;
			audioClip.loop();
			return true;
		} else
			return false;		
	}

	public void setClock() {
		/** Sets the display for clock */
		calendar = new GregorianCalendar();
		hourClock = (calendar.get(Calendar.HOUR_OF_DAY) < 10) ? "0" + calendar.get(Calendar.HOUR_OF_DAY) 
				: calendar.get(Calendar.HOUR_OF_DAY) + "";
		minuteClock = (calendar.get(Calendar.MINUTE) < 10) ? "0" + calendar.get(Calendar.MINUTE)
				: calendar.get(Calendar.MINUTE) + "";
		secondClock = (calendar.get(Calendar.SECOND) < 10) ? "0" + calendar.get(Calendar.SECOND)
				: calendar.get(Calendar.SECOND) + "";
		jlblHourDigit.setText(hourClock);
		jlblMinuteDigit.setText(minuteClock);
		jlblSecondDigit.setText(secondClock);
	}

	public void setAlarm() {
		/** Sets the display for alarm */
		hourAlarm = jtfHour.getText();
		minuteAlarm = jtfMinute.getText();
		secondAlarm = jtfSecond.getText();
		if (isAlarm) {
			jlblHourDigit.setText(hourAlarm);
			jlblMinuteDigit.setText(minuteAlarm);
			jlblSecondDigit.setText(secondAlarm);
		}
		frameSetAlarm.setVisible(false);
	}

	@Override
	public void init() {
		setSize(280, 150);
	}

	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1821_AlarmClock applet = new PE1821_AlarmClock();
		frame.add(applet);
		frame.setTitle("Exercise18_21");
		frame.setSize(280, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
