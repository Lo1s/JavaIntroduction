/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 8:35:33 
 */
public class PE1004_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MyPoint p1 = new MyPoint();
		 MyPoint p2 = new MyPoint(10, 30.5);
		 System.out.println(p1.distance(p2));
		 System.out.println(MyPoint.distance(p1, p2));
	}

}
