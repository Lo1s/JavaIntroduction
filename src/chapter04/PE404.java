package chapter04;
public class PE404 {
  public static void main(String[] args) {

    double miles = 1;
    double kilometers = 2.2;
    
    // Headline
    System.out.println("Miles          Kilometers");


    while (miles < 11) {
      if (miles < 10) {
        System.out.printf("\n" + (int)miles + "                    %1.3f", kilometers);
      } else if (miles == 10) {
        System.out.printf("\n" + (int)miles + "                   %2.3f", kilometers);
        System.out.println();
      }      
      miles ++;
      kilometers = miles * 1.609;
    }
  }
}