/**
 * 
 */
package chapter15;

/**
 * @author jslapnicka
 * @Date & @Time 8. 9. 2014 2014 8:54:09 
 */
public class PE1515_CourseCloneable implements Cloneable {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	
	public PE1515_CourseCloneable(String courseName) {
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
