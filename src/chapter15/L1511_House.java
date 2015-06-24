/**
 * 
 */
package chapter15;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 3. 9. 2014 2014 15:54:20 
 */

public class L1511_House implements Cloneable, Comparable<L1511_House> {
	private int id;
	private double area;
	private java.util.Date whenBuilt;
	
	public L1511_House(int id, double area) {
		this.id = id;
		this.area =  area;
		whenBuilt = new java.util.Date();
	}
	
	public int getId() {
		return id;
	}
	
	public double getArea() {
		return area;
	}
	
	public Date getWhenBuilt() {
		return whenBuilt;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public int compareTo(L1511_House house) {
		if (area > house.area)
			return 1;
		else if (area < house.area)
			return -1;
		else
			return 0;
	}
}


