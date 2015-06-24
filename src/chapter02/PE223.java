package chapter02;
import java.util.Scanner;

public class PE223 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);
  System.out.print("Enter the ASCII code: ");
  byte ascii = input.nextByte();
  
  if(ascii < 127 && ascii > 0) {
  System.out.print("The character for " + ascii + " is " + (char)ascii);
  } else {
  System.out.print("Please enter a correct digit between 0 - 127");
    }
  }
}

  