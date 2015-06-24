/**
 * 
 */
package chapter18;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


/**
 * @author jslapnicka
 * @Date & @Time 22. 10. 2014 2014 14:49:01 
 */
@SuppressWarnings("serial")
public class PE1822_ImageAnimatorWithAudio extends JApplet {

	// Creating the UI
	private JButton jbtStartAnimation = new JButton("Start Animation");
	private ImageIcon image = new ImageIcon();
	private AudioClip audioClip;
	private JLabel jlblImageViewer = new JLabel(image);
	private JLabel jlblAnimationSpeed = new JLabel("Animation speed in milliseconds");
	private JLabel jlblImageFilePrefix = new JLabel("Image file prefix");
	private JLabel jlblNumberOfImages = new JLabel("Number of images");
	private JLabel jlblAudioFile = new JLabel("Audio file");
	private JTextField jtfAnimationSpeed = new JTextField(10);
	private JTextField jtfImageFilePrefix = new JTextField(10);
	private JTextField jtfNumberOfImages = new JTextField(10);
	private JTextField jtfAudioFile = new JTextField(10);
	private JPanel jpButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JPanel jpSettings = new JPanel(new GridLayout(4, 4));

	// Data field
	private Timer timer;
	private ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
	private int count = 0;
	private int delay;

	public PE1822_ImageAnimatorWithAudio() {
		// TODO Auto-generated constructor stub
		LineBorder lineBorder = new LineBorder(Color.BLACK);
		TitledBorder titledBorder = new TitledBorder("Enter information for animation");

		// Add items to the panels
		jpButton.add(jbtStartAnimation);
		jpSettings.add(jlblAnimationSpeed);
		jpSettings.add(jtfAnimationSpeed);
		jpSettings.add(jlblImageFilePrefix);
		jpSettings.add(jtfImageFilePrefix);
		jpSettings.add(jlblNumberOfImages);
		jpSettings.add(jtfNumberOfImages);
		jpSettings.add(jlblAudioFile);
		jpSettings.add(jtfAudioFile);

		jlblImageViewer.setBorder(lineBorder);
		jpSettings.setBorder(titledBorder);

		// Register listeners
		timer = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (count < images.size()) {
					jlblImageViewer.setIcon(images.get(count));
					count++;
					System.out.println("tik");
					repaint();
				} else {
					timer.stop();
					audioClip.stop();
				}
			}
		});
		jtfAnimationSpeed.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delay = Integer.parseInt(jtfAnimationSpeed.getText());
			}
		});
		jtfImageFilePrefix.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		jbtStartAnimation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!jtfAnimationSpeed.getText().isEmpty() && !jtfImageFilePrefix.getText().isEmpty() 
						&& !jtfNumberOfImages.getText().isEmpty() && !jtfAudioFile.getText().isEmpty()) {
					for (int i = 1; i <= Integer.parseInt(jtfNumberOfImages.getText()) ; i++) {
						images.add( new ImageIcon("C:/Java/site/image/" + jtfImageFilePrefix.getText() + i + ".gif"));
						System.out.println("C:/Java/site/image/" + jtfImageFilePrefix.getText() + i + ".gif");
					}
					timer.start();
					audioClip = newAudioClip(getClass().getResource("audio/" + jtfAudioFile.getText()));
					audioClip.play();
				}
			}
		});


		// Add items to the frame
		add(jpButton, BorderLayout.NORTH);
		add(jlblImageViewer, BorderLayout.CENTER);
		add(jpSettings, BorderLayout.SOUTH);
	}

	@Override
	public void init() {
		setSize(600, 900);
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
		PE1822_ImageAnimatorWithAudio applet = new PE1822_ImageAnimatorWithAudio();
		frame.add(applet);

		frame.setTitle("Exercise18_22");
		frame.setSize(600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
