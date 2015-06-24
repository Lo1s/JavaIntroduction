/**
 * 
 */
package chapter11;


/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 12:28:51 
 */
public class L1104_TestCirclerectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1102_CircleFromSimpleGeometricObject circle = new L1102_CircleFromSimpleGeometricObject(1);
		System.out.println("A circle: " + circle.toString());
		System.out.println("The color is: " + circle.getColor());
		System.out.println("The radius is. " + circle.getRadius());
		System.out.println("The Area is: " + circle.getArea());
		System.out.println("The diameter is: " + circle.getDiameter());
		
		L1103_RectangleFromSimpleGeometricObject rectangle = new L1103_RectangleFromSimpleGeometricObject(2, 4);
		System.out.println("\nA rectangle: " + rectangle.toString());
		System.out.println("The Area is: " + rectangle.getArea());
		System.out.println("The perimeter is: " + rectangle.getPerimeter());
	}

}
