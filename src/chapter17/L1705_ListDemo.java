/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author jslapnicka
 * @Date & @Time 24. 9. 2014 2014 15:59:48 
 */
@SuppressWarnings("serial")
public class L1705_ListDemo extends JFrame {

	/**
	 * @param args
	 */

	final int NUMBER_OF_FLAGS = 9;

	// Declare an array of Strings for flag titles
	private String[] flagTitles = {"Canada", "China", "Denmark", 
			"France", "Germany", "India", "Norway", "United Kingdom", 
	"United States of America"};

	// The list for selecting countries
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JList jlst = new JList(flagTitles);

	// Declare an ImageIcon array for the national flags of 9 countries
	private ImageIcon[] imageIcons = {
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
	
	// Arrays of labels for displaying images 
	private JLabel[] jlblImageViewer = new JLabel[NUMBER_OF_FLAGS];
	
	public L1705_ListDemo() {
		// TODO Auto-generated constructor stub
		// Create a panel to hold 9 labels
		JPanel p = new JPanel(new GridLayout(3, 3, 5, 5));
		
		for (int i = 0; i < NUMBER_OF_FLAGS; i++) {
			p.add(jlblImageViewer[i] = new JLabel());
			jlblImageViewer[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		// Add p and the list to the frame
		add(p, BorderLayout.CENTER);
		add(new JScrollPane(jlst), BorderLayout.WEST);
		
		// Register listeners
		jlst.addListSelectionListener(new ListSelectionListener() {
			@Override /** Handle list selection*/
			public void valueChanged(ListSelectionEvent e) {
				// Get selected indices
				int[] indices = jlst.getSelectedIndices();
				
				int i;
				// Set icons in the labels
				for (i = 0; i < indices.length; i++) {
					jlblImageViewer[i].setIcon(imageIcons[indices[i]]);
				}
				
				// Remove icons from the rest of the labels
				for (; i < NUMBER_OF_FLAGS; i++) {
					jlblImageViewer[i].setIcon(null);
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1705_ListDemo frame = new L1705_ListDemo();
		frame.setTitle("ListDemo");
		frame.setSize(650, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
