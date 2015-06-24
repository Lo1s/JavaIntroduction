/**
 * 
 */
package chapter15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 4. 9. 2014 2014 14:20:54 
 */
@SuppressWarnings("serial")
public class PE1505_DisplayCalendar extends JFrame {

	/**
	 * @param args
	 */

	public PE1505_DisplayCalendar() {
		// TODO Auto-generated constructor stub
		
		// Getting the calendar information 
		GregorianCalendar calendar = new GregorianCalendar();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Border lineBorder = new LineBorder(Color.black, 1);
		setLayout(new BorderLayout());

		// Create Header
		JLabel jlblHeader = new JLabel();
		jlblHeader.setText(month + "/" + year);
		jlblHeader.setHorizontalAlignment(0);
		// Create the panel with numbers of days and titles
		JPanel panelNumberOfDays = new JPanel();
		// Title
		panelNumberOfDays.add(new JLabel("Monday", 0));
		panelNumberOfDays.add(new JLabel("Tuesday", 0));
		panelNumberOfDays.add(new JLabel("Wednesday", 0));
		panelNumberOfDays.add(new JLabel("Thursday", 0));
		panelNumberOfDays.add(new JLabel("Friday", 0));
		panelNumberOfDays.add(new JLabel("Saturday", 0));
		panelNumberOfDays.add(new JLabel("Sunday", 0));

		// Numbers of days
		panelNumberOfDays.setLayout(new GridLayout(6, 7));
		panelNumberOfDays.setBorder(lineBorder);
		int day = 1;
		for (int column = 1; day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); column++) {
			if (column >= firstDay()) {
				JLabel jlbl = new JLabel();
				jlbl.setText(day++ + "");
				jlbl.setBorder(lineBorder);
				jlbl.setHorizontalAlignment(4);
				panelNumberOfDays.add(jlbl);
			} else {
				panelNumberOfDays.add(new JLabel());
			}
		}
		add(jlblHeader, BorderLayout.NORTH);
		add(panelNumberOfDays, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1505_DisplayCalendar();
		frame.setTitle("Exercise15_05");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public int firstDay() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

}