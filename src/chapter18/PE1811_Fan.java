package chapter18;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PE1811_Fan extends JPanel {

	private int startingAngle = 0;
	private int increment = 2;
	private Timer timer;


	public PE1811_Fan() {
		// TODO Auto-generated constructor stub
		timer = new Timer(250, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setSpeed(int delay) {
		timer.setDelay(delay);
	}

	public void reverse() {
		increment *= -1;
	}
	
	public int getDelay() {
		return timer.getDelay();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

		int x = xCenter - radius;
		int y = yCenter - radius;

		startingAngle += increment;

		g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle + 90, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle + 180, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle + 270, 30);
		g.drawArc(x - 3, y  - 3, 2 * radius + 6, 2 * radius + 6, 0, 360);
	}
}