package chapter03;
import javax.swing.JOptionPane;

  public class PE324 {
    public static void main(String[] args) {

    int randomRank = 1 + (int)(Math.random() * ((13 - 1) + 1));
    int randomSuit = 1 + (int)(Math.random() * ((4 - 1) + 1));    

    String card = "";

    switch(randomRank) {
      case 1: card = "Ace"; break;
      case 2: card = "Two"; break;
      case 3: card = "Three"; break;
      case 4: card = "Four"; break;
      case 5: card = "Five"; break;
      case 6: card = "Six"; break;
      case 7: card = "Seven"; break;
      case 8: card = "Eight"; break;
      case 9: card = "Nine"; break;
      case 10: card = "Ten"; break;
      case 11: card = "Jack"; break;
      case 12: card = "Queen"; break;
      case 13: card = "King"; break;
    }

   String suit = "";
   
   switch(randomSuit) {
     case 1: suit = "Clubs"; break;
     case 2: suit = "Diamonds"; break;
     case 3: suit = "Hearts"; break;
     case 4: suit = "Spades"; break;
   }
   System.out.println(randomRank + ", " + randomSuit);

   JOptionPane.showMessageDialog(null, "The card you picked is " + card + " of " + suit + " !", "Deck of Cards", JOptionPane.INFORMATION_MESSAGE);
 
  }  
}   