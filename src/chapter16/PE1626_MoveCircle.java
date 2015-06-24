/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 16. 9. 2014 2014 16:19:06 
 */
@SuppressWarnings("serial")
public class PE1626_MoveCircle extends JFrame {

	/**
	 * @param args
	 */
	
	public PE1626_MoveCircle() {
		// TODO Auto-generated constructor stub
		add(new MoveCircle());
	}
	
	class MoveCircle extends JPanel {
		int x = 120;
		int y = 120;
		int radius = 10;
		
		public MoveCircle() {
			// TODO Auto-generated constructor stub
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1626_MoveCircle();
		frame.setTitle("Exercise16_26");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
