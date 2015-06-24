/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author jslapnicka
 * @Date & @Time 25. 9. 2014 2014 9:57:15 
 */
public class L1708_MultipleWindowsDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	
	private JTextArea jta;
	private JButton jbtShowHistogram = new JButton("Show Histogram");
	private L1709_Histogram histogram = new L1709_Histogram();
	
	// Create a new frame to hold the histogram panel
	private JFrame histogramFrame = new JFrame();
	
	public L1708_MultipleWindowsDemo() {
		// TODO Auto-generated constructor stub
		// Store text area in a scroll pane
		JScrollPane scrollPane = new JScrollPane(jta = new JTextArea());
		scrollPane.setPreferredSize(new Dimension(300, 200));
		jta.setWrapStyleWord(true);
		jta.setLineWrap(true);
		
		// Place scroll pane and button in the frame
		add(scrollPane, BorderLayout.CENTER);
		add(jbtShowHistogram, BorderLayout.SOUTH);
		
		// Register listeners
		jbtShowHistogram.addActionListener(new ActionListener() {
			
			@Override /** Handle the button action */
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Count the letters in the text area
				int[] count = countLetters();
				
				// Set the letter count to histogram for display
				histogram.showHistogram(count);
				
				// Show the frame
				histogramFrame.setVisible(true);
			}
		});
		
		// Add the histogram panel to the frame
		histogramFrame.add(histogram);
		histogramFrame.pack();
		histogramFrame.setTitle("Histogram");
	}
	
	private int[] countLetters() {
		// Count for 26 letters
		int[] count = new int[26];
		
		// Get contents from the text area
		String text = jta.getText();
		
		// Count occurrences of each letter (case insensitive)
		for (int i = 0; i < text.length(); i++) {
			char character = text.charAt(i);
			
			if (character >= 'A' && character <= 'Z') {
				count[character - 'A']++;
			}
			else if (character >= 'a' && character <= 'z') {
				count[character - 'a']++;
			}
		}
		
		return count; // Return the count array
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1708_MultipleWindowsDemo frame = new L1708_MultipleWindowsDemo();
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MultipleWindowsDemo");
		frame.setVisible(true);
	}

}
