package chapter03;
import java.util.Scanner;

public class L301b {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(System.currentTimeMillis() % 10);
  int number2 = (int)(System.currentTimeMillis() / 7 % 10);

  Scanner input = new Scanner(System.in);

  System.out.print("What is " + number1 + " + " + number2 + " ?");
  int enteredNumber = input.nextInt();

  int calculation = number1 + number2;  

    System.out.print(number1 + " + " + number2 + " = " + enteredNumber + " is " + 
    (calculation == enteredNumber));

    
  }
}
	 