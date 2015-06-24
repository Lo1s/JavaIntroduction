/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 9. 7. 2014 2014 10:15:15 
 */
public class PE1002_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1002_BMI test = new PE1002_BMI("Jura", 26, 127.868, 5, 6);
		
		System.out.println("My BMI: " + test.getBMI() + " " + test.getStatus() + " (height control: " + test.getHeight() * 0.0254 + ")");
	}

}
