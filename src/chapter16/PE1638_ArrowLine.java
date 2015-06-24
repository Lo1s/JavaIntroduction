/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import chapter13.PE1328_DrawArrowLine;

/**
 * @author jslapnicka
 * @Date & @Time 19. 9. 2014 2014 12:41:53 
 */
@SuppressWarnings("serial")
public class PE1638_ArrowLine extends JFrame {

	/**
	 * @param args
	 */

	JButton jbtDraw = new JButton("Draw Arrow Line");
	private boolean isPressed = false;

	public PE1638_ArrowLine() {
		// TODO Auto-generated constructor stub
		add(new ArrowLine());
		add(jbtDraw, BorderLayout.SOUTH);

		jbtDraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isPressed = true;
				repaint();
			}
		});
	}

	public static void drawArrowLine(int x1, int y1, int x2, int y2, Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);


		// find slope of this line
		double slope = ((((double) y1) - (double) y2))
				/ (((double) x1) - (((double) x2)));

		double arctan = Math.atan(slope);

		// This will flip the arrow 45 off of a
		// perpendicular line at pt x2
		double set45 = 1.57 / 2;

		// arrows should always point towards i, not i+1
		if (x1 < x2) {
			// add 90 degrees to arrow lines
			set45 = -1.57 * 1.5;
		}

		// set length of arrows
		int arrlen = 15;

		// draw arrows on line
		g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan + set45) * arrlen))),
				(int) (((y2)) + (Math.sin(arctan + set45) * arrlen)));

		g.drawLine(x2, y2, (int) ((x2 + (Math.cos(arctan - set45) * arrlen))),
				(int) (((y2)) + (Math.sin(arctan - set45) * arrlen)));

	}

	class ArrowLine extends JPanel {

		public ArrowLine() {
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void paintComponent(Graphics g) {

			if (isPressed) {
				int x1 = (int)(Math.random() * (getWidth() - 12));
				int x2 = (int)(Math.random() * (getWidth() - 12));
				int y1 = (int)(Math.random() * (getHeight() - 12));
				int y2 = (int)(Math.random() * (getHeight() - 12));

				System.out.println(x1);
				PE1328_DrawArrowLine.drawArrowLine(x1, y1, x2, y2, g);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1638_ArrowLine();
		frame.setTitle("Exercise16_38");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
