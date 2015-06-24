package chapter04;
import java.util.Scanner;

public class L404 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  // number of questions
  final int NUMBER_OF_QUESTIONS	= 5;
  // count the number of right answers
  int correctCount = 0;
  // count the number of right answers
  int count = 0; 
  // creating the timer
  long startTime = System.currentTimeMillis();
  // creating output message with summary
  String output = "";

  // creating scanner
  Scanner input = new Scanner(System.in);
  
  // creating loop for asking 5 questions
  while(count < NUMBER_OF_QUESTIONS) {
    int number1 = (int)(Math.random() * 10);	// generating numbers for calculation
    int number2 = (int)(Math.random() * 10);    

    if (number2 > number1) {			// swapping the numbers in case that number2 > number1
      int temp = number1;
      number1 = number2;
      number2 = temp;
    }

    System.out.print("What is " + number1 + " - " + number2 + " ? ");	// prompting the user for input
    int answer = input.nextInt();

    if(number1 - number2 == answer) {
      System.out.println("You are correct !\n");
      correctCount++; 				// increase the correct count
    } else {
      System.out.println("You are wrong !\n" 
        + number1 + " - " + number2 + " should be: " + (number1 - number2) + "\n");
    }
    
    count++;

    output += "\n" + number1 + " - " + number2 + " = " + answer + 
             ((number1 - number2 == answer) ? " correct" : " wrong");   
  }

  long endTime = System.currentTimeMillis();
  long testTime = endTime - startTime;
  double percentil = ((double)correctCount / (double)count) * 100.0; 

  System.out.println("Correct count is: " + correctCount + "\n" +
    "Test time is: " + testTime / 1000 + " seconds.\n" + 
    "Percentil of right answers is: " + percentil + "%\n" + output);  

  }
}
  