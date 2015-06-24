/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 12:36:13 
 */
public class L1105_PolymorphismDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Display circle and rectangle properties
		displayObject(new L1102_CircleFromSimpleGeometricObject(1, "red", false));
		displayObject(new L1103_RectangleFromSimpleGeometricObject(1, 1, "black", true));
	}
	/** Display geometric object properties */
	public static void displayObject(L1101_SimpleGeometricObject object) {
		System.out.println("Created on " + object.getDateCreated() + 
				". Color is " + object.getColor());
	}
}
