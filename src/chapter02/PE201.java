package chapter02;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PE201 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);	// creating the scanner
  
  System.out.println("Enter temparature value in Celsius: ");
  double celsiusDegree = input.nextDouble();	// defining the input
  
  double fahrenheitDegree = ((9.0 / 5) * celsiusDegree + 32);

  JOptionPane.showMessageDialog(null, celsiusDegree + " Celsius is: " + fahrenheitDegree + " Fahrenheit", "Temperature in Fahreneit", JOptionPane.INFORMATION_MESSAGE); 
  }
}

