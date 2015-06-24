package chapter02;

import javax.swing.JOptionPane;

public class PE226 {
  public static void main(String[] args) {

    String amountString = JOptionPane.showInputDialog(null, "Enter an amount, for example, 11,56: ", "Enter an input data", JOptionPane.QUESTION_MESSAGE); 
    double amount = Double.parseDouble(amountString);   
    
    int remainingAmount = (int)(amount * 100);
    
    int numberOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;
    
    int numberOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;

    int numberOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;

    int numberOfNickles = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;

    int numberOfPennies = remainingAmount;

    // Display the results

    JOptionPane.showMessageDialog(null, "Your amount " + amount + " consists of \n" +
		"\t" + numberOfOneDollars + " dollars\n" +
		"\t" + numberOfQuarters + " quarters\n" +
		"\t" + numberOfDimes + " dimes\n" +
		"\t" + numberOfNickles + " nickles\n" + 
		"\t" + numberOfPennies + " pennies", "The result", JOptionPane.INFORMATION_MESSAGE);
  }
}
