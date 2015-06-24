/**
 * 
 */
package chapter11;

/**
 * @author jslapnicka
 * @Date & @Time 17. 7. 2014 2014 7:36:54 
 */
public class PE1102_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PE1102_Person person = new PE1102_Person();
		PE1102_Student student = new PE1102_Student();
		PE1102_Employee employee = new PE1102_Employee();
		PE1102_Faculty faculty = new PE1102_Faculty();
		PE1102_Staff staff = new PE1102_Staff();
		staff.title = "Test";
		
		System.out.println(person.toString());
		System.out.println(student.toString());
		System.out.println(employee.toString());
		System.out.println(faculty.toString());
		System.out.println(staff.toString());
	}

}
