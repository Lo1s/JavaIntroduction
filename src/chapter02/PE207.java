package chapter02;
import java.util.Scanner;

public class PE207 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Enter the number of minutes: ");
  long numberOfMinutes = input.nextLong();

  long hours = numberOfMinutes / 60;
  long days = hours / 24;
  long years = days / 365;
  long remainingDays = days % 365;
     




  System.out.print(numberOfMinutes + " minutes is approximately " + years + " and " + remainingDays + " days.");
  }
}