/**
 * 
 */
package chapter22;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jslapnicka
 * @Date & @Time 11. 12. 2014 2014 12:53:26 
 */
@SuppressWarnings("serial")
public class PE2202_StoreNumbersInLinkedList extends JFrame {

	private JButton jbtSort = new JButton("Sort");
	private JButton jbtShuffle = new JButton("Shuffle");
	private JButton jbtReverse = new JButton("Reverse");
	
	private JLabel jlblNumber = new JLabel("Enter a number: ");
	private JTextField jtfNumber = new JTextField(8);
	
	private JTextArea jtaResult = new JTextArea();
	
	private LinkedList<Integer> numbers = new LinkedList<Integer>();
	private Integer number = new Integer(0);
	
	public PE2202_StoreNumbersInLinkedList() {
		// TODO Auto-generated constructor stub
		JPanel jpNumber = new JPanel();
		jpNumber.add(jlblNumber);
		jpNumber.add(jtfNumber);
		
		JPanel jpSettings = new JPanel();
		jpSettings.add(jbtSort);
		jpSettings.add(jbtShuffle);
		jpSettings.add(jbtReverse);
		
		add(jpNumber, BorderLayout.NORTH);
		add(jtaResult, BorderLayout.CENTER);
		add(jpSettings, BorderLayout.SOUTH);
		
		// Register listener
		jtfNumber.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = jtfNumber.getText();
				// Works only for integers
				if (!numbers.contains(number = new Integer(input)))
					numbers.add(number);
				jtaResult.setText(PE2202_StoreNumbersInLinkedList.toString(numbers));
			}
		});
		
		jbtSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Collections.sort(numbers);
				jtaResult.setText(PE2202_StoreNumbersInLinkedList.toString(numbers));
			}
		});
		
		jbtShuffle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Collections.shuffle(numbers);
				jtaResult.setText(PE2202_StoreNumbersInLinkedList.toString(numbers));
			}
		});
		
		jbtReverse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Collections.reverse(numbers);
				jtaResult.setText(PE2202_StoreNumbersInLinkedList.toString(numbers));
			}
		});
	}
	
		
	public static <E> String toString(LinkedList<E> numbers) {
		String result = "";
		for (E temp: numbers)
			result += temp + " ";
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE2202_StoreNumbersInLinkedList();
		frame.setTitle("Exercise22_02");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
