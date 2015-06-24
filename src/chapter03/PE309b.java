package chapter03;
import java.util.Scanner;

  public class PE309b {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Please enter the first 9 digits of an ISBN as integer: ");
    int digits = input.nextInt();

    // check if input is 9 digits

    if (digits >= 000000000 && digits <= 999999999) {

      int firstDigit = digits / 10000000;
      int secondDigit = digits % 10000000;
      int thirdDigit = digits % 1000000;
      int fourthDigit = digits % 100000;
      int fifthDigit = digits % 10000;
      int sixthDigit = digits % 1000;
      int seventhDigit = digits % 100;
      int eighthDigit = digits % 10;
      int ninthDigit = (digits / 10) % 10;

      @SuppressWarnings("unused")
	int tenthDigit = (firstDigit * 1 
        + secondDigit * 2
        + thirdDigit * 3
        + fourthDigit * 4
        + fifthDigit * 5
        + sixthDigit * 6
        + seventhDigit * 7
        + eighthDigit * 8
        + ninthDigit * 9) % 11;

/* check
System.out.print(firstDigit);
System.out.print(secondDigit);
System.out.print(thirdDigit);
System.out.print(fourthDigit);
System.out.print(fifthDigit);
System.out.print(sixthDigit);
System.out.print(seventhDigit);
System.out.print(eighthDigit);
System.out.print(ninthDigit);
*/


      System.out.print("The ISBN-10 number is " + firstDigit + secondDigit +
        thirdDigit + fourthDigit + fifthDigit + sixthDigit + seventhDigit +
        eighthDigit + ninthDigit);
    }
  }
}