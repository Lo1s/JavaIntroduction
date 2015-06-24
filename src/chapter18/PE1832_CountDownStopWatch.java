/**
 * 
 */
package chapter18;

import java.applet.AudioClip;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 31. 10. 2014 2014 8:11:15 
 */
@SuppressWarnings("serial")
public class PE1832_CountDownStopWatch extends JApplet {

	private JTextField jtfCountdown = new JTextField(5);
	private Timer timer;
	private int countdown;
	private AudioClip audioClip;
	
	public PE1832_CountDownStopWatch() {
		// TODO Auto-generated constructor stub
		audioClip = newAudioClip(this.getClass().getResource("audio/alarm.mid"));
		Font font = new Font("TimesRoman", Font.BOLD, 40);
		jtfCountdown.setFont(font);
		jtfCountdown.setHorizontalAlignment(JTextField.CENTER);
		
		// Register listener
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				countdown = Integer.parseInt(jtfCountdown.getText());
				if (countdown > 0) {
					countdown--;
					jtfCountdown.setText(countdown + "");
				} else
					audioClip.loop();
				repaint();
			}
		});
		
		jtfCountdown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!jtfCountdown.getText().isEmpty())
					timer.start();
				audioClip.stop();
			}
		});
		
		add(jtfCountdown);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		PE1832_CountDownStopWatch applet = new PE1832_CountDownStopWatch();
		
		frame.add(applet);
		frame.setTitle("Exercise18_32");
		frame.setSize(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
