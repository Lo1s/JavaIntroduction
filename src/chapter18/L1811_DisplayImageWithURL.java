/**
 * 
 */
package chapter18;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 8:26:04 
 */
@SuppressWarnings("serial")
public class L1811_DisplayImageWithURL extends JApplet {

	public L1811_DisplayImageWithURL() {
		// TODO Auto-generated constructor stub
		java.net.URL url = this.getClass().getResource("image/us.gif");
		add(new JLabel(new ImageIcon(url)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		L1811_DisplayImageWithURL applet = new L1811_DisplayImageWithURL();
		
		frame.add(applet);
		frame.setTitle("DisplaImageWithURL");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
