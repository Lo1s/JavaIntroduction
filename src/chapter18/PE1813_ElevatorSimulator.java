/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 15. 10. 2014 2014 8:01:07 
 */
@SuppressWarnings("serial")
public class PE1813_ElevatorSimulator extends JApplet {

	Elevator elevator = new Elevator();
	ButtonPanel buttonPanel1 = new ButtonPanel();
	ButtonPanel buttonPanel2 = new ButtonPanel();
	JLabel jlblStatus = new JLabel("Status");

	public PE1813_ElevatorSimulator() {
		// TODO Auto-generated constructor stub
		// Register listeners to recognize the appropriate panel and start timer
		ButtonListener listener = new ButtonListener();
		buttonPanel1.jbtF1.addActionListener(listener);
		buttonPanel1.jbtF2.addActionListener(listener);
		buttonPanel1.jbtF3.addActionListener(listener);
		buttonPanel1.jbtF4.addActionListener(listener);
		buttonPanel1.jbtF5.addActionListener(listener);
		buttonPanel1.jbtF6.addActionListener(listener);
		buttonPanel1.jbtF7.addActionListener(listener);
		buttonPanel1.jbtF8.addActionListener(listener);
		buttonPanel2.jbtF1.addActionListener(listener);
		buttonPanel2.jbtF2.addActionListener(listener);
		buttonPanel2.jbtF3.addActionListener(listener);
		buttonPanel2.jbtF4.addActionListener(listener);
		buttonPanel2.jbtF5.addActionListener(listener);
		buttonPanel2.jbtF6.addActionListener(listener);
		buttonPanel2.jbtF7.addActionListener(listener);
		buttonPanel2.jbtF8.addActionListener(listener);
		
		add(jlblStatus, BorderLayout.NORTH);
		add(buttonPanel1, BorderLayout.WEST);
		add(elevator, BorderLayout.CENTER);
		add(buttonPanel2, BorderLayout.EAST);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/** Set floor */
			if (e.getSource() == buttonPanel1.jbtF1) {
				elevator.setFloor(1);
			} else if (e.getSource() == buttonPanel1.jbtF2) {
				elevator.setFloor(2);
			} else if (e.getSource() == buttonPanel1.jbtF3) {
				elevator.setFloor(3);
			} else if (e.getSource() == buttonPanel1.jbtF4) {
				elevator.setFloor(4);
			} else if (e.getSource() == buttonPanel1.jbtF5) {
				elevator.setFloor(5);
			} else if (e.getSource() == buttonPanel1.jbtF6) {
				elevator.setFloor(6);
			} else if (e.getSource() == buttonPanel1.jbtF7) {
				elevator.setFloor(7);
			} else if (e.getSource() == buttonPanel1.jbtF8) {
				elevator.setFloor(8);
			} else if (e.getSource() == buttonPanel2.jbtF1) {
				elevator.setFloor(1);
			} else if (e.getSource() == buttonPanel2.jbtF2) {
				elevator.setFloor(2);
			} else if (e.getSource() == buttonPanel2.jbtF3) {
				elevator.setFloor(3);
			} else if (e.getSource() == buttonPanel2.jbtF4) {
				elevator.setFloor(4);
			} else if (e.getSource() == buttonPanel2.jbtF5) {
				elevator.setFloor(5);
			} else if (e.getSource() == buttonPanel2.jbtF6) {
				elevator.setFloor(6);
			} else if (e.getSource() == buttonPanel2.jbtF7) {
				elevator.setFloor(7);
			} else if (e.getSource() == buttonPanel2.jbtF8) {
				elevator.setFloor(8);
			}
			
			/** Recognize if the elevator is getting or sending and sets the timer */
			if (e.getSource() == buttonPanel1.jbtF1 || e.getSource() == buttonPanel1.jbtF2
					|| e.getSource() == buttonPanel1.jbtF3 || e.getSource() == buttonPanel1.jbtF4
					|| e.getSource() == buttonPanel1.jbtF5 || e.getSource() == buttonPanel1.jbtF6
					|| e.getSource() == buttonPanel1.jbtF7 || e.getSource() == buttonPanel1.jbtF8) {
				elevator.isGetting = true;
				jlblStatus.setForeground(Color.BLACK);
				jlblStatus.setText("Getting passengers !");
				elevator.timer.start();
				System.out.println("Timer has been started !");
			} else if (e.getSource() == buttonPanel2.jbtF1 || e.getSource() == buttonPanel2.jbtF2
					|| e.getSource() == buttonPanel2.jbtF3 || e.getSource() == buttonPanel2.jbtF4
					|| e.getSource() == buttonPanel2.jbtF5 || e.getSource() == buttonPanel2.jbtF6
					|| e.getSource() == buttonPanel2.jbtF7 || e.getSource() == buttonPanel2.jbtF8) {
				elevator.isGetting = false;
				jlblStatus.setForeground(Color.RED);
				jlblStatus.setText("Sending passengers !");
				elevator.timer.start();
				System.out.println("Timer has been started !");
			}
		}
	}

	class ButtonPanel extends JPanel {

		JButton jbtF1 = new JButton("F1");
		JButton jbtF2 = new JButton("F2");
		JButton jbtF3 = new JButton("F3");
		JButton jbtF4 = new JButton("F4");
		JButton jbtF5 = new JButton("F5");
		JButton jbtF6 = new JButton("F6");
		JButton jbtF7 = new JButton("F7");
		JButton jbtF8 = new JButton("F8");

		public ButtonPanel() {
			// TODO Auto-generated constructor stub

			setLayout(new GridLayout(8, 1));
			add(jbtF8);
			add(jbtF7);
			add(jbtF6);
			add(jbtF5);
			add(jbtF4);
			add(jbtF3);
			add(jbtF2);
			add(jbtF1);
		}
	}

	class Elevator extends JPanel {
		private boolean isGetting;
		private int floor = 1;
		private int nextFloor = 1;
		private int floorSize;
		private int floorCoordination;
		private int move;
		private boolean firstTime = true;
		private Timer timer;

		public Elevator() {
			// TODO Auto-generated constructor stub
			setBackground(Color.BLACK);

			// Register listener for a timer
			timer = new Timer(200, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					floorCoordination = (getHeight() - (floorSize * nextFloor));
					// Up
					if (floor < nextFloor && move > floorCoordination)
						move -= 2;
					// Down
					else if (floor > nextFloor && move < floorCoordination)
						move += 2;
					else {
						System.out.println("Timer has been stopped !");
						timer.stop();
					}
					System.out.println("move: " + move + "\nfloorCoordination: " + floorCoordination
							+ "\nfloor: " + floor + "\nnextFloor: " + nextFloor);
					repaint();
				}
			});
		}

		public void isGetting(boolean isGetting) {
			this.isGetting = isGetting;
		}

		public void setFloor(int nextFloor) {
			floor = this.nextFloor;
			this.nextFloor = nextFloor;
		}

		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);			
			
			int xCenter = getWidth() / 2;
			floorSize = getHeight() / 8;
			

			if (firstTime) {
				move = getHeight() - floorSize;
				firstTime = false;
			}
			
			// Select color
			if (isGetting)
				g.setColor(Color.GREEN);
			else
				g.setColor(Color.RED);

			// Draw floors
			for (int i = 0; i < getHeight(); i = i + floorSize)
				g.drawLine(0, i, getWidth(), i);

			// Draw elevator
			g.setColor(Color.GRAY);
			g.fillRect(xCenter - floorSize / 2, move, floorSize, floorSize);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1813_ElevatorSimulator applet = new PE1813_ElevatorSimulator();
		JFrame frame = new JFrame();
		frame.add(applet);

		frame.setTitle("Exercise18_13");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
