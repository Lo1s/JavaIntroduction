/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 12. 9. 2014 2014 12:37:18 
 */
@SuppressWarnings("serial")
public class PE1613_SlideShow extends JFrame {

	/**
	 * @param args
	 */
	
	ImageIcon imageIcon = new ImageIcon("C:/Java/site/image/card/1.png");
	JLabel jlbl = new JLabel();
	
	public PE1613_SlideShow() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		jlbl.setIcon(imageIcon);
		add(jlbl, BorderLayout.CENTER);
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
	}
	
	class TimerListener implements ActionListener {
		int card = 1;
		@Override
		public void actionPerformed(ActionEvent e) {
			card++;
			imageIcon = new ImageIcon("C:/Java/site/image/card/" + card + ".png");
			jlbl.setIcon(imageIcon);
			
			if (card == 54)
				card = 0;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1613_SlideShow();
		frame.setTitle("Exercise16_13");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
