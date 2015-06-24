/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 13:55:04 
 */
public class PE1009_Course {

	private int capacity = 5;
	private String courseName;
	private String[] students = new String[capacity];
	private int numberOfStudents;
	
	public PE1009_Course(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void addStudent(String student) {
		if (numberOfStudents >= this.capacity) {
			this.capacity = 2 * capacity;
			String[] temp = new String[capacity];
			System.arraycopy(students, 0, temp, 0, students.length);
			students = temp;
		}
		
		this.students[numberOfStudents++] = student;
	}
	
	public void dropStudent(String student) {
		for (int i = 0; i < students.length; i++) {
			if (students[i].equals(student)) {
				for (int j = i; j < students.length - 1; j++) {
					students[j] = students[j + 1];
				}
				break;
			}		
		}
		numberOfStudents--;
	}
	
	public void clear() {
		for (int i = 0; i < students.length; i++) {
			students[i] = "";
		}
		this.numberOfStudents = 0;
	}
	
	public String[] getStudents() {
		return this.students;
	}
	
	public int getNumberOfStudents() {
		return this.numberOfStudents;
	}
	
	
}

