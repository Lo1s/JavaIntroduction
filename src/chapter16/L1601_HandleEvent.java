/**
 * 
 */
package chapter16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 9. 9. 2014 2014 10:18:00 
 */
@SuppressWarnings("serial")
public class L1601_HandleEvent extends JFrame {

	/**
	 * @param args
	 */
	
	public L1601_HandleEvent() {
		// Create two buttons
		JButton jbtOK = new JButton("OK");
		JButton jbtCancel = new JButton("Cancel");
		
		// Create a panel to hold buttons
		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		
		add(panel); // Add panel to the frame
		
		// Register listeners
		OKListenerClass listener1 = new OKListenerClass();
		CancelListenerClass listener2 = new CancelListenerClass();
		jbtOK.addActionListener(listener1);
		jbtCancel.addActionListener(listener2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1601_HandleEvent();
		frame.setTitle("Listing 16.1");
		frame.setSize(200, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class OKListenerClass implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK button clicked !");
	}
}

class CancelListenerClass implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cancel button clicked !");
	}
}
