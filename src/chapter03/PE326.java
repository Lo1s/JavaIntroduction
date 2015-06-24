package chapter03;
import java.util.Scanner;

  public class PE326 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Please enter an integer :");
    int number = input.nextInt();

      System.out.println(number + " is divisible by 5 or 6, but not both." + (number % 5 == 0 ^ number % 6 == 0)); 
      System.out.println(number + " is divisible by both 5 and 6." + (number % 5 == 0 && number % 6 == 0));
      System.out.println(number + " is divisible by either 5 or 6." + (number % 5 == 0 || number % 6 == 0));
  
  }
}
      