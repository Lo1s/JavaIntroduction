/**
 * 
 */
package chapter18;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 23. 10. 2014 2014 8:50:31 
 */
@SuppressWarnings("serial")
public class PE1823_RaiseFlagWithAnthem extends JApplet {

	private Timer timer;
	private Flag flag = new Flag();
	private AudioClip audioClip;

	public PE1823_RaiseFlagWithAnthem() {
		// TODO Auto-generated constructor stub
		audioClip = newAudioClip(getClass().getResource("audio/us.mid"));
		audioClip.play();
		timer = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				flag.move();
				repaint();
			}
		});
		timer.start();
		add(flag);
	}

	class Flag extends JPanel {
		ImageIcon icon = new ImageIcon("C:/Java/site/image/us.gif");
		Image image = icon.getImage();
		int move = 0;
		int xCenter;
		int yCenter;


		public void move() {
			if ((getHeight() - 20 + move - 5) > 0)
				this.move -= 5;
			else {
				timer.stop();
				audioClip.stop();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {

			xCenter = getWidth() / 2;
			yCenter = getHeight() / 2;

			super.paintComponent(g);

			g.drawImage(image, xCenter - 10, getHeight() - 20 + move, 20, 20, this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1823_RaiseFlagWithAnthem applet = new PE1823_RaiseFlagWithAnthem();
		JFrame frame = new JFrame();

		frame.add(applet);
		frame.setTitle("Exercise18_23");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
