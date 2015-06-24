/**
 * 
 */
package chapter13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 31. 7. 2014 2014 10:28:14 
 */
public class PE1301_Grid3x3 extends JFrame {

	private static final long serialVersionUID = 1L;


	public PE1301_Grid3x3() {
		// TODO Auto-generated constructor stub
		add(new grid3x3());
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1301_Grid3x3();
		frame.setTitle("Grid3x3");
		frame.setSize(300, 300);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class grid3x3 extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.red);
		g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
		g.drawLine((getWidth() / 3) * 2, 0, (getWidth() / 3) * 2, getHeight());
		
		g.setColor(Color.blue);
		g.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3);
		g.drawLine(0, (getHeight() / 3) * 2, getWidth(), (getHeight() / 3) * 2);
		
	}
}