/**
 * 
 */
package chapter15;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 5. 9. 2014 2014 12:25:23 
 */
public abstract class PE1507_GeometricObjectComparable implements Comparable<PE1507_GeometricObjectComparable> {
	
	private String color = "white";
	private boolean isFilled;
	private Date dateCreated;
	
	// Default constructor
	protected PE1507_GeometricObjectComparable() {
		dateCreated = new Date();
	}
	
	// Constructor with specified color and filled value
	protected PE1507_GeometricObjectComparable(String color, boolean filled) {
		this.color = color;
		this.isFilled = filled;
		dateCreated = new Date();
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the filled
	 */
	public boolean isFilled() {
		return isFilled;
	}

	/**
	 * @param filled the filled to set
	 */
	public void setFilled(boolean filled) {
		this.isFilled = filled;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + 
				" and filled: " + isFilled;				
	}
	
	@Override
	public int compareTo(PE1507_GeometricObjectComparable o) {
		if (o.getArea() < this.getArea())
			return 1;
		else if (o.getArea() > this.getArea())
			return -1;
		else
			return 0;
	}
	
	public static PE1507_GeometricObjectComparable max(PE1507_GeometricObjectComparable o1, PE1507_GeometricObjectComparable o2) {
		if (o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}
	
	/** Abstract method getArea */
	public abstract double getArea();
	
	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}
