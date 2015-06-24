package chapter04;

import java.util.Scanner;

public class PE441 {

	public PE441() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int number = input.nextInt();
		int count = 1;
		int max = 0;
		
		while (number != 0) {
			if (number > max) {
				max = number;
				count = 1;
			} else if (number == max)
				count++;
			number = input.nextInt();
		}
		System.out.println("The largest number is: " + max);
		System.out.println("The occurence count of the largest number is: " + count);
		

	}

}
