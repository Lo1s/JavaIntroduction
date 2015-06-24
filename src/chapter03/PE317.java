package chapter03;
import java.util.Scanner;

public class PE317 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);


			System.out.println("scissors(0), rock(1), paper(2)");
			int guess = input.nextInt();

			String guessString = "";

			switch(guess) {
			case 0: guessString = "Scissors"; break;
			case 1: guessString = "Rock"; break;
			case 2: guessString = "Paper"; break;
			}

			int random = (int)(Math.random() * ((2 - 0) + 1));

			String randomString = "";

			switch(random) {
			case 0: randomString = "Scissors"; break;
			case 1: randomString = "Rock"; break;
			case 2: randomString = "Paper"; break;
			}

			if (guess == random) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + " too. It is a draw !");
			} else if (guess == 0 && random == 1) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + ". You lose !");
			} else if (guess == 0 && random == 2) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + ". You won !");
			} else if (guess == 1 && random == 0) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + ". You won !");
			} else if (guess == 1 && random == 2) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + ". You lose !");
			} else if (guess == 2 && random == 0) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + ". You lose !");
			} else if (guess == 2 && random == 1) {
				System.out.println("The computer is " + randomString + "." + " You are " +
						guessString + ". You won !");
			}
		
	}
}            

