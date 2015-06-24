/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 8:02:34 
 */
public class PE1513_Octagon extends L1501_GeometricObject implements Comparable<PE1513_Octagon>, Cloneable {
	
	double side;
	
	public PE1513_Octagon() {
		// TODO Auto-generated constructor stub
	}
	
	public PE1513_Octagon(double side) {
		setSide(side);
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	public double getArea() {
		return (2 + 4 / (Math.pow(2, 2)) * side * side);
	}
	
	public double getPerimeter() {
		return side * 8;
	}
	
	public int compareTo(PE1513_Octagon o) {
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		else
			return 0;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
