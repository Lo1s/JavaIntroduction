/**
 * 
 */
package chapter16;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 15. 9. 2014 2014 8:35:11 
 */
@SuppressWarnings("serial")
public class PE1617_MovingLabel extends JFrame {

	public PE1617_MovingLabel() {
		this.setLayout(new GridLayout(2, 1));
		add(new MovingMessagePanel("message 1 moving ?"));
		add(new MovingMessagePanel("message 2 moving ?"));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1617_MovingLabel();
		frame.setTitle("Listing 16.11");
		frame.setSize(280, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	static class MovingMessagePanel extends JPanel {
		private String message = "Welcome to Java !";
		private int xCoordinate = 0;
		private int yCoordinate = 20;
		private Timer timer = new Timer(1000, new TimerListener());
		
		public MovingMessagePanel(String message) {
			this.message = message;
			
			// Start the timer
			timer.start();
			
			// Control animation speed using mouse buttons
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int delay = timer.getDelay();
					if (e.getButton() == MouseEvent.BUTTON1)
						timer.setDelay(delay > 10 ? delay - 10 : 0);
					else if (e.getButton() == MouseEvent.BUTTON3)
						timer.setDelay(delay < 50000 ? delay + 10 : 50000);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					timer.stop();
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					timer.start();
				}
			});	
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			if (xCoordinate > getWidth()) {
				xCoordinate = -20;
			}
			xCoordinate += 5;
			g.drawString(message, xCoordinate, yCoordinate);
		}

		class TimerListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		}
	}
}
