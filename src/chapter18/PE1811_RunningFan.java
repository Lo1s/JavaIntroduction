/**
 * 
 */
package chapter18;

import javax.swing.JApplet;
import javax.swing.JFrame;




/**
 * @author jslapnicka
 * @Date & @Time 13. 10. 2014 2014 13:07:02 
 */
@SuppressWarnings("serial")
public class PE1811_RunningFan extends JApplet {

	@Override
	public void init() {
		add(new PE1811_FanControl());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1811_FanControl applet = new PE1811_FanControl();
		JFrame frame = new JFrame();
		frame.add(applet);

		frame.setTitle("Exercise18_11");
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

