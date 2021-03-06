package chapter05;


public class PE515 {
	public static void main(String[] args) {
		System.out.print("Taxable Income" + "     " + "Single" + "     " + "Married Joint or Qualifying Widower" + "     " +
	"Married Separated" + "     " + "Head of Household");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
			for (int income = 50000; income <= 60000; income += 50) {
				System.out.printf("%9d", income);
				System.out.printf("%15.0f", computeTax(income, 0));
				System.out.printf("%25.0f", computeTax(income, 1));
				System.out.printf("%31.0f", computeTax(income, 2));
				System.out.printf("%22.0f", computeTax(income, 3));
				System.out.println();
			}
	}
	public static double computeTax(int income, int fillingStatus) {
		

		// Declaring tax amount value
		@SuppressWarnings("unused")
		double taxAmount = 0;

		// Single: Calculating the tax amount 

		if (fillingStatus == 0) { 
			// tax rate 10%
			if (income <= 8350) {
				return taxAmount = income * 0.10;

				// tax rate 15%
			} else if (income <= 33950) {						
				return taxAmount = 8350 * 0.10 + (income - 8351) * 0.15; 

				// tax rate 25%
			} else if (income <= 82250) {						
				return taxAmount = 8350 * 0.10 + (33950 - 8351) * 0.15 + (income - 33951) * 0.25;

				// tax rate 28%
			} else if (income <= 171550) {
				return taxAmount = 8350 * 0.10 + (33950 - 8351) * 0.15 + (82250 - 33951) * 0.25 + (income - 82250) * 0.28;

				// tax rate 33%
			} else if (income <= 372950) {
				return taxAmount = 8350 * 0.10 + (33950 - 8351) + 0.15 + (82250 - 33951) * 0.25 + (171550 - 82251) * 0.28 + (income - 171551) * 0.33;

				// tax rate 35%
			} else {
				return taxAmount = 8350 * 0.10 + (33950 - 8351) + 0.15 + (82250 - 33951) * 0.25 + (171550 - 82251) * 0.28 + (372950 - 171551) * 0.33 + (income - 372951) * 0.35;
			}
			// Married Filling Jointly: Calculating the tax amount 

		} else if (fillingStatus == 1) {
			// tax rate 10%
			if (income <= 16700) {
				return taxAmount = income * 0.10;

				// tax rate 15%
			} else if (income <= 67900) {						
				return taxAmount = 16700 * 0.10 + (income - 16700) * 0.15; 

				// tax rate 25%
			} else if (income <= 137050) {						
				return taxAmount = 16700 * 0.10 + (67900 - 16701) * 0.15 + (income - 67901) * 0.25;

				// tax rate 28%
			} else if (income <= 208850) {
				return taxAmount = 16700 * 0.10 + (67900 - 16701) * 0.15 + (137050 - 67901) * 0.25 + (income - 137051) * 0.28;

				// tax rate 33%
			} else if (income <= 372950) {
				return taxAmount = 16700 * 0.10 + (67900 - 16701) + 0.15 + (137050 - 67901) * 0.25 + (208850 - 137051) * 0.28 + (income - 208851) * 0.33;

				// tax rate 35%
			} else {
				return taxAmount = 16700 * 0.10 + (67900 - 16701) + 0.15 + (137050 - 67901) * 0.25 + (208850 - 137051) * 0.28 + (372950 - 208851) * 0.33 + (income - 372951) * 0.35;
			}

			// Married Filling Separately: Calculating the tax amount 

		} else if (fillingStatus == 2) { 
			// tax rate 10%
			if (income <= 8350) {
				return taxAmount = income * 0.10;

				// tax rate 15%
			} else if (income <= 33950) {						
				return taxAmount = 8350 * 0.10 + (income - 8351) * 0.15; 

				// tax rate 25%
			} else if (income <= 68525) {						
				return taxAmount = 8350 * 0.10 + (33950 - 8351) * 0.15 + (income - 33951) * 0.25;

				// tax rate 28%
			} else if (income <= 104425) {
				return taxAmount = 8350 * 0.10 + (33950 - 8351) * 0.15 + (68525 - 33951) * 0.25 + (income - 68526) * 0.28;

				// tax rate 33%
			} else if (income <= 186475) {
				return taxAmount = 8350 * 0.10 + (33950 - 8351) + 0.15 + (68525 - 33951) * 0.25 + (104425 - 68526) * 0.28 + (income - 104426) * 0.33;

				// tax rate 35%
			} else {
				return taxAmount = 8350 * 0.10 + (33950 - 8351) + 0.15 + (68525 - 33951) * 0.25 + (104425 - 68526) * 0.28 + (186475 - 104426) * 0.33 + (income - 186476) * 0.35;
			}

			// Head Of Household: Calculating the tax amount 

		} else if (fillingStatus == 3) { 
			// tax rate 10%
			if (income <= 11950) {
				return taxAmount = income * 0.10;

				// tax rate 15%
			} else if (income <= 45500) {						
				return taxAmount = 11950 * 0.10 + (income - 11951) * 0.15; 

				// tax rate 25%
			} else if (income <= 117450) {						
				return taxAmount = 11950 * 0.10 + (45500 - 11951) * 0.15 + (income - 45501) * 0.25;

				// tax rate 28%
			} else if (income <= 190200) {
				return taxAmount = 11950 * 0.10 + (45500 - 11951) * 0.15 + (117450 - 45501) * 0.25 + (income - 117451) * 0.28;

				// tax rate 33%
			} else if (income <= 372950) {
				return taxAmount = 11950 * 0.10 + (45500 - 11951) + 0.15 + (117450 - 45501) * 0.25 + (190200 - 117451) * 0.28 + (income - 190201) * 0.33;

				// tax rate 35%
			} else {
				return taxAmount = 11950 * 0.10 + (45500 - 11951) + 0.15 + (117450 - 45501) * 0.25 + (190200 - 117451) * 0.28 + (372950 - 19201) * 0.33 + (income - 372951) * 0.35;
			}
		} else {
			System.out.print("You have entered a wrong status filling !");
			System.exit(1);
		}
		return 0;

		// Display the result


	}
}

