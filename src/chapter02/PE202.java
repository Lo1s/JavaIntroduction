package chapter02;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PE202 {
  @SuppressWarnings("resource")
public static void main(String[] arg) {

  Scanner input = new Scanner(System.in);
  
  System.out.println("Enter the radius and length of a cylinder: ");
  double radius = input.nextDouble();
  double length = input.nextDouble();

  final double PI = 3.14159;

  double area = radius * radius * PI;
  double volume = area * length;

  JOptionPane.showMessageDialog(null, "The area is: " + area + ".\n" +
  "\t" + "The volume is: " + volume + ".", "The result", JOptionPane.INFORMATION_MESSAGE);
  }
}