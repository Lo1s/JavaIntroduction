/**
 * 
 */
package chapter15;


/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 8:24:07 
 */
public class PE1513_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		PE1513_Octagon o1 = new PE1513_Octagon(6);
		PE1513_Octagon o2 = (PE1513_Octagon)o1.clone();
		@SuppressWarnings("unused")
		PE1513_Octagon o3 = new PE1513_Octagon(5);
		System.out.println("o1.compareTo(o2): " + o1.compareTo(o2));
	}

}
