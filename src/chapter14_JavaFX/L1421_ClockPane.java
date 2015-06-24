/**
 * 
 */
package chapter14_JavaFX;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * @author jslapnicka
 * @Date & @Time 5. 1. 2015 2015 10:45:28 
 */
public class L1421_ClockPane extends Pane {

	private int hour;
	private int minute;
	private int second;
	private double h = 250, w = 250;
	private boolean hourHandVisible = true;
	private boolean minuteHandVisible = true;
	private boolean secondHandVisible = true;

	/** Construct a default clock with the current time*/
	public L1421_ClockPane() {
		setCurrentTime();
	}

	/** Construct a clock with specified hour, minute, and second */
	public L1421_ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public L1421_ClockPane(int hour, int minute, int second, boolean hourHand, boolean minuteHand, boolean secondHand) {
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
		paintClock();
	}

	/** Return minute */
	public int getMinute() {
		return minute;
	}

	/** Set a new minute */
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}

	/** Return second */
	public int getSecond() {
		return second;
	}

	/** Set a new second */
	public void setSecond(int second) {
		this.second = second;
		paintClock();
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

	public double getW() {
		return w;
	}

	public void setW(double newW) {
		this.w = newW;
		paintClock();
	}

	public double getH() {
		return h;
	}

	public void setH(double newH) {
		this.h = newH;
		paintClock();
	}

	protected void paintClock() {
		// Initialize clock parameters
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;

		// Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

		Line sLine = new Line();
		Line mLine = new Line();
		Line hLine = new Line();
		// Draw second hand
		if (secondHandVisible) {
			int sLength = (int)(clockRadius * 0.8);
			int xSecond = (int)(centerX + sLength * Math.sin(second * (2 * Math.PI / 60)));
			int ySecond = (int)(centerY - sLength *	Math.cos(second * (2 * Math.PI / 60)));
			sLine.setStartX(centerX);
			sLine.setStartY(centerY);
			sLine.setEndX(xSecond);
			sLine.setEndY(ySecond);
			sLine.setStroke(Color.RED);
		}

		// Draw minute hand
		if (minuteHandVisible) {
			int mLength = (int)(clockRadius * 0.65);
			int xMinute = (int)(centerX + mLength * Math.sin(minute * (2 * Math.PI / 60)));
			int yMinute = (int)(centerY - mLength *	Math.cos(minute * (2 * Math.PI / 60)));
			mLine.setStartX(centerX);
			mLine.setStartY(centerY);
			mLine.setEndX(xMinute);
			mLine.setEndY(yMinute);
			mLine.setStroke(Color.BLUE);
		}

		// Draw hour hand
		if (hourHandVisible) {
			int hLength = (int)(clockRadius * 0.5);
			int xHour = (int)(centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
			int yHour = (int)(centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
			hLine.setStartX(centerX);
			hLine.setStartY(centerY);
			hLine.setEndX(xHour);
			hLine.setEndY(yHour);			
			hLine.setStroke(Color.GREEN);
		}
		
		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
	}

	public void setCurrentTime() {
		// Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();

		// Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock();
	}

}
