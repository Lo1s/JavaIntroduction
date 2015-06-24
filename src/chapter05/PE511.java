/**
 * 
 */
package chapter05;

/**
 * @author Jura
 *
 */
public class PE511 {

	/**
	 * 
	 */
	public PE511() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int salesAmount = 0;
		System.out.println("Sales amount     Commission");
		System.out.println("___________________________");
		for (int i = 10000; i <= 100000; i += 5000) {
			salesAmount = i;
			System.out.printf("%6d%18.1f", salesAmount, computeCommission(salesAmount));
			System.out.println();
		}
	}

		public static double computeCommission(double salesAmount)
		{
			double commission;
			if(salesAmount >= 10000.01D)
			{
				commission = 900D + (salesAmount - 10000D) * 0.12D;
			} else
				if(salesAmount >= 5000.0100000000002D)
				{
					commission = 400D + (salesAmount - 5000D) * 0.10000000000000001D;
				} else
				{
					commission = salesAmount * 0.080000000000000002D;
				}
			return commission;
		}
	}




