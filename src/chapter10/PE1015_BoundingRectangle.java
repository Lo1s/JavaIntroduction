/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 11:16:07 
 */
public class PE1015_BoundingRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] points = {{1.0, 2.5}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
		PE1013_MyRectangle2D test = getRectangle(points);
		System.out.println("The bounding rectangle's center (" + test.getX() + ", " + test.getY() + "), width " + test.getWidth() + ", height " + test.getHeight());
	}
	//Finds the bounding rectangle.
	public static PE1013_MyRectangle2D getRectangle(double[][] points) {
		double maxDown = 100;
		double maxRight = 0;
		double maxUp = 0;
		double maxLeft = 100;

		for (int i = 0; i < points.length; i++) {
			if (points[i][1] < maxDown) {
				maxDown = points[i][1];
			}
			if (points[i][0] > maxRight) {
				maxRight = points[i][0];
			}
			if (points[i][1] > maxUp) {
				maxUp = points[i][1];
			}
			if (points[i][0] < maxLeft) {
				maxLeft = points[i][0];
			}
		}
		return new PE1013_MyRectangle2D((maxRight - maxLeft) / 2 + maxLeft, (maxUp - maxDown) / 2 + maxDown, (maxRight - maxLeft), (maxUp - maxDown));
	}

}
