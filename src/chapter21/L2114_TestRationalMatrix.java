/**
 * 
 */
package chapter21;

import chapter15.L1513_Rational;

/**
 * @author jslapnicka
 * @Date & @Time 9. 12. 2014 2014 12:09:51 
 */
public class L2114_TestRationalMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1513_Rational[][] m1 = new L1513_Rational[3][3];
		L1513_Rational[][] m2 = new L1513_Rational[3][3];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m1[i][j] = new L1513_Rational(i + 1, j + 5);
				m2[i][j] = new L1513_Rational(i + 1, j + 6);
			}
		}
		
		// Create an instance of RationalMatrix
		L2112_RationalMatrix rationalMatrix = new L2112_RationalMatrix();
		
		System.out.println("\nm1 + m2 is ");
		L2110_GenericMatrix.printResult(m1, m2, rationalMatrix.addMatrix(m1, m2), '+');
		System.out.println("\nm1 * m2 is ");
		L2110_GenericMatrix.printResult(m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
	}

}
