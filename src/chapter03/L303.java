package chapter03;
import javax.swing.JOptionPane;

public class L303 {
  public static void main(String[] args) {

  String set1 =
	" 1	3	5	7\n" +
	" 9	11	13	15\n" +
	" 17	19	21	23\n" +
	" 25	27	29	31";

  String set2 =
	" 2	3	6	7\n" +
	" 10	11	14	15\n" +
	" 18	19	22	23\n" +
	" 26	27	30	31";  

  String set3 =
	" 4	5	6	7\n" +
	" 12	13	14	15\n" +
	" 20	21	22	23\n" +
	" 28	29	30	31";

  String set4 =
	" 8	9	10	11\n" +
	" 12	13	14	15\n" + 
	" 24	25	26	27\n" +
	" 28	29	30	31";

  String set5 =
	" 16	17	18	19\n" +
	" 20	21	22	23\n" +
	" 24	25	26	27\n" +
	" 28	29	30	31";

  int day = 0;

  // Prompt the user to answer questions
  
  System.out.print("\nIs your birthday in this set of numbers ?\n");
  System.out.print(set1);
  String answerString = JOptionPane.showInputDialog(null, "Enter 0 for No and 1 for Yes: ", "Set 1", JOptionPane.QUESTION_MESSAGE);
  int answer = Integer.parseInt(answerString);

  if (answer == 1) {
  day += 1;
  }

  System.out.print("\nIs your birthday in this set of numbers ?\n");
  System.out.print(set2);
  String answerString2 = JOptionPane.showInputDialog(null, "Enter 0 for No and 1 for Yes: ", "Set 2", JOptionPane.QUESTION_MESSAGE);
  int answer2 = Integer.parseInt(answerString2);

  if (answer2 == 1) {
  day += 2; 
  }

  System.out.print("\nIs your birthday in this set of numbers ?\n");
  System.out.print(set3);
  String answerString3 = JOptionPane.showInputDialog(null, "Enter 0 for No and 1 for Yes: ", "Set 3", JOptionPane.QUESTION_MESSAGE);
  int answer3 = Integer.parseInt(answerString3);

  if (answer3 == 1) {
  day += 4;   
  }

  System.out.print("\nIs your birthday in this set of numbers ?\n");
  System.out.print(set4);
  String answerString4 = JOptionPane.showInputDialog(null, "Enter 0 for No and 1 for Yes: ", "Set 4", JOptionPane.QUESTION_MESSAGE);
  int answer4 = Integer.parseInt(answerString4);

  if (answer4 == 1) {
  day += 8; 
  }

  System.out.print("\nIs your birthday in this set of numbers ?\n");
  System.out.print(set5);
  String answerString5 = JOptionPane.showInputDialog(null, "Enter 0 for No and 1 for Yes: ", "Set 5", JOptionPane.QUESTION_MESSAGE);
  int answer5 = Integer.parseInt(answerString5);

  if (answer5 == 1) {
  day += 16;
  }

  JOptionPane.showMessageDialog(null, "Your birthday is at " + day + ". day of the month !", "Ehmm, let me guess", JOptionPane.INFORMATION_MESSAGE);

  }
}

