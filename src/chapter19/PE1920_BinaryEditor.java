/**
 * 
 */
package chapter19;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 19. 11. 2014 2014 9:55:32 
 */
@SuppressWarnings("serial")
public class PE1920_BinaryEditor extends JFrame {

	private JTextField jtfFilePath = new JTextField(28);
	private JLabel jlblFilePath = new JLabel("Enter a file");
	private JTextArea jtaViewer = new JTextArea();
	private JButton jbtSave = new JButton("Save the bits to the file");

	public PE1920_BinaryEditor() {
		// TODO Auto-generated constructor stub

		// Add label and text field into the panel
		JPanel jpFilePath = new JPanel();
		jpFilePath.add(jlblFilePath);
		jpFilePath.add(jtfFilePath);

		// Add text area to the scroll pane
		jtaViewer.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(jtaViewer);
		scrollPane.getVerticalScrollBar();

		// Add items to the frame
		add(jpFilePath, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(jbtSave, BorderLayout.SOUTH);

		// Register listeners
		jtfFilePath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				try {
					FileInputStream input = new FileInputStream(jtfFilePath.getText().trim());

					String s = "";
					int value;
					while ((value = input.read()) != -1) {
						s += getBits(value);			
					}

					input.close();
					jtaViewer.setText(s);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});

		jbtSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BitOutputStream output = new BitOutputStream(new File(jtfFilePath.getText().trim()));
				String tempString = jtaViewer.getText().trim();

				try {
					output.writeBit(tempString);
				} catch (IOException ex) {
					ex.printStackTrace();				
					}				
			}
			
		});
	}

	public String getBits(int value) {

		String result = "";
		int mask = 1; // [0001] in binary

		for (int i = 7; i >= 0; i--) {
			int temp = value >> i; // shift the binary value of the passed integer (value) to the right for i places
			int bits = temp & mask;
			result += bits;
		}
		return result;
	}

	public static class BitOutputStream {
		private int mask = 1;
		private int value;
		private int count;
		private FileOutputStream output;

		public BitOutputStream(File file) {
			// TODO Auto-generated constructor stub
			try {
				output = new FileOutputStream(file);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		public void writeBit(char bit) throws IOException {
			count++;

			value = value << 1;

			if (bit == '1')
				value = value | mask;

			if (count == 8) {
				output.write(value);
				count = 0;
			}		
		}

		public void writeBit(String bits) throws IOException {
			for (int i = 0; i < bits.length(); i++) {
				writeBit(bits.charAt(i));
			}
		}

		public void close() throws IOException {
			if (count > 0) {
				value = value << (8 - count);
				output.write(value);
			}

			output.close();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1920_BinaryEditor();
		frame.setTitle("Exercise19_20");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
