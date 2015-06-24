package chapter03;
import java.util.Scanner;

public class L302 {
  @SuppressWarnings("resource")
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number for a day: ");
    byte day = input.nextByte();

    switch (day) {
      case 0: System.out.println(day + " stands for Sunday !"); break;
      case 1: System.out.println(day + " stands for Monday !"); break;
      case 2: System.out.println(day + " stands for Tuesday !"); break;
      case 3: System.out.println(day + " stands for Wednesday !"); break;
      case 4: System.out.println(day + " stands for Thursday !"); break;
      case 5: System.out.println(day + " stands for Friday !"); break;
      case 6: System.out.println(day + " stands for Saturday !"); break;
    }
  }
}