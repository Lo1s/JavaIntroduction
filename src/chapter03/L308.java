package chapter03;
import java.util.Scanner;

public class L308 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Please enter a year. ");
  int year = input.nextInt();

  // Check if the year is leap

  boolean isLeapYear =
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

  System.out.print(year + " is a leap year ? " + isLeapYear);

  }
}
