/**
 * 
 */
package chapter12;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 12:45:16 
 */
public class PE1211_FourCards extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public PE1211_FourCards() {
		setLayout(new FlowLayout());
		
		int random1 = (int)(Math.random() * (55 - 1) + 1);
		int random2 = (int)(Math.random() * (55 - 1) + 1);
		int random3 = (int)(Math.random() * (55 - 1) + 1);
		int random4 = (int)(Math.random() * (55 - 1) + 1);
		while (random1 == random2) {
			random2 = (int)(Math.random() * (55 - 1) + 1);
		}
		while (random1 == random3 || random2 == random3) {
			random3 = (int)(Math.random() * (55 - 1) + 1);
		}
		while (random1 == random4 || random2 == random4 || random3 == random4) {
			random4 = (int)(Math.random() * (55 - 1) + 1);
		}
		
		ImageIcon card1 = new ImageIcon("C://Java//site//image//card//" + random1 + ".png");
		ImageIcon card2 = new ImageIcon("C://Java//site//image//card//" + random2 + ".png");
		ImageIcon card3 = new ImageIcon("C://Java//site//image//card//" + random3 + ".png");
		ImageIcon card4 = new ImageIcon("C://Java//site//image//card//" + random4 + ".png");
		ImageIcon backCard = new ImageIcon("C://Java//site//image//card//b2fv.png");
		
		JButton first = new JButton(backCard);
		first.setPressedIcon(card1);
		
		JButton second = new JButton(backCard);
		second.setPressedIcon(card2);
		
		JButton third = new JButton(backCard);
		third.setPressedIcon(card3);
		
		JButton fourth = new JButton(backCard);
		fourth.setPressedIcon(card4);
		
		add(first);
		add(second);
		add(third);
		add(fourth);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1211_FourCards();
		frame.setTitle("FourCards");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
