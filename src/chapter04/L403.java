package chapter04;
import java.util.Scanner;

public class L403 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  
  System.out.println("Guess a magic number between 0 and 100.");

  int magicNumber = (int)(Math.random() * ((100 - 0) + 1));

  int guess = -1;
  while(guess != magicNumber) {
    System.out.println("\nEnter your guess now !");
    guess = input.nextInt();
  
      if(guess == magicNumber) {
        System.out.println("Yes the number is " + magicNumber);
      } else if(guess > magicNumber) {
        System.out.println("Your guess is too high !");
      } else {
        System.out.println("Your guess is too low !");
      }
    }
  }
}