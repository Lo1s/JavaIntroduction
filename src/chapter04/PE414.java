package chapter04;
import java.util.Scanner;

public class PE414 {

	@SuppressWarnings("resource")
	public PE414() {
		// TODO Auto-generated constructor stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int n1 = input.nextInt();
		System.out.print("Enter the second number: ");
		int n2 = input.nextInt();
		int gcd = 1;
		int d = 2;
		
		if (n1 > n2)
			d = n2;
		else
			d = n1;
		
		while (d > 1) {
			if (n1 % d == 0 && n2 % d == 0) {
				gcd = d;
				break;
			} else {
				d--;
			}						
		}
		System.out.println("The greatest common diviser is: " + gcd);
	}

}
