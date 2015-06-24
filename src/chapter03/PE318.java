package chapter03;

import javax.swing.JOptionPane;

public class PE318 {
  public static void main(String[] args) {

  String yearString = JOptionPane.showInputDialog(null, "Please enter a year. ", "Enter an year", JOptionPane.INFORMATION_MESSAGE);
  int year = Integer.parseInt(yearString); 

  // Check if the year is leap

  boolean isLeapYear =
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

  System.out.print(year + " is a leap year ? " + isLeapYear);

  }
}
