/**
 * 
 */
package chapter18;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author jslapnicka
 * @Date & @Time 7. 10. 2014 2014 11:12:15 
 */
@SuppressWarnings("serial")
public class PE1803_GuessCapitals extends JApplet {

	// Correct/Total UI components
	TitledBorder countTitledBorder = new TitledBorder("correct/total count");
	JLabel jlblCount = new JLabel();

	// State/Capital UI components
	TitledBorder guessTitledBorder = new TitledBorder("Guess state or capital");
	JRadioButton jrbState = new JRadioButton("State");
	JRadioButton jrbCapital = new JRadioButton("Capital");

	// Order of questions UI
	TitledBorder orderTitledBorder = new TitledBorder("Order of questions ?");
	JRadioButton jrbSequential = new JRadioButton("Sequential");
	JRadioButton jrbRandom = new JRadioButton("Random");

	// Question & Answer UI
	JLabel jlblQuestion = new JLabel();
	JTextField jtfAnswer = new JTextField(20);
	JButton jbtAnswer = new JButton("Answer");

	// Scanner for input and data field
	private Scanner input;
	private int correct = 0;
	private int total = 0;
	private String answer;
	private boolean setCapital = true;
	private boolean isSequential = true;
	ArrayList<String> states = new ArrayList<String>();
	ArrayList<String> capitals = new ArrayList<String>();

	public PE1803_GuessCapitals() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		// Read the data from the input file
		URL url = getClass().getResource("input/PE917-input.txt");
		input = new Scanner(url.openStream());
		while (input.hasNext()) {
			states.add(input.next().replace('_', ' '));
			capitals.add(input.next().replace('_', ' '));
		}

		// Create a button group for radio buttons
		ButtonGroup groupGuess = new ButtonGroup();
		groupGuess.add(jrbState);
		groupGuess.add(jrbCapital);
		ButtonGroup groupOrder = new ButtonGroup();
		groupOrder.add(jrbSequential);
		groupOrder.add(jrbRandom);

		// Create panels and set up items in option bar
		jlblCount.setText(correct + " / " + total);
		jlblCount.setVerticalTextPosition(JLabel.BOTTOM);
		jlblCount.setVerticalAlignment(JLabel.CENTER);
		jlblCount.setBorder(countTitledBorder);

		JPanel jpStateCapital = new JPanel(new GridLayout(2, 1));
		jpStateCapital.add(jrbState);
		jpStateCapital.add(jrbCapital);
		jpStateCapital.setBorder(guessTitledBorder);

		JPanel jpOrder = new JPanel(new GridLayout(2, 1));
		jpOrder.add(jrbSequential);
		jpOrder.add(jrbRandom);
		jpOrder.setBorder(orderTitledBorder);

		// Create panel and set up question/answer bar
		JPanel jpInput = new JPanel(new BorderLayout());
		jpInput.add(jlblQuestion, BorderLayout.NORTH);
		jpInput.add(jtfAnswer, BorderLayout.CENTER);
		jpInput.add(jbtAnswer, BorderLayout.EAST);

		// Default settings
		jrbCapital.setSelected(true);
		jrbSequential.setSelected(true);
		jlblQuestion.setText("What is the capital of " + states.get(total) + " ?");

		// Register listeners
		jbtAnswer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				answer = jtfAnswer.getText();
				if (answer.equals(states.get(total)) || answer.equals(capitals.get(total))) {
					correct++;
					JOptionPane.showMessageDialog(null, "Your answer is correct", "Message", JOptionPane.INFORMATION_MESSAGE);
				} else if (!answer.equals(capitals.get(total)) && setCapital) {
					JOptionPane.showMessageDialog(null, "The capital of " + states.get(total) + " should be " + capitals.get(total));
				} else if (!answer.equals(capitals.get(total)) && !setCapital) {
					JOptionPane.showMessageDialog(null, capitals.get(total) + " is located in " + states.get(total));
				}

				if (isSequential)
					total++;
				else {
					int random = hdR.mtd.getRandomNumber(0, states.size());
					if (random == total)
						random = hdR.mtd.getRandomNumber(0, states.size());
					else
						total = random;
				}
				jlblCount.setText(correct + " / " + total);

				if (setCapital) {
					jlblQuestion.setText("What is the capital of " + states.get(total) + " ?");
				} else {
					jlblQuestion.setText("At which state is " + capitals.get(total) + " the capital city ?");
				}
			}
		});
		jrbCapital.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbCapital.isSelected()) {
					setCapital = true;
					jlblQuestion.setText("What is the capital of " + states.get(total) + " ?");
				}
			}
		});
		jrbState.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbState.isSelected()) {
					setCapital = false;
					jlblQuestion.setText("At which state is " + capitals.get(total) + " the capital city ?");
				}
			}
		});
		jrbSequential.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (jrbSequential.isSelected())
					isSequential = true;
			}
		});
		jrbRandom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbRandom.isSelected())
					isSequential = false;
			}
		});

		// Add items to the applet
		JPanel jpOptionBar = new JPanel(new GridLayout(1, 3));
		jpOptionBar.add(jlblCount);
		jpOptionBar.add(jpStateCapital);
		jpOptionBar.add(jpOrder);
		add(jpOptionBar, BorderLayout.CENTER);
		add(jpInput, BorderLayout.SOUTH);

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		PE1803_GuessCapitals applet = new PE1803_GuessCapitals();
		JFrame frame = new JFrame();
		frame.add(applet);

		frame.setTitle("Exercise18_03");
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
