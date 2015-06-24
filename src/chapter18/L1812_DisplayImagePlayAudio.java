/**
 * 
 */
package chapter18;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 8:35:04 
 */
@SuppressWarnings("serial")
public class L1812_DisplayImagePlayAudio extends JApplet {

	private AudioClip audioClip;
	
	public L1812_DisplayImagePlayAudio() {
		// TODO Auto-generated constructor stub
		java.net.URL urlForImage = getClass().getResource("image/denmark.gif");
		add(new JLabel(new ImageIcon(urlForImage)));
		
		java.net.URL urlForAudio = getClass().getResource("audio/denmark.mid");
		audioClip = Applet.newAudioClip(urlForAudio);
		audioClip.loop();
	}
	
	@Override
	public void start() {
		if (audioClip != null) audioClip.loop();
	}
	
	@Override
	public void stop() {
		if (audioClip != null) audioClip.stop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1812_DisplayImagePlayAudio applet = new L1812_DisplayImagePlayAudio();
		JFrame frame = new JFrame();
		frame.add(applet);
		
		frame.setTitle("DisplayImagePlayAudio");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
