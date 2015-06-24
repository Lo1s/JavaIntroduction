package chapter04;
import java.util.Scanner;

public class L405 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter an integer (the input ends if it is 0): ");
    int inputValue = input.nextInt();

    int sum = 0;
    while (inputValue != 0) {
    sum += inputValue;
    System.out.println("Enter an integer (the input ends if it is 0): ");
    inputValue = input.nextInt();
    }

      System.out.println("The sum is " + sum);
  }
} 

