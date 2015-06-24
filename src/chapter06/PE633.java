/**
 * 
 */
package chapter06;
import java.util.Scanner;

/**
 * @author jslapnicka
 *
 */
public class PE633 {

	/**
	 * 
	 */
	public PE633() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner input = new Scanner(System.in);
		  
		  System.out.print("Enter a year: ");
		  int year = input.nextInt();
		  String[] chineseZodiac = {"Monkey", "Rooster", "Dog" ,"Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};
		  System.out.print(chineseZodiac[year % 12]);
	}

}
