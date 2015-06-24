/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 15. 10. 2014 2014 13:57:57 
 */
@SuppressWarnings("serial")
public class PE1815_EnlargeAndShrinkImage extends JApplet {


	public PE1815_EnlargeAndShrinkImage() {
		// TODO Auto-generated constructor stub
		add(new EnlargeShrinkImage(), BorderLayout.CENTER);
		
	}

	class EnlargeShrinkImage extends JPanel {
		private URL urlImage;
		private ImageIcon imageIcon;
		private Image image;
		private Timer timer;
		private int width = 300;
		private int height = 300;
		private int increment = 1;

		@SuppressWarnings("rawtypes")
		public EnlargeShrinkImage() {
			// TODO Auto-generated constructor stub
			Class metaObject = this.getClass();
			urlImage = metaObject.getResource("image/us.gif");
			imageIcon = new ImageIcon(urlImage);
			image = imageIcon.getImage();
			
			timer = new Timer(50, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (width == 50 || height == 50 || width == 300 || height == 300)
						increment *= -1;
					width += increment;
					height += increment;
					setSize(width, height);
				}
			});
			timer.start();
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1815_EnlargeAndShrinkImage applet = new PE1815_EnlargeAndShrinkImage();
		JFrame frame = new JFrame();

		frame.add(applet);
		frame.setTitle("Exercise18_15");
		frame.setSize(300, 300);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
