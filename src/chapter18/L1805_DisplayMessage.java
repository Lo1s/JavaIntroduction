/**
 * 
 */
package chapter18;

import javax.swing.JApplet;

import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 6. 10. 2014 2014 11:09:00 
 */
@SuppressWarnings("serial")
public class L1805_DisplayMessage extends JApplet {

	@Override
	public void init() {
		// Get parameter values from the HTML file
		String message = getParameter("MESSAGE");
		int x = Integer.parseInt(getParameter("X"));
		int y = Integer.parseInt(getParameter("Y"));
		
		// Create a message panel
		L1308_MessagePanel messagePanel = new L1308_MessagePanel(message);
		messagePanel.setXCoordinate(x);
		messagePanel.setYCoordinate(y);
		
		// Add message panel to the applet
		add(messagePanel);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
