package chapter02;
import java.util.Scanner;

public class PE203 {
  @SuppressWarnings("resource")
public static void main(String[] arg) {

  Scanner input = new Scanner(System.in);
  
  System.out.println("Enter a value for feet: ");
  double feets = input.nextDouble();
  
  double meters = feets * 0.305;

  System.out.println(feets + " feet is: " + meters + " meters");
  }
} 
  