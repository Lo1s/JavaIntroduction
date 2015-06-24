/**
 * 
 */
package chapter16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author jslapnicka
 * @Date & @Time 22. 9. 2014 2014 10:10:06 
 */
@SuppressWarnings("serial")
public class PE1640_Random01 extends JFrame {

	/**
	 * @param args
	 */
	
	JButton jbtRefresh = new JButton("Refresh");
	JPanel panel = new JPanel(new GridLayout(10, 10));
	
	public PE1640_Random01() {
		// TODO Auto-generated constructor stub
		add(jbtRefresh, BorderLayout.SOUTH);
		
		jbtRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				for (int i = 0; i < 100; i++) {
					JLabel label = new JLabel(hdR.mtd.getRandomNumber(0, 1) + "");
					label.setHorizontalTextPosition(JLabel.CENTER);
					label.setVerticalTextPosition(JLabel.CENTER);
					label.setHorizontalAlignment(JLabel.CENTER);
					panel.add(label);
				}
				panel.revalidate();
			}
		});
		LineBorder border = new LineBorder(Color.BLACK);
		panel.setBorder(border);
		add(panel);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE1640_Random01();
		frame.setTitle("Exercise16_40");
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
