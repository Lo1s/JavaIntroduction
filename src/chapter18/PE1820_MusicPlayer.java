/**
 * 
 */
package chapter18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.AudioClip;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 21. 10. 2014 2014 14:18:42 
 */
@SuppressWarnings("serial")
public class PE1820_MusicPlayer extends JApplet {

	JButton jbtPlay = new JButton("Play");
	JButton jbtLoop = new JButton("Loop");
	JButton jbtStop = new JButton("Stop");
	AudioClip song;
	
	public PE1820_MusicPlayer() {
		// TODO Auto-generated constructor stub
		song = newAudioClip(getClass().getResource("audio/us.mid"));
		
		
		// Register listeners
		ButtonsListener listener = new ButtonsListener();
		jbtPlay.addActionListener(listener);
		jbtLoop.addActionListener(listener);
		jbtStop.addActionListener(listener);
		
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtPlay);
		jpButtons.add(jbtLoop);
		jpButtons.add(jbtStop);
		
		add(jpButtons);
	}
	
	class ButtonsListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbtPlay)
				song.play();
			else if (e.getSource() == jbtStop)
				song.stop();
			else if (e.getSource() == jbtLoop)
				song.loop();
		}
	}
	
	@Override
	public void init() {
		setSize(300, 45);
	}
	
	@Override
	public void start() {
		
	}
	
	@Override
	public void stop() {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1820_MusicPlayer applet = new PE1820_MusicPlayer();
		frame.add(applet);
		
		frame.setTitle("Exercise18_20");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
