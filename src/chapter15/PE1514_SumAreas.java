/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 8:42:18 
 */
public class PE1514_SumAreas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1501_GeometricObject[] objects = {new L1502_Circle(5), new L1502_Circle(6), 
				new L1503_Rectangle(5, 5), new L1503_Rectangle(6, 6)};
		
		System.out.println("Sum of the object areas is: " + sumArea(objects));
	}
	
	public static double sumArea(L1501_GeometricObject[] a) {
		double sumArea = 0;
		for (int i = 0; i < a.length; i++) {
			sumArea += a[1].getArea();
		}
		return sumArea;
	}

}
