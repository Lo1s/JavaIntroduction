/**
 * 
 */
package chapter20;

import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 21. 11. 2014 2014 18:09:22 
 */
@SuppressWarnings("serial")
public class PE2020_DisplayCircles extends JApplet {

	public PE2020_DisplayCircles() {
		// TODO Auto-generated constructor stub
		add(new DrawCircles());
	}

	static class DrawCircles extends JPanel {

		private int radius = 5;

		@Override
		protected void paintComponent(Graphics g) {

			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;

			displayCircles(g, xCenter, yCenter, radius);
		}

		private static void displayCircles(Graphics g, int xCenter, int yCenter, int radius) {
			if (2 * radius < ((yCenter - 10) * 2)) {
				System.out.println("radius: "  + radius + ", yCenter: " + (yCenter * 2));
				radius += 5;
				g.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
				displayCircles(g, xCenter, yCenter, radius);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE2020_DisplayCircles applet = new PE2020_DisplayCircles();

		frame.add(applet);
		frame.setTitle("Exercise20_20");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
