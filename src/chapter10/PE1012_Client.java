/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 11. 7. 2014 2014 8:29:29 
 */
public class PE1012_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1012_Triangle2D r1 = new PE1012_Triangle2D(2, 2, 5.5, 4.9, 9.0, 10.3);
	    System.out.println("Area is " + r1.getArea());
	    System.out.println("Perimeter is " + r1.getPerimeter());
	    PE1012_Triangle2D test = new PE1012_Triangle2D(1, 1, 4, 3, 1, 5);
	    PE1004_MyPoint p = new PE1004_MyPoint(2, 3);
	    System.out.println(test.contains(p));
	    PE1004_MyPoint p2 = new PE1004_MyPoint(3, 3);
	    System.out.println(r1.contains(p2));
	    System.out.println(r1.contains(new PE1012_Triangle2D(4, 5, 10.5, 3.2, -0.5, -10.5)));
	    System.out.println(r1.overlaps(new PE1012_Triangle2D(3, 5, 2.3, 6.7, 5.5, 8.8)));
	}

}
