package chapter02;
import java.util.Scanner;

public class PE217 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);  

  System.out.print("Enter the temperature in Fahrenheit: ");
  double ta = input.nextDouble();
  
  System.out.print("Enter the wind speed in miles per hour: ");
  double v = input.nextDouble();

  double wc = 35.74 + 0.6215 * ta - 35.75 * Math.pow(v, 0.16) + 0.4275 * ta * Math.pow(v, 0.16);

  System.out.print("The wind chill index is: " + wc );
  }
}  