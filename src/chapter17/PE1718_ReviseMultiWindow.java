/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author jslapnicka
 * @Date & @Time 3. 10. 2014 2014 8:40:42 
 */
@SuppressWarnings("serial")
public class PE1718_ReviseMultiWindow extends JFrame {

	private JTextArea jta;
	private JButton jbtShowHistogram = new JButton("Show Histogram");
	private BarChart barChart = new BarChart();

	// Create a new frame to hold the histogram panel
	private JFrame barChartFrame = new JFrame();

	public PE1718_ReviseMultiWindow() {
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
				barChart.showBarChart(count);

				// Show the frame
				barChartFrame.setVisible(true);
			}
		});

		// Add the histogram panel to the frame
		barChartFrame.add(barChart);
		barChartFrame.setSize(300, 600);
		barChartFrame.setTitle("Histogram");
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

	class BarChart extends JPanel {
		int count[];


		public void showBarChart(int[] count) {
			this.count = count;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {

			int interval = 0;
			super.paintComponent(g);

			// Draw line
			g.drawLine(10, getHeight() - 20, getWidth() - 10, getHeight() - 20);

			for (int i = 0; i < count.length; i++) {
				int top = getHeight() - 20 - count[i] * 4;
				// Draw rectangle
				g.drawRect(15 + interval, top, 5, getHeight() - 20 - top);

				// Draw letters
				g.drawString((char)(65 + i) + "", 15 + interval, top - 20);
				// Draw count
				g.drawString("(" + count[i] + ")", 10 + interval, top - 40);
				interval += 10;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1718_ReviseMultiWindow frame = new PE1718_ReviseMultiWindow();
		frame.setTitle("Excercise17_18");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MultipleWindowsDemo");
		frame.setVisible(true);
	}

}