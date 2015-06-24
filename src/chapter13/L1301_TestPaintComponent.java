/**
 * 
 */
package chapter13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 29. 7. 2014 2014 7:51:29 
 */
public class L1301_TestPaintComponent extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1301_TestPaintComponent() {
		add(new NewPanel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1301_TestPaintComponent frame = new L1301_TestPaintComponent();
		frame.setTitle("TestPaintComponent");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class NewPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, 50, 50);
		g.drawString("Banner", 0, 40);
	}
}
