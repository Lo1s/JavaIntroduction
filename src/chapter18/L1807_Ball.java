/**
 * 
 */
package chapter18;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 14:22:04 
 */
@SuppressWarnings("serial")
public class L1807_Ball extends JPanel {

	private int delay = 10;

	// Create a timer with the specified delay in miliseconds
	private Timer timer = new Timer(delay, new TimerListener());

	private int radius = 5;
	private ArrayList<Point> balls = new ArrayList<Point>();
	private ArrayList<Color> colors = new ArrayList<Color>();
	private ArrayList<Point> distancePoints = new ArrayList<Point>();

	public L1807_Ball() {
		// TODO Auto-generated constructor stub
		timer.start();
	}

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (balls.size() > 0) {

			for (int i = 0; i < balls.size(); i++) {


				g.setColor(colors.get(i));

				// Check boundaries
				if ((int)balls.get(i).getX() < 0 || (int)balls.get(i).getX() > getWidth())
					distancePoints.set(i, new Point((int)distancePoints.get(i).getX() * (-1), (int)distancePoints.get(i).getY()));
				if ((int)balls.get(i).getY() < 0 || (int)balls.get(i).getY() > getHeight())
					distancePoints.set(i, new Point((int)distancePoints.get(i).getX(), (int)(distancePoints.get(i).getY() * (-1))));

				// Adjust ball position
				balls.set(i, new Point((int)balls.get(i).getX() + (int)distancePoints.get(i).getX(), 
						(int)balls.get(i).getY() + (int)distancePoints.get(i).getY()));
				g.fillOval((int)balls.get(i).getX() - radius, (int)balls.get(i).getY() - radius, 2 * radius, 2 * radius);

			}
		}
	}

	public void suspend() {
		timer.stop(); // Suspend timer
	}

	public void resume() {
		timer.start(); // Resume timer
	}
	
	public void addBall() {
		balls.add(new Point(0, 0));
		distancePoints.add(new Point(2, 2));
		int red = 1 + (int)(Math.random() * (255 - 1) + 1);
		int green = 1 + (int)(Math.random() * (255 - 1) + 1);
		int blue = 1 + (int)(Math.random() * (255 - 1) + 1);
		colors.add(new Color(red, green, blue));
	}

	public void removeBall() {
		balls.remove(balls.size() - 1);
	}

	public void setDelay(int delay) {
		this.delay = delay;
		System.out.println(delay);
		timer.setDelay(delay);
	}
	
	public int getDelay() {
		return timer.getDelay();
	}
}
