package chapter04;
import java.util.Scanner;

public class L401 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(System.currentTimeMillis() % 10);
  int number2 = (int)(System.currentTimeMillis() / 7 % 10);

  Scanner input = new Scanner(System.in);

  System.out.println("What is " + number1 + " + " + number2 + " ?");
  int enteredNumber = input.nextInt();

  int calculation = number1 + number2;  

  while(enteredNumber != calculation) {
    System.out.println("Wrong answer. Try again ! What is "
      + number1 + " + " + number2 + " ?");
    enteredNumber = input.nextInt();
    } 

  System.out.println("You got it ! Congratz !");

  }
}
	 