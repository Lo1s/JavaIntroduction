package chapter01;
// Vypo�te "p�"

public class PE107 {
  public static void main(String[] args) { 


    System.out.println("Pokud dosad�m 1 = " + 4.0 * (1/1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11));
    System.out.println("Pokud dosad�m 1.0 = " + 4.0 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11));
    System.out.println("P�esn�j�� v�po�et = " + 4.0 * (1.0 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13));
  }
}    