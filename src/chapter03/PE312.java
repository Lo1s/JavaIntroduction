package chapter03;
import java.util.Scanner;

  public class PE312 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter an integer :");
    int number = input.nextInt();

    if (number % 5 == 0 ^ number % 6 == 0) {
      System.out.print(number + " is divisible by 5 or 6, but not both."); 
    } else if (number % 5 == 0 && number % 6 == 0) {
      System.out.print(number + " is divisible by both 5 and 6.");
    } else {
      System.out.print(number + " is not divisible by either 5 or 6.");
    }
  }
}
      