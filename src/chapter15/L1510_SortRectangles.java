/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 3. 9. 2014 2014 15:43:25 
 */
public class L1510_SortRectangles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1509_ComparableRectangle[] rectangles = {
				new L1509_ComparableRectangle(3.4, 5.4),
				new L1509_ComparableRectangle(13.24, 55.4),
				new L1509_ComparableRectangle(7.4, 35.4),
				new L1509_ComparableRectangle(1.4, 25.4)};
		java.util.Arrays.sort(rectangles);
		for (L1503_Rectangle rectangle: rectangles) {
			System.out.print(rectangle + " ");
			System.out.println();
		}
	}
}
