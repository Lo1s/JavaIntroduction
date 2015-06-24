/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;





import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author jslapnicka
 * @Date & @Time 24. 9. 2014 2014 14:52:08 
 */
@SuppressWarnings("serial")
public class L1703_TextAreaDemo extends JFrame {

	private L1702_DescriptionPanel descriptionPanel = new L1702_DescriptionPanel();
		
	public L1703_TextAreaDemo() {
		// TODO Auto-generated constructor stub
		descriptionPanel.setTitle("Canada");
		String description = "The Canadian national flag...";
		descriptionPanel.setImageIcon(new ImageIcon("C:/Java/site/image/ca.gif"));
		descriptionPanel.setDescription(description);
		
		setLayout(new BorderLayout());
		add(descriptionPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1703_TextAreaDemo frame = new L1703_TextAreaDemo();
		frame.pack();
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TextAreaDemo");
		frame.setVisible(true);
		
	}

}
