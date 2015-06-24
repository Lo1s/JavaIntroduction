/**
 * 
 */
package chapter19;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 18. 11. 2014 2014 8:59:49 
 */
@SuppressWarnings("serial")
public class PE1915_DecryptFile extends JFrame {

	private JTextField jtfInput = new JTextField("Enter a file input name");
	private JTextField jtfOutput = new JTextField("Enter a file output name");
	private JButton jbtDecrypt = new JButton("Decrypt !");

	public PE1915_DecryptFile() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(3, 1));
		add(jtfInput);
		add(jtfOutput);
		add(jbtDecrypt);

		// Register listeners
		jbtDecrypt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File sourceFile = new File(jtfInput.getText());
				File targetFile = new File(jtfOutput.getText());
				try {
					decrypt(sourceFile, targetFile);
				} catch (IOException ex) {
					System.out.println(sourceFile + " not found !");
					System.out.println("Terminating..");
					System.exit(0);
				}
			}
		});		
	}

	public void decrypt (File sourceFile, File targetFile) throws FileNotFoundException, IOException {

		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));

		int value;
		while ((value = input.read()) != -1) {
			output.write(value - 5);
		}

		input.close();
		output.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1915_DecryptFile();
		frame.setTitle("Exercise19_15");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
