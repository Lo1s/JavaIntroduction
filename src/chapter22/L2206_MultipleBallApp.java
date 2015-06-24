/**
 * 
 */
package chapter22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 10. 12. 2014 2014 16:12:50 
 */
@SuppressWarnings("serial")
public class L2206_MultipleBallApp extends JApplet {

	public L2206_MultipleBallApp() {
		// TODO Auto-generated constructor stub
		add(new BallControl());
	}
	
	class BallControl extends JPanel {
		private BallPanel ballPanel = new BallPanel();
		private JButton jbtSuspend = new JButton("Suspend");
		private JButton jbtResume = new JButton("Resume");
		private JButton jbtAdd = new JButton("+1");
		private JButton jbtSubtract = new JButton("-1");
		private JScrollBar jsbDelay = new JScrollBar();
		
		public BallControl() {
			// TODO Auto-generated constructor stub
			JPanel panel = new JPanel();
			panel.add(jbtSuspend);
			panel.add(jbtResume);
			panel.add(jbtAdd);
			panel.add(jbtSubtract);
			
			// Add ball and buttons to thte panel
			ballPanel.setBorder(new javax.swing.border.LineBorder(Color.RED));
			jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
			ballPanel.setDelay(jsbDelay.getMaximum());
			setLayout(new BorderLayout());
			add(jsbDelay, BorderLayout.NORTH);
			add(ballPanel, BorderLayout.CENTER);
			add(panel, BorderLayout.SOUTH);
			
			// Register listeners
			jbtSuspend.addActionListener(new Listener());
			jbtResume.addActionListener(new Listener());
			jbtAdd.addActionListener(new Listener());
			jbtSubtract.addActionListener(new Listener());
			jsbDelay.addAdjustmentListener(new AdjustmentListener() {
				
				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					// TODO Auto-generated method stub
					ballPanel.setDelay(jsbDelay.getMaximum() - e.getValue());
				}
			});
		}
		
		class Listener implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbtSuspend)
					ballPanel.suspend();
				else if (e.getSource() == jbtResume)
					ballPanel.resume();
				else if (e.getSource() == jbtAdd)
					ballPanel.add();
				else if (e.getSource() == jbtSubtract)
					ballPanel.subtract();
			}
		}
		
		class BallPanel extends JPanel {
			private int delay = 10;
			private ArrayList<Ball> list = new ArrayList<Ball>();
			
			// Create a timer with the initial delay
			protected Timer timer = new Timer(delay, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					repaint();
				}
			});
			
			public BallPanel() {
				// TODO Auto-generated constructor stub
				timer.start();
			}
			
			public void add() {
				list.add(new Ball());
			}
			
			public void subtract() {
				if (list.size() > 0)
					list.remove(list.size() - 1); // Remove the last ball
			}
			
			@Override
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				for (int i = 0; i < list.size(); i++) {
					Ball ball = (Ball)list.get(i); // Get a ball
					g.setColor(ball.color);
					
					// Check boundaries
					if (ball.x < 0 || ball.x > getWidth())
						ball.dx = -ball.dx;
					if (ball.y < 0 || ball.y > getHeight())
						ball.dy = -ball.dy;
					
					// Adjust ball position
					ball.x += ball.dx;
					ball.y += ball.dy;
					g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
				}
			}
			
			public void suspend() {
				timer.stop();
			}
			
			public void resume() {
				timer.start();
			}
			
			public void setDelay(int delay) {
				this.delay = delay;
				timer.setDelay(delay);
			}
		}
		
		class Ball {
			int x = 0; 
			int y = 0; // Current ball position
			int dx = 2; // Increment on ball's x-coordinate
			int dy = 2; // Increment on ball's y-coordinate
			int radius = 5; // Ball radius
			Color color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		L2206_MultipleBallApp applet = new L2206_MultipleBallApp();
		frame.add(applet);
		frame.setTitle("Bouncing balls");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
