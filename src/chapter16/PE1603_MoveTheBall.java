/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 9:09:58 
 */
@SuppressWarnings("serial")
public class PE1603_MoveTheBall extends JFrame {

	JButton jbtLeft = new JButton("Left");
	JButton jbtRight = new JButton("Right");
	JButton jbtUp = new JButton("Up");
	JButton jbtDown = new JButton("Down");
	PaintBall ball = new PaintBall();
	
	public PE1603_MoveTheBall() {
		// TODO Auto-generated constructor stub
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(jbtLeft);
		p1.add(jbtRight);
		p1.add(jbtUp);
		p1.add(jbtDown);
		
				
		ButtonListener listener = new ButtonListener();
		jbtLeft.addActionListener(listener);
		jbtRight.addActionListener(listener);
		jbtUp.addActionListener(listener);
		jbtDown.addActionListener(listener);
		
		add(p1, BorderLayout.SOUTH);
		add(ball, BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbtLeft) 
				ball.moveLeft();
			else if (e.getSource() == jbtRight)
				ball.moveRight();
			else if (e.getSource() == jbtUp)
				ball.moveUp();
			else if (e.getSource() == jbtDown)
				ball.moveDown();
							
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1603_MoveTheBall();
		frame.setTitle("Exercise16_03");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	class PaintBall extends JPanel {
		private int radius;
		private int xCoordinate;
		private int yCoordinate;
		
		public PaintBall() {
			// TODO Auto-generated constructor stub
			radius = 5;
			xCoordinate = 200 - radius;
			yCoordinate = 100 - radius;
		}
		
		// Move the ball left, right, up or down
		public void moveLeft() {
			if ((xCoordinate + radius + 10) <= getWidth()) {
				xCoordinate += 10;
				repaint();
			}
		}
		
		public void moveRight() {
			if ((xCoordinate - 10) >= 0) {
				xCoordinate -= 10;
				repaint();
			}
		}
		
		public void moveUp() {
			if ((yCoordinate - 10) >= 0) {
				yCoordinate -= 10;
				repaint();
			}
		}
		
		public void moveDown() {
			if ((yCoordinate + radius + 10) <= getHeight()) {
				yCoordinate += 10;
				repaint();
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawOval(xCoordinate, yCoordinate, 2 * radius, 2 * radius);
		}
	}
}
