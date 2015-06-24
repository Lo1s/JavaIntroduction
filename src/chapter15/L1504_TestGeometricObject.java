/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 2. 9. 2014 2014 11:04:51 
 */
public class L1504_TestGeometricObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1501_GeometricObject object1 = new L1502_Circle(5);
		L1501_GeometricObject object2 = new L1503_Rectangle(5, 3);
		
		System.out.println("Two objects have same area ? " + equalArea(object1, object2));
		
		// Display circle
		displayGeometricObject(object1);
		
		// Display rectangle
		displayGeometricObject(object2);
		
	}
	
	/** A method for comparing the areas of two geometric objects */
	public static boolean equalArea(L1501_GeometricObject o1, L1501_GeometricObject o2) {
		return o1.getArea() == o2.getArea();
	}
	
	/** A method for displaying a geometric object */
	public static void displayGeometricObject(L1501_GeometricObject o) {
		System.out.println();
		System.out.println("The area is: " + o.getArea());
		System.out.println("The perimeter is: " + o.getPerimeter());
	}

}
