/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 26. 9. 2014 2014 7:48:42 
 */
@SuppressWarnings("serial")
public class PE1705_HistogramUsage extends JFrame {

	/**
	 * @param args
	 */

	// Create a histogram panel
	L1709_Histogram histogram = new L1709_Histogram();

	// Create a label "Text file"
	JLabel jlblTextFile = new JLabel("Text File");

	// Create a Text Field
	JTextField jtfPath = new JTextField();

	// Create an array for counting the letters
	int[] count;

	public PE1705_HistogramUsage() {
		// TODO Auto-generated constructor stub

		// Set up JLabel
		jlblTextFile.setHorizontalTextPosition(JLabel.CENTER);
		jlblTextFile.setVerticalTextPosition(JLabel.CENTER);

		// Set up the Text Field
		jtfPath.setColumns(30);

		// Create a panel for thte label and text field
		JPanel pToolBar = new JPanel();
		pToolBar.add(jlblTextFile);
		pToolBar.add(jtfPath);

		// Register listeners
		jtfPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder builder = new StringBuilder();
				try {
					Scanner input = new Scanner(new File(jtfPath.getText()));
					while (input.hasNextLine())
						builder.append(input.nextLine() + "\n");
					count = new int[26];
					String pathWay = builder.toString();
					for (int i = 0; i < pathWay.length(); i++) {
						if (pathWay.charAt(i) >= 'A' && pathWay.charAt(i) <= 'Z')
							count[pathWay.charAt(i) - 'A']++;
						else if (pathWay.charAt(i) >= 'a' && pathWay.charAt(i) <= 'z')
							count[pathWay.charAt(i) - 'a']++;
					}
					input.close();
				}
				catch (FileNotFoundException ex) {
					javax.swing.JOptionPane.showMessageDialog(null, "The file not found !", "File does not exist", JOptionPane.INFORMATION_MESSAGE);
				}
				histogram.showHistogram(count);
			}
		});

		add(histogram, BorderLayout.CENTER);
		add(pToolBar, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1705_HistogramUsage frame = new PE1705_HistogramUsage();
		frame.setTitle("Exercise17_05");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
