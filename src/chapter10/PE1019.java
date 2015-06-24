/**
 * 
 */
package chapter10;

import java.math.BigInteger;

/**
 * @author jslapnicka
 * @Date & @Time 14. 7. 2014 2014 15:25:07 
 */
public class PE1019 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pow = 1;
		
		for (BigInteger i = new BigInteger("2"); ; i = i.add(BigInteger.ONE)) {
			pow++;
			for (BigInteger j = new BigInteger("2"); j.compareTo(i) <= 0; j = j.add(BigInteger.ONE)) {
				if (!i.equals(j) && i.remainder(j).equals(BigInteger.ZERO))
					break;
				else if (i.equals(new BigInteger("2")) || j.equals(i.subtract(BigInteger.ONE))) {
					
					BigInteger mersenne = new BigInteger("2").pow(pow).subtract(BigInteger.ONE);
					for (BigInteger k = new BigInteger("2"); k.compareTo(mersenne) <= 0; k = k.add(BigInteger.ONE)) {
						if (!mersenne.equals(k) && mersenne.remainder(k).equals(BigInteger.ZERO))
							break;
						else if (k.equals(mersenne.subtract(BigInteger.ONE))) {
							System.out.print(mersenne + " ");
							break;
						}
					}
				}
			}
		}
	}

}
