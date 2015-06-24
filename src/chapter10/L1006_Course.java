/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 7. 7. 2014 2014 12:12:29 
 */
public class L1006_Course {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	
	public L1006_Course(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void addStudent(String student) {
		this.students[numberOfStudents++] = student;
	}
	
	public void dropStudent(String student) {
	
	}
	
	public String[] getStudents() {
		return this.students;
	}
	
	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}
	
	
}
