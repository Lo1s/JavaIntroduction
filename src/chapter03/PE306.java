package chapter03;
import java.util.Scanner;

public class PE306 {
  @SuppressWarnings("resource")
public static void main(String[] args) {


  // Input by user
  Scanner input = new Scanner(System.in);
  System.out.print("Please enter your weight in pounds: ");
  double weightInPounds = input.nextDouble();
  
  System.out.print("Please enter your height in feet: ");
  double heightInFeet = input.nextInt();

  System.out.print("Please enter your height in inches: ");
  double heightInInches = input.nextDouble();  


  // Diffining constants
  final double POUNDS_TO_KILOGRAMS = 0.4539237;
  final double INCHES_TO_METERS	= 0.0254;
  final double FEETS_TO_METERS = 0.3048;
   
  // Calculation
  double weightInKilograms = weightInPounds * POUNDS_TO_KILOGRAMS;
  double heightInMeters = heightInInches * INCHES_TO_METERS + heightInFeet * FEETS_TO_METERS; 
  
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
 