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
 * 19:32:31
 */
public class PE1328_DrawArrowLine extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1328_DrawArrowLine() {
		add(new DrawArrow());
	}

	public static void drawArrowLine(int x1, int y1, int x2, int y2, Graphics g) {
		g.setColor(Color.RED);
		
		g.drawLine(x1, y1, x2, y2);


		// find slope of this line
	    double slope = ((((double) y1) - (double) y2))
	      / (((double) x1) - (((double) x2)));

	    double arctan = Math.atan(slope);

	    // This will flip the arrow 45 off of a
	    // perpendicular line at pt x2
	    double set45 = 1.57 / 2;
	    
	    // arrows should always point towards i, not i+1
	    if (x1 < x2) {
	      // add 90 degrees to arrow lines
	      set45 = -1.57 * 1.5;
	    }

	    // set length of arrows
	    int arrlen = 15;

	    // draw arrows on line
	    g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan + set45) * arrlen))),
	        (int) (((y2)) + (Math.sin(arctan + set45) * arrlen)));

	    g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan - set45) * arrlen))),
	        (int) (((y2)) + (Math.sin(arctan - set45) * arrlen)));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1328_DrawArrowLine();
		frame.setTitle("Exercise13_28");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class DrawArrow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int x1 = (int)(Math.random() * (getWidth() - 12));
		int x2 = (int)(Math.random() * (getWidth() - 12));
		int y1 = (int)(Math.random() * (getHeight() - 12));
		int y2 = (int)(Math.random() * (getHeight() - 12));
		
		System.out.println(x1);
		PE1328_DrawArrowLine.drawArrowLine(x1, y1, x2, y2, g);

	}
}