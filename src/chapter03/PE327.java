package chapter03;
import java.util.Scanner;

public class PE327 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);

  System.out.print("Enter a point's x- and y- coordinates: ");
  double x = input.nextDouble();
  double y = input.nextDouble();



  if (x > 200D || x < 0.0D || y > 100D || y < 0) {
    System.out.print("The point with coordinates " + (int)x + ", " + (int)y + " is not in the triangle.");    
  } else { 
    double slope = -2D;
    double x1 = x + -y * slope;
    if (x1 <= 200D) {
    System.out.print("The point with coordinates " + (int)x + ", " + (int)y + " is in the triangle.");
  } else {
    System.out.print("The point with coordinates " + (int)x + ", " + (int)y + " is not in the triangle.");    
  }
  }
  }
}
   