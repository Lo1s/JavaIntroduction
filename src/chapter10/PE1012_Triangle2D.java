/**
 * 
 */
package chapter10;
import java.awt.geom.Line2D;
/**
 * @author jslapnicka
 * @Date & @Time 11. 7. 2014 2014 8:29:07 
 */
public class PE1012_Triangle2D {
	private PE1004_MyPoint p1, p2, p3;

	public PE1012_Triangle2D() {
		// TODO Auto-generated constructor stub
		this.p1 = new PE1004_MyPoint(0, 0);
		this.p2 = new PE1004_MyPoint(1, 1);
		this.p3 = new PE1004_MyPoint(2, 5);
	}

	public PE1012_Triangle2D(PE1004_MyPoint p1, PE1004_MyPoint p2, PE1004_MyPoint p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public PE1012_Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.p1 = new PE1004_MyPoint(x1, y1);
		this.p2 = new PE1004_MyPoint(x2, y2);
		this.p3 = new PE1004_MyPoint(x3, y3);		
	}

	/**
	 * @return the p1
	 */
	public PE1004_MyPoint getP1() {
		return p1;
	}

	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(PE1004_MyPoint p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p2
	 */
	public PE1004_MyPoint getP2() {
		return p2;
	}

	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(PE1004_MyPoint p2) {
		this.p2 = p2;
	}

	/**
	 * @return the p3
	 */
	public PE1004_MyPoint getP3() {
		return p3;
	}

	/**
	 * @param p3 the p3 to set
	 */
	public void setP3(PE1004_MyPoint p3) {
		this.p3 = p3;
	}

	public double getArea() {
		double side1 = p1.distance(p2);
		double side2 = p1.distance(p3);
		double side3 = p3.distance(p2);

		double s = (side1 + side2 + side3) / 2D;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	public double getPerimeter() {
		return p1.distance(p2) + p1.distance(p3) + p3.distance(p2);
	}

	public boolean contains(PE1004_MyPoint p) {
		// Creating max/min values for the X and Y
		double maxX = Math.max(p1.getX(), Math.max(p2.getX(), p3.getX()));
		double minX = Math.min(p1.getX(), Math.min(p2.getX(), p3.getX()));
		double maxY = Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()));
		double minY = Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()));

		if (p.getX() < minX || p.getX() > maxX || p.getY() < minY || p.getY() > maxY)
			return false;	// Outside the bounding rectangle of the triangle

		Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
		Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

		if (side1.contains(p.getX(), p.getY()) || side2.contains(p.getX(), p.getY()) || side3.contains(p.getX(), p.getY()))
			return true;	// On the border of the line

		double topY = -10;
		if (p.getX() == p1.getX()) {
			topY = p1.getY();
		} 
		else if (p.getX() == p2.getX()) {
			topY = p2.getY();
		} 
		else if (p.getX() == p3.getX()) {
			topY = p3.getY();
		} 

		Line2D line;
		if (p.getY() < topY) 
			line = new Line2D.Double(p.getX(), p.getY(), p.getX(), minY);
		else  
			line = new Line2D.Double(p.getX(), p.getY(), p.getX(), maxY);

		int hits = 0;
		if (line.intersectsLine(side1))
			hits++;

		if (line.intersectsLine(side2))
			hits++;

		if (line.intersectsLine(side3))
			hits++;

		if (hits % 2 == 0) 
			return false;
		else 
			return true;
	}

	public boolean contains(PE1012_Triangle2D t) {
		return contains(t.p1) && contains(t.p2) && contains(t.p3);
	}

	/** Return true if a triangle overlaps with this triangle */
	public boolean overlaps(PE1012_Triangle2D t) {    
		// Two triangles overlap if one is inside the other or a side in
		// one triangle intersects a side in the other triangle
		Line2D line1 = new Line2D.Double(t.getP1().getX(), t.getP1().getY(), t.getP2().getX(), t.getP2().getY());
		Line2D line2 = new Line2D.Double(t.getP1().getX(), t.getP1().getY(), t.getP3().getX(), t.getP3().getY());
		Line2D line3 = new Line2D.Double(t.getP2().getX(), t.getP2().getY(), t.getP3().getX(), t.getP3().getY());

		Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
		Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());

		return contains(t) || t.contains(this) ||
				line1.intersectsLine(side1) || 
				line1.intersectsLine(side2) || 
				line1.intersectsLine(side3) || 
				line2.intersectsLine(side1) || 
				line2.intersectsLine(side2) || 
				line2.intersectsLine(side3) ||
				line3.intersectsLine(side1) || 
				line3.intersectsLine(side2) || 
				line3.intersectsLine(side3);
	}	
}
