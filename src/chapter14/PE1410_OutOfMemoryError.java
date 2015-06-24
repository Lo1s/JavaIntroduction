/**
 * 
 */
package chapter14;

/**
 * @author jslapnicka
 * @Date & @Time 22. 8. 2014 2014 15:16:31 
 */
public class PE1410_OutOfMemoryError {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("unused")
			int[] test = new int[20000000];
		}
		catch (Error ex) {
			ex.printStackTrace();
			System.out.println("You are running out of memory !");
		}
		
		System.out.println("Go !");
		
		javax.swing.JOptionPane.showMessageDialog(null, "Wait");
	}

}
