package chapter04;
public class PE418c {
  public static void main(String [] args) {

    for (int i = 1; i <= 6; i++) {
      for (int j = 6; j > 0; j--)
        if (j > i) {
          System.out.print(" " + " ");
        } else if (j == i || j < i) {
          System.out.print(j + " ");
        }            
    System.out.println();
    }
  }
}    



  