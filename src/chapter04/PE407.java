/**
 * 
 */
package chapter04;

/**
 * @author Jura
 *
 */
public class PE407 {

	/**
	 * 
	 */
	public PE407() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double tuition = 10000.00;
		double increase = 1.05;
		double sum = 0;
			
		for (int year = 1; year <= 14; year++) {
			tuition = tuition * increase;
			if (year > 1)
				System.out.println("Tuition in " + year + " years will be: " + (int)tuition);
			else
				System.out.println("Tuition in " + year + " year will be: " + (int)tuition);
			if (year >= 10)
				sum += tuition;
		}
		System.out.println("The sum for 4 year scholarship will be: " + (int)sum);

	}

}
