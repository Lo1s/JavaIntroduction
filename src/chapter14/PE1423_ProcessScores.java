/**
 * 
 */
package chapter14;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 28. 8. 2014 2014 10:12:43 
 */
public class PE1423_ProcessScores {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		// Input the URL
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a URL: ");
		String URLString = input.nextLine();
		input.close();
		
		// Read the data from the web by the StringBuilder
		StringBuilder buffer = new StringBuilder();
		try {
			URL url = new URL(URLString);
			input = new Scanner(url.openStream());
			while (input.hasNextLine()) {
				buffer.append(input.nextLine() + " ");
			}
		}
		catch (MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (IOException ex) {
			System.out.println("Adress does not exist !");
		}
		
		// Split them into an array and count their total and average
		int total = 0;
		int average = 0;
		String[] scores = buffer.toString().split("\\s|\\n");
		
		for (int i = 0; i < scores.length; i++) {
			total += Integer.valueOf(scores[i]);
		}
		average = total / scores.length;
		
		System.out.println("Total: " + total);
		System.out.println("Average: " + average);	
	}

}
