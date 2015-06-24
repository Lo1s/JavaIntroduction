package chapter02;

import javax.swing.JOptionPane;

public class PE204 {
  public static void main(String[] args) {

  String poundsString = JOptionPane.showInputDialog(null, "Enter a number in pounds: ", "Please enter a value", JOptionPane.QUESTION_MESSAGE);

  double pounds = Double.parseDouble(poundsString);
  double kilograms = pounds * 0.454;

  JOptionPane.showMessageDialog(null, pounds + " pounds" + " is " + kilograms + " kilograms" + ".");
  }
}  