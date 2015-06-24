/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 3. 10. 2014 2014 10:46:41 
 */
@SuppressWarnings("serial")
public class PE1719_DisplayCountryFlagWithDescription extends JFrame {

	// Create an array of Strings for flag cities
	private String[] flagTitles = {"Canada", "China", "Denmark", "France", "Germany", "India", "Norway", "United Kingdom",
	"United States of America"};

	// Declare an ImageIcon array for the national flags of 9 countries
	private ImageIcon[] flagImage = {
			new ImageIcon("C:/Java/site/image/ca.gif"),
			new ImageIcon("C:/Java/site/image/china.gif"),
			new ImageIcon("C:/Java/site/image/denmark.gif"),
			new ImageIcon("C:/Java/site/image/fr.gif"),
			new ImageIcon("C:/Java/site/image/germany.gif"),
			new ImageIcon("C:/Java/site/image/india.gif"),
			new ImageIcon("C:/Java/site/image/norway.gif"),
			new ImageIcon("C:/Java/site/image/uk.gif"),
			new ImageIcon("C:/Java/site/image/us.gif")
	};

	// Declare an array of Strings for flag descriptions
	private String[] flagDescription = new String[9];

	// Declare and create description panel
	private L1702_DescriptionPanel descriptionPanel = new L1702_DescriptionPanel();

	// Create a combo box for selecting countries
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox jcbo = new JComboBox(flagTitles);

	// Create Scanner for the text input
	Scanner input; 

	public PE1719_DisplayCountryFlagWithDescription() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		// Reading the description from txt files
		for (int i = 0; i < flagDescription.length; i++) {
			input = new Scanner(new File("C:/Java/site/textfiles/description" + i + ".txt"));
			StringBuilder builder = new StringBuilder();
			while (input.hasNextLine())
				builder.append(input.nextLine() + "\n");
			flagDescription[i] = builder.toString();
		}

		// Set the first country (Canada) for display
		setDisplay(0);

		// Add combo boc and description panel to the frame
		add(jcbo, BorderLayout.NORTH);
		add(descriptionPanel, BorderLayout.CENTER);

		// Register listener
		jcbo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				setDisplay(jcbo.getSelectedIndex());
			}
		});
	}

	public void setDisplay(int index) {
		descriptionPanel.setTitle(flagTitles[index]);
		descriptionPanel.setImageIcon(flagImage[index]);
		descriptionPanel.setDescription(flagDescription[index]);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PE1719_DisplayCountryFlagWithDescription frame = new PE1719_DisplayCountryFlagWithDescription();
		frame.setTitle("Excercise17_19");
		frame.setSize(500, 200);;
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}