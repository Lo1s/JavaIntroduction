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
 * @Date & @Time 19. 11. 2014 2014 17:03:14 
 */
@SuppressWarnings("serial")
public class PE1921_HexEditor extends JFrame{

	private JTextField jtfFilePath = new JTextField(28);
	private JLabel jlblFilePath = new JLabel("Enter a file");
	private JTextArea jtaViewer = new JTextArea();
	private JButton jbtSave = new JButton("Save the bits to the file");

	public PE1921_HexEditor() {
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
						s += getHex(getBits(value));			
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
				String s = jtaViewer.getText();
				String binaryString = "";
				int index = 0;
				while (index < s.length()) {
					binaryString += getBits(Integer.parseInt(s.substring(index, index + 2), 16));
					index += 2;
				}

				BitOutputStream output = new BitOutputStream(new File(jtfFilePath.getText()));
				try {
					output.writeBit(binaryString);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

		});		
	}

	public String getHex(String hexString) {	
		StringBuilder builder = new StringBuilder();
		int value = ((hexString.charAt(0) - 48) * 8) + ((hexString.charAt(1) - 48) * 4) + ((hexString.charAt(2) - 48) * 2)
				+ ((hexString.charAt(3) - 48) * 1);
		builder.append(toHexChar(value));

		value = ((hexString.charAt(4) - 48) * 8) + ((hexString.charAt(5) - 48) * 4) + ((hexString.charAt(6) - 48) * 2)
				+ ((hexString.charAt(7) - 48) * 1);
		builder.append(toHexChar(value));

		return builder.toString();		
	}

	public static char toHexChar(int value) {
		if (value >= 0 && value <= 9)
			return (char)(value + 48);
		else
			return (char)(value + 65 - 10);
	}

	public static String getBits(int value) {
		String bitString = "";

		int mask = 1;
		for (int i = 7; i >= 0; i--) {
			int temp = value >> i;
			int bit = temp & mask;

			bitString += bit;
		}
		return bitString;
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
		JFrame frame = new PE1921_HexEditor();
		frame.setTitle("Exercise19_21");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
