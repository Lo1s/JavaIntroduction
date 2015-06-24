/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 13:28:35 
 */
@SuppressWarnings("serial")
public class PE1614_RaiseFlag extends JFrame {

	/**
	 * @param args
	 */

	public PE1614_RaiseFlag() {
		// TODO Auto-generated constructor stub
		add(new RaiseFlag());
	}

	class RaiseFlag extends JPanel {
		ImageIcon flagIcon = new ImageIcon("C:/Java/site/image/us.jpg");
		Image image = flagIcon.getImage();
		boolean firstTime = true;
		int y;

		public RaiseFlag() {
			// TODO Auto-generated constructor stub
			Timer timer = new Timer(1000, new ActionListener() {		
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					y -= 20;
					repaint();
				}
			});
			timer.start();
		}


		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (firstTime || y < -80) {
				y = getHeight() - 50;
				firstTime = false;
			}			
			g.drawImage(image, 20, y, 80, 50, this);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1614_RaiseFlag();
		frame.setTitle("Exercise16_14");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
