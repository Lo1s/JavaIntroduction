package chapter03;
import java.util.Scanner;

  public class PE303 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a value for a: ");
    double a = input.nextDouble();
    System.out.print("Please enter a value for b: ");
    double b = input.nextDouble();
    System.out.print("Please enter a value for c: ");
    double c = input.nextDouble();
    System.out.print("Please enter a value for d: ");
    double d = input.nextDouble();
    System.out.print("Please enter a value for e: ");
    double e = input.nextDouble();
    System.out.print("Please enter a value for f: ");
    double f = input.nextDouble();

    double denominator = (a * d - b * c);

    if (denominator == 0) { 
      System.out.print("The equation has no solution");
      System.exit(0);
    } else {
      double x = (e * d - b * f) / denominator;
      double y = (a * f - e * c) / denominator;
      System.out.print("x is: " + x + " and y is: " + y);
    }

  }
}  
