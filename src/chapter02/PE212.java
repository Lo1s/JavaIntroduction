package chapter02;
import java.util.Scanner;

public class PE212 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Enter speed and acceleration: ");
  double speed = input.nextDouble();
  double acceleration = input.nextDouble();

  double length = Math.pow(speed, 2) / (2 * acceleration);

  System.out.print("The minimum length for this airplane is: " + length);
  }
}