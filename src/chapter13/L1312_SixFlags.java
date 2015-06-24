/**
 * 
 */
package chapter13;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 30. 7. 2014 2014 14:25:03 
 */
public class L1312_SixFlags extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public L1312_SixFlags() {
		Image image1 = new ImageIcon("C://Java//site//image//us.gif").getImage();
		Image image2 = new ImageIcon("C://Java//site//image//ca.gif").getImage();
		Image image3 = new ImageIcon("C://Java//site//image//india.gif").getImage();
		Image image4 = new ImageIcon("C://Java//site//image//uk.gif").getImage();
		Image image5 = new ImageIcon("C://Java//site//image//china.gif").getImage();
		Image image6 = new ImageIcon("C://Java//site//image//norway.gif").getImage();
		
		setLayout(new GridLayout(2, 0, 5, 5));
		add(new L1313_ImageViewer(image1));
		add(new L1313_ImageViewer(image2));
		add(new L1313_ImageViewer(image3));
		add(new L1313_ImageViewer(image4));
		add(new L1313_ImageViewer(image5));
		add(new L1313_ImageViewer(image6));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1312_SixFlags frame = new L1312_SixFlags();
		frame.setTitle("SixFlags");
		frame.setSize(400, 320);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
