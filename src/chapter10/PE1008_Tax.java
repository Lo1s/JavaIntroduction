/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 11:21:02 
 */
public class PE1008_Tax {
	public final int SINGLE_FILLER = 0;
	public final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	public final int MARRIED_SEPARATELY = 2;
	public final int HEAD_OF_HOUSEHOLD = 3;

	private int fillingStatus = SINGLE_FILLER;

	private int[][] brackets = {
			{27050, 65550, 136750, 297350}, // Single filer
			{45200, 109250, 166500, 297350}, // married filing jointly
			{22600, 54625, 83250, 148675}, // married filing separately
			{36250, 93650, 151650, 297350} // head of household
	};

	private double[] rates = {0.15, 0.275, 0.305, 0.355, 0.391};
	private double taxableIncome;
	
	public PE1008_Tax() {
		
	}
	
	public PE1008_Tax(int fillingStatus, double taxableIncome) {
		this.fillingStatus = fillingStatus;
		this.taxableIncome = taxableIncome;
	}
	
	public PE1008_Tax(int fillingStatus, int[][] brackets, double[] rates, double taxableIncome) {
		this.fillingStatus = fillingStatus;
		this.brackets = brackets;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
	}
	
	public double getTax() {
		double tax = 0;

		for (int i = 1; i < brackets[0].length; i++) {
			if (taxableIncome < brackets[fillingStatus][0]) {
				tax = taxableIncome * rates[0];
				break;
			}			
			if (taxableIncome > brackets[fillingStatus][i])
				tax += (brackets[fillingStatus][i] - brackets[fillingStatus][i - 1]) * rates[i];
			else {
				tax += (taxableIncome - brackets[fillingStatus][i - 1]) * rates[i];
				break;
			}
		}
		// Computing tax for the first bracket
		if (taxableIncome > brackets[fillingStatus][0])
			tax += brackets[fillingStatus][0] * rates[0];
		// Computing tax for last bracket if necessary
		if (taxableIncome > brackets[fillingStatus][3])
			tax += (taxableIncome - brackets[fillingStatus][3]) * rates[5];
		
		return tax;
	}
	
	/**
	 * @return the fillingStatus
	 */
	public int getFillingStatus() {
		return fillingStatus;
	}
	/**
	 * @param fillingStatus the fillingStatus to set
	 */
	public void setFillingStatus(int fillingStatus) {
		this.fillingStatus = fillingStatus;
	}
	/**
	 * @return the brackets
	 */
	public int[][] getBrackets() {
		return brackets;
	}
	/**
	 * @param brackets the brackets to set
	 */
	public void setBrackets(int[][] brackets) {
		this.brackets = brackets;
	}
	/**
	 * @return the rates
	 */
	public double[] getRates() {
		return rates;
	}
	/**
	 * @param rates the rates to set
	 */
	public void setRates(double[] rates) {
		this.rates = rates;
	}
	/**
	 * @return the taxableIncome
	 */
	public double getTaxableIncome() {
		return taxableIncome;
	}
	/**
	 * @param taxableIncome the taxableIncome to set
	 */
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	
	
}
