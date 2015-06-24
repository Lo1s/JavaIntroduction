/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author jslapnicka
 * @Date & @Time 24. 9. 2014 2014 14:31:24 
 */
@SuppressWarnings("serial")
public class L1702_DescriptionPanel extends JPanel {

	/** Label for displaying an image icon and a title */
	private JLabel jlblImageTitle = new JLabel();
	
	/** Text area for displaying text */
	private JTextArea jtaDescription = new JTextArea();
	
	public L1702_DescriptionPanel() {
		// TODO Auto-generated constructor stub
		jlblImageTitle.setHorizontalAlignment(JLabel.CENTER);
		jlblImageTitle.setHorizontalTextPosition(JLabel.CENTER);
		jlblImageTitle.setVerticalTextPosition(JLabel.BOTTOM);
		
		// Set the font in the label and the text field
		jlblImageTitle.setFont(new Font("Serif", Font.BOLD, 16));
		jtaDescription.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		// Set lineWrap and wrapStyleWord true for text area
		jtaDescription.setLineWrap(true);
		jtaDescription.setWrapStyleWord(true);
		jtaDescription.setEditable(false);
		
		// Create a scroll pane to hold the text area
		JScrollPane scrollPane = new JScrollPane(jtaDescription);
		
		// Set BorderLayout for the panel, add label and scroll pane
		setLayout(new BorderLayout(5, 5));
		add(scrollPane, BorderLayout.CENTER);
		add(jlblImageTitle, BorderLayout.WEST);
		
	}
	
	/** Set the title */
	public void setTitle(String title) {
		jlblImageTitle.setText(title);
	}
	
	/** Set the icon */
	public void setImageIcon(ImageIcon icon) {
		jlblImageTitle.setIcon(icon);
	}
	
	/** Set the text description */
	public void setDescription(String text) {
		jtaDescription.setText(text);
	}
		
}
