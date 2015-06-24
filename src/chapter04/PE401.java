package chapter04;
import java.util.Scanner;

public class PE401 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int count = 0;     
    int quantityPositive = 0;
    int quantityNegative = 0;
    int sumPositive = 0;
    int sumNegative = 0; 
    int number = 1;
    int sum = 0;
    int quantity = 0;
    float average = 0;

    while (number != 0) {
      System.out.println("Enter an integer, the input ends if it is 0: ");
      number = input.nextInt();
      
      if (number > 0) {
        count++;
        quantityPositive++;
        sumPositive += number;
      } else if (number < 0) {
        count++;
        quantityNegative++;
        sumNegative += number;
      }
    }
    
      if (number == 0 && count == 0) {
        System.out.println("No numbers are entered except 0");
        System.exit(0);
      } else {
        sum = sumPositive + sumNegative;
        quantity = quantityPositive + quantityNegative; 
        average = (float)sum / (float)quantity;
      }
    
    System.out.println("The number of positives is " + quantityPositive + "\n"
        + "The number of negatives is " + quantityNegative + "\n"
        + "The total is " + sum + "\n"
        + "The average is " + average);
     
    
  }
}