/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author jslapnicka
 * @Date & @Time 26. 9. 2014 2014 12:51:06 
 */
@SuppressWarnings("serial")
public class PE1709_LabelProperties extends JFrame {

	/**
	 * @param args
	 */

	
	// Create ImageIcon
	ImageIcon imageGrapes = new ImageIcon("C:/Java/site/image/grapes.gif");
	// Create JLabel for image icon
	JButton jbtGrapes = new JButton(imageGrapes);
	
	// Create JLabels for Vertical/Horizontal description
	JLabel jlblHortAli = new JLabel("Horizontal");
	JLabel jlblVertAli = new JLabel("Vertical");
	JLabel jlblHortTxt = new JLabel("Horizontal");
	JLabel jlblVertTxt = new JLabel("Vertical");
	// Create ComboBoxes
	@SuppressWarnings("rawtypes")
	JComboBox jcbHortAli = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox jcbVertAli = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox jcbHortText = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox jcbVertText = new JComboBox();
	
	// Create TitledBorders
	TitledBorder hortAliBorder = new TitledBorder("Horizontal Alignment");
	TitledBorder txtPosBorder = new TitledBorder("Text Position");
	// Create LineBorder
	LineBorder lineBorder = new LineBorder(Color.BLACK);
	
	@SuppressWarnings("unchecked")
	public PE1709_LabelProperties() {
		// TODO Auto-generated constructor stub
		// Add text to the label with image
		jbtGrapes.setText("Grapes");
		jbtGrapes.setVerticalAlignment(JButton.CENTER);
		jbtGrapes.setHorizontalAlignment(JButton.CENTER);
		jbtGrapes.setVerticalTextPosition(JButton.CENTER);
		jbtGrapes.setHorizontalTextPosition(JButton.CENTER);
		// Set up ComboBoxes
		String[] horizontalCoordinations = {"CENTER", "LEFT", "RIGHT"};
		for (int i = 0; i < horizontalCoordinations.length; i++) {
			jcbHortAli.addItem(horizontalCoordinations[i]);
			jcbHortText.addItem(horizontalCoordinations[i]);
		}
		String[] verticalCoordinations = {"CENTER", "TOP", "BOTTOM",};
		for (int i = 0; i < verticalCoordinations.length; i++) {
			jcbVertAli.addItem(verticalCoordinations[i]);
			jcbVertText.addItem(verticalCoordinations[i]);
		}
		
		// Create a JPanel for the image label
		JPanel jpImage = new JPanel(new BorderLayout());
		jpImage.add(jbtGrapes, "Center");
		// Create a panel for hort/vert labels
		JPanel jpHortVertLabelsAli = new JPanel(new GridLayout(2, 1));
		jpHortVertLabelsAli.add(jlblHortAli);
		jpHortVertLabelsAli.add(jlblVertAli);
		jpHortVertLabelsAli.setBorder(lineBorder);
		JPanel jpHortVertLabelsTxt = new JPanel(new GridLayout(2, 1));
		jpHortVertLabelsTxt.add(jlblHortTxt);
		jpHortVertLabelsTxt.add(jlblVertTxt);
		jpHortVertLabelsTxt.setBorder(lineBorder);
		
		// Create a panel for hort/vert combo boxes for alignment
		JPanel jpHortVertComboBoxesAli = new JPanel(new GridLayout(2, 1));
		jpHortVertComboBoxesAli.add(jcbHortAli);
		jpHortVertComboBoxesAli.add(jcbVertAli);
		jpHortVertComboBoxesAli.setBorder(lineBorder);
		
		// Create a panel for hort/vert combo boxes for text position
		JPanel jpHortVertComboBoxesTxt = new JPanel(new GridLayout(2, 1));
		jpHortVertComboBoxesTxt.add(jcbHortText);
		jpHortVertComboBoxesTxt.add(jcbVertText);
		jpHortVertComboBoxesTxt.setBorder(lineBorder);
		
		// Create panel for horizontal alignment
		JPanel jpAlignment = new JPanel(new BorderLayout(2, 2));
		jpAlignment.add(jpHortVertLabelsAli, BorderLayout.CENTER);
		jpAlignment.add(jpHortVertComboBoxesAli, BorderLayout.EAST);
		jpAlignment.setBorder(hortAliBorder);
		
		// Create panel for text position
		JPanel jpTextPos = new JPanel(new BorderLayout(2, 2));
		jpTextPos.add(jpHortVertLabelsTxt, BorderLayout.CENTER);
		jpTextPos.add(jpHortVertComboBoxesTxt, BorderLayout.EAST);
		jpTextPos.setBorder(txtPosBorder);
		
		// Create panel for toolbar
		JPanel jpToolBar = new JPanel(new GridLayout(1, 2, 2, 2));
		jpToolBar.add(jpAlignment);
		jpToolBar.add(jpTextPos);
		
		// Register listeners
		jcbHortAli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				switch (jcbHortAli.getSelectedIndex()) {
				case 0: jbtGrapes.setHorizontalAlignment(JButton.CENTER); break;
				case 1: jbtGrapes.setHorizontalAlignment(JButton.LEFT); break;
				case 2: jbtGrapes.setHorizontalAlignment(JButton.RIGHT); break;
				}
			
			}
		});
		jcbHortText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (jcbHortText.getSelectedIndex()) {
				case 0: jbtGrapes.setHorizontalTextPosition(JButton.CENTER); break;
				case 1: jbtGrapes.setHorizontalTextPosition(JButton.LEFT); break;
				case 2: jbtGrapes.setHorizontalTextPosition(JButton.RIGHT); break;
				}
			}
		});
		jcbVertAli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (jcbVertAli.getSelectedIndex()) {
				case 0: jbtGrapes.setVerticalAlignment(JButton.CENTER); break;
				case 1: jbtGrapes.setVerticalAlignment(JButton.TOP); break;
				case 2: jbtGrapes.setVerticalAlignment(JButton.BOTTOM); break;
				}
			}
		});
		jcbVertText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (jcbVertText.getSelectedIndex()) {
				case 0: jbtGrapes.setVerticalTextPosition(JButton.CENTER); break;
				case 1: jbtGrapes.setVerticalTextPosition(JButton.TOP); break;
				case 2: jbtGrapes.setVerticalTextPosition(JButton.BOTTOM); break;
				}
			}
		});
		
		// Add panels to the frame
		setLayout(new BorderLayout(2, 2));
		add(jpImage, BorderLayout.CENTER);
		add(jpToolBar, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1709_LabelProperties();
		frame.setTitle("Exercise17_09");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
