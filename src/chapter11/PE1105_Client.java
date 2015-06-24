/**
 * 
 */
package chapter11;



/**
 * @author jslapnicka
 * @Date & @Time 18. 7. 2014 2014 10:25:38 
 */
public class PE1105_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1105_Course course1 = new PE1105_Course("Data Structures");
		PE1105_Course course2 = new PE1105_Course("Database Systems");
		
		course1.addStudent("Peter Jones");
		course1.addStudent("Kim Smith");
		course1.addStudent("Anne Kennedy");
		
		course2.addStudent("Peter Jones");
		course2.addStudent("Steve Smith");
		
		System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
		System.out.println(course1.getStudents());
		
		System.out.println("\nNumber of students in course2: " + course2.getNumberOfStudents());
		System.out.println(course2.getStudents());
		
	}

}