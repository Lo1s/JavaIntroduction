package chapter02;
import java.util.Scanner;


public class PE206 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);  

  System.out.print("Enter a number between 0 and 1000: ");
  int numberUnderThousand = input.nextInt();

  if(numberUnderThousand < 1000 && numberUnderThousand > 0) {
    int firstNumber = numberUnderThousand / 100;
    int secondNumber = (numberUnderThousand % 100) / 10;
    int thirdNumber = numberUnderThousand % 10;
    int sum = firstNumber + secondNumber + thirdNumber;
    System.out.println("The sum of the digits is: " + sum); 
  } else {
    System.out.println("Your number is not between 0 and 1000 !");
    }
  }
} 
