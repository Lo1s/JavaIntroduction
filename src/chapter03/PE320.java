package chapter03;
import java.util.Scanner;

public class PE320 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);  

  System.out.print("Enter the temperature in Fahrenheit: ");
  double ta = input.nextDouble();
  final double MIN_TEMP = -58.0;
  final double MAX_TEMP = 41.0; 
  
  System.out.print("Enter the wind speed in miles per hour: ");
  double v = input.nextDouble();

  double wc = 35.74 + 0.6215 * ta - 35.75 * Math.pow(v, 0.16) + 0.4275 * ta * Math.pow(v, 0.16);

  if (ta > MIN_TEMP && ta < MAX_TEMP) {
  System.out.printf("The wind chill index is : %.2f", wc);
  } else {
  System.out.print("You have entered an invalid value !");
  System.exit(0);
  }

  }
}  