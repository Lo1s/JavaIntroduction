package chapter04;
public class L413b {
  public static void main(String[] args) {

  int sum = 0;
  int number = 0;

  while (number < 20) {
    number++;
    if (number != 10 || number != 11) 
      sum += number;
  }

  System.out.println("The number is " + number);
  System.out.println("The sum is " + sum);
  
  }
}