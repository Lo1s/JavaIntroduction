/**
 * 
 */
package chapter13;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter10.PE1013_MyRectangle2D;

/**
 * @author jslapnicka
 * @Date & @Time 18. 8. 2014 2014 10:14:11 
 */
public class PE1332_TwoRectangles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1332_TwoRectangles() {
		// TODO Auto-generated constructor stub
	}
	
	public PE1332_TwoRectangles(int xCenter, int yCenter, int width, int height, int xCenter2, int yCenter2, int width2, int height2) {
		add(new TwoRectangles(xCenter, yCenter, width, height, xCenter2, yCenter2, width2, height2));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int xCenter = Integer.valueOf(args[0]);
		int yCenter = Integer.valueOf(args[1]);
		int width = Integer.valueOf(args[2]);
		int height = Integer.valueOf(args[3]);
		
		int xCenter2 = Integer.valueOf(args[4]);
		int yCenter2 = Integer.valueOf(args[5]);
		int width2 = Integer.valueOf(args[6]);
		int height2 = Integer.valueOf(args[7]);
		
		JFrame frame = new PE1332_TwoRectangles(xCenter, yCenter, width, height, xCenter2, yCenter2, width2, height2);
		frame.setTitle("Exercise13_32");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class TwoRectangles extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int xCenter;
	int yCenter;
	int width;
	int height;
	
	int xCenter2;
	int yCenter2;
	int width2;
	int height2;
	
	public TwoRectangles() {
		// TODO Auto-generated constructor stub
	}
	
	public TwoRectangles(int xCenter, int yCenter, int width, int height, int xCenter2, int yCenter2, int width2, int height2) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.width = width;
		this.height = height;
		
		this.xCenter2 = xCenter2;
		this.yCenter2 = yCenter2;
		this.width2 = width2;
		this.height2 = height2;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
				
		g.drawRect(xCenter, yCenter, width, height);
		g.drawRect(xCenter2, yCenter2, width2, height2);
		
		Font font = new Font("TimesRoman", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(font);
		
		PE1013_MyRectangle2D rect1 = new PE1013_MyRectangle2D(xCenter, yCenter, width, height);
		PE1013_MyRectangle2D rect2 = new PE1013_MyRectangle2D(xCenter2, yCenter2, width2, height2);
				
		String message1 = "One rectangle is contained in another";
		String message2 = "The rectangles overlap";
		String message3 = "The rectangles do not overlap";
		
		int center = getWidth() / 2;
		
		if (rect1.contains(rect2))
			g.drawString(message1, center - fm.stringWidth(message1) / 2, getHeight() - 20);
		else if (!rect1.contains(rect2) && !rect1.overlaps(rect2))
			g.drawString(message3, center - fm.stringWidth(message3) / 2, getHeight() - 20);
		else if (rect1.overlaps(rect2))
			g.drawString(message2, center - fm.stringWidth(message2) / 2, getHeight() - 20);
	}
} 
