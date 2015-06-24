/**
 * 
 */
package chapter12;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 23. 7. 2014 2014 14:19:42 
 */
public class L1206_TestPanels extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public L1206_TestPanels() {
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		
		for (int i = 1; i <= 9; i++) {
			p1.add(new JButton("" + i));
		}
		
		p1.add(new JButton("" + 0));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(new JTextField("Time to be displayed here"), BorderLayout.NORTH);
		p2.add(p1, BorderLayout.CENTER);
		
		add(p2, BorderLayout.EAST);
		add(new JButton("Food to be placed here"), BorderLayout.CENTER);
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1206_TestPanels frame = new L1206_TestPanels();
		
		frame.setTitle("The Front View of a Microwave Oven");
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
