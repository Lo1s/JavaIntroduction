/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 10:18:40 
 */
public class PE1014_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    MyDate date = new MyDate();
	    System.out.println("year: " + date.getYear());
	    System.out.println("month: " + date.getMonth());
	    System.out.println("day: " + date.getDay());
	    
	    date = new MyDate(561555550000L);
	    System.out.println("year: " + date.getYear());
	    System.out.println("month: " + date.getMonth());
	    System.out.println("day: " + date.getDay());
	}

}
