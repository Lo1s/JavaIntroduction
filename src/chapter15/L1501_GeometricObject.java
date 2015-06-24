/**
 * 
 */
package chapter15;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 2. 9. 2014 2014 10:49:22 
 */
public abstract class L1501_GeometricObject {
	private String color = "white";
	private boolean isFilled;
	private Date dateCreated;
	
	// Default constructor
	protected L1501_GeometricObject() {
		dateCreated = new Date();
	}
	
	// Constructor with specified color and filled value
	protected L1501_GeometricObject(String color, boolean filled) {
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
	
	/** Abstract method getArea */
	public abstract double getArea();
	
	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}
