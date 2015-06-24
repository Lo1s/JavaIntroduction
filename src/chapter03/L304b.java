package chapter03;
import java.util.Scanner;

public class L304b {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  int number1 = (int)(Math.random() * 10);
  int number2 = (int)(Math.random() * 10);

  if (number1 < number2) {
    int temp = number1;
    number1 = number2;
    number2 = temp;
    }

  Scanner input = new Scanner(System.in);
  System.out.print
    ("What is " + number1 + " - " + number2 + " ?");
  int answer = input.nextInt();

  if (number1 - number2 == answer) {
    System.out.println("You are correct !");
  } else {
    System.out.println("You are wrong !\n" + number1 + " - " + number2 + " is " + (number1 - number2));
  } 
  }
}
  