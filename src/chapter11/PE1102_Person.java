/**
 * 
 */
package chapter11;

import chapter10.PE1014_MyDate;

/**
 * @author jslapnicka
 * @Date & @Time 16. 7. 2014 2014 14:22:00 
 */
public class PE1102_Person {
	private String name;
	private String address;
	private String phoneNumber;
	private String email;

	public PE1102_Person() {

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person";
	}

}

class PE1102_Student extends PE1102_Person {
	public final int FRESHMAN = 1;
	public final int SOPHOMORE = 2;
	public final int JUNIOR = 3;
	public final int SENIOR = 4;

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student";
	}
}

class PE1102_Employee extends PE1102_Person {
	protected String office;
	protected int salary;
	protected PE1014_MyDate dateHired;

	public PE1102_Employee() {

	}

	@Override
	public String toString() {
		return "Employee";
	}
}

class PE1102_Faculty extends PE1102_Employee {
	public final int LECTURER = 1;
	public final int ASSISTANT_PROFESSOR = 2;
	public final int ASSOCIATE_PROFESSOR = 3;
	public final int PROFESSOR = 4;

	protected String officeHours;
	protected int rank;
	
	public String toString() {
		return "Faculty";
	}
}

class PE1102_Staff extends PE1102_Employee {
	protected String title;
	
	public String toString() {
		return "Staff's title is " + title;
	}
}
