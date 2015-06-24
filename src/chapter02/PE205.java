package chapter02;
import java.util.Scanner;


public class PE205 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);

  System.out.println("Enter a subtotal and gratuity rate: ");
  double subtotal = input.nextDouble();  
  double gratuityRate = input.nextDouble();

  double gratuity = subtotal * (gratuityRate / 100);
  double total = subtotal + gratuity;

  System.out.println("The gratuity is: " + "$" + gratuity + " and total is: " + "$" + total);
  }
}
 
  