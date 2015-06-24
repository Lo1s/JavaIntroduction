/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 14:06:25 
 */
public class L1107_CastingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create and initialize two objects
		Object object1 = new L1102_CircleFromSimpleGeometricObject(1);
		Object object2 = new L1103_RectangleFromSimpleGeometricObject(1, 1);
		
		displayObject(object1);
		displayObject(object2);
	}
	/** A method for displaying an object */
	public static void displayObject(Object object) {
		if (object instanceof L1102_CircleFromSimpleGeometricObject) {
			System.out.println("The circle Area is: " + 
					((L1102_CircleFromSimpleGeometricObject)object).getArea());
			System.out.println("The circle Diameter is: " + 
					((L1102_CircleFromSimpleGeometricObject)object).getDiameter());
		}
		else if (object instanceof L1103_RectangleFromSimpleGeometricObject) {
			System.out.println("The rectangle Area is: " + 
					((L1103_RectangleFromSimpleGeometricObject)object).getArea());
		}
	}

}
