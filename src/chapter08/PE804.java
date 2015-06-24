/**
 * 
 */
package chapter08;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 12:55:28 
 */
public class PE804 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random1 = new Random(1000);
		Random random2 = new Random(1000);
		for (int i = 0; i < 50; i++) {
			System.out.print(random1.nextInt(100) + " ");
		}
		
		// Checking thte seed function, works great !
		System.out.println("\n");
		for (int i = 0; i < 50; i++) {
			System.out.print(random2.nextInt(100) + " ");
		}
	}

}
