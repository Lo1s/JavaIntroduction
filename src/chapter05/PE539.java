/**
 * 
 */
package chapter05;
import java.util.Scanner;

/**
 * @author Jura
 *
 */
public class PE539 {

	/**
	 * 
	 */
	public PE539() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three points for p0, p1 and p2: ");
	    double x0 = input.nextDouble();
	    double y0 = input.nextDouble();
	    double x1 = input.nextDouble();
	    double y1 = input.nextDouble();
	    double x2 = input.nextDouble();
	    double y2 = input.nextDouble();
	    
	    if(PE539.leftOfTheLine(x0, y0, x1, y1, x2, y2))
	    	System.out.println(x2 + " " + y2 + " is on the left side of the line from " + x0 + " " +  y0 + " " + x1 + " " + y1);
	    else if (PE539.onTheLineSegment(x0, y0, x1, y1, x2, y2))
	    	System.out.println(x2 + " " + y2 + " is on the line segment from " + x0 + " " +  y0 + " " + x1 + " " + y1);
	    else if(PE539.onTheSameLine(x0, y0, x1, y1, x2, y2))
	    	System.out.println(x2 + " " + y2 + " is on the same line from " + x0 + " " +  y0 + " " + x1 + " " + y1);
	    else
	    	System.out.println(x2 + " " + y2 + " is on the right side of the line from " + x0 + " " +  y0 + " " + x1 + " " + y1);

	}
	
	/** Return true if point (x2, y2) is on the left side of the
	* directed line from (x0, y0) to (x1, y1) */
	public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
	    double p2 = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	    if (p2 > 0)
	    	return true;
	    else
	    	return false;
	    
	}
	/** Return true if point (x2, y2) is on the same
	* line from (x0, y0) to (x1, y1) */
	public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return Math.abs((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)) < 1.0000000000000001E-009D;
	}
	/** Return true if point (x2, y2) is on the
	* line segment from (x0, y0) to (x1, y1) */
	public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
		@SuppressWarnings("unused")
		double p2 = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	      return onTheSameLine(x0, y0, x1, y1, x2, y2) && (x0 <= x2 && x2 <= x1 || x0 >= x2 && x2 >= x1);
	}

}
