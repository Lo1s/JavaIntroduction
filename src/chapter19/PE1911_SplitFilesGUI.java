/**
 * 
 */
package chapter19;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 13. 11. 2014 2014 14:52:17 
 */
@SuppressWarnings("serial")
public class PE1911_SplitFilesGUI extends JFrame {

	// Text fields
	private JTextArea jtaGuidance = new JTextArea("If you split a file named temp.txt into 3 smaller files, "
			+ "the three smaller files would be named temp.part1, "
			+ "temp.part2 and temp.part3.", 2, 20);
	private JTextField jtfChooseFile = new JTextField(20);
	private JTextField jtfNumberOfFiles = new JTextField(19);

	// Butttons
	private JButton jbtBrowse = new JButton("Browse");
	private JButton jbtStart = new JButton("Start");

	// Labels
	private JLabel jlblChooseFile = new JLabel("Enter or choose a file:");
	private JLabel jlblNumberOfFiles = new JLabel("Number of smaller files:");

	// Create File Chooser
	private JFileChooser jfcBrowse = new JFileChooser(new File("C:/Java/examples"));
	
	// Data field
	private int numberOfPieces;
	private File sourceFile;

	public PE1911_SplitFilesGUI() {
		// TODO Auto-generated constructor stub

		// Set up the header text field
		jtaGuidance.setWrapStyleWord(false);
		jtaGuidance.setLineWrap(true);
		// Create p1 for jlblChooseFile, jtfChooseFile and jbtBrowse
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(jlblChooseFile);
		p1.add(jtfChooseFile);

		// Create p2 for jlblNumberOfFiles and jtfNumberOfFiles
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(jlblNumberOfFiles);
		p2.add(jtfNumberOfFiles);

		// Create p3 for p1 and p2
		JPanel p3 = new JPanel(new GridLayout(2, 1));
		p3.add(p1);
		p3.add(p2);

		// Create panel for buttons
		JPanel jpButtons = new JPanel(new GridLayout(2, 1));
		jpButtons.add(jbtBrowse);
		jpButtons.add(jbtStart);

		// Add items to the frame
		add(jtaGuidance, BorderLayout.NORTH);
		add(p3, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.EAST);
		// Register listeners
		jbtBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jfcBrowse.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					// Get selected file
					sourceFile = jfcBrowse.getSelectedFile();
					jtfChooseFile.setText(sourceFile.getAbsolutePath());
				}
			}
		});

		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numberOfPieces = Integer.parseInt(jtfNumberOfFiles.getText());
				if (!jtfChooseFile.getText().isEmpty())
					sourceFile = new File(jtfChooseFile.getText());

				PE1910_SplitFiles splitFiles = new PE1910_SplitFiles(sourceFile, numberOfPieces);
				try {
					splitFiles.split();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1911_SplitFilesGUI();
		frame.setTitle("Exercise19_11: Split a File");
		frame.setSize(480, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
