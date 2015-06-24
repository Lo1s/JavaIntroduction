package chapter04;
public class L407 {
  public static void main(String[] args) {

    // Display the table heading
    System.out.print("\n\n");
    System.out.println("            Multiplication Table");

    //Display the number title

    System.out.print("    ");
    for (int j = 1; j < 10; j++) {
      System.out.print("   " + j);
    }   

      System.out.println("\n--------------------------------------");

    // Display the table body

    for (int i = 1; i < 10; i++) {
      System.out.print(i + " | ");
      for (int j = 1; j < 10; j++) {
        System.out.printf("%4d", i * j);
      }
      System.out.println();
    }
  }
} 