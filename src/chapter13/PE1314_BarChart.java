/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 5. 8. 2014
 * 17:01:25
 */
public class PE1314_BarChart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1314_BarChart() {
		setLayout(new GridLayout(1, 4));
		add(new BarChart());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1314_BarChart();
		frame.setTitle("Exercise13_14");
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class BarChart extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawString("Project -- 20%", 10, 90);
		g.setColor(Color.RED);
		g.fillRect(10, 100, 100, 50);
		
		g.setColor(Color.BLACK);
		g.drawString("Quizzes -- 10%", 120, 115);
		g.setColor(Color.BLUE);
		g.fillRect(120, 125, 100, 25);
		
		g.setColor(Color.BLACK);
		g.drawString("Midterms -- 30%", 230, 65);
		g.setColor(Color.GREEN);
		g.fillRect(230, 75, 100, 75);
		
		g.setColor(Color.BLACK);
		g.drawString("Final -- 40%", 340, 40);
		g.setColor(Color.ORANGE);
		g.fillRect(340, 50, 100, 100);
		
		g.setColor(Color.BLACK);
		g.drawLine(5, 150, 445, 150);
	}
}