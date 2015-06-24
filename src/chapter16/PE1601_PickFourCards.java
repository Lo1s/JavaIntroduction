/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 10. 9. 2014 2014 16:26:56 
 */
@SuppressWarnings("serial")
public class PE1601_PickFourCards extends JFrame {

	JButton jbtRefresh = new JButton("Refresh");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel(new GridLayout(1, 4));

	public PE1601_PickFourCards() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		p1.add(jbtRefresh, BorderLayout.SOUTH);
		p2.add(new JLabel(new ImageIcon("C:/Java/site/image/card/" + 1  + ".png")));
		p2.add(new JLabel(new ImageIcon("C:/Java/site/image/card/" + 2  + ".png")));
		p2.add(new JLabel(new ImageIcon("C:/Java/site/image/card/" + 3  + ".png")));
		p2.add(new JLabel(new ImageIcon("C:/Java/site/image/card/" + 4  + ".png")));
		
		jbtRefresh.addActionListener(new refreshListener());
		add(p1, BorderLayout.SOUTH);
		add(p2, BorderLayout.CENTER);
	}
	
	class refreshListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String[] cards = pickCards();
			p2.removeAll();
			for (int i = 0; i < cards.length; i++) {
				p2.add(new JLabel(new ImageIcon(cards[i])));
			}
			p2.revalidate();
		}
	}

	// Generate random cards as string
	public String[] pickCards() {
		String[] cards = new String[4];
		int[] deck = new int[52];

		// Initialize the deck
		for (int i = 0; i < 52; i++) {
			deck[i] = i + 1;
		}
		// Shuffle the deck
		int temp = 0;
		for (int i = 0; i < deck.length; i++) {
			int random = hdR.mtd.getRandomNumber(0, 51);
			temp = deck[i];
			deck[i] = deck[random];
			deck[random] = temp;
		}
		// Pick 4 cards
		for (int i = 0; i < cards.length; i++) {
			cards[i] = "C:/Java/site/image/card/" + (deck[i] + 1)  + ".png";
		}
		return cards;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1601_PickFourCards();
		frame.setTitle("Exercise16_01");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
