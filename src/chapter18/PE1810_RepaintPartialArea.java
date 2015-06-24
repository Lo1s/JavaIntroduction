/**
 * 
 */
package chapter18;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 10. 10. 2014 2014 14:27:05 
 */
@SuppressWarnings("serial")
public class PE1810_RepaintPartialArea extends JApplet {


	public PE1810_RepaintPartialArea() {
		// TODO Auto-generated constructor stub

		add(new TemperatureHistogram());
	}


	class TemperatureHistogram extends JPanel {
		java.util.Date date = new Date();
		int slopeWidth = 10;
		final int INTERVAL = 8;
		int startingPointCurrent = 25;
		int startingPointHistory = 25;
		int[] randomHeight = new int[24];
		int countCurrentSlope = 0;
		int countHistorySlope = 0;
		int tick;
		boolean isRunning = false;
		boolean isLast = false;
		javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tick++;
				System.out.println(tick);
				isRunning = true;
				if (tick == 25) {
					isLast = true;
					tick = 0;
				} else 
					isLast = false;
				repaint();
			}
		});

		public TemperatureHistogram() {
			// TODO Auto-generated constructor stub
		}

		protected void paintComponent(Graphics g) {



			// Draw the baseline
			g.drawLine(10, getHeight() - 40, getWidth() - 10, getHeight() - 40);

			if (!isRunning) {
				// Draw time & date
				Font font = new Font("TimesRoman", Font.PLAIN, 12);
				FontMetrics fm = getFontMetrics(font);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString("Current time: " + date.toString(), getWidth() / 2 - (fm.stringWidth("Current time: " + date.toString()) / 2), 
						getHeight() - 10);
				// Draw underline numbers
				for (int i = 0; i < 24; i++) {
					g.drawString(i + "", startingPointCurrent, getHeight() - 25);
					startingPointCurrent +=  INTERVAL + slopeWidth;
				}
				startingPointCurrent = 25;
			}
			// Draw slopes
			timer.start();
			if (isRunning && !isLast) {
				// Delete previous slope
				g.setColor(Color.WHITE);
				g.fillRect(startingPointCurrent, randomHeight[countCurrentSlope], slopeWidth + 1, getHeight() - 40 - randomHeight[countCurrentSlope]);
				// Draw a new slope for current hour
				randomHeight[countCurrentSlope] = 10 + (int)(Math.random() * (getHeight() - 40 - 10) + 1);
				g.setColor(Color.RED);
				g.fillRect(startingPointCurrent, randomHeight[countCurrentSlope], slopeWidth, getHeight() - 40 - randomHeight[countCurrentSlope]);
				startingPointHistory = 25;
				countHistorySlope = 0;
				while (startingPointHistory < startingPointCurrent) {
					// Delete the initial slope
					g.setColor(Color.WHITE);
					g.fillRect(startingPointHistory, randomHeight[countHistorySlope], slopeWidth + 1, getHeight() - 40 - randomHeight[countHistorySlope]);
					g.setColor(Color.BLACK);
					g.drawRect(startingPointHistory, randomHeight[countHistorySlope], slopeWidth, getHeight() - 40 - randomHeight[countHistorySlope]);
					startingPointHistory += INTERVAL + slopeWidth;
					countHistorySlope++;
				}
				startingPointCurrent += INTERVAL + slopeWidth;
				countCurrentSlope++;
			} else if (isRunning && isLast){
				g.setColor(Color.WHITE);
				g.fillRect(startingPointCurrent - INTERVAL - slopeWidth, randomHeight[countCurrentSlope - 1], 
						slopeWidth + 1, getHeight() - 40 - randomHeight[countCurrentSlope - 1]);
				g.setColor(Color.BLACK);
				g.drawRect(startingPointCurrent - INTERVAL - slopeWidth, randomHeight[countCurrentSlope - 1], 
						slopeWidth, getHeight() - 40 - randomHeight[countCurrentSlope - 1]);
				countCurrentSlope = 0;
				startingPointCurrent = 25;
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1810_RepaintPartialArea applet = new PE1810_RepaintPartialArea();

		frame.add(applet);
		frame.setTitle("Exercise18_10");
		frame.setSize(500, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
