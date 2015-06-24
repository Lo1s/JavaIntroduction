/**
 * 
 */
package chapter12;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author jslapnicka
 * @Date & @Time 24. 7. 2014 2014 11:22:43 
 */
public class PE1201_FlowLayoutManager extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PE1201_FlowLayoutManager() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		JButton jbt1 = new JButton("Button 1");
		JButton jbt2 = new JButton("Button 2");
		JButton jbt3 = new JButton("Button 3");
		p1.add(jbt1);
		p1.add(jbt2);
		p1.add(jbt3);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		JButton jbt4 = new JButton("Button 4");
		JButton jbt5 = new JButton("Button 5");
		JButton jbt6 = new JButton("Button 6");
		p2.add(jbt4);
		p2.add(jbt5);
		p2.add(jbt6);
		
		add(p1);
		add(p2);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1201_FlowLayoutManager();
		frame.setTitle("PE1201_FlowLayoutManager");
		frame.setSize(400, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
