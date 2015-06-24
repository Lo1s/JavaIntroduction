/**
 * 
 */
package chapter14;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jslapnicka
 * @Date & @Time 21. 1. 2015 2015 15:26:33 
 */
public class L1418_WebCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a URL: ");
		String url = input.nextLine();
		crawler(url);
		input.close();
	}
	
	public static void crawler(String startingURL) {
		ArrayList<String> listOfPendingURLs = new ArrayList<String>();
		ArrayList<String> listOfTraversedURLs = new ArrayList<String>();
		
		listOfPendingURLs.add(startingURL);
		while(!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
			String urlString = listOfPendingURLs.remove(0);
			if (!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				System.out.println("Craw " + urlString);
				
				for (String s: getSubURLs(urlString)) {
					if (!listOfTraversedURLs.contains(s))
						listOfPendingURLs.add(s);
				}
			}
		}
	}
	
	public static ArrayList<String> getSubURLs(String urlString) {
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			URL url = new URL(urlString);
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			while(input.hasNext()) {
				String line = input.nextLine();
				current = line.indexOf("http:", current);
				while (current > 0) {
					int endIndex = line.indexOf("\"", current);
					if (endIndex > 0) {
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					} else
						current = -1;
				}
			}
			input.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		
		return list;
	}

}
