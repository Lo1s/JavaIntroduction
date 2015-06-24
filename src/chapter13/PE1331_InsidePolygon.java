/**
 * 
 */
package chapter13;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 16. 8. 2014
 * 21:00:32
 */
public class PE1331_InsidePolygon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1331_InsidePolygon() {
		// TODO Auto-generated constructor stub
	}
	
	public PE1331_InsidePolygon(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
		add(new DrawPolygon(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = Integer.valueOf(args[0]);
		int y1 = Integer.valueOf(args[1]);
		int x2 = Integer.valueOf(args[2]);
		int y2 = Integer.valueOf(args[3]);
		int x3 = Integer.valueOf(args[4]);
		int y3 = Integer.valueOf(args[5]);
		int x4 = Integer.valueOf(args[6]);
		int y4 = Integer.valueOf(args[7]);
		int x5 = Integer.valueOf(args[8]);
		int y5 = Integer.valueOf(args[9]);
		
		JFrame frame = new PE1331_InsidePolygon(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);
		frame.setTitle("Exercise13_31");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class DrawPolygon extends JPanel {
	int x1;
	int x2;
	int x3;
	int x4;
	int x5;
	int y1;
	int y2;
	int y3;
	int y4;
	int y5;
	/**
	 * 
	 */
	public DrawPolygon() {
		// TODO Auto-generated constructor stub
	}
	
	public DrawPolygon(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.y5 = y5;
	}
	
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Polygon p = new Polygon();
		p.addPoint(x1, y1);
		p.addPoint(x2, y2);
		p.addPoint(x3, y3);
		p.addPoint(x4, y4);
		g.drawPolygon(p);
		
		g.drawOval(x5, y5, 5, 5);
		
		String message;
		if (p.contains(x5, y5))
			message = "The point is inside the polygon";
		else
			message = "The point is not inside the polygon";
		
		Font font = new Font("TimesRoman", Font.BOLD, 12);
		FontMetrics fm = getFontMetrics(font);
		setFont(font);
		g.drawString(message, getWidth() / 2 - (fm.stringWidth(message) / 2), getHeight() - 50);
	}
}