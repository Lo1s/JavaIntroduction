/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 13:55:19 
 */
public class PE1009_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1009_Course course1 = new PE1009_Course("Dreamers");

		// Adding students
		course1.addStudent("DeStorm");
		course1.addStudent("Will Smith");
		course1.addStudent("2Pac");
		course1.addStudent("Steve Jobs");
		course1.addStudent("Rafael Nadal");
		course1.addStudent("Jurashek");

		// Dropping student
		course1.dropStudent("2Pac");

		String[] test1 = course1.getStudents();
		for (int i = 0; i < course1.getNumberOfStudents(); i++) {
				System.out.print(test1[i] + " ");
		}
	}

}
