package chapter03;
import java.util.Scanner;

  public class PE322 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Please enter the coordinates for point X: ");
    double x1 = input.nextDouble();
    System.out.println("Please enter the coordinates for point y: ");
    double y1 = input.nextDouble();

 
    double x2 = 0;
    double y2 = 0;
    double x2x1 = Math.pow((x2 - x1), 2);
    double y2y1 = Math.pow((y2 - y1), 2);
    double distance = Math.pow(x2x1 + y2y1, 0.5);

    // double distance = Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0,5);

    if (distance <= 10) {
      System.out.println("point (" + x1 + ", " + y1 + ") is in the circle !");
    } else {
      System.out.println("point (" + x1 + ", " + y1 + ") is not in the circle !");
    }
  }
}