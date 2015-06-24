package chapter04;
public class PE418d {
  public static void main(String [] args) {
    for (int i = 0; i < 6; i++) {
      for (int j = 1; j <= 6; j++)
        if (i == j || i < j) {
          System.out.print(((j - i) != 0) ? (j - i) + " " : " " + " ");
        } else if (i > j) {
          System.out.print(" " + " ");
        }
      System.out.println();
    }
  }
}

