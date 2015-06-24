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
 * 5. 8. 2014
 * 18:40:42
 */
public class PE1315_PieChart extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1315_PieChart() {
		add(new PieChart());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1315_PieChart();
		frame.setTitle("Exercise13_15");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class PieChart extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		
		int radius = (int)(Math.min(getWidth(), getHeight() * 0.4));
		
		g.setColor(Color.RED);
		g.fillArc(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius, 0, (int)(3.6 * 20));
		g.setColor(Color.BLACK);
		g.drawString("Projects -- 20%", (int)((double)xCenter + (double)radius * Math.cos(0.62831853071795862D)), (int)((double)yCenter - (double)radius * Math.sin(0.62831853071795862D)));    
				
		g.setColor(Color.BLUE);
		g.fillArc(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius, (int)(3.6 * 20), (int)(3.6 * 10));
		g.setColor(Color.BLACK);
		g.drawString("Quizzes -- 10%", (int)((double)xCenter + (double)radius * Math.cos(1.5707963267948966D)), (int)((double)yCenter - (double)radius * Math.sin(1.5707963267948966D)));
				
		g.setColor(Color.GREEN);
		g.fillArc(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius, (int)(3.6 * 30), (int)(3.6 * 30));
		g.setColor(Color.BLACK);
		g.drawString("Midterms -- 30%", (int)((double)xCenter + (double)radius * Math.cos(2.8274333882308138D)) - 40, (int)((double)yCenter - (double)radius * Math.sin(2.8274333882308138D)));
				
		g.setColor(Color.ORANGE);
		g.fillArc(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius, (int)(3.6 * 60), (int)(3.6 * 40));
		g.setColor(Color.BLACK);
		g.drawString("Final -- 40%", (int)((double)xCenter + (double)radius * Math.cos(5.026548245743669D)), (int)((double)yCenter - (double)radius * Math.sin(5.026548245743669D)));
		
	}
}
