package chapter02;
import java.util.Scanner;

public class PE209 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Enter v1, v0 and t: ");
  double v0 = input.nextDouble();
  double v1 = input.nextDouble();
  double t = input.nextDouble();

  double acceleration = (v1 - v0) / t;

  System.out.print("The average acceleration is: " + acceleration);
  }
} 