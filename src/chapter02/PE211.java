package chapter02;
import java.util.Scanner;

public class PE211 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  // Births, Deaths and Immigrants
  long deathsPerYear = (60 * 60 * 24 * 365) / 13;
  long birthsPerYear = (60 * 60 * 24 * 365) / 7;
  long immigrantsPerYear = (60 * 60 * 24 * 365) / 45;

  //Prompt the user for number of years
  Scanner input = new Scanner(System.in);
  System.out.print("Please enter the number of years: ");
  int numberOfYears = input.nextInt();

  // Calculation of the population
  long currentPopulation = 312032486;  
  
  long population = ((birthsPerYear + immigrantsPerYear - deathsPerYear) * numberOfYears) + currentPopulation;
 


  System.out.print("The population in " + numberOfYears + " years will be: " + population);
  }
}