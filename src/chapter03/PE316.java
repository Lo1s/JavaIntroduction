package chapter03;
public class PE316 {
  public static void main(String[] args) {

  int random = 65 + (int)(Math.random() * ((90 - 65) + 1)); // check if casting is right
  
  System.out.print((char)random);

  }
}