/**
 * 
 */
package chapter11;
import java.util.*;
/**
 * @author jslapnicka
 * @Date & @Time 15. 7. 2014 2014 11:06:09 
 */
public class L1101_SimpleGeometricObject {
	private String color ="white";
	private boolean filled;
	private Date dateCreated;
	
	public L1101_SimpleGeometricObject() {
		this.dateCreated = new Date();
	}
	
	public L1101_SimpleGeometricObject(String color, boolean filled) {
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
