/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 2. 10. 2014 2014 8:34:39 
 */
@SuppressWarnings("serial")
public class PE1717_DisplayCalendar extends JFrame {

	/**
	 * @param args
	 */
	// Data Field
	GregorianCalendar calendar = new GregorianCalendar();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH);

	String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
			"November", "December"};


	// Create JButtons for moving through calendar months
	JButton jbtPrior = new JButton("Prior");
	JButton jbtNext = new JButton("Next");

	// Create a JLabel for a month title and days
	JLabel jlblMonthTitle = new JLabel(monthName[month] + " " + year);
	JLabel jlblMonday = new JLabel("Monday");
	JLabel jlblTuesday = new JLabel("Tuesday");
	JLabel jlblWednesday = new JLabel("Wednesday");
	JLabel jlblThursday = new JLabel("Thursday");
	JLabel jlblFriday = new JLabel("Friday");
	JLabel jlblSaturday = new JLabel("Saturday");
	JLabel jlblSunday = new JLabel("Sunday");

	// Panels
	JPanel jpMonthTitle = new JPanel();
	JPanel jpDays = new JPanel(new GridLayout(0, 7));
	JPanel jpButtons = new JPanel();

	// Create a LineBorder
	LineBorder lineBorder = new LineBorder(Color.BLACK);

	public PE1717_DisplayCalendar() {
		// TODO Auto-generated constructor stub
		// Set up JLabels
		jlblMonthTitle.setHorizontalAlignment(JLabel.CENTER);

		// 
		// Days
		jlblMonday.setBorder(lineBorder);
		jlblMonday.setHorizontalAlignment(JLabel.CENTER);
		jlblTuesday.setBorder(lineBorder);
		jlblTuesday.setHorizontalAlignment(JLabel.CENTER);
		jlblWednesday.setBorder(lineBorder);
		jlblWednesday.setHorizontalAlignment(JLabel.CENTER);
		jlblThursday.setBorder(lineBorder);
		jlblThursday.setHorizontalAlignment(JLabel.CENTER);
		jlblFriday.setBorder(lineBorder);
		jlblFriday.setHorizontalAlignment(JLabel.CENTER);
		jlblSaturday.setBorder(lineBorder);
		jlblSaturday.setHorizontalAlignment(JLabel.CENTER);
		jlblSunday.setBorder(lineBorder);
		jlblSunday.setHorizontalAlignment(JLabel.CENTER);
		setDays(month, year);
		jpDays.setBorder(lineBorder);

		// Add buttons to the panel
		jpButtons.add(jbtPrior);
		jpButtons.add(jbtNext);

		// Register listeners
		jbtPrior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (month == 0) {
					year--;
					month = 11;
				} else
					month--;
				setDays(month, year);
			}
		});

		jbtNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (month == 11) {
					year++;
					month = 0;
				} else
					month++;
				setDays(month, year);
			}
		});

		// Add items to the frame
		add(jpMonthTitle, BorderLayout.NORTH);
		add(jpDays, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.SOUTH);
	}

	public void setDays(int month, int year) {
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		GregorianCalendar pastCalendar = new GregorianCalendar();
		if (month == 0) {
			pastCalendar.set(Calendar.MONTH, 11);
			pastCalendar.set(Calendar.YEAR, year - 1);
		} else if (month == 1) {
			pastCalendar.set(Calendar.MONTH, 0);
			pastCalendar.set(Calendar.YEAR, year);
		} else {
			pastCalendar.set(Calendar.MONTH, month - 1);
			pastCalendar.set(Calendar.YEAR, year);
		}
			
		// Month title
		jlblMonthTitle.setText(monthName[month] + " " + year);
		jpMonthTitle.add(jlblMonthTitle);
		jpDays.removeAll();
		jpDays.add(jlblMonday);
		jpDays.add(jlblTuesday);
		jpDays.add(jlblWednesday);
		jpDays.add(jlblThursday);
		jpDays.add(jlblFriday);
		jpDays.add(jlblSaturday);
		jpDays.add(jlblSunday);

		JLabel jlblDay;		
		int firstDay = getFirstDay(month, year) - 1;
		firstDay = (firstDay == 0) ? 7 : firstDay;
		int day = 0;
		System.out.println("Calendar: " + monthName[calendar.get(Calendar.MONTH)]);
		System.out.println("Past calendar: " + monthName[pastCalendar.get(Calendar.MONTH)]);
		System.out.println("Calendar Starting day: " + firstDay);
		System.out.println("Past Calendar maximum: " + pastCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("------------");
		for (int cell = 1; cell <= 42; cell++) {
			if (cell < firstDay) {
				jlblDay = new JLabel((pastCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) - (firstDay - cell - 1)) + "");
				jlblDay.setForeground(Color.GRAY);
				jlblDay.setBorder(lineBorder);
				jlblDay.setHorizontalAlignment(JLabel.RIGHT);
				jlblDay.setVerticalAlignment(JLabel.TOP);
				jpDays.add(jlblDay);
			} else if (cell >= firstDay && day < calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				day++;
				jlblDay = new JLabel(day + "");
				jlblDay.setBorder(lineBorder);
				jlblDay.setHorizontalAlignment(JLabel.RIGHT);
				jlblDay.setVerticalAlignment(JLabel.TOP);
				jpDays.add(jlblDay);
			} else {
				jlblDay = new JLabel();
				jlblDay.setBorder(lineBorder);
				jpDays.add(jlblDay);
			}
			
		}
		
		/**for (int i = calendar.get(Calendar.DAY_OF_WEEK) - 3; i > 0; i--) {
			jlblDay = new JLabel((pastCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) - (i - 1)) + "");
			jlblDay.setForeground(Color.GRAY);
			jlblDay.setBorder(lineBorder);
			jlblDay.setHorizontalAlignment(JLabel.RIGHT);
			jlblDay.setVerticalAlignment(JLabel.TOP);
			jpDays.add(jlblDay);
		}

		for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			jlblDay = new JLabel((i + 1) + "");
			jlblDay.setBorder(lineBorder);
			jlblDay.setHorizontalAlignment(JLabel.RIGHT);
			jlblDay.setVerticalAlignment(JLabel.TOP);
			jpDays.add(jlblDay);
		}*/

		jpDays.revalidate();
	}
	
	public static int getFirstDay(int month, int year){
	    Calendar c = new GregorianCalendar();
	    c.set(Calendar.MONTH, month);
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    return c.get(Calendar.DAY_OF_WEEK);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1717_DisplayCalendar();
		frame.setTitle("Exercise17_17");
		frame.setSize(510, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
