/**
 * 
 */
package chapter22;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * @author jslapnicka
 * @Date & @Time 12. 12. 2014 2014 12:57:05 
 */
@SuppressWarnings("serial")
public class PE2207_Hangman extends JFrame {

	public PE2207_Hangman() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		add(new Hangman());
	}

	class Hangman extends JPanel {
		int angle = 90;
		int leftAngle = 70;
		int rightAngle = 110;
		Timer timer;
		String guessString = "";
		Scanner input = new Scanner(System.in);
		Scanner fileInput;
		String[] word = new String[32];
		GuessWord guess = new GuessWord();
		StringBuilder userGuess;
		boolean wannaPlay;

		public Hangman() throws FileNotFoundException {
			// TODO Auto-generated constructor stub


			try {
				fileInput = new Scanner(new File ("C:/Java/site/Test/PE925-input.txt"));
				for (int i = 0; i < word.length; i++) {
					word[i] = fileInput.nextLine();
				}
				guess.setWord(word[(int)(Math.random() * (32 - 1) + 1)]);
				guess.setUserGuess(new StringBuilder(guess.getWord().length()).toString());
				guess.toAsterisks();
			} catch(FileNotFoundException ex) {
				System.out.println("Database file not found !");
				System.exit(1);
			}

			timer = new Timer(100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (angle < rightAngle) {
						angle++;
						rightAngle = 110;
					} else {
						angle--;
						rightAngle = leftAngle;
					}
					repaint();
				}
			});

			setFocusable(true);
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int delay = timer.getDelay();
					if (e.getKeyCode() == KeyEvent.VK_UP && delay > 10) {
						delay -= 10;
						timer.setDelay(delay);
					} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						delay += 10;
						timer.setDelay(delay);
					}
					// Game on !
					if (!guess.userGuess.toString().equals(guess.getWord()) && guess.missedLetters.length() < 7) {
						char guessChar = e.getKeyChar();
						if (guess.isRight(guessChar))
							guess.modify(guessChar);
					} else if (e.getKeyChar() == '\n' && (guess.missedLetters.length() == 7 || guess.userGuess.toString().equals(guess.getWord()))) {
						guess.setWord(word[(int)(Math.random() * (32 - 1) + 1)]);
						guess.setUserGuess(new StringBuilder(guess.getWord().length()).toString());
						guess.removeUserGuess();
						guess.removeMissedLetters();
						guess.toAsterisks();
						timer.stop();
						angle = 90;
						leftAngle = 70;
						rightAngle = 110;
					}
					repaint();
					System.out.println(guess.missedLetters.length());


				}
			});
		}


		public void setGuess(String guessWord) {
			this.guessString = guessWord;
			repaint();
		}


		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.drawArc(20, 200, 80, 40, 0, 180); // Draw the base
			g.drawLine(20 + 40, 200, 20 + 40, 20); // Draw the pole
			g.drawLine(20 + 40, 20, 20 + 40 + 100, 20); // Draw the hanger


			// Draw the guess
			Font font = new Font("TimesRoman", Font.BOLD, 20);
			g.setFont(font);
			if (guess.missedLetters.length() < 7 && !guess.userGuess.toString().equals(guess.getWord())) {
				g.drawString("Guess a word:", 10, 300);
				g.drawString(guess.getUserGuess(), 230, 300);
				g.drawString("Missed letters:", 10, 340);
				g.drawString(guess.getMissedLetters(), 230, 340);
			} 
			if (guess.missedLetters.length() == 7 || guess.userGuess.toString().equals(guess.getWord())) {
				g.drawString("The word is: " + guess.getWord(), 10, 300);			
				g.drawString("To continue a game, press ENTER", 10, 340);
			}



			int x1 = 20 + 40 + 100;
			int y1 = 20;
			int radius = 20;
			int x = x1 + (int)(radius * Math.cos(Math.toRadians(angle)));
			int y = y1 + (int)(radius * Math.sin(Math.toRadians(angle)));

			if (guess.missedLetters.length() > 0)
				g.drawLine(20 + 40 + 100, 20, x, y); // Draw the hanger

			// Draw the head
			double length = 20 + 20;
			if (guess.missedLetters.length() > 1) {
				x = x1 + (int)(length * Math.cos(Math.toRadians(angle)));
				y = y1 + (int)(length * Math.sin(Math.toRadians(angle)));      
				g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius); // Draw the hanger
			}
			// Draw the left arm
			double angle1 = 0;
			int x2 = 0;
			int y2 = 0; 
			int x3 = 0;
			int y3 = 0;

			if (guess.missedLetters.length() > 2) {
				length = distance(x1, y1, 
						20 + 40 + 100 - (int)(radius * Math.cos(Math.toRadians(45))),
						40 + radius + (int)(radius * Math.sin(Math.toRadians(45))));    
				angle1 = Math.toDegrees(Math.asin(
						radius * Math.cos(Math.toRadians(45)) / length));
				x2 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
				y2 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1)));      

				length = (int)distance(x1, y1, 
						20 + 40 + 100 - 60, 40 + radius + 60);
				angle1 = Math.toDegrees(Math.asin(60 / length));
				x3 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
				y3 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1)));      

				g.drawLine(x2, y2, x3, y3);
			}

			if (guess.missedLetters.length() > 3) {
				// Draw the right arm
				length = distance(x1, y1, 
						20 + 40 + 100 + (int)(radius * Math.cos(Math.toRadians(45))),
						40 + radius + (int)(radius * Math.sin(Math.toRadians(45))));    
				angle1 = - Math.toDegrees(Math.asin(
						radius * Math.cos(Math.toRadians(45)) / length));
				x2 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
				y2 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1)));      

				length = (int)distance(x1, y1, 
						20 + 40 + 100 + 60, 40 + radius + 60);
				angle1 = -Math.toDegrees(Math.asin(60 / length));
				x3 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
				y3 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1))); 

				g.drawLine(x2, y2, x3, y3);
			}

			if (guess.missedLetters.length() > 4) {
				// Draw the body
				length = 40 + 20;
				x2 = x1 + (int)(length * Math.cos(Math.toRadians(angle)));
				y2 = y1 + (int)(length * Math.sin(Math.toRadians(angle)));

				length = 40 + 20 + 60;
				x3 = x1 + (int)(length * Math.cos(Math.toRadians(angle)));
				y3 = y1 + (int)(length * Math.sin(Math.toRadians(angle)));

				g.drawLine(x2, y2, x3, y3);
			}

			int x4 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
			int y4 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1)));

			if (guess.missedLetters.length() > 5) {
				// Draw the left leg
				length = distance(x1, y1, 
						20 + 40 + 100 - 40, 40 + radius + 80 + 40);     
				angle1 = Math.toDegrees(Math.asin(
						40.0 / length));
				x4 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
				y4 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1)));            
				g.drawLine(x3, y3, x4, y4);
			}

			if (guess.missedLetters.length() > 6) {
				// Draw the right leg
				angle1 = -Math.toDegrees(Math.asin(
						40.0 / length));
				x4 = x1 + (int)(length * Math.cos(Math.toRadians(angle + angle1)));
				y4 = y1 + (int)(length * Math.sin(Math.toRadians(angle + angle1)));            
				g.drawLine(x3, y3, x4, y4);
				timer.start();
			}

		}


	}

	class GuessWord { 
		private String word = "";
		private StringBuilder userGuess = new StringBuilder();
		private StringBuilder missedLetters = new StringBuilder();
		GuessWord() {		
		}

		// Creates a word made from asterisks
		public void toAsterisks() {
			for (int i = 0; i < word.length() ; i++) {
				userGuess.replace(i, i + 1, "*");
			}	
		}
		// Randomly choose the word from the input file
		public void chooseWord() {

		}

		public boolean isAlreadyMissed(char ch) {
			for (int i = 0; i < missedLetters.length(); i++) {
				if (missedLetters.charAt(i) == ch)
					return true;
			}
			return false;
		}

		// Checks the quessed char
		public boolean isRight(char ch) {
			for (int i = 0; i < word.length(); i++) {
				if (userGuess.charAt(i) == '*' && ch == word.charAt(i)) {
					return true;
				} else if (userGuess.charAt(i) != '*' && ch == word.charAt(i)) {
					System.out.println(ch + " is already in the word !");
					return false;
				}
			}
			System.out.println(ch + " is not in the word !");
			if (!isAlreadyMissed(ch)) {
				missedLetters.append(ch + "");
			}
			return false;
		}
		// Change the asteriks to the char
		public void modify(char ch) {
			for (int i = 0; i < userGuess.length(); i++) {
				if (userGuess.charAt(i) == '*')
					if (ch == word.charAt(i))
						userGuess.setCharAt(i, ch);
			}
		}
		// Getter for the guess word
		public String getWord() {
			return this.word;
		}
		public String setWord(String newWord) {
			return this.word = newWord;
		}

		public String getUserGuess() {
			return this.userGuess.toString();
		}

		public void removeUserGuess() {
			this.userGuess.delete(0, userGuess.length() - 1);
		}

		public void setUserGuess(String userGuess) {
			this.userGuess.append(userGuess);
		}

		public String getMissedLetters() {
			return missedLetters.toString();
		}

		public void removeMissedLetters() {
			this.missedLetters = new StringBuilder();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		JFrame frame = new PE2207_Hangman();
		frame.setTitle("Exercise16_34");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	/** Compute the distance between two points (x1, y1) and (x2, y2)*/
	public static double distance(
			double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

}