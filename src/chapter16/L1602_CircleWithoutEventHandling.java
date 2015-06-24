/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 9. 9. 2014 2014 12:12:22 
 */
@SuppressWarnings("serial")
public class L1602_CircleWithoutEventHandling extends JFrame {

	private JButton jbtEnglarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();
	
	public L1602_CircleWithoutEventHandling() {
		JPanel panel = new JPanel();
		panel.add(jbtEnglarge);
		panel.add(jbtShrink);
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1602_CircleWithoutEventHandling();
		frame.setTitle("Listing 16.2");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

@SuppressWarnings("serial")
class CirclePanel extends JPanel {
	
	private int radius = 5;
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
	}
}