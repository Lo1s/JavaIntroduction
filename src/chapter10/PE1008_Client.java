/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 12:35:14 
 */
public class PE1008_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] bracketsFor2001 = {
				{27050, 65550, 136750, 297350}, // Single filer
				{45200, 109250, 166500, 297350}, // married filing jointly
				{22600, 54625, 83250, 148675}, // married filing separately
				{36250, 93650, 151650, 297350} // head of household
		};

		double[] ratesFor2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

		int[][] bracketsFor2002 = {
				{6000, 27950, 67700, 141250, 307050}, // Single filer
				{12000 , 46700, 112850, 171950, 307050}, // married filing jointly
				{6000, 23350, 56425, 85975, 153525}, // married filing separately
				{10000, 37450, 96700, 156600, 307050} // head of household
		};

		double[] ratesFor2002 = {0.1, 0.15, 0.27, 0.30, 0.35, 0.386};
		
		System.out.printf("%50s","2001 Tax Table\n");
		System.out.printf("%s%25s%25s%25s%25s","Income", "Single Filler", "Married Jointly", "Married Separately", "Head of Household\n");
		for (int i = 50000; i <= 60000; i += 1000) {
			PE1008_Tax taxSF = new PE1008_Tax(0, bracketsFor2001, ratesFor2001, i);
			PE1008_Tax taxMJ = new PE1008_Tax(1, bracketsFor2001, ratesFor2001, i);
			PE1008_Tax taxMS = new PE1008_Tax(2, bracketsFor2001, ratesFor2001, i);
			PE1008_Tax taxHH = new PE1008_Tax(3, bracketsFor2001, ratesFor2001, i);
			System.out.printf("%5d%25.2f%25.2f%25.2f%25.2f\n", i, taxSF.getTax(), taxMJ.getTax(), taxMS.getTax(), taxHH.getTax());
		}
		
		System.out.printf("%50s","2002 Tax Table\n");
		System.out.printf("%s%25s%25s%25s%25s","Income", "Single Filler", "Married Jointly", "Married Separately", "Head of Household\n");
		for (int i = 50000; i <= 60000; i += 1000) {
			PE1008_Tax taxSF = new PE1008_Tax(0, bracketsFor2002, ratesFor2002, i);
			PE1008_Tax taxMJ = new PE1008_Tax(1, bracketsFor2002, ratesFor2002, i);
			PE1008_Tax taxMS = new PE1008_Tax(2, bracketsFor2002, ratesFor2002, i);
			PE1008_Tax taxHH = new PE1008_Tax(3, bracketsFor2002, ratesFor2002, i);
			System.out.printf("%5d%25.2f%25.2f%25.2f%25.2f\n", i, taxSF.getTax(), taxMJ.getTax(), taxMS.getTax(), taxHH.getTax());
		}
	}

}
