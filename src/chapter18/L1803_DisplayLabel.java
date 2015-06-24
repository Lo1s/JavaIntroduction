package chapter18;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 10:05:22 
 */
@SuppressWarnings("serial")
public class L1803_DisplayLabel extends JApplet {

	public L1803_DisplayLabel() {
		// TODO Auto-generated constructor stub
		add(new JLabel("Great!", JLabel.CENTER));
	}
	
	// Creating main method for standalone app
	public static void maim(String[] args) {
		// Create a frame
		JFrame frame = new JFrame("Applet is in the frame");
		
		// Create an instance of the applet
		L1803_DisplayLabel applet = new L1803_DisplayLabel();
		// Add Applet to the frame
		frame.add(applet);
		
		// Display the frame
		frame.setTitle("Listing 18.3");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}