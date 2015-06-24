package chapter03;
import java.util.Scanner;

public class PE308 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    
    System.out.print("Please enter the first integer: ");
    int num1 = input.nextInt();
    System.out.print("Please enter the second integer: ");
    int num2 = input.nextInt();
    System.out.print("Please enter the third integer: ");
    int num3 = input.nextInt();

    if (num1 <= num2 && num2 <= num3) {
      System.out.print("The result is: \n" + 
      "\t" + "num3 = " + num3 + ";\n" + 
      "\t" + "num2 = " + num2 + ";\n" +
      "\t" + "num1 = " + num1 + ";");

    } else if (num1 <= num2 && num2 >= num3 && num3 >= num1) {
      System.out.print("The result is: \n" + 
      "\t" + "num2 = " + num2 + ";\n" + 
      "\t" + "num3 = " + num3 + ";\n" +
      "\t" + "num1 = " + num1 + ";");  

    } else if (num1 <= num2 && num2 >= num3 && num3 <= num1) {
      System.out.print("The result is: \n" + 
      "\t" + "num2 = " + num2 + ";\n" + 
      "\t" + "num1 = " + num1 + ";\n" +
      "\t" + "num3 = " + num3 + ";");      

    } else if (num1 >= num2 && num1 >= num3 && num2 <= num3) {
      System.out.print("The result is: \n" + 
      "\t" + "num1 = " + num1 + ";\n" + 
      "\t" + "num3 = " + num3 + ";\n" +
      "\t" + "num2 = " + num2 + ";");

    } else if (num1 >= num2 && num1 >= num3 && num2 >= num3) {
      System.out.print("The result is: \n" + 
      "\t" + "num1 = " + num1 + ";\n" +
      "\t" + "num2 = " + num2 + ";\n" +
      "\t" + "num3 = " + num3 + ";");
    } else {
      System.out.print("You have forgot some combination !");
    }
  }
}

  
          