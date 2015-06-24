/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 24. 9. 2014 2014 15:32:15 
 */
@SuppressWarnings("serial")
public class L1704_ComboBoxDemo2 extends JFrame {

	/**
	 * @param args
	 */
	
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
	
	public L1704_ComboBoxDemo2() {
		// TODO Auto-generated constructor stub
		flagDescription[0] = "The Canadian national flag...";
		flagDescription[1] = "Description for China ...";
		flagDescription[2] = "Description for Denmark ...";
		flagDescription[3] = "Description for France ...";
		flagDescription[4] = "Description for Germany ...";
		flagDescription[5] = "Description for India ...";
		flagDescription[6] = "Description for Norway ...";
		flagDescription[7] = "Description for UK ...";
		flagDescription[8] = "Description for US ...";
		
		// Set the first country (Canada) for display
		setDisplay(0);
		
		// Add combo boc and description panel to the frame
		add(jcbo, BorderLayout.NORTH);
		add(descriptionPanel, BorderLayout.CENTER);
		
		// Register listener
		jcbo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDisplay(jcbo.getSelectedIndex());
			}
		});
	}
	
	public void setDisplay(int index) {
		descriptionPanel.setTitle(flagTitles[index]);
		descriptionPanel.setImageIcon(flagImage[index]);
		descriptionPanel.setDescription(flagDescription[index]);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1704_ComboBoxDemo2 frame = new L1704_ComboBoxDemo2();
		frame.setTitle("ComboBoxDemo");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
