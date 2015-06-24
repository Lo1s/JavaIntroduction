/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 14:50:19 
 */
public class PE1511_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1511_ComparableCircle c1 = new PE1511_ComparableCircle(6);
		PE1511_ComparableCircle c2 = new PE1511_ComparableCircle(6);
		System.out.println(c1.compareTo(c2));
		System.out.println("c1.equals(c2) ? " + c1.equals(c2));
	}

}
