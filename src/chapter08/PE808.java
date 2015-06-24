/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 * @Date & @Time 11. 6. 2014 2014 16:40:35 
 */
public class PE808 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// First fan
		Fan fan1 = new Fan();
		fan1.setSpeed(fan1.FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		System.out.println("First Fan: ");
		System.out.println(fan1.toString() + "\n");
		// Second fan
		Fan fan2 = new Fan();
		fan2.setSpeed(fan2.MEDIUM);
		fan2.setRadius(5);
		fan2.setColor("blue");
		fan2.setOn(false);
		System.out.println("Second Fan: ");
		System.out.println(fan2.toString());
	}

}

class Fan {
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5;
	String color = "blue";
	
	// No-arg constructor
	Fan() {
		
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the on
	 */
	public boolean isOn() {
		return on;
	}

	/**
	 * @param on the on to set
	 */
	public void setOn(boolean on) {
		this.on = on;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
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
	
	/** toString method */
	public String toString() {
		String toString = "";
		if (on) {
			toString = "Speed: " + speed + "\nColor: " + color + "\nRadius: " + radius;
			return toString;
		} else {
			toString = "Color: " + color + "\nRadius: " + radius + "\nFan is off";
			return toString;
		}
			
	}
	
}