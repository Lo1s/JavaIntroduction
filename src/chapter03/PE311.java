package chapter03;
import java.util.Scanner;

  public class PE311 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

      Scanner input = new Scanner(System.in);
      
      System.out.print("Please enter the month (by its number: ");
      int monthInput = input.nextInt();
      System.out.print("Please enter the year: ");
      int yearInput = input.nextInt();

      // check if the initialization of the variable "month" is relevant
      
      int january = 31;
      int february = 28;
      int februaryLeap = 29;
      int march = 31;
      int april = 30;
      int may = 31;
      int june = 30;
      int july = 31;
      int august = 31;
      int september = 30;
      int october = 31;
      int november = 30;
      int december = 31;

      if (yearInput % 4 == 0 && yearInput % 100 != 0 && (monthInput == 2)) {
        System.out.println("February " + yearInput + " had " + februaryLeap + " days.");
      } else {
        switch(monthInput) {
          case 1: System.out.print("January " + yearInput + " had " + january + " days."); break;
          case 2: System.out.print("February " + yearInput + " had " + february + " days."); break;
          case 3: System.out.print("March " + yearInput + " had " + march + " days."); break;
          case 4: System.out.print("April " + yearInput + " had " + april + " days."); break;
          case 5: System.out.print("May " + yearInput + " had " + may + " days."); break;
          case 6: System.out.print("June " + yearInput + " had " + june + " days."); break;
          case 7: System.out.print("July " + yearInput + " had " + july + " days."); break;
          case 8: System.out.print("August " + yearInput + " had " + august + " days."); break;
          case 9: System.out.print("September " + yearInput + " had " + september + " days."); break;
          case 10: System.out.print("October " + yearInput + " had " + october + " days."); break;
          case 11: System.out.print("November " + yearInput + " had " + november + " days."); break;
          case 12: System.out.print("December " + yearInput + " had " + december + " days."); break;
        }
      }
  }
}