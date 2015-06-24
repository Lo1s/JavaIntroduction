package chapter01;
public class PE111 {
  public static void main(String[] args) {

  long deathsPerYear = (60 * 60 * 24 * 365) / 13;
  long birthsPerYear = (60 * 60 * 24 * 365) / 7;
  long immigrantsPerYear = (60 * 60 * 24 * 365) / 45;

  long currentPopulation = 312032486;  
  long yearOne = (birthsPerYear + immigrantsPerYear - deathsPerYear) + currentPopulation;
  long yearTwo = ((birthsPerYear + immigrantsPerYear - deathsPerYear) * 2) + currentPopulation;
  long yearThree = ((birthsPerYear + immigrantsPerYear - deathsPerYear) * 3) + currentPopulation;
  long yearFour = ((birthsPerYear + immigrantsPerYear - deathsPerYear) * 4) + currentPopulation;
  long yearFive = ((birthsPerYear + immigrantsPerYear - deathsPerYear) * 5) + currentPopulation; 
  


  System.out.print("The population in the next 5 years will be: \n" +
	"\t" + "First year: " + "\t" + yearOne + "\n" +
	"\t" + "Second year: " + "\t" + yearTwo + "\n" +
	"\t" + "Third year: " + "\t" + yearThree + "\n" +
	"\t" + "Fourth year: " + "\t" + yearFour + "\n" +
	"\t" + "Fifth year: " + "\t" + yearFive);
  }
}