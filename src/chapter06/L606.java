/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class L606 {

	/**
	 * 
	 */
	public L606() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1, 4, 4, 2, 5, -3, 6, 2};
		
		System.out.println(linearSearch(list, -3));
	}
		public static int linearSearch(int[] array, int key) {
			for (int i = 0; i < array.length; i++) {
				if (key == array[i])
					return i;
			}
			return -1;
		}
}
