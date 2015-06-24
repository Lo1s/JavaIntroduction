/**
 * 
 */
package chapter13;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * @author jslapnicka
 * @Date & @Time 31. 7. 2014 2014 10:57:09 
 */
public class PE1302_CustomButton extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OvalButton jbtOK = new OvalButton("OK");
	private OvalButton jbtCancel = new OvalButton("Cancel");
	
	public PE1302_CustomButton() {
		setLayout(new FlowLayout());
		add(jbtOK);
		add(jbtCancel);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1302_CustomButton();
		frame.setTitle("CustomButton");
		frame.setSize(100, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class OvalButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OvalButton() {
		
	}
	
	public OvalButton(String title) {
		super(title);
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(100, 50);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(100, 50);
	}
}