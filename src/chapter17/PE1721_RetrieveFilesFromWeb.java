/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 3. 10. 2014 2014 12:27:00 
 */
@SuppressWarnings("serial")
public class PE1721_RetrieveFilesFromWeb extends JFrame {

	/**
	 * @param args
	 */

	// Create TextField, Text Area, JButton and JLabels
	JLabel jlblFilename = new JLabel("Filename");
	JLabel jlblStatus = new JLabel();
	JTextField jtfFilename = new JTextField(30);
	JButton jbtView = new JButton("View");
	JTextArea jtaViewer = new JTextArea();

	public PE1721_RetrieveFilesFromWeb() {
		// TODO Auto-generated constructor stub
		// Create panel and add label, text field and button to it
		JPanel jpSearchBar = new JPanel();
		jpSearchBar.add(jlblFilename);
		jpSearchBar.add(jtfFilename);
		jpSearchBar.add(jbtView);

		// Create ScrollPane for the Text Area
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(jtaViewer);

		// Register listeners
		jbtView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URL url = new URL(jtfFilename.getText());
					Scanner input = new Scanner(url.openStream());
					jlblStatus.setText("File loaded successfully");
					StringBuilder builder = new StringBuilder();
					while (input.hasNextLine()) {
						builder.append(input.nextLine() + "\n");
					}
					jtaViewer.setText(builder.toString());
					input.close();
				}
				catch (MalformedURLException ex) {
					jlblStatus.setText("Network connection problem");
				}
				catch (IOException ex) {
					jlblStatus.setText("Wrong input");
				}

			}
		});

		// Create panel for status label
		jlblStatus.setHorizontalAlignment(JLabel.LEFT);
		jlblStatus.setHorizontalTextPosition(JLabel.LEFT);

		// Add items to the frame
		add(jpSearchBar, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(jlblStatus, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1721_RetrieveFilesFromWeb();
		frame.setTitle("View File on the Internet");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
