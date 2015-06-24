package chapter04;
/**
 * 
 */

/**
 * @author Jura
 *
 */
public class PE424 {

	/**
	 * 
	 */
	public PE424() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numerator = 1;
		int devisor = 3;
		double division = (double)numerator / (double)devisor;
		double sum = 0;
		while (numerator < 97 && devisor < 99) {
			sum = division + sum;
			numerator = numerator + 2;
			devisor = devisor + 2;				

		}
		System.out.println("Numerator is: " + numerator + "\n" + 
				"Devisor is: " + devisor + "\n" + 
				"Sum is:" + sum);

	}

}
