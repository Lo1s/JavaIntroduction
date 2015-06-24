/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 12:12:50 
 */
public class L1005_TestCourse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L1006_Course course1 = new L1006_Course("Data Structures");
		L1006_Course course2 = new L1006_Course("Database Systems");
		
		course1.addStudent("Peter Jones");
		course1.addStudent("Kim Smith");
		course1.addStudent("Anne Kennedy");
		
		course2.addStudent("Peter Jones");
		course2.addStudent("Steve Smith");
		
		System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
		String[] students = course1.getStudents();
		for (int i = 0; i < course1.getNumberOfStudents(); i++) {
			System.out.println(students[i]);
		}
		
		System.out.println("\nNumber of students in course2: " + course2.getNumberOfStudents());
		String[] students2 = course2.getStudents();
		for (int i = 0; i < course2.getNumberOfStudents(); i++) {
			System.out.println(students2[i]);
		}
		
	}

}
