/**
 * 
 */
package chapter21;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 10:23:40 
 */
public class L2113_TestIntegerMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Integer arrays m1, m2
		Integer[][] m1 = new Integer[][] {{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
		Integer[][] m2 = new Integer[][] {{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};
		
		// Create an instance of IntegerMatrix
		L2111_IntegerMatrix integerMatrix = new L2111_IntegerMatrix();
		System.out.println("\nm1 + m2 is ");
		L2110_GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
		
		System.out.println("\nm1 * m2 is ");
		L2110_GenericMatrix.printResult(m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
	}

}
