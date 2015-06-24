/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import chapter13.L1308_MessagePanel;

/**
 * @author jslapnicka
 * @Date & @Time 26. 9. 2014 2014 10:00:44 
 */
@SuppressWarnings("serial")
public class PE1708_SelectFont extends JFrame {

	/**
	 * @param args
	 */

	// Create JLabels
	JLabel jlblFontName = new JLabel("Font Name");
	JLabel jlblFontSize = new JLabel("Font Size");

	// Create ComboBoxes
	@SuppressWarnings("rawtypes")
	JComboBox jcbFontName = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox jcbFontSize = new JComboBox();

	// Create Message Panel
	L1308_MessagePanel messagePanel = new L1308_MessagePanel();

	// Create JCheckBoxes
	JCheckBox jchkbCentered = new JCheckBox("Centered");
	JCheckBox jchkbBold = new JCheckBox("Bold");
	JCheckBox jchkbItalic = new JCheckBox("Italic");

	// Create Graphics Environment for the fonts
	GraphicsEnvironment gE = GraphicsEnvironment.getLocalGraphicsEnvironment();
	// Get Font names and styles
	String[] fontNames = gE.getAvailableFontFamilyNames();
	Font[] fontStyles = gE.getAllFonts();

	@SuppressWarnings("unchecked")
	public PE1708_SelectFont() {
		// TODO Auto-generated constructor stub
		messagePanel.setBackground(Color.WHITE);
		// Create a line border
		LineBorder lineBorder = new LineBorder(Color.BLACK);

		// Set up labels
		jlblFontName.setHorizontalTextPosition(JLabel.LEFT);
		jlblFontName.setVerticalTextPosition(JLabel.CENTER);
		jlblFontSize.setHorizontalTextPosition(JLabel.LEFT);
		jlblFontSize.setVerticalTextPosition(JLabel.CENTER);

		// Set up check boxes
		jchkbCentered.setMnemonic('C');
		jchkbBold.setMnemonic('B');
		jchkbItalic.setMnemonic('I');

		// Set up Combo Boxes
		/** Set font names */
		for (int i = 0; i < fontNames.length; i++) {
			jcbFontName.addItem(fontNames[i]);
		}
		/** Set font sizes */
		for (int i = 1; i <= 100; i++)
			jcbFontSize.addItem(i);
		jcbFontSize.setSelectedIndex(19);
		messagePanel.setFontSize(jcbFontSize.getSelectedIndex());

		// Create a panel for Font name
		JPanel jpFontName = new JPanel(new BorderLayout(2, 2));
		jpFontName.add(jlblFontName, BorderLayout.WEST);
		jpFontName.add(jcbFontName, BorderLayout.EAST);
		jpFontName.setBorder(lineBorder);

		// Create a panel for Font size
		JPanel jpFontSize = new JPanel(new BorderLayout(2, 2));
		jpFontSize.add(jlblFontSize, BorderLayout.WEST);
		jpFontSize.add(jcbFontSize, BorderLayout.EAST);
		jpFontSize.setBorder(lineBorder);

		// Create a panel for Font style toolbar
		JPanel jpFontStyle = new JPanel(new BorderLayout(2, 2));
		jpFontStyle.add(jpFontName, BorderLayout.WEST);
		jpFontStyle.add(jpFontSize, BorderLayout.EAST);
		jpFontStyle.setBorder(lineBorder);

		// Create a panel for the check boxes
		JPanel jpCheckBoxes = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		jpCheckBoxes.add(jchkbCentered);
		jpCheckBoxes.add(jchkbBold);
		jpCheckBoxes.add(jchkbItalic);

		// Register listeners
		jcbFontName.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = jcbFontName.getSelectedIndex();
				messagePanel.setFontName(fontStyles[index].getName());
				messagePanel.repaint();
			}
		});
		jcbFontSize.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				messagePanel.setFontSize(jcbFontSize.getSelectedIndex() - 1);
				messagePanel.repaint();
			}
		});
		jchkbCentered.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jchkbCentered.isSelected())
					messagePanel.setCentered(true);
				else
					messagePanel.setCentered(false);
				messagePanel.repaint();					
			}
		});
		jchkbBold.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (jchkbBold.isSelected())
					messagePanel.setFontStyle(Font.BOLD);
				else
					messagePanel.setFontStyle(-Font.BOLD);
				messagePanel.repaint();
			}
		});
		jchkbItalic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jchkbItalic.isSelected())
					messagePanel.setFontStyle(Font.ITALIC);
				else
					messagePanel.setFontStyle(-Font.ITALIC);
				repaint();
			}
		});

		// Add panels to the frame
		add(jpFontStyle, BorderLayout.NORTH);
		add(messagePanel, BorderLayout.CENTER);
		add(jpCheckBoxes, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1708_SelectFont();
		frame.setTitle("Exercise17_08");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
