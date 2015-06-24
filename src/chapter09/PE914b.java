/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 10:10:18 
 */
public class PE914b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		String[] splitted = args[0].split(" ");
		for (int i = 0; i < splitted.length; i++) {
			sum += Integer.parseInt(splitted[i]);
		}
		System.out.print(sum);
	}

}
