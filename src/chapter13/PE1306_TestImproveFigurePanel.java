/**
 * 
 */
package chapter13;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * @author hydRa
 *
 */
public class PE1306_TestImproveFigurePanel extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1306_TestImproveFigurePanel() {
		setLayout(new GridLayout(2, 2));
		add(new PE1306_ImproveFigurePanel(PE1306_ImproveFigurePanel.ARC));
		add(new PE1306_ImproveFigurePanel(PE1306_ImproveFigurePanel.POLYGON));
		add(new PE1306_ImproveFigurePanel(PE1306_ImproveFigurePanel.ARC, true));
		add(new PE1306_ImproveFigurePanel(PE1306_ImproveFigurePanel.POLYGON, true));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1306_TestImproveFigurePanel();
		frame.setTitle("Exercise13_06");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
