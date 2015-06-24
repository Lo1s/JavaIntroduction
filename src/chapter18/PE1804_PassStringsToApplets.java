/**
 * 
 */
package chapter18;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JApplet;

import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 14:49:17 
 */
@SuppressWarnings("serial")
public class PE1804_PassStringsToApplets extends JApplet {

	public PE1804_PassStringsToApplets() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		String message = getParameter("MESSAGE");
		int x = Integer.parseInt(getParameter("X"));
		int y = Integer.parseInt(getParameter("Y"));
		String color = getParameter("COLOR");
		String fontName = getParameter("FONTNAME");
		int fontSize = Integer.parseInt(getParameter("FONTSIZE"));
		
		L1308_MessagePanel messagePanel = new L1308_MessagePanel(message);
		messagePanel.setXCoordinate(x);
		messagePanel.setYCoordinate(y);
		
		if (color.equals("red"))
			messagePanel.setForeground(Color.RED);
		else if (color.equals("yellow"))
			messagePanel.setForeground(Color.YELLOW);
		else if (color.equals("green"))
			messagePanel.setForeground(Color.GREEN);
		else if (color.equals("blue"))
			messagePanel.setForeground(Color.BLUE);
		
		Font font = new Font(fontName, Font.PLAIN, fontSize);
		messagePanel.setFont(font);
		
		add(messagePanel);
	}
	
}
