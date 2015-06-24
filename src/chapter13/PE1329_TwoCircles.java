/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 12. 8. 2014
 * 20:04:54
 */
public class PE1329_TwoCircles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1329_TwoCircles() {
		add(new TwoCircles());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1329_TwoCircles();
		frame.setTitle("Exercise13_29");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}

}

class TwoCircles extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x1 = (int)(Math.random() * (double)(getWidth() - 12));
        int y1 = (int)(Math.random() * (double)(getHeight() - 12));
        int x2 = (int)(Math.random() * (double)(getWidth() - 12));
        int y2 = (int)(Math.random() * (double)(getHeight() - 12));
        int RADIUS = 15;
        g.setColor(Color.RED);
        g.fillOval(x1 - RADIUS, y1 - RADIUS, 2 * RADIUS, 2 * RADIUS);
        g.fillOval(x2 - RADIUS, y2 - RADIUS, 2 * RADIUS, 2 * RADIUS);
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
        int distance = (int)getDistance(x1, y1, x2, y2);
        g.drawString((new StringBuilder(String.valueOf(distance))).toString(), (x1 + x2) / 2, (y1 + y2) / 2);
    }

    public static double getDistance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
