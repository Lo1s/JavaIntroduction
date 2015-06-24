package chapter03;
import java.util.Scanner;

  public class PE325 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Please enter the coordinates for x1: ");
    double x1 = input.nextDouble();
    System.out.println("Please enter the coordinates for y1: ");
    double y1 = input.nextDouble();
    System.out.println("Please enter the coordinates for x2: ");
    double x2 = input.nextDouble();
    System.out.println("Please enter the coordinates for y2: ");
    double y2 = input.nextDouble();
    System.out.println("Please enter the coordinates for x3: ");
    double x3 = input.nextDouble();
    System.out.println("Please enter the coordinates for y3: ");
    double y3 = input.nextDouble();
    System.out.println("Please enter the coordinates for x4: ");
    double x4 = input.nextDouble();
    System.out.println("Please enter the coordinates for y4: ");
    double y4 = input.nextDouble();

    // Cramer's rule for computing "x" and "y"
    
    double a = (y1 - y2);
    double b = -(x1 - x2);
    double c = (y3 - y4);
    double d = -(x3 - x4);
    double e = ((y1 - y2) * x1 - (x1 - x2) * y1);
    double f = ((y3 - y4) * x3 - (x3 - x4) * y3);
    double denominator = a * d - b * c;
    double x = (e * d - b * f) / denominator;
    double y = (a * f - e * c) / denominator;

    if((a * x + b * y) == e && (c * x + d * y) == f) {
      System.out.println("The intersecting point is at (" + x + ", " + y + ")"); 
    } else {
      System.out.println("Twe two lines are parallel");
    }
  }
}