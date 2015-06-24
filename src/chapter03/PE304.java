package chapter03;
import java.util.Scanner;

public class PE304 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(Math.random() * 100);
  int number2 = (int)(Math.random() * 100);

  Scanner input = new Scanner(System.in);

  System.out.println("What is " + number1 + " + " + number2 + " ?");
  int enteredNumber = input.nextInt();

  int calculation = number1 + number2;  

  if (enteredNumber == calculation) {
    System.out.print("You are right !");
  } else {
    System.out.print("You are wrong ! \n" + "Please try again !");

    }
  }
}
	 