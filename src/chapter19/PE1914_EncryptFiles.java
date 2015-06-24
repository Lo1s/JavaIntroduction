/**
 * 
 */
package chapter19;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
 * @Date & @Time 18. 11. 2014 2014 8:09:00 
 */
@SuppressWarnings("serial")
public class PE1914_EncryptFiles extends JFrame {

	private JTextField jtfInput = new JTextField("Enter a file input name");
	private JTextField jtfOutput = new JTextField("Enter a file output name");
	private JButton jbtEncrypt = new JButton("Encrypt !");

	public PE1914_EncryptFiles()  {
		// TODO Auto-generated constructor stub

		setLayout(new GridLayout(3, 1));
		add(jtfInput);
		add(jtfOutput);
		add(jbtEncrypt);

		// Register listeners
		jbtEncrypt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File sourceFile = new File(jtfInput.getText());
				File targetFile = new File(jtfOutput.getText());
				try {
					encrypt(sourceFile, targetFile);
				} catch(IOException ex) {
					System.out.println(sourceFile + " not found !");
					System.out.println("Terminating..");
					System.exit(0);
				}
			}
		});		

	}

	public void encrypt(File sourceFile, File targetFile) throws FileNotFoundException, IOException {

		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
		
		int value;
		while ((value = input.read()) != -1) {
			output.write(value + 5);
		}
		
		input.close();
		output.close();
		
	}
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1914_EncryptFiles();
		frame.setTitle("Exercise19_14");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
