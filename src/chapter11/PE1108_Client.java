/**
 * 
 */
package chapter11;



/**
 * @author jslapnicka
 * @Date & @Time 18. 7. 2014 2014 15:47:38 
 */
public class PE1108_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1108_Account acc1 = new PE1108_Account();
		acc1.setAnnualInterestRate(1.5);
		acc1.setBalance(1000);
		acc1.setiD(1122);
		acc1.setName("George");
		
		acc1.deposit(30);
		acc1.deposit(40);
		acc1.deposit(50);
		
		acc1.withdraw(5);
		acc1.withdraw(4);
		acc1.withdraw(2);
		
		System.out.println(acc1.toString() + "\n");
		System.out.println(acc1.transaction.toString());
	}

}
