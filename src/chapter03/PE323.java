package chapter03;
import java.util.Scanner;

  public class PE323 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Please enter the coordinates for point X: ");
    double x1 = input.nextDouble();
    System.out.println("Please enter the coordinates for point y: ");
    double y1 = input.nextDouble();


    double hDistance = Math.pow(x1 * x1, 0.5);
    double vDistance = Math.pow(y1 * y1, 0.5);    

    //double distance = Math.pow((Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)), 0.5);
    double maxHorizontalDistance = 10 / 2;
    double maxVerticalDistance = 5 / 2;


    if (hDistance <= maxHorizontalDistance && vDistance <= maxVerticalDistance) {
      System.out.println("point (" + x1 + ", " + y1 + ") is in the rectangle !");
    } else {
      System.out.println("point (" + x1 + ", " + y1 + ") is not in the rectangle!");
    }
  }
}