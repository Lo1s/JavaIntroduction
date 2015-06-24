/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 11:00:11 
 */
public class L1003_UseBMI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1004_BMI bmi1 = new L1004_BMI("Kim Yang", 18, 145, 70);
		L1004_BMI bmi2 = new L1004_BMI("Susan King", 215, 70);
		
		System.out.println("The BMI for: " + bmi1.getName() + " is " + bmi1.getBMI() + " " + bmi1.getStatus());
		System.out.println("The BMI for: " + bmi2.getName() + " is " + bmi2.getBMI() + " " + bmi2.getStatus()); 
	}

}
