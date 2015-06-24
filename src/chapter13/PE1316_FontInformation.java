/**
 * 
 */
package chapter13;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author hydRa
 * 5. 8. 2014
 * 20:27:13
 */
public class PE1316_FontInformation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1316_FontInformation() {
		add(new FontInformation());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1316_FontInformation();
		frame.setTitle("Exercise13_16");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class FontInformation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font font = new Font("TimesRoman", Font.BOLD, 20);
	FontMetrics fm = getFontMetrics(font);
	
	
	
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		g.setFont(font);
		g.drawString("Java is Fun !", 50, getHeight() / 2);
		
		String text = "Ascent: " + fm.getAscent() + ", " + "Descent: " + fm.getDescent() + ", "
				+ "Leading: " + fm.getLeading() + ", String width: " + fm.stringWidth("Java is Fun !");
		
		setToolTipText(text);
	}
	
}
