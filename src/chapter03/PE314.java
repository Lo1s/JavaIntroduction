package chapter03;
import java.util.Scanner;

  public class PE314 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    int flipOfCoin = (int)(Math.random() * (2 - 0));

    Scanner input = new Scanner(System.in);
    System.out.println("Head or tail ?");
    String guess = input.next();

    String flipOfCoinString = "";

    if (flipOfCoin == 0) {
      flipOfCoinString = "Head";
    } else {
      flipOfCoinString = "Tail";
    }

    if (guess.equals(flipOfCoinString)) {
      System.out.println("Your guess of " + guess + " is right !");
    } else {
      System.out.println("Your guess of " + guess + " is wrong !\n" + 
      "Try again !");
    }
  }
}
    
    