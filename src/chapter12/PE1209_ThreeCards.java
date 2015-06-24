/**
 * 
 */
package chapter12;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 25. 7. 2014 2014 9:02:10 
 */
public class PE1209_ThreeCards extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public PE1209_ThreeCards() {
		
		setLayout(new FlowLayout());
				
		int random = (int)(Math.random() * (55 - 1) + 1);
		JLabel jlbl1 = new JLabel(new ImageIcon("C://Java//site//image//card//" + random + ".png"));
		
		int nextRandom = (int)(Math.random() * (55 - 1) + 1);
		while (random == nextRandom) {
			nextRandom = (int)(Math.random() * (55 - 1) + 1);
		}
		JLabel jlbl2 = new JLabel(new ImageIcon("C://Java//site//image//card//" + nextRandom + ".png"));
		
		int nextRandom2 = (int)(Math.random() * (55 - 1) + 1);
		while (random == nextRandom2 || nextRandom == nextRandom2) {
			nextRandom2 = (int)(Math.random() * (55 - 1) + 1);
		}
		JLabel jlbl3 = new JLabel(new ImageIcon("C://Java//site//image//card//" + nextRandom2 + ".png"));
		
		add(jlbl1);
		add(jlbl2);
		add(jlbl3);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1209_ThreeCards();
		frame.setTitle("ThreeCards");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
