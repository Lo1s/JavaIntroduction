package chapter04;
public class PE403 {
  public static void main(String[] args) {

    double kilograms = 1;
    double pounds = 2.2;
    
    // Headline
    System.out.println("Kilograms          Pounds");


    while (kilograms < 200) {
      if (kilograms < 10) {
        System.out.printf("\n" + (int)kilograms + "                    %1.1f", pounds);
      } else if (kilograms >= 10 && kilograms < 100) {
        System.out.printf("\n" + (int)kilograms + "                   %2.1f", pounds);
      } else if (kilograms >= 100 && kilograms < 200) {
        System.out.printf("\n" + (int)kilograms + "                  %3.1f", pounds);

      }      
      kilograms += 2;
      pounds = kilograms * 2.2;
    }

    System.out.println();

  }
}