/**
 * 
 */
package chapter11;

import java.util.*;

import javax.swing.JFrame;

import chapter10.L1002_Loan;

/**
 * @author jslapnicka
 * @Date & @Time 18. 7. 2014 2014 10:32:22 
 */
public class PE1106_UseArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1002_Loan loan = new L1002_Loan();
		Date date = new Date();
		JFrame frame = new JFrame();
		L1102_CircleFromSimpleGeometricObject circle = new L1102_CircleFromSimpleGeometricObject();
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(loan);
		list.add(date);
		list.add(frame);
		list.add(circle);
		
		System.out.println(list.toString());

	}

}
