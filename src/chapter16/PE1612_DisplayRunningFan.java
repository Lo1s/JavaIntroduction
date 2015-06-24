/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 10:24:58 
 */
@SuppressWarnings("serial")
public class PE1612_DisplayRunningFan extends JFrame {

	/**
	 * @param args
	 */
	private DrawArcs drawArcs = new DrawArcs();

	public PE1612_DisplayRunningFan() {
		// TODO Auto-generated constructor stub
		add(drawArcs);
		drawArcs.setFocusable(true);
	}

	class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	class DrawArcs extends JPanel {
		/**
		 * 
		 */
		int startingAngle = 0;
		Timer timer = new Timer(1000, new TimerListener());

		private static final long serialVersionUID = 1L;

		public DrawArcs() {
			// TODO Auto-generated constructor stub
			timer.start();
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int delay = timer.getDelay();
					if (e.getButton() == MouseEvent.BUTTON1)
						timer.setDelay(delay > 100 ? delay - 100 : 0);
					else if (e.getButton() == MouseEvent.BUTTON3)
						timer.setDelay(delay < Integer.MAX_VALUE ? delay + 100 : Integer.MAX_VALUE);
				}
			});
		}


		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;
			int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

			int x = xCenter - radius;
			int y = yCenter - radius;

			startingAngle += 5;

			g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle, 30);
			g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle + 90, 30);
			g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle + 180, 30);
			g.fillArc(x, y, 2 * radius, 2 * radius, startingAngle + 270, 30);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1612_DisplayRunningFan();
		frame.setTitle("Exercise16_12");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
