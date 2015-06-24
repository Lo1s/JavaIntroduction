/**
 * 
 */
package chapter08;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 12:36:51 
 */
public class PE803 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creates the Date object from the java.util.* date class
		
		for (long i = 10000; i <= 100000000000L; i *= 10) {
			System.out.println(new Date(i).toString());
		}
	}

}
