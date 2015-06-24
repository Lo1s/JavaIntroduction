package chapter02;

import javax.swing.JOptionPane;

public class PE214 {
  public static void main(String[] args) {

  String weightString = JOptionPane.showInputDialog(null, "Enter weight in pounds: ", "BMI calculator", JOptionPane.QUESTION_MESSAGE);
  double weightInPounds = Double.parseDouble(weightString);
  
  String heightString = JOptionPane.showInputDialog(null, "Enter height in inches: ", "BMi calculator", JOptionPane.QUESTION_MESSAGE);
  double heightInInches = Double.parseDouble(heightString);

  double weightInKilograms = weightInPounds * 0.45359237;
  double heightInMeters = heightInInches * 0.0254;

  double bmi = weightInKilograms / Math.pow(heightInMeters, 2);

  System.out.print("BMI is: " + bmi);
  }
}