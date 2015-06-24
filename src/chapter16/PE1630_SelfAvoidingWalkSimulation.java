package chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
public class PE1630_SelfAvoidingWalkSimulation extends JFrame {

	JButton jbtStart = new JButton("Start");
	Timer timer;
	DrawWalk drawWalk = new DrawWalk();
	private boolean firstTime = true;
	private boolean checkmate = false;
	private int number_of_lines = 10;
	private int[][] lattice;
	private int dead_end = 0;

	public PE1630_SelfAvoidingWalkSimulation() {
		// TODO Auto-generated constructor stub
		add(drawWalk, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.add(jbtStart);
		add(panel, BorderLayout.SOUTH);

		for (; number_of_lines <= 80; number_of_lines++) {
			lattice = new int[number_of_lines][number_of_lines];
			for (int j = 0; j < 10000; j++) {
				firstTime = true;
				checkmate = false;
				drawWalk.getPath();
			}
			System.out.println("For a lattice of size " + number_of_lines + ", the probability of dead-end paths is " + (double)(dead_end / 10000.0) * 100.0 + "%");
			System.out.println(dead_end);
			dead_end = 0;
		}
	}

	class DrawWalk extends JPanel {

		private int xWalk;
		private int yWalk;
		private int x2;
		private int y2;
		private final int UP = 1;
		private final int DOWN = 2;
		private final int LEFT = 3;
		private final int RIGHT = 4;
	
		private int row;
		private int column;
		ArrayList<Point> points = new ArrayList<Point>();

		public DrawWalk() {
			// TODO Auto-generated constructor stub
		}

		public void getPath() {
			// Refresh lattice
			points.clear();
			// Refresh lattice
			for (int i = 0; i < lattice.length; i++)
				for (int j = 0; j < lattice.length; j++)
					lattice[i][j] = 0;

			while (!checkmate) {
				// Initial point
				if (firstTime) {
					row = number_of_lines / 2;
					column = number_of_lines / 2;
					lattice[row][column] = 1;
					firstTime = false;
				} else {
					int random = hdR.mtd.getRandomNumber(4, 1);
					switch (move(random)) {
					case UP: row--; lattice[row][column] = 1; break;
					case DOWN: row++; lattice[row][column] = 1; break;
					case LEFT: column--; lattice[row][column] = 1; break;
					case RIGHT: column++; lattice[row][column] = 1; break;
					case 0: checkmate = true; break;
					}
				}
				x2 = column;
				y2 = row;
				points.add(new Point(x2, y2));
				if (checkmate && row != 0 && column != 0)
					dead_end++;
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

			super.paintComponent(g);

			xWalk = getWidth() / number_of_lines;
			yWalk = getHeight() / number_of_lines;


			// Draw lattice
			/** Horizontal lines */
			g.setColor(Color.LIGHT_GRAY);
			for (int y = 0; y <= number_of_lines * (getHeight() / number_of_lines); y += getHeight() / number_of_lines) {
				g.drawLine(0, y, getWidth(), y);
			}
			/** Vertical lines */
			for (int x = 0; x < number_of_lines * (getWidth() / number_of_lines); x += getWidth() / number_of_lines) {
				g.drawLine(x, 0, x, getHeight());
			}

			// Draw the walk
			if (checkmate) {
				for (int i = 0; i < points.size(); i++) {
					g.setColor(Color.BLACK);
					if (i + 1 < points.size())
						g.drawLine((int)points.get(i).getX() * xWalk, (int)points.get(i).getY() * yWalk, 
								(int)points.get(i + 1).getX() * xWalk, (int)points.get(i + 1).getY() * yWalk);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PE1630_SelfAvoidingWalkSimulation();
	}

}
