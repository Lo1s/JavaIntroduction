/**
 * 
 */
package chapter13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 9:58:38 
 */
public class L1304_DrawArcs extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public L1304_DrawArcs() {
		setTitle("DrawArcs");
		add(new ArcsPanel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1304_DrawArcs frame = new L1304_DrawArcs();
		frame.setTitle("DrawArcs");
		frame.setSize(250, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class ArcsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
		
		int x = xCenter - radius;
		int y = yCenter - radius;
		
		g.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
	}
}
