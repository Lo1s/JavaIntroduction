/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 8:57:33 
 */
public class PE1515_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		PE1515_CourseCloneable course1 = new PE1515_CourseCloneable("Course 1");
		course1.addStudent("John");
		course1.addStudent("Will");
		PE1515_CourseCloneable course2 = (PE1515_CourseCloneable)course1.clone();
		course2.addStudent("Jura");
		System.out.println("Course 1: "
				+ "\nName: " + course1.getCourseName()
				+ "\nNumber of students: " + course1.getNumberOfStudents());
		System.out.println("\nCourse 2: "
				+ "\nName: " + course2.getCourseName()
				+ "\nNumber of students: " + course2.getNumberOfStudents());
	}

}
