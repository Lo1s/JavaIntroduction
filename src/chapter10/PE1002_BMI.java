/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 9. 7. 2014 2014 10:15:36 
 */
public class PE1002_BMI {
	private String name;
	private int age;
	private double weight;
	private double height;
	public static final double KILOGRAMS_PER_POUND = 0.45359237;
	public static final double METERS_PER_INCH = 0.0254;
	
	public PE1002_BMI(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	public PE1002_BMI(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.age = 20;
	}
	
	public PE1002_BMI (String name, int age, double weight, double feet, double inches) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = inches + (feet * 12);	
	}
	
	public double getBMI() {
		double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		return Math.round(bmi * 100) / 100.0;
	}
	
	public String getStatus() {
		double bmi = getBMI();
		if (bmi < 18.5)
			return "Underweight";
		else if (bmi < 25)
			return "Normal";
		else if (bmi < 30)
			return "Overweight";
		else
			return "Obese";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	
}
