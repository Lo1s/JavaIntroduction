package chapter02;

import javax.swing.JOptionPane;

public class PE216 {
  public static void main(String[] args) {

  String sideString = JOptionPane.showInputDialog(null, "Enter the side: ", "Area of Hexagon", JOptionPane.QUESTION_MESSAGE);
  double side = Double.parseDouble(sideString);

  double area = ((3 * (Math.pow(3, 0.5))) / 2) * Math.pow(side, 2);

  System.out.print("The area of the hexagon is: " + area);
  }
}

