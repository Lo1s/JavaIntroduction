/**
 * 
 */
package chapter18;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 8:47:09 
 */
@SuppressWarnings("serial")
public class L1813_FlagAnthem extends JApplet {

	private final static int NUMBER_OF_NATIONS = 7;
	private int current = 0;
	private ImageIcon[] icons = new ImageIcon[NUMBER_OF_NATIONS];
	private AudioClip[] audioClips = new AudioClip[NUMBER_OF_NATIONS];
	private AudioClip currentAudioClip;
	
	private JLabel jlblImageLabel = new JLabel();
	private JButton jbtResume = new JButton("Resume");
	private JButton jbtSuspend = new JButton("Suspend");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox jcboNations = new JComboBox(new Object[] {"Denmark", "Germany", "China", "India", "Norway", "UK", "US"});
	
	public L1813_FlagAnthem() {
		// Load image files and audio clips
		for (int i = 0; i < NUMBER_OF_NATIONS; i++) {
			icons[i] = new ImageIcon(getClass().getResource("image/flag" + i + ".gif"));
			audioClips[i] = Applet.newAudioClip(getClass().getResource("audio/anthem" + i + ".mid")); 
		}
		JPanel panel = new JPanel();
		panel.add(jbtResume);
		panel.add(jbtSuspend);
		panel.add(new JLabel("Select"));
		panel.add(jcboNations);
		add(jlblImageLabel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		// Register listeners
		jbtResume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
			}
		});
		jbtSuspend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop();
			}
		});
		jcboNations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop();
				current = jcboNations.getSelectedIndex();
				presentNation(current);
			}
		});
		
		jlblImageLabel.setIcon(icons[0]);
		jlblImageLabel.setHorizontalAlignment(JLabel.CENTER);
		currentAudioClip = audioClips[0];
		currentAudioClip.play();
	}
	
	public void presentNation(int index) {
		jlblImageLabel.setIcon(icons[index]);
		jcboNations.setSelectedIndex(index);
		currentAudioClip = audioClips[index];
		currentAudioClip.play();
	}
	
	@Override
	public void start() {
		currentAudioClip.play();
	}
	
	@Override public void stop() {
		currentAudioClip.stop();
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1813_FlagAnthem applet = new L1813_FlagAnthem();
		JFrame frame = new JFrame();
		
		frame.add(applet);
		
		frame.setTitle("FlagAnthem");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
