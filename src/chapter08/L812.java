/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 9:03:18 
 */
public class L812 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare circleArray
		L809[] circleArray;
		
		// Create circleArray
		circleArray = createCircleArray();
		
		// Print circleArray and total areas of the circles
		printCircleArray(circleArray);
	}
	
	/** Create an array of Circle objects */
	public static L809[] createCircleArray() {
		L809[] circleArray = new L809[5];
		
		for (int i = 0; i < circleArray.length; i++) {
			circleArray[i] = new L809(Math.random() * 100);
		}
		
		// Return Circle array
		return circleArray;
	}
	
	/** Print an array of circles and their total area */
	public static void printCircleArray(L809[] circleArray) {
		System.out.printf("%-30s%-15s\n", "Radius", "Area");
		for (int i = 0; i < circleArray.length; i++) {
			System.out.printf("%-30f%-15f\n", circleArray[i].getRadius(), circleArray[i].getArea());
		}
		
		System.out.println("—————————————————————————————————————————-");
		
		// Compute and display the result
		System.out.printf("%-30s%-15f\n", "The total area of circles is", sum(circleArray));
	}
	/** Add circle areas */
	public static double sum(L809[] circleArray) {
		// Initialize sum
		double sum = 0;
		
		// Add areas to sum
		for (int i = 0; i < circleArray.length; i++) {
			sum += circleArray[i].getArea();
		}
		return sum;
	}
}
