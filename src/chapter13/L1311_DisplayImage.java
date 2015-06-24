/**
 * 
 */
package chapter13;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 30. 7. 2014 2014 14:25:41 
 */
public class L1311_DisplayImage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public L1311_DisplayImage() {
		add(new ImagePanel());
	}
	
	public static void main(String[] args) {
		JFrame frame = new L1311_DisplayImage();
		frame.setTitle("DisplayImage");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = new ImageIcon("C://Java//site//image//us.gif");
	private Image image = imageIcon.getImage();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}


