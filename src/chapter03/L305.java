package chapter03;
import java.util.Scanner;

public class L305 {
  @SuppressWarnings("resource")
public static void main(String[] args) {


  // Input by user
  Scanner input = new Scanner(System.in);
  System.out.print("Please enter your weight in pounds: ");
  double weightInPounds = input.nextDouble();
  
  System.out.print("Please enter your height in inches: ");
  double heightInInches = input.nextDouble();  


  // Diffining constants
  final double WEIGHT_IN_KILOGRAMS = 0.4539237;
  final double HEIGHT_IN_METERS	= 0.0254;
   
  // Calculation
  double weightInKilograms = weightInPounds * WEIGHT_IN_KILOGRAMS;
  double heightInMeters = heightInInches * HEIGHT_IN_METERS; 
  
  double bmi = weightInKilograms / (heightInMeters * heightInMeters);

  // Status

  if (bmi < 18.5) {
    System.out.println(
    "Based on input data your BMI is: " + bmi + "\n" +
    "That indicates that you are: Underweight");
  } else if (bmi >= 18.5 && bmi <= 24.9) {
    System.out.println(
    "Based on input data your BMI is: " + bmi + "\n" +
    "That indicates that you are: Normal");
  } else if (bmi >= 25.0 && bmi <= 29.9) {
    System.out.println(
    "Based on input data your BMI is: " + bmi + "\n" +
    "That indicates that you are: Overweight");
    System.out.println(
    "Based on input data your BMI is: " + bmi + "\n" +
    "That indicates that you are: Obese");
  }

  }
}
 