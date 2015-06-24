/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 13:52:21 
 */
@SuppressWarnings("serial")
public class PE1704_TextViewer extends JFrame {
	
	// Create TextArea for a Viewer
	private JTextArea jtaViewer = new JTextArea();

	// Create JLabel for a filename
	private JLabel jlblFilename = new JLabel("Filename");

	// Create JTextField for a file path
	private JTextField jtfPath = new JTextField(20);

	// Create JButton for viewing
	private JButton jbtView = new JButton("View");

	public PE1704_TextViewer() {
		// TODO Auto-generated constructor stub
		// Set up Text Area
		jtaViewer.setLineWrap(true);
		jtaViewer.setWrapStyleWord(true);
		
		// Create a scrollpane for text area
		JScrollPane scrollPane = new JScrollPane(jtaViewer);
		

		// Create and set a panel for a button, text field and label
		JPanel panelBottomBar = new JPanel(new FlowLayout());
		jlblFilename.setHorizontalTextPosition(JLabel.LEFT);
		jlblFilename.setVerticalTextPosition(JLabel.CENTER);
		panelBottomBar.add(jlblFilename);
		panelBottomBar.add(jtfPath);
		panelBottomBar.add(jbtView);

		// Register listener for JButton
		jbtView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String path = jtfPath.getText();
				StringBuilder builder = new StringBuilder();
				try {
					Scanner input = new Scanner(new File(path));
					while (input.hasNextLine())
						builder.append(input.nextLine() + "\n");
					input.close();
				} 
				catch(FileNotFoundException ex) {
					System.out.print("Wrong path !");
				}
				jtaViewer.setText(builder.toString());
			}
		});
		
		// Add panels to the frame
		add(scrollPane, BorderLayout.CENTER);
		add(panelBottomBar, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1704_TextViewer frame = new PE1704_TextViewer();
		frame.setTitle("Exercise17_04");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
