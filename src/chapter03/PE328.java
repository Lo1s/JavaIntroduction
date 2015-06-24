package chapter03;
import java.util.Scanner;

public class PE328 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  
  System.out.println("Enter r1's center x-, y-coordinates, width and height: ");
  double xR1 = input.nextDouble();
  double yR1 = input.nextDouble();
  double widthR1 = input.nextDouble();
  double heightR1 = input.nextDouble(); 

  System.out.println("Enter r2's center x-, y-coordinates, width and height: ");
  double xR2 = input.nextDouble();
  double yR2 = input.nextDouble();
  double widthR2 = input.nextDouble();
  double heightR2 = input.nextDouble();

  double xDistance = xR1 >= xR2 ? xR1 - xR2 : xR2 - xR1;
  double yDistance = yR1 >= yR2 ? yR1 - yR2 : yR2 - yR1;

  if (xDistance <= (widthR1 - widthR2) / 2 && yDistance <= (heightR1 - heightR2) / 2) {
    System.out.println("R2 is inside R1");
  } else if (xDistance <= (widthR1 + widthR2) / 2 && yDistance <= (heightR1 + heightR2) / 2) {
    System.out.println("R2 overlaps R1");
  } else {
    System.out.println("R2 does not overlap R1");
  }
  }
}
   
  