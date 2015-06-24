package chapter03;
import java.util.Scanner;

  public class PE321 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    // input

    System.out.println("Enter year (e.g., 2012): ");
    int year = input.nextInt();
    System.out.println("Enter month: 1-12: ");
    int month = input.nextInt();
    System.out.println("Enter the day of the month: 1-31: ");
    int dayOfTheMonth = input.nextInt();

    int century = year / 100;
    int yearOfTheCentury = year % 100;    


    
    // conversion for january and february (13. & 14. month of previous year)
    if (month == 1) {
      month = 13;
      year--; 
    } else if (month == 2) {
      month = 14;
      year--;
    } 

    int dayOfTheWeek = (dayOfTheMonth + ((month + 1) * 26 / 10) + yearOfTheCentury + yearOfTheCentury / 4 + century / 4 + 5 * century) % 7;

    // creating names for days

    if(dayOfTheWeek == 0)
        {
            System.out.println("Day of the week is Saturday");
        } else
        if(dayOfTheWeek == 1)
        {
            System.out.println("Day of the week is Sunday");
        } else
        if(dayOfTheWeek == 2)
        {
            System.out.println("Day of the week is Monday");
        } else
        if(dayOfTheWeek == 3)
        {
            System.out.println("Day of the week is Tuesday");
        } else
        if(dayOfTheWeek == 4)
        {
            System.out.println("Day of the week is Wednesday");
        } else
        if(dayOfTheWeek == 5)
        {
            System.out.println("Day of the week is Thursday");
        } else
        if(dayOfTheWeek == 6)
        {
            System.out.println("Day of the week is Friday");
        }

   /* switch(dayOfTheWeek) {
      case 0: dayString = "Saturday"; break;
      case 1: dayString = "Sunday"; break;
      case 2: dayString = "Monday"; break;
      case 3: dayString = "Tuesday"; break;
      case 4: dayString = "Wednesday"; break;
      case 5: dayString = "Thursday"; break;
      case 6: dayString = "Friday"; break;
      }

    System.out.println("Day of the week is " + dayString); */
  }
}