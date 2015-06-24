package chapter02;
import java.util.Scanner;

public class PE225 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

  Scanner input = new Scanner(System.in);

  System.out.print("Enter employee's name: ");			// Employees name
  String employeesName = input.next();
  

  System.out.print("Enter number of hours worked in a week: "); // Worktime
  int numberOfhours = input.nextInt();

  System.out.print("Enter hourly pay rate: "); 			// Pay rate 
  double hourlyPayRate = input.nextDouble();
  double grossPayment = hourlyPayRate * numberOfhours;

  System.out.print("Enter federal tax withholding rate: ");	// Federal tax
  double federalWithholdingRate = input.nextDouble();
  double federalTax = federalWithholdingRate * (hourlyPayRate * numberOfhours);

  System.out.print("Enter a state tax withholding rate: ");	// State tax
  double stateWithholdingRate = input.nextDouble();
  double stateTax = stateWithholdingRate  * (hourlyPayRate * numberOfhours);

  System.out.println(
	"\t" + "Employee name: " + employeesName + "\n" +
	"\t" + "Hours worked: " + numberOfhours + "\n" + 
	"\t" + "Pay rate: " + "$" + hourlyPayRate + "\n" +
        "\t" + "Gross Pay: " + "$" + grossPayment + "\n" +
	"\t" + "Deductions:" + "\n" +
	"\t" + "  Federal Withholding (20.0%): " + "$" + federalTax + "\n" +
	"\t" + "  State Withholding (9.0%): " + "$" + stateTax + "\n" +
	"\t" + "  Total Deduction: " + "$" + (federalTax + stateTax)  + "\n" +
	"\t" + "Net pay: " + "$" + (grossPayment - (federalTax + stateTax)));
  }
} 
  