/**
 * 
 */
package chapter16;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author jslapnicka
 * @Date & @Time 11. 9. 2014 2014 7:50:37 
 */
@SuppressWarnings("serial")
public class PE1602_Buttons extends JFrame {
	JButton jbt1 = new JButton("Button 1");
	JButton jbt2 = new JButton("Button 2");
	JButton jbt3 = new JButton("Button 3");
	JButton jbt4 = new JButton("Button 4");
	JButton jbt5 = new JButton("Button 5");
	JButton jbt6 = new JButton("Button 6");
	
	public PE1602_Buttons() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(jbt1);
		p1.add(jbt2);
		p1.add(jbt3);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(jbt4);
		p2.add(jbt5);
		p2.add(jbt6);
		
		add(p1);
		add(p2);
		
		ButtonListener listener = new ButtonListener();
		jbt1.addActionListener(listener);
		jbt2.addActionListener(listener);
		jbt3.addActionListener(listener);
		jbt4.addActionListener(listener);
		jbt5.addActionListener(listener);
		jbt6.addActionListener(listener);
		
	}
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbt1)
				System.out.println("Button1 pressed !");
			else if (e.getSource() == jbt2)
				System.out.println("Button2 pressed !");
			else if (e.getSource() == jbt3)
				System.out.println("Button3 pressed !");
			else if (e.getSource() == jbt4)
				System.out.println("Button4 pressed !");
			else if (e.getSource() == jbt5)
				System.out.println("Button5 pressed !");
			else if (e.getSource() == jbt6)
				System.out.println("Button6 pressed !");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1602_Buttons();
		frame.setTitle("PE1201_FlowLayoutManager");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
