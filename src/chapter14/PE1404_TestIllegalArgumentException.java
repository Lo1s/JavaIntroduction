/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 21. 8. 2014 2014 11:02:38 
 */
public class PE1404_TestIllegalArgumentException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PE1404_IllegalArgumentException loan1 = new PE1404_IllegalArgumentException();
		
		try {
		loan1.setAnnualInterestRate(1);
		loan1.setLoanAmount(0);
		loan1.setNumberOfYears(1);
		}
		catch (IllegalArgumentException ex) {
			System.out.print(ex);
		}
	}

}
