package chapter03;
import java.util.Scanner;

  public class PE301 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a value for a: ");
    double a = input.nextDouble();
    System.out.print("Enter a value for b: ");
    double b = input.nextDouble();
    System.out.print("Enter a value for c: ");
    double c = input.nextDouble();

    double bOn2 = Math.pow(b, 2);

    double r1 = (-(b) + Math.pow((bOn2 - 4 * (a * c)), 0.5)) / (2 * a);
    double r2 = (-(b) - Math.pow((bOn2 - 4 * (a * c)), 0.5)) / (2 * a);

    double discriminant = bOn2 - 4 * (a * c);

    if (discriminant > 0) {
      System.out.print("The equation has two roots (r1 = " + r1 + ", r2 = " + r2 +
      ") because discriminant is positive = " + discriminant);
    } else if (discriminant == 0) {
      System.out.print("The equation has one root (r1 = " + r1 + ", r2 = " + r2 +
      ") because discriminant is equal to zero = " + discriminant);
    } else if (discriminant < 0) {
      System.out.print("The equation has no roots (r1 = " + r1 + ", r2 = " + r2 +
      ") because discriminant is negative = " + discriminant);
    }

  }
} 