/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 9. 9. 2014 2014 12:19:55 
 */
@SuppressWarnings("serial")
public class L1603_ControlCircle extends JFrame {

	private JButton jbtEnglarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private ControlCirclePanel canvas = new ControlCirclePanel();

	public L1603_ControlCircle() {
		JPanel panel = new JPanel();
		panel.add(jbtEnglarge);
		panel.add(jbtShrink);

		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		
		EnlargeListener listener1 = new EnlargeListener();
		jbtEnglarge.addActionListener(listener1);
		ShrinkListener listener2 = new ShrinkListener();
		jbtShrink.addActionListener(listener2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1603_ControlCircle();
		frame.setTitle("Listing 16.2");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	class ControlCirclePanel extends JPanel { // Inner class

		private int radius = 5;

		public void enlarge() {
			radius++;
			repaint();
		}
		
		public void shrink() {
			if (radius >= 5) {
				radius--;
				repaint();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
		}
	}

	class EnlargeListener implements ActionListener { // Inner class

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.enlarge();
		}
	}
	
	class ShrinkListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.shrink();
		}
	}
}