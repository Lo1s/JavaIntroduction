/**
 * 
 */
package chapter18;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 14:44:24 
 */
@SuppressWarnings("serial")
public class L1809_BounceBallApp extends JApplet{

	L1808_BallControl ball = new L1808_BallControl();
	
	public L1809_BounceBallApp() {
		// TODO Auto-generated constructor stub
		add(ball);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		frame.add(new L1808_BallControl());
		
		frame.setTitle("BounceBallApp");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
