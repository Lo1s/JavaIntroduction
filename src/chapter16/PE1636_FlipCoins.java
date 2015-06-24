/**
 * 
 */
package chapter16;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 19. 9. 2014 2014 10:44:49 
 */
@SuppressWarnings("serial")
public class PE1636_FlipCoins extends JFrame {

	/**
	 * @param args
	 */
	
	public PE1636_FlipCoins() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			add(new CoinLabel());
		}
	}

	class CoinLabel extends JLabel {
		Font font = new Font("TimesRoman", Font.BOLD, 20);
		private boolean isHeads = true;
		LineBorder lineBoarder = new LineBorder(Color.BLACK);

		public CoinLabel() {
			// TODO Auto-generated constructor stub
			setFont(font);
			setText("H");
			setHorizontalAlignment(JLabel.CENTER);
			setVerticalAlignment(JLabel.CENTER);
			setHorizontalTextPosition(JLabel.CENTER);
			setVerticalTextPosition(JLabel.CENTER);
			setBorder(lineBoarder);

			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (isHeads) {
						setText("T");
						isHeads = false;
					} else {
						setText("H");
						isHeads = true;
					}
				}
			});
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1636_FlipCoins();
		frame.setTitle("Exercise16_36");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
