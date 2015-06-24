package chapter03;
import java.util.Scanner;

public class PE333 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter weight and price for package 1: ");
    double weight1 = input.nextDouble();
    double price1 = input.nextDouble();

    System.out.println("Enter weight and price for package 2: ");
    double weight2 = input.nextDouble();
    double price2 = input.nextDouble();

    double packageIndex1 = price1 * 1.0D / weight1;
    double packageIndex2 = price2 * 1.0D / weight2;

    if (packageIndex1 > packageIndex2) 
      System.out.println("Package 1 has a better price.");
    else
      System.out.println("Package 2 has a better price.");
    
  }
}