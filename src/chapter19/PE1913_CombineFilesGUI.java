/**
 * 
 */
package chapter19;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 14. 11. 2014 2014 14:46:28 
 */
@SuppressWarnings("serial")
public class PE1913_CombineFilesGUI extends JFrame {

	// Text fields
	private JTextArea jtaGuidance = new JTextArea("If you split a file named temp.txt into 3 smaller files, "
			+ "the three smaller files would be named temp.part1, "
			+ "temp.part2 and temp.part3.", 2, 20);
	private JTextField jtfChooseFile = new JTextField(20);
	private JTextField jtfNumberOfFiles = new JTextField(19);

	// Butttons
	private JButton jbtStart = new JButton("Start");

	// Labels
	private JLabel jlblChooseFile = new JLabel("Enter a base file:");
	private JLabel jlblNumberOfFiles = new JLabel("Number of smaller files:");

	// Data field
	private int numberOfPieces;
	private String sourceFile;

	public PE1913_CombineFilesGUI() {
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



		// Add items to the frame
		add(jtaGuidance, BorderLayout.NORTH);
		add(p3, BorderLayout.CENTER);
		add(jbtStart, BorderLayout.SOUTH);
		// Register listeners
		
		jbtStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numberOfPieces = Integer.parseInt(jtfNumberOfFiles.getText());
				sourceFile = jtfChooseFile.getText();
				
				try {
					PE1912_CombineFiles combineFiles = new PE1912_CombineFiles(sourceFile, numberOfPieces); 
					combineFiles.combine();
				}
				catch (IOException ex) {
					System.out.println(sourceFile + " not found !");
				}
			}
		});
	}

	/** Run from the command prompt */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1913_CombineFilesGUI();
		frame.setTitle("Exercise19_13: Combine a File");
		frame.setSize(480, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
