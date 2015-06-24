/**
 * 
 */
package chapter09;

/**
 * @author jslapnicka
 * @Date & @Time 30. 6. 2014 2014 9:47:57 
 */
public class PE914a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			sum += Integer.parseInt(args[i]); 
		}
		System.out.print(sum);
	}
}
