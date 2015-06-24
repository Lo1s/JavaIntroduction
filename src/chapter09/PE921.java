/**
 * 
 */
package chapter09;
import java.util.Scanner;
/**
 * @author jslapnicka
 * @Date & @Time 1. 7. 2014 2014 12:14:54 
 */
public class PE921 {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string and delimeter: ");
		String s = input.next();
		String regex = input.next();

		String[] splitted = split(s, regex);
		for (int i = 0; i < splitted.length; i++) {
			if (splitted[i].isEmpty())
				System.exit(0);
			else {
				System.out.print(splitted[i]);
				System.out.print(", ");
			}
		}
	}
	// Splits the string by the delimeter
	public static String[] split(String s, String regex) {
		String[] splitted = new String[s.length()];
		int position = 0;
		boolean isRegex = false;
		for (int i = 0; i < splitted.length; i++) {
			splitted[i] = "";
		}
		if (regex.charAt(0) == '[')
			for (int i = 0; i < s.length(); i++) {
				isRegex = false;
				for (int j = 1; j < regex.length() - 1; j++) {
					if (s.charAt(i) == regex.charAt(j)) {
						isRegex = true;
					}
				}
				if (isRegex) {
					if (splitted[position].isEmpty())
						splitted[position] += s.charAt(i);
					else {
						position++;
						splitted[position] += s.charAt(i);
					} 
				} else {
					if (!splitted[position].isEmpty())
						for (int k = 1; k < regex.length(); k++) {
							if (splitted[position].charAt((splitted[position].length() > 0 ? splitted[position].length() - 1 : 0)) == regex.charAt(k)) {
								position++;
								break;
							}
						}
					splitted[position] += s.charAt(i);
				}
			}
		else
			for (int i = 0; i < s.length(); i++) {
				isRegex = false;
				if (s.substring(i, i + 1).equals(regex)) {
					isRegex = true;
				}

				if (isRegex) {
					if (splitted[position].isEmpty())
						splitted[position] += s.charAt(i);
					else {
						position++;
						splitted[position] += s.charAt(i);
					} 
				} else {
					if (!splitted[position].isEmpty()) {
						if (splitted[position].equals(regex)) {
							position++;
							splitted[position] += s.charAt(i);
						} else
							splitted[position] += s.charAt(i);
					} else
						splitted[position] += s.charAt(i);
				}
			}
		return splitted;
	}
}
