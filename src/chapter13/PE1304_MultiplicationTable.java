/**
 * 
 */
package chapter13;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 1. 8. 2014 2014 8:53:48 
 */
public class PE1304_MultiplicationTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1304_MultiplicationTable() {
		add(new MultiplicationTable());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1304_MultiplicationTable frame = new PE1304_MultiplicationTable();
		frame.setTitle("Exercise13_4");
		frame.setSize(250, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class MultiplicationTable extends JPanel {

	String title = "Multiplication Table";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		Font title = new Font("TimesRoman", Font.BOLD, 18);
		Font headerNumbers = new Font("TimesRoman", Font.BOLD, 14);

		g.setFont(title);
		g.drawString("Multiplication Table", 50, 35);


		g.setFont(headerNumbers);
		for (int i = 0; i < 9; i++) {
			g.drawString((i + 1) + "", 50 + (i * 18), 58);
		}

		for (int i = 0; i < 9; i++) {
			g.drawString((i + 1) + "", 25, 75 + (i * 18));
		}

		g.drawRect(45, 60, 160, 160);

		int row = 75;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if ((i * j) <= 9) 
					g.drawString((i * j) + "", 50 + ((j - 1) * 18), row);
				else
					g.drawString((i * j) + "", 50 + (int)((j - 1.5) * 18), row);
			}
			row += 18;
		}
	}

}