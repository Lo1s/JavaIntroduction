/**
 * 
 */
package chapter22;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author hydRa
 * @Date & @Time 18. 12. 2014 2014 12:33:02 
 */
@SuppressWarnings("serial")
public class PE2213_24PointGame extends JFrame {

	private JButton jbtRefresh = new JButton("Refresh");
	private JButton jbtVerify = new JButton("Verify");
	private JLabel jlblExpression = new JLabel("Enter an expression:");
	private JTextField jtfExpression = new JTextField(7);
	private int card1;
	private int card2;
	private int card3;
	private int card4;
	private ImageIcon card1Image;
	private ImageIcon card2Image;
	private ImageIcon card3Image;
	private ImageIcon card4Image;
	private JPanel jpCards = new JPanel();
	private ArrayList<Integer> inputNumbers = new ArrayList<Integer>();
	private ArrayList<Integer> cardsNumbers = new ArrayList<Integer>();

	public PE2213_24PointGame() {
		// TODO Auto-generated constructor stub
		refresh();		
		JPanel jpRefresh = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jpRefresh.add(jbtRefresh);
		
		
		JPanel jpExpression = new JPanel();
		jpExpression.add(jlblExpression);
		jpExpression.add(jtfExpression);
		jpExpression.add(jbtVerify);
		
		// Register listeners
		jbtRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		
		jbtVerify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int evaluate = evaluateExpression(jtfExpression.getText());
				System.out.println(inputNumbers);
				System.out.println(cardsNumbers);
				Collections.sort(inputNumbers);
				Collections.sort(cardsNumbers);
				
				if (inputNumbers.equals(cardsNumbers)) {
					if (evaluate == 24)
						JOptionPane.showMessageDialog(null, "Correct result");
					else
						JOptionPane.showMessageDialog(null, "Incorrect result");
				} else
					JOptionPane.showMessageDialog(null, "The numbers in the expression don't match\n the numbers in the set !", 
							"Input expression does not match !", JOptionPane.INFORMATION_MESSAGE);					
			}
		});
		
		add(jpRefresh, BorderLayout.NORTH);
		add(jpCards, BorderLayout.CENTER);
		add(jpExpression, BorderLayout.SOUTH);
	}

	public void refresh() {
		jpCards.removeAll();
		
		card1 = 1 + (int)(Math.random() * (52 + 1) - 1);
		card2 = 1 + (int)(Math.random() * (52 + 1) - 1);
		card3 = 1 + (int)(Math.random() * (52 + 1) - 1);
		card4 = 1 + (int)(Math.random() * (52 + 1) - 1);
		
		card1Image = new ImageIcon("C:/Java/site/image/card/" + card1 + ".png");
		card2Image = new ImageIcon("C:/Java/site/image/card/" + card2 + ".png");
		card3Image = new ImageIcon("C:/Java/site/image/card/" + card3 + ".png");
		card4Image = new ImageIcon("C:/Java/site/image/card/" + card4 + ".png");
		
		jpCards.add(new JLabel(card1Image));
		jpCards.add(new JLabel(card2Image));
		jpCards.add(new JLabel(card3Image));
		jpCards.add(new JLabel(card4Image));
		
		cardsNumbers.clear();
		cardsNumbers.add(card1 % 13 == 0 ? 13 : card1 % 13);
		cardsNumbers.add(card2 % 13 == 0 ? 13 : card2 % 13);
		cardsNumbers.add(card3 % 13 == 0 ? 13 : card3 % 13);
		cardsNumbers.add(card4 % 13 == 0 ? 13 : card4 % 13);
		
		jpCards.revalidate();
		repaint();
	}
	
	/** Evaluate an expression */
	public int evaluateExpression(String expression) {
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<Integer>();
		// Create operatorStack to store operators
		Stack<Character> operatorStack = new Stack<Character>();

		// Insert blanks around (, ), +, -, * and /
		expression = insertBlanks(expression);

		// Extract operands & operators
		String[] tokens = expression.split(" ");
		// Phase 1: Scan tokens
		for (String token: tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				// Process all +, -, *, / in the top of the operator stack
				while (!operatorStack.isEmpty() &&
						(operatorStack.peek() == '+' ||
						operatorStack.peek() == '-' ||
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				
				// Push the '+' or '-' into operator stack
				operatorStack.push(token.charAt(0));
			}
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				// Process all *, / in the top of the operator stack
				while (!operatorStack.isEmpty() &&
						(operatorStack.peek() == '*' ||
						operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				
				// Push the '*' or '/' into the operator stack
				operatorStack.push(token.charAt(0));
			}
			
			else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			}
			else if (token.trim().charAt(0) == ')') {
				// Process all operators in the stack until seeing '('
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				
				operatorStack.pop(); // Pop the '(' symbol from the stack
			}
			else { // An operand scanned
				// Push an operand to the stack
				operandStack.push(new Integer(token));
				inputNumbers.add(new Integer(token));
			}
		}
		
		// Phase 2: Process all the remaining operators in the stack
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		
		// Return the result
		return operandStack.pop();
	}

	/** Process one operator: Take an operator from the operatorStack and
	 * apply it on the operands in the operandStack 
	 * @param operandStack
	 * @param operatorStack
	 */
	public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+') {
			operandStack.push(op2 + op1);
		} else if (op == '-') {
			operandStack.push(op2 - op1);
		} else if (op == '*') {
			operandStack.push(op2 * op1);
		} else if (op == '/') {
			operandStack.push(op2 / op1);
		}
	}

	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
					s.charAt(i) == '+' || s.charAt(i) == '-' ||
					s.charAt(i) == '*' || s.charAt(i) == '/')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new PE2213_24PointGame();
		frame.setTitle("Exercise22_13");
		frame.setSize(350, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
