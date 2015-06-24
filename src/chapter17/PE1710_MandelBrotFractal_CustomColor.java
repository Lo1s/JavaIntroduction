/**
 * 
 */
package chapter17;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chapter15.PE1520_MandelbrotFractal;

/**
 * @author jslapnicka
 * @Date & @Time 29. 9. 2014 2014 8:44:18 
 */
@SuppressWarnings("serial")
public class PE1710_MandelBrotFractal_CustomColor extends JFrame {

	/**
	 * @param args
	 */
	
	// Create a MandelBrot panel
	PE1520_MandelbrotFractal mainClass = new PE1520_MandelbrotFractal();
	PE1520_MandelbrotFractal.MandelbrotCanvas mandelBrot = mainClass.new MandelbrotCanvas();
	
	// Create JLabels
	JLabel jlblRed = new JLabel("Red Factor:");
	JLabel jlblGreen = new JLabel("Green Factor:");
	JLabel jlblBlue = new JLabel("Blue Factor:");
	
	// Create JTextFields
	JTextField jtfRed = new JTextField(2);
	JTextField jtfGreen = new JTextField(2);
	JTextField jtfBlue = new JTextField(2);
	
	public PE1710_MandelBrotFractal_CustomColor() {
		// TODO Auto-generated constructor stub
		// Create panel for color customization and add JTextFields to it
		JPanel jpToolbar = new JPanel(new GridLayout(1, 6));
		jpToolbar.add(jlblRed);
		jpToolbar.add(jtfRed);
		jpToolbar.add(jlblGreen);
		jpToolbar.add(jtfGreen);
		jpToolbar.add(jlblBlue);
		jpToolbar.add(jtfBlue);
		
		// Register listeners
		jtfRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer redColor = new Integer(jtfRed.getText());
				mandelBrot.setRedColor(redColor);
				repaint();
			}
		});
		jtfGreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Integer greenColor = new Integer(jtfGreen.getText());
				mandelBrot.setGreenColor(greenColor);
				repaint();
			}
		});
		jtfBlue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer blueColor = new Integer(jtfBlue.getText());
				mandelBrot.setBlueColor(blueColor);
				repaint();
			}
		});
		
		// Add paneld into the frame
		add(mandelBrot, BorderLayout.CENTER);
		add(jpToolbar, BorderLayout.SOUTH);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1710_MandelBrotFractal_CustomColor();
		frame.setTitle("Exercise17_10");
		frame.setSize(450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
