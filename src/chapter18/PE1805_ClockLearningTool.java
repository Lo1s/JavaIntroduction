/**
 * 
 */
package chapter18;

import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JApplet;
import javax.swing.JPanel;





/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 15:20:47 
 */
@SuppressWarnings("serial")
public class PE1805_ClockLearningTool extends JApplet {
	
	int randomMinute = hdR.mtd.getRandomNumber(59, 0);
	int randomHour = hdR.mtd.getRandomNumber(0, 11);
	DetailedClock detailedClock = new DetailedClock(randomHour, randomMinute, 0, true, true, false);
	
	public PE1805_ClockLearningTool() {
		// TODO Auto-generated constructor stub
		add(detailedClock);
		addMouseListener(new MouseAdapter() {
			
			 @Override
			 public void mousePressed(MouseEvent e) {
				 if (e.getButton() == MouseEvent.BUTTON1) {
					 randomHour = hdR.mtd.getRandomNumber(0, 11);
					 randomMinute = hdR.mtd.getRandomNumber(59, 0);
					 detailedClock.setHour(randomHour);
					 detailedClock.setMinute(randomMinute);
					 repaint();
				 }
			 }
		});
		
		
	}
	
	class DetailedClock extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private int hour;
		private int minute;
		private int second;
		private boolean hourHandVisible = true;
		private boolean minuteHandVisible = true;
		private boolean secondHandVisible = true;

		/** Construct a default clock with the current time*/
		public DetailedClock() {
			setCurrentTime();
		}

		/** Construct a clock with specified hour, minute, and second */
		public DetailedClock(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		
		public DetailedClock(int hour, int minute, int second, boolean hourHand, boolean minuteHand, boolean secondHand) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
			this.hourHandVisible = hourHand;
			this.minuteHandVisible = minuteHand;
			this.secondHandVisible = secondHand;
		}

		/** Return hour */
		public int getHour() {
			return hour;
		}

		/** Set a new hour */
		public void setHour(int hour) {
			this.hour = hour;
			repaint();
		}

		/** Return minute */
		public int getMinute() {
			return minute;
		}

		/** Set a new minute */
		public void setMinute(int minute) {
			this.minute = minute;
			repaint();
		}

		/** Return second */
		public int getSecond() {
			return second;
		}

		/** Set a new second */
		public void setSecond(int second) {
			this.second = second;
			repaint();
		}
		
		public boolean getHourHandVisible() {
			return hourHandVisible;
		}
		
		public boolean getMinuteHandVisible() {
			return minuteHandVisible;
		}
		
		public boolean getSecondHandVisible() {
			return secondHandVisible;
		}

		public void setHourHandVisible(boolean visible) {
			this.hourHandVisible = visible;
		}

		public void setMinuteHandVisible(boolean visible) {
			this.minuteHandVisible = visible;
		}

		public void setSecondHandVisible(boolean visible) {
			this.secondHandVisible = visible;
		}

		@Override /** Draw the clock */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Initialize clock parameters
			int clockRadius = (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;

			// Draw circle
			g.setColor(Color.black);
			g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
			g.drawString("12", xCenter - 5, yCenter - clockRadius + 20);
			g.drawString("9", xCenter - clockRadius + 10, yCenter + 5);
			g.drawString("3", xCenter + clockRadius - 17, yCenter + 3);
			g.drawString("6", xCenter - 3, yCenter + clockRadius - 9);

			// Draw second hand
			if (secondHandVisible) {
				int sLength = (int)(clockRadius * 0.7);
				int xSecond = (int)(xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
				int ySecond = (int)(yCenter - sLength *	Math.cos(second * (2 * Math.PI / 60)));
				g.setColor(Color.red);
				g.drawLine(xCenter, yCenter, xSecond, ySecond);
			}

			// Draw minute hand
			if (minuteHandVisible) {
				int mLength = (int)(clockRadius * 0.6);
				int xMinute = (int)(xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
				int yMinute = (int)(yCenter - mLength *	Math.cos(minute * (2 * Math.PI / 60)));
				g.setColor(Color.blue);
				g.drawLine(xCenter, yCenter, xMinute, yMinute);
			}

			// Draw hour hand
			if (hourHandVisible) {
				int hLength = (int)(clockRadius * 0.5);
				int xHour = (int)(xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
				int yHour = (int)(yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
				g.setColor(Color.green);
				g.drawLine(xCenter, yCenter, xHour, yHour);
			}
			
			// Display more details on the clock
		    for (int i = 0; i < 60; i++) {
		      double percent;

		      if (i % 5 == 0) {
		        percent = 0.9;
		      }
		      else {
		        percent = 0.95;
		      }

		      int xOuter = (int)(xCenter +
		                         clockRadius * Math.sin(i * (2 * Math.PI / 60)));
		      int yOuter = (int)(yCenter -
		                         clockRadius * Math.cos(i * (2 * Math.PI / 60)));
		      int xInner = (int)(xCenter +
		                         percent * clockRadius * Math.sin(i * (2 * Math.PI / 60)));
		      int yInner = (int)(yCenter -
		                         percent * clockRadius * Math.cos(i * (2 * Math.PI / 60)));

		      g.setColor(Color.BLACK);
		      g.drawLine(xOuter, yOuter, xInner, yInner);
		    }
		}

		public void setCurrentTime() {
			// Construct a calendar for the current date and time
			Calendar calendar = new GregorianCalendar();

			// Set current hour, minute and second
			this.hour = calendar.get(Calendar.HOUR_OF_DAY);
			this.minute = calendar.get(Calendar.MINUTE);
			this.second = calendar.get(Calendar.SECOND);
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(200, 200);
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
