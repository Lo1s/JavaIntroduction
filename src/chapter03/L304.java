package chapter03;
import java.util.Scanner;

public class L304 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(Math.random() * 10);
  int number2 = (int)(Math.random() * 10);
  int answer1 = 0;
  int answer2 = 0;
  int result1 = 0;
  int result2 = 0;

  Scanner input = new Scanner(System.in);

  if (number1 > number2) {
    result1 = (number1 - number2);
    System.out.print("What is " + number1 + " - " + number2 + " ?");
    answer1 = input.nextInt();

  } else {
    result2 = (number2 - number1);
    System.out.print("What is " + number2 + " - " + number1 + " ?");
    answer2 = input.nextInt();

  }

  if (result1 == answer1 || result2 == answer2) {
    System.out.print("You are right !");
  } else {
    System.out.println("You are wrong !\n" + number1 + " - " + number2 + " is " + (number1 - number2));
  }

  }
}
  