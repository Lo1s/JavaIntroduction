/**
 * 
 */
package chapter11;

import java.util.Date;

/**
 * @author jslapnicka
 * @Date & @Time 16. 7. 2014 2014 12:57:22 
 */
public class PE1101_GeometricObject {
	private String color ="white";
	private boolean filled;
	private Date dateCreated;
	
	public PE1101_GeometricObject() {
		this.dateCreated = new Date();
	}
	
	public PE1101_GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		this.dateCreated = new Date();
	}
	
	public String getColor() {
		return this.color;
	}
	
	public boolean isFilled() {
		return this.filled;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void isFilled(boolean filled) {
		this.filled = filled;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled ? " + filled;
	}
	
	

}
