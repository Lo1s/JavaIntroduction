/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author jslapnicka
 * @Date & @Time 10. 9. 2014 2014 12:42:59 
 */
@SuppressWarnings("serial")
public class L1610_ControlCircleWithMouseAndKey extends JFrame {

	private JButton jbtEnlarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();
	
	public L1610_ControlCircleWithMouseAndKey() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		
		jbtEnlarge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.enlarge();
				canvas.requestFocusInWindow();
			}
		});
		
		jbtShrink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.shrink();
				canvas.requestFocusInWindow();
			}
		});
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1)
					canvas.enlarge();
				else if (e.getButton() == MouseEvent.BUTTON3)
					canvas.shrink();
			}
		});
		
		canvas.setFocusable(true);
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					canvas.enlarge();
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					canvas.shrink();
			}	
		});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1610_ControlCircleWithMouseAndKey();
		frame.setTitle("Listing16.10");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	class CirclePanel extends JPanel {
		
		private int radius = 5;
		
		public void enlarge() {
			radius++;
			repaint();
		}
		
		public void shrink() {
			if (radius > 5) {
				radius--;
				repaint();
			}
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
		}
	}
}

