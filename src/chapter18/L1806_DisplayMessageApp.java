/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JApplet;
import javax.swing.JFrame;

import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 13:02:29 
 */
@SuppressWarnings("serial")
public class L1806_DisplayMessageApp extends JApplet {

	private String message = "A default message";
	private int x = 20;
	private int y = 20;
	
	/** Determinine whether it is an application */
	private boolean isStandalone = false;
	
	@Override
	public void init() {
		if (!isStandalone) {
			message = getParameter("MESSAGE");
			x = Integer.parseInt(getParameter("X"));
			y = Integer.parseInt(getParameter("Y"));
		}
		
		// Create a message panel
		L1308_MessagePanel messagePanel = new L1308_MessagePanel(message);
		messagePanel.setFont(new Font("SansSerif", Font.BOLD, 20));
		messagePanel.setXCoordinate(x);
		messagePanel.setYCoordinate(y);
		
		// Add message panel to the applet
		add(messagePanel);
	}
	
	/** Main method to display a message
	 * @param args[0] = x-coordinate
	 * @param args[1] = y-coordinate
	 * @param args[2] = message
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a frame
		JFrame frame = new JFrame("DisplayMessageApp");
		
		// Create an instance of the applet
		L1806_DisplayMessageApp applet = new L1806_DisplayMessageApp();
		
		// It runs as an application
		applet.isStandalone = true;
		// Get parameters from the command line 
		applet.getCommandLineParameters(args);
		
		// Add the applet instance to the frame
		frame.add(applet, BorderLayout.CENTER);
		
		// invoke applet's init method
		applet.init();
		applet.start();
		
		// Display the frame
		frame.setTitle("Listing 18.6");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	/** Get command-line parameters */
	public void getCommandLineParameters(String[] args) {
		// Check usage and get x, y and message
		if (args.length != 3) {
			System.out.println("Usage: java L1806_DisplayMessageApp x y message");
			System.exit(1);
		} else {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			message = args[2];
		}
	}

}
