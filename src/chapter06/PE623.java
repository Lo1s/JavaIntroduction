/**
 * 
 */
package chapter06;

/**
 * @author jslapnicka
 *
 */
public class PE623 {

	/**
	 * 
	 */
	public PE623() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] status = new boolean[100];
		int[] students = new int[100];
		int position = 0;

		for (int i = 0; i < students.length; i++) {
			students[i] = (i + 1);
		}

		for (int i = 0; i < students.length; i++) {
			position = 0;
			for (int j = 0; position < status.length; j++) {
				position = (i + (j * students[i]));
				if (position < status.length && status[position])
					status[i + j * students[i]] = false;
				else if (position < status.length && !status[position])
					status[i + j * students[i]] = true;
			}
		}
		hdR.mtd.displayArray(status, 10);
	}

}
