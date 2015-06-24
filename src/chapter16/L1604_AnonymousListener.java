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
 * @Date & @Time 9. 9. 2014 2014 13:54:15 
 */
@SuppressWarnings("serial")
public class L1604_AnonymousListener extends JFrame {

	/**
	 * @param args
	 */

	public L1604_AnonymousListener() {

		// Create four buttons
		JButton jbtNew = new JButton("New");
		JButton jbtOpen = new JButton("Open");
		JButton jbtSave = new JButton("Save");
		JButton jbtPrint = new JButton("Print");

		// Create panel to hold buttons
		JPanel panel = new JPanel();
		panel.add(jbtNew);
		panel.add(jbtOpen);
		panel.add(jbtSave);
		panel.add(jbtPrint);

		add(panel);

		// Create and register anonymous inner-class listener
		jbtNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process New");
			}
		});

		jbtOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Open");
			}
		});

		jbtSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Save");
			}
		});

		jbtPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Print");
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new L1604_AnonymousListener();
		frame.setTitle("Listing 16.4");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
