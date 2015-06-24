package chapter02;

import javax.swing.JOptionPane;

public class PE213 {
  public static void main(String[] args) {

  String savingAmountString = JOptionPane.showInputDialog(null, "Enter the monthly saving amount: ", "Saving Amount", JOptionPane.QUESTION_MESSAGE);
  double savingAmount = Double.parseDouble(savingAmountString);

  final double INTEREST_RATE = 0.00417;
  double firstMonth = savingAmount * (1 + INTEREST_RATE);
  double secondMonth = (savingAmount + firstMonth) * (1 + INTEREST_RATE);
  double thirdMonth = (savingAmount + secondMonth) * (1 + INTEREST_RATE);
  double fourthMonth = (savingAmount + thirdMonth) * (1 + INTEREST_RATE);
  double fifthMonth = (savingAmount + fourthMonth) * (1 + INTEREST_RATE);
  double sixthMonth = (savingAmount + fifthMonth) * (1 + INTEREST_RATE);

  System.out.print("After the sixth month, the account value is: " + sixthMonth);
  }
}  
