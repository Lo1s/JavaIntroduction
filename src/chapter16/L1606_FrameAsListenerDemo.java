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
 * @Date & @Time 9. 9. 2014 2014 14:38:40 
 */
@SuppressWarnings("serial")
public class L1606_FrameAsListenerDemo extends JFrame implements ActionListener {

	private JButton jbtNew = new JButton("New");
	private JButton jbtOpen = new JButton("Open");
	private JButton jbtSave = new JButton("Save");
	private JButton jbtPrint = new JButton("Print");
	
	public L1606_FrameAsListenerDemo() {
		
		JPanel panel = new JPanel();
		panel.add(jbtNew);
		panel.add(jbtOpen);
		panel.add(jbtSave);
		panel.add(jbtPrint);
		
		add(panel);
		
		// Register listeners with buttons
		jbtNew.addActionListener(this);
		jbtOpen.addActionListener(this);
		jbtSave.addActionListener(this);
		jbtPrint.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtNew)
			System.out.println("Process New");
		else if (e.getSource() == jbtOpen)
			System.out.println("Process Open");
		else if (e.getSource() == jbtSave)
			System.out.println("Process Save");
		else if (e.getSource() == jbtPrint)
			System.out.println("Process Print");
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new L1606_FrameAsListenerDemo();
		frame.setTitle("Listing 16.6");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
