package chapter03;
import java.util.Scanner;

public class L301 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(System.currentTimeMillis() % 10);
  int number2 = (int)(System.currentTimeMillis() / 7 % 10);

  Scanner input = new Scanner(System.in);

  System.out.println("What is " + number1 + " + " + number2 + " ?");
  int enteredNumber = input.nextInt();

  int calculation = number1 + number2;  

  if (enteredNumber == calculation) {
    System.out.print("You are right !");
  } else {
    System.out.print("You are wrong ! \n" +
	"\t" + "Please try again !");

    }
  }
}
	 