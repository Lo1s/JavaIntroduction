package chapter02; 
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PE210 {
@SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  
  System.out.print("Enter the amount of water in kilograms: ");
  double M = input.nextDouble();

  System.out.print("Enter the initial temperature: ");
  double initialTemperature = input.nextDouble();

  System.out.print("Enter the final temperature: ");
  double finalTemperature = input.nextDouble();

  double Q = M * (finalTemperature - initialTemperature) * 4184;
  JOptionPane.showMessageDialog(null, "The energy needed is: " + Q, "The result", JOptionPane.INFORMATION_MESSAGE);
  }
} 