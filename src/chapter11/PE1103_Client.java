/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 17. 7. 2014 2014 10:45:16 
 */
public class PE1103_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1103_Account acc = new PE1103_Account(1337, 1337, 2.5);
		PE1103_CheckingAccount checkAcc = new PE1103_CheckingAccount(13370, 13370, 2.5, 10000);
		PE1103_SavingsAccount savingsAcc = new PE1103_SavingsAccount(133700, 133700, 2.5);
		
		
		System.out.println(acc.toString());
		System.out.println("\nAfter withdrawl:");
		acc.withdraw(20000);
		System.out.println(acc.toString());
		System.out.println("\n");
		
		System.out.println(checkAcc.toString());
		System.out.println("\nAfter withdrawl:");
		checkAcc.withdraw(30000);
		System.out.println(checkAcc.toString());
		System.out.println("\n");
		
		System.out.println(savingsAcc.toString());
		System.out.println("\nAfter withdrawl:");
		savingsAcc.withdraw(20000);
		System.out.println(savingsAcc.toString());
		
	}

}
