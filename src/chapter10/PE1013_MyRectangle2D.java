/**
 * 
 */
package chapter10;
import java.awt.geom.*;
/**
 * @author jslapnicka
 * @Date & @Time 11. 7. 2014 2014 14:32:12 
 */
public class PE1013_MyRectangle2D {
	private double x;
	private double y;
	private double width;
	private double height;
	
	public PE1013_MyRectangle2D() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.height = 1;
	}
	
	public PE1013_MyRectangle2D(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return this.width * this.height;
	}
	
	public double getPerimeter() {
		return 2 * this.width + 2 * this.height;
	}
	
	public boolean contains(double x, double y) {
		return Math.abs(x - this.x) <= width / 2D && Math.abs(y - this.y) <= height / 2D;	
	}
	
	public boolean contains(PE1013_MyRectangle2D r) {
		return (r.x + r.width / 2 < this.x + this.width / 2 && r.y + r.height / 2 < this.y + this.height / 2) && (r.x - r.width / 2 > this.x - this.width / 2 && r.y  - r.height / 2 > this.y - this.height / 2);
	}
	
	public boolean overlaps(PE1013_MyRectangle2D r) {
		// Creating points A. B. C, D for the first triangle
		Point2D A1 = new Point2D.Double(this.x - this.width / 2, this.y - this.height / 2);
		Point2D B1 = new Point2D.Double(this.x + this.width / 2, this.y - this.height / 2);
		Point2D C1 = new Point2D.Double(this.x + this.width / 2, this.y + this.height / 2);
		Point2D D1 = new Point2D.Double(this.x - this.width / 2, this.y + this.height / 2);
		
		// Creating points A, B, C, D for the second (passed) triangle
		Point2D A2 = new Point2D.Double(r.x - r.width / 2, r.y - r.height / 2);
		Point2D B2 = new Point2D.Double(r.x + r.width / 2, r.y - r.height / 2);
		Point2D C2 = new Point2D.Double(r.x + r.width / 2, r.y + r.height / 2);
		Point2D D2 = new Point2D.Double(r.x - r.width / 2, r.y + r.height / 2);
		
		// Creating sides for the first triangle
		Line2D sideAr1 = new Line2D.Double(A1, B1);
		Line2D sideBr1 = new Line2D.Double(B1, C1);
		Line2D sideCr1 = new Line2D.Double(C1, D1);
		Line2D sideDr1 = new Line2D.Double(D1, A1);
		
		// Creating sides for the second triangle
		Line2D sideAr2 = new Line2D.Double(A2, B2);
		Line2D sideBr2 = new Line2D.Double(B2, C2);
		Line2D sideCr2 = new Line2D.Double(C2, D2);
		Line2D sideDr2 = new Line2D.Double(D2, A2);
		
		return (sideAr1.intersectsLine(sideAr2) || 
				sideAr1.intersectsLine(sideBr2) || 
				sideAr1.intersectsLine(sideCr2) ||
				sideAr1.intersectsLine(sideDr2) ||
				sideBr1.intersectsLine(sideAr2) ||
				sideBr1.intersectsLine(sideBr2) ||
				sideBr1.intersectsLine(sideCr2) ||
				sideBr1.intersectsLine(sideDr2) ||
				sideCr1.intersectsLine(sideAr2) ||
				sideCr1.intersectsLine(sideBr2) ||
				sideCr1.intersectsLine(sideCr2) ||
				sideCr1.intersectsLine(sideDr2) ||
				sideDr1.intersectsLine(sideAr2) ||
				sideDr1.intersectsLine(sideBr2) ||
				sideDr1.intersectsLine(sideCr2) ||
				sideDr1.intersectsLine(sideDr2));
	}		
	
}
