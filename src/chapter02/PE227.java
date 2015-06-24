package chapter02;

import javax.swing.JOptionPane;

public class PE227 {
  public static void main(String[] args) {

  // Employees name
  String employeesName = JOptionPane.showInputDialog(null, "Enter employee's name: ", "Employee's name", JOptionPane.QUESTION_MESSAGE);
    
  // Worktime
  String numberOfHoursString = JOptionPane.showInputDialog(null, "Enter number of hours worked in a week: ", "Worktime", JOptionPane.QUESTION_MESSAGE); 
  int numberOfHours = Integer.parseInt(numberOfHoursString);

  // Pay rate
  String hourlyPayRateString = JOptionPane.showInputDialog(null, "Enter hourly pay rate: ", "Pay rate", JOptionPane.QUESTION_MESSAGE); 
  double hourlyPayRate = Double.parseDouble(hourlyPayRateString);
  double grossPayment = hourlyPayRate * numberOfHours;

  // Federal tax
  String federalWithholdingRateString = JOptionPane.showInputDialog(null, "Enter federal tax withholding rate: ", "Federal Tax", JOptionPane.QUESTION_MESSAGE); 
  double federalWithholdingRate = Double.parseDouble(federalWithholdingRateString);
  double federalTax = federalWithholdingRate * (hourlyPayRate * numberOfHours);

  // State tax
  String stateWithholdingRateString = JOptionPane.showInputDialog(null, "Enter a state tax withholding rate: ", "State Tax", JOptionPane.QUESTION_MESSAGE);  
  double stateWithholdingRate = Double.parseDouble(stateWithholdingRateString);
  double stateTax = stateWithholdingRate  * (hourlyPayRate * numberOfHours);

  JOptionPane.showMessageDialog(null, 
	"\t" + "Employee name: " + employeesName + "\n" +
	"\t" + "Hours worked: " + numberOfHours + "\n"  +
	"\t" + "Pay rate: " + "$" + hourlyPayRate + "\n" +
	"\t" + "Gross Pay: " + "$" + grossPayment + "\n" +
	"\t" + "Deductions: " + "\n" +
	"\t" + " Federal Withholding (20.0%): " + "$" + federalTax + "\n" +
	"\t" + " State Withholding (9.0%): " + "$" + stateTax + "\n" +
	"\t" + " Total Deduction: " + "$" + (federalTax + stateTax) + "\n" +
	"\t" + "Net pay: " + "$" + (grossPayment - (federalTax + stateTax)), "Employee information", JOptionPane.INFORMATION_MESSAGE);
  }
} 
  