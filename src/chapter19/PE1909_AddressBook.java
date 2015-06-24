/**
 * 
 */
package chapter19;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 12. 11. 2014 2014 14:37:13 
 */
@SuppressWarnings("serial")
public class PE1909_AddressBook extends JFrame {

	// Specify the size of five string fields in the record
	final static int NAME_SIZE = 32;
	final static int STREET_SIZE = 32;
	final static int CITY_SIZE = 20;
	final static int STATE_SIZE = 2;
	final static int ZIP_SIZE = 5;
	final static int RECORD_SIZE = (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

	private JLabel jlblName = new JLabel("Name");
	private JLabel jlblStreet = new JLabel("Street");
	private JLabel jlblCity = new JLabel("City");
	private JLabel jlblState = new JLabel("State");
	private JLabel jlblZip = new JLabel("Zip");

	private JTextField jtfName = new JTextField(NAME_SIZE);
	private JTextField jtfStreet = new JTextField(STREET_SIZE);
	private JTextField jtfCity = new JTextField(CITY_SIZE);
	private JTextField jtfState = new JTextField(STATE_SIZE);
	private JTextField jtfZip = new JTextField(ZIP_SIZE);

	private JButton jbtAdd = new JButton("Add");
	private JButton jbtFirst = new JButton("First");
	private JButton jbtNext = new JButton("Next");
	private JButton jbtPrevious = new JButton("Previous");
	private JButton jbtLast = new JButton("Last");
	private JButton jbtUpdate = new JButton("Update");

	private File file = new File("C:/Java/examples/Address.dat");
	private RandomAccessFile raf;

	public PE1909_AddressBook() {
		// Open and create random access file stream
		try {
			raf = new RandomAccessFile(file, "rw");
		}
		catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(0);
		}

		// Panel p1 for holding labels name, street and city
		JPanel p1 = new JPanel(new GridLayout(3, 1));
		p1.add(jlblName);
		p1.add(jlblStreet);
		p1.add(jlblCity);

		// Panel jpState for holding state label and state text field
		JPanel jpState = new JPanel(new BorderLayout());
		jpState.add(jlblState, BorderLayout.WEST);
		jpState.add(jtfState, BorderLayout.CENTER);

		// Panel jpZip for holding zip label and text field
		JPanel jpZip = new JPanel(new BorderLayout());
		jpZip.add(jlblZip, BorderLayout.WEST);
		jpZip.add(jtfZip, BorderLayout.CENTER);

		// Panel p2 for holding jpState and jpZip
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(jpState, BorderLayout.WEST);
		p2.add(jpZip, BorderLayout.CENTER);

		// Panel p3 for holding jtfCity and p2
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add(jtfCity, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.EAST);

		// Panel p4 for holding jtfName, jtfStreet and p3
		JPanel p4 = new JPanel(new GridLayout(3, 1));
		p4.add(jtfName);
		p4.add(jtfStreet);
		p4.add(p3);

		// Place p1 and p4 into jpAdress
		JPanel jpAddress = new JPanel(new BorderLayout());
		jpAddress.add(p1, BorderLayout.WEST);
		jpAddress.add(p4, BorderLayout.CENTER);

		// Add buttons to the panel
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtAdd);
		jpButtons.add(jbtFirst);
		jpButtons.add(jbtNext);
		jpButtons.add(jbtPrevious);
		jpButtons.add(jbtLast);
		jpButtons.add(jbtUpdate);

		add(jpAddress, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.SOUTH);
		
		// Register listeners
		jbtAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				writeAddress();
			}
		});

		jbtFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (raf.length() > 0)
						readAddress(0);
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		jbtNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long currentPosition = raf.getFilePointer();
					if (currentPosition < raf.length())
						readAddress(currentPosition);
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		jbtPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long currentPosition = raf.getFilePointer();
					if (currentPosition - 2 * RECORD_SIZE > 0)
						readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
					else 
						readAddress(0);
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		jbtLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long lastPosition = raf.length();
					if (lastPosition > 0) {
						readAddress(lastPosition - 2 * RECORD_SIZE);
					}
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		jbtUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long currentPosition = raf.getFilePointer();
					if (currentPosition > 0)
						currentPosition -= 2 * RECORD_SIZE;
					else
						currentPosition = 0;
					updateAddress(currentPosition);
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		// Display the first record if exists
		try {
			if (raf.length() > 0)
				readAddress(0);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Write a record at the end of the file */
	public void writeAddress() {
		try {
			raf.seek(raf.length());
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfName.getText(), NAME_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfStreet.getText(), STREET_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfCity.getText(), CITY_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfState.getText(), STATE_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfZip.getText(), ZIP_SIZE, raf);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/** Write a record at the specified position */
	public void updateAddress(long position) {
		try {
			raf.seek(position);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfName.getText(), NAME_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfStreet.getText(), STREET_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfCity.getText(), CITY_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfState.getText(), STATE_SIZE, raf);
			PE1909_FixedLengthStringIO.writeFixedLengthString(jtfZip.getText(), ZIP_SIZE, raf);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Read a record at the specified position */
	public void readAddress(long position) throws IOException {
		raf.seek(position);
		String name = PE1909_FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
		String street = PE1909_FixedLengthStringIO.readFixedLengthString(STREET_SIZE, raf);
		String city = PE1909_FixedLengthStringIO.readFixedLengthString(CITY_SIZE, raf);
		String state = PE1909_FixedLengthStringIO.readFixedLengthString(STATE_SIZE, raf);
		String zip = PE1909_FixedLengthStringIO.readFixedLengthString(ZIP_SIZE, raf);

		jtfName.setText(name);
		jtfStreet.setText(street);
		jtfCity.setText(city);
		jtfState.setText(state);
		jtfZip.setText(zip);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame frame = new PE1909_AddressBook();

		frame.setTitle("Exercise19_09");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
