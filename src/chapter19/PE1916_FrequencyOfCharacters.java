/**
 * 
 */
package chapter19;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 18. 11. 2014 2014 9:27:24 
 */
@SuppressWarnings("serial")
public class PE1916_FrequencyOfCharacters extends JFrame {

	private JTextField jtfInput = new JTextField("Enter a file input name");
	private JButton jbtCount = new JButton("Count !");

	public PE1916_FrequencyOfCharacters() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(2, 1));
		add(jtfInput);
		add(jbtCount);

		// Register listener
		jbtCount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File sourceFile = new File(jtfInput.getText());
				try {
					count(sourceFile);
				} catch (IOException ex) {
					System.out.println(sourceFile + " not found !");
					System.out.println("Terminating..");
					System.exit(0);
				}
			}
		});
	}

	public void count(File sourceFile) throws FileNotFoundException, IOException {
		int[] count = new int[128];
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));	
		
		int value;
		while ((value = input.read()) != -1) {
			count[value]++;
		}
		
		System.out.printf("%15s%15s\n", "ASCII Code", "Counts");
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				System.out.printf("%15d%15d\n", i, count[i]);
		}
		
		input.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1916_FrequencyOfCharacters();
		frame.setTitle("Exercise19_16");
		frame.setSize(300, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
