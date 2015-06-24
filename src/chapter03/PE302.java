package chapter03;
import java.util.Scanner;

public class PE302 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(System.currentTimeMillis() % 10);
  int number2 = (int)(System.currentTimeMillis() % 20);
  int number3 = (int)(System.currentTimeMillis() % 35);

  Scanner input = new Scanner(System.in);

  System.out.println("What is " + number1 + " + " + number2 + " + " + number3 +" ?");
  int enteredNumber = input.nextInt();

  int calculation = number1 + number2 + number3;  

  if (enteredNumber == calculation) {
    System.out.print("\t" + "You are right !");
  } else {
    System.out.print("\t" + "You are wrong ! \n" +
	"\t" + "Please try again !");

    }
  }
}
	 