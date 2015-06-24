package chapter03;
import java.util.Scanner;

public class PE319 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  
  System.out.println("Please enter first edge of the triangle: ");
  int firstEdge = input.nextInt();
  System.out.println("Please enter second edge of the triangle: ");
  int secondEdge = input.nextInt();
  System.out.println("Please enter third edge of the triangle: ");
  int thirdEdge = input.nextInt();

  int perimeter = firstEdge + secondEdge + thirdEdge;

  if ((firstEdge + secondEdge) >= thirdEdge && (firstEdge + thirdEdge) >= secondEdge && (secondEdge + thirdEdge) >= firstEdge) {
    System.out.println("The perimeter of the triangle with edges:\n" +
      firstEdge + ", " + secondEdge + ", " + thirdEdge + "\n" +
      "is: " + perimeter); 

  } else {
    System.out.println("You have entered a wrong values !");
    System.exit(0); 
  }

  }
}