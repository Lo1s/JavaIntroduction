package chapter03;
import java.util.Scanner;

public class PE335 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Enter a decimal value (0 to 15): ");
  int hexInput = input.nextInt();
  String hex = "";
 
  if (hexInput > 15) {
    System.out.println("Invalid input");
  } else {
    hex = Integer.toHexString(hexInput);
    System.out.println("Hex value for " + hexInput + " is " + hex);
  }


  }
}
  
