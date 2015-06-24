/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;

import java.awt.event.*;

/**
 * @author jslapnicka
 * @Date & @Time 30. 9. 2014 2014 12:36:22 
 */
@SuppressWarnings("serial")
public class PE1714_UseComboBoxAndJList extends JFrame {

	/**
	 * @param args
	 */

	@SuppressWarnings("rawtypes")
	// Create JComboBox
	JComboBox jcbSelection = new JComboBox();
	// Create JList
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JList jlstItems = new JList(new String[] {"Czech Republic", "Denmark", "Netherland", "Norway", "United States of America", 
			"United Kingdom", "China", "Germany", "France", "Italy", "Jamaica", "Sweden", "Russia", "Spain"});
	// Create JLabels
	JLabel jlblSelectionMode = new JLabel("Choose Selection Mode");
	JLabel jlblOutput = new JLabel();

	// Array for output
	String[] selectedItems;

	@SuppressWarnings("unchecked")
	public PE1714_UseComboBoxAndJList() {
		// TODO Auto-generated constructor stub
		// Set up Combo Box
		jcbSelection.addItem("SINGLE_SELECTION");
		jcbSelection.addItem("SINGLE_INTERVAL_SELECTION");
		jcbSelection.addItem("MULTIPLE_INTERVAL_SELECTION");

		// Set up selection mode
		jcbSelection.setSelectedIndex(0);
		jlstItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Create panel for the selection mode
		JPanel jpSelectionMode = new JPanel(new FlowLayout());
		jpSelectionMode.add(jlblSelectionMode);
		jpSelectionMode.add(jcbSelection);

		// Create Scroll pane and put JList in it
		JScrollPane scrollPane = new JScrollPane(jlstItems);

		// Add Output to the panel
		JPanel jpOutput = new JPanel();
		jpOutput.add(jlblOutput);

		// Register listeners
		jcbSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(jcbSelection.getSelectedIndex()) {
				case 0: jlstItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); break;
				case 1: jlstItems.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); break;
				case 2: jlstItems.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); break;
				}
			}
		});
		jlstItems.addListSelectionListener(new ListSelectionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Get the selected items
				Object[] selectObject = jlstItems.getSelectedValues();
				selectedItems = new String[selectObject.length];
				if (selectObject != null) 
					for (int i = 0; i < selectObject.length; i++) {
						selectedItems[i] = (String)selectObject[i];
					}

				jlblOutput.setText(PE1714_UseComboBoxAndJList.toString(selectedItems));
			}
		});


		// Add items to the frame
		add(jpSelectionMode, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(jpOutput, BorderLayout.SOUTH);
	}

	public static String toString(String[] array) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i] + ", ");
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1714_UseComboBoxAndJList();
		frame.setTitle("Exercise17_14");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
