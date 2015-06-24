/**
 * 
 */
package chapter11;

import java.util.ArrayList;

/**
 * @author jslapnicka
 * @Date & @Time 18. 7. 2014 2014 10:11:18 
 */
public class PE1105_Course {
	private String courseName;
	private ArrayList<String> students = new ArrayList<String>();
	
	public PE1105_Course(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void addStudent(String student) {
		students.add(student);
	}
	
	public void dropStudent(String student) {
		students.remove(student);	
	}
	
	public String getStudents() {
		return this.students.toString();
	}
	
	public int getNumberOfStudents() {
		return students.size();
	}
	
	
}