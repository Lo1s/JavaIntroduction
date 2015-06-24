/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;


/**
 * @author jslapnicka
 * @Date & @Time 3. 10. 2014 2014 12:04:56 
 */
@SuppressWarnings("serial")
public class PE1720_SlideShow extends JFrame {

	
	JTextArea jtaSlides = new JTextArea();
	Scanner input;
	
	public PE1720_SlideShow() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		add(jtaSlides, BorderLayout.CENTER);
		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
	}
	
	class TimerListener implements ActionListener {
		int slide = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			input = new Scanner(new File("C:/Java/site/textfiles/slide" + slide + ".txt"));
			StringBuilder builder = new StringBuilder();
			while (input.hasNextLine()) {
				builder.append(input.nextLine() + "\n");
			}
			jtaSlides.setText(builder.toString());
			slide++;
			}
			catch (FileNotFoundException ex) {
				System.out.println("File not found !");
			}
			
			if (slide == 9)
				slide = 0;
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JFrame frame = new PE1720_SlideShow();
		frame.setTitle("Exercise16_13");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
