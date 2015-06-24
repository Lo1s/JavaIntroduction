/**
 * 
 */
package chapter18;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * @author jslapnicka
 * @Date & @Time 21. 10. 2014 2014 8:08:05 
 */
@SuppressWarnings("serial")
public class PE1818_NationalFlags extends JApplet {

	private int numberOfCountries;
	private String[] titles;
	private String[] descriptions;
	private ImageIcon[] flags;
	private AudioClip[] audioClips;
	private Timer timer;
	private int count = 0;

	JLabel jlblFlag = new JLabel();
	JLabel jlblTitle = new JLabel();
	JTextArea jtaDescription = new JTextArea();

	public PE1818_NationalFlags() {
		// TODO Auto-generated constructor stub

	}


	@Override
	public void init() {
		setSize(450, 200);
		// Getting the paramaters from the XML file
		numberOfCountries = Integer.parseInt(getParameter("numberOfCountries"));
		titles = new String[numberOfCountries];
		flags = new ImageIcon[numberOfCountries];
		audioClips = new AudioClip[numberOfCountries];
		descriptions = new String[numberOfCountries];

		for (int i = 0; i < numberOfCountries; i++) {
			titles[i] = getParameter("name" + i);
			descriptions[i] = getParameter("description" + i);
			flags[i] = new ImageIcon(getClass().getResource("image/flag" + i + ".gif"));
			audioClips[i] = getAudioClip(getClass().getResource("audio/anthem" + i + ".mid"));
		}

		// Setting up the UI
		timer = new Timer(10000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jtaDescription.setText(descriptions[count]);
				jlblFlag.setIcon(flags[count]);
				jlblTitle.setText(titles[count]);
				audioClips[count].play();
				if (count != 0)
					audioClips[count - 1].stop();
				count++;

				if (count == 7)
					count = 0;
			}
		});
		timer.start();

		jlblFlag.setHorizontalAlignment(JLabel.CENTER);
		jlblTitle.setHorizontalAlignment(JLabel.CENTER);
		jlblTitle.setHorizontalTextPosition(JLabel.CENTER);

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(jlblFlag, BorderLayout.CENTER);
		panel.add(jlblTitle, BorderLayout.SOUTH);

		setLayout(new GridLayout(1, 2));
		add(panel);
		add(jtaDescription);
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
		PE1818_NationalFlags applet = new PE1818_NationalFlags();
		JFrame frame = new JFrame();

		applet.init();

		frame.add(applet);
		frame.setTitle("Exercise18_08");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
