package chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 17. 9. 2014 2014 8:54:30 
 */
@SuppressWarnings("serial")
public class PE1629_SelfAvoidingWalkAnimation extends JFrame {

	Timer timer;
	DrawWalk drawWalk = new DrawWalk();
	private boolean firstTime = true;
	private boolean checkmate = false;
	int pathLength;

	public PE1629_SelfAvoidingWalkAnimation() {
		// TODO Auto-generated constructor stub
		timer = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				drawWalk.getPath();
				pathLength++;
				if (!checkmate)
					repaint();
			}
		});
		
		add(drawWalk, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JButton jbtStart = new JButton("Start");
		panel.add(jbtStart);
		add(panel, BorderLayout.SOUTH);


		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstTime = true;
				checkmate = false;
				timer.start();
			}
		});
	}

	class DrawWalk extends JPanel {
		private final int NUMBER_OF_LINES = 16;
		private int xWalk;
		private int yWalk;
		private int x2;
		private int y2;
		private final int UP = 1;
		private final int DOWN = 2;
		private final int LEFT = 3;
		private final int RIGHT = 4;
		private int[][] lattice = new int[NUMBER_OF_LINES][NUMBER_OF_LINES];
		private int row;
		private int column;
		ArrayList<Point> points = new ArrayList<Point>();

		public DrawWalk() {
			// TODO Auto-generated constructor stub
			
		}

		public void getPath() {
			// Initial point
			if (firstTime) {
				row = 8;
				column = 8;
				lattice[row][column] = 1;
				firstTime = false;
			} else {
				int random = hdR.mtd.getRandomNumber(4, 1);
				switch (move(random)) {
				case UP: row--; lattice[row][column] = 1; System.out.println("Row: " + row + "\nColumn: " + column); break;
				case DOWN: row++; lattice[row][column] = 1; System.out.println("Row: " + row + "\nColumn: " + column); break;
				case LEFT: column--; lattice[row][column] = 1; System.out.println("Row: " + row + "\nColumn: " + column); break;
				case RIGHT: column++; lattice[row][column] = 1; System.out.println("Row: " + row + "\nColumn: " + column); break;
				case 0: checkmate = true; break;
				}
			}
			x2 = column;
			y2 = row;
			points.add(new Point(x2, y2));
			System.out.println(points.size());
			for (int i = 0; i < lattice.length; i++) {
				for (int j = 0; j < lattice[i].length; j++) {
					System.out.print(lattice[i][j] + " ");
				}
				System.out.println();
			}

			if (checkmate) {
				timer.stop();
				// Refresh lattice
				points.clear();
				// Refresh lattice
				for (int i = 0; i < lattice.length; i++)
					for (int j = 0; j < lattice.length; j++)
						lattice[i][j] = 0;
			}
		}

		public int move(int random) {
			// Check if still in scope of the array
			switch (random) {
			// UP
			case 1: if ((row - 1) >= 0 && lattice[row - 1][column] == 0) // Check if not used before
				return 1; break;
				// DOWN
			case 2: if ((row + 1) < lattice[row].length && lattice[row + 1][column] == 0)
				return 2; break;
				// LEFT
			case 3: if ((column - 1) >= 0 && lattice[row][column - 1] == 0)
				return 3; break;
				// RIGHT
			case 4: if ((column + 1) < lattice.length && lattice[row][column + 1] == 0)
				return 4; break;
			}
			return 0;

		}
		@Override
		protected void paintComponent(Graphics g) {

			xWalk = getWidth() / NUMBER_OF_LINES;
			yWalk = getHeight() / NUMBER_OF_LINES;


			// Draw lattice
			/** Horizontal lines */
			g.setColor(Color.LIGHT_GRAY);
			for (int y = 0; y <= NUMBER_OF_LINES * (getHeight() / NUMBER_OF_LINES); y += getHeight() / NUMBER_OF_LINES) {
				g.drawLine(0, y, getWidth(), y);
			}
			/** Vertical lines */
			for (int x = 0; x < NUMBER_OF_LINES * (getWidth() / NUMBER_OF_LINES); x += getWidth() / NUMBER_OF_LINES) {
				g.drawLine(x, 0, x, getHeight());
			}

			// Draw walk
			g.setColor(Color.BLACK);
			for (int i = 0; i < points.size(); i++) {
				g.setColor(Color.BLACK);
				if (i + 1 < points.size())
					g.drawLine((int)points.get(i).getX() * xWalk, (int)points.get(i).getY() * yWalk, 
							(int)points.get(i + 1).getX() * xWalk, (int)points.get(i + 1).getY() * yWalk);
			}
				

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1629_SelfAvoidingWalkAnimation();
		frame.setTitle("Exercise16_29");
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
