/**
 * 
 */
package chapter08;

/**
 * @author jslapnicka
 * @Date & @Time 10. 6. 2014 2014 10:57:14 
 */
public class PE802 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock("ORCL", "Oracle Corporation");
		stock.previousClosingPrice = 34.5;
		stock.currentPrice = 34.35;
		System.out.println("The price-change percentage for " + stock.name + " (" + stock.symbol + ") is: " + stock.getChangePercent());
	}

}
class Stock {
	String symbol;
	String name;
	double previousClosingPrice = 0;
	double currentPrice = 0;
	
	/** Creates the Stock object */
	public Stock(String newSymbol, String newName) {
		symbol = newSymbol;
		name = newName;
	}
	/** Instance method for calculation of the change in the percentage of the stock price */
	public double getChangePercent() {
		return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
	}
		
}
