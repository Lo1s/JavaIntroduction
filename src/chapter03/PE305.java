package chapter03;
import java.util.Scanner;

  public class PE305 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter today's day: ");
    int today = input.nextInt();

    String todaysName = "";

    switch(today) {
    case 0: todaysName = "Sunday"; break;
    case 1: todaysName = "Monday"; break;
    case 2: todaysName = "Tuesday"; break;
    case 3: todaysName = "Wednesday"; break;
    case 4: todaysName = "Thursday"; break;
    case 5: todaysName = "Friday"; break;
    case 6: todaysName = "Saturday"; break;
    }     

    System.out.print("Enter the number of days elapsed since today: ");
    int elapsedDays = input.nextInt();

    int futureDay = (today + elapsedDays) % 7;

    switch(futureDay) {
    case 0: System.out.print("Today is " + todaysName + " and the future day is Sunday !"); break;
    case 1: System.out.print("Today is " + todaysName + " and the future day is Monday !"); break;
    case 2: System.out.print("Today is " + todaysName + " and the future day is Tuesday !"); break;
    case 3: System.out.print("Today is " + todaysName + " and the future day is Wednesday !"); break;
    case 4: System.out.print("Today is " + todaysName + " and the future day is Thursday !"); break;
    case 5: System.out.print("Today is " + todaysName + " and the future day is Friday !"); break;
    case 6: System.out.print("Today is " + todaysName + " and the future day is Saturday !"); break;
	
    }

  }
}        