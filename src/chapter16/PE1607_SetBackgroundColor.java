/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 15:29:33 
 */
@SuppressWarnings("serial")
public class PE1607_SetBackgroundColor extends JFrame {

	JPanel panel = new JPanel();
	
	public PE1607_SetBackgroundColor() {
		// TODO Auto-generated constructor stub
		panel.setBackground(Color.RED);
		
		BackgroundListener listener = new BackgroundListener();
		addMouseListener(listener);
		add(panel);
	}
	
	class BackgroundListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(Color.black);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(Color.white);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1607_SetBackgroundColor();
		frame.setTitle("Exercise16_07");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
