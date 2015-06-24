package hdR;

import java.util.Scanner;
/**
 * 
 */

/**
 * @author jslapnicka
 * Compilation of own methods created during Java Introduction
 */
public class mtd {

	/**
	 * 
	 */
	public mtd() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	// Print a message n times
	public static void nPrintln(String message, int n) {
		for (int i = 0; i < n; i++) 
			System.out.println(message);

	}

	// Converts decimal number to hex
	public static String decimalToHex(int decimal) {
		String hex = "";

		while (decimal != 0) {
			int hexValue = decimal % 16;
			hex = toHexChar(hexValue) + hex;
			decimal = decimal / 16;
		}

		return hex;
	}

	public static char toHexChar(int hexValue) {
		if (hexValue <= 9 && hexValue >= 0)
			return (char)(hexValue + '0');
		else
			return (char)(hexValue - 10 + 'A');
	}

	// Finding the max value of two integers
	public static int max(int num1, int num2) {
		if (num1 > num2)
			return num1;
		else
			return num2;		
	}

	// Overloading the max method for double values
	public static double max(double num1, double num2) {
		if (num1 > num2)
			return num1;
		else 
			return num2;
	}

	// Overloading the max method for three integers
	public static int max(int num1, int num2, int num3) {
		return max(max(num1, num2), num3);
	}

	// Overloading the max method for three double values
	public static double max(double num1, double num2, double num3) {
		return max(max(num1, num2), num3);
	}

	// Generate a random character between ch1 and ch2
	public static char getRandomCharacter(char ch1, char ch2) {
		return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
	}

	// Generate a random lower case character
	public static char getRandomLowerCaseLetter() {
		return getRandomCharacter('a', 'z');
	}

	// Generate a random upper case character
	public static char getRandomUpperCaseLetter() {
		return getRandomCharacter('A', 'Z');
	}

	// Generate a random digit character
	public static char getRandomDigitCharacter() {
		return getRandomCharacter('0', '9');
	}

	// Generate a random character
	public static char getRandomCharacter() {
		return getRandomCharacter('\u0000', '\uFFFF');
	}

	// Generate a random number in range X to Y
	public static int getRandomNumber(int num1, int num2) {
		int temp = 0;
		if (num1 > 0 && num2 > 0)
			if (num2 < num1) {
				temp = num2;
				num2 = num1;
				num1 = temp;
			}
		int random = num1 + (int)(Math.random() * (num2 - (num1) + 1));
		return random;
	}

	// Get a pentagonal number n(3n - 1)/2
	public static int getPentagonalNumber(int num) {
		int n = num * (3 * num - 1)/2;
		return n;
	}

	// Sum all digits in the input integer
	public static int sumDigits(long number) {
		int sumDigits = 0;
		while (number != 0) {
			long digit = number % 10;
			number = number / 10;
			sumDigits += digit;
		}
		return sumDigits;
	}

	// Returns reversed integer
	public static int reverse(int number) {
		int digit = 0;
		int reverse =0;
		while (number != 0) {
			digit = number % 10;
			number = number / 10;
			reverse = (reverse * 10) + digit;
		}
		return reverse;			
	}

	// Reverse method void type
	public static void reverseVoid(int number) {
		int reverse = 0;
		int digit = 0;
		while (number != 0) {
			digit = number % 10;
			number = number / 10;
			reverse = (reverse * 10) + digit;
		}
		System.out.print(reverse);
	}

	// Checks if returned reversed integer is the same as original
	public static boolean isPalidrome(int number) {
		if (number == reverse(number))
			return true;
		else
			return false;

	}

	// Sorting three numbers in the increasing order
	public static void sortNumbersIncrease(double num1, double num2, double num3) {
		double sorted1 = 0;
		double sorted2 = 0;
		double sorted3 = 0;
		if (num1 < num2 && num1 < num3) {
			sorted1 = num1;
			if (num2 < num3) {
				sorted2 = num2;
				sorted3 = num3;
			} else {
				sorted3 = num2;
				sorted2 = num3;				

			}
		}
		if (num2 < num1 && num2 < num3) {
			num2 = sorted1;
			if (num1 < num3) {
				num1 = sorted2;
				sorted3 = num3;
			} else {
				sorted3 = num1;
				sorted2 = num3;
			}
		}
		if (num3 < num1 && num3 < num2) {
			sorted1 = num3;
			if (num1 < num2) {
				sorted2 = num1;
				sorted3 = num2;
			} else {
				sorted3 = num1;
				sorted2 = num2;
			}
		}
		System.out.print(sorted1 + ", " + sorted2 + ", " + sorted3);			
	}

	// Sorting numbers in decreasing order
	public static void sortNumbersDecrease(double num1, double num2, double num3) {
		double sorted1 = 0;
		double sorted2 = 0;
		double sorted3 = 0;
		if (num1 > num2 && num1 > num3) {
			sorted1 = num1;
			if (num2 > num3) {
				sorted2 = num2;
				sorted3 = num3;
			} else {
				sorted3 = num2;
				sorted2 = num3;				

			}
		}
		if (num2 > num1 && num2 > num3) {
			num2 = sorted1;
			if (num1 > num3) {
				num1 = sorted2;
				sorted3 = num3;
			} else {
				sorted3 = num1;
				sorted2 = num3;
			}
		}
		if (num3 > num1 && num3 > num2) {
			sorted1 = num3;
			if (num1 > num2) {
				sorted2 = num1;
				sorted3 = num2;
			} else {
				sorted3 = num1;
				sorted2 = num2;
			}
		}
		System.out.print(sorted1 + ", " + sorted2 + ", " + sorted3);			
	}

	// Celsius to fahrenheit
	public static double celsiusToFahrenheit(double celsius) {
		double fahrenheit = (9.0 / 5) * celsius + 32;
		return fahrenheit;
	}

	// Fahrenheit to celsius
	public static double fahrenheitToCelsius (double fahrenheit) {
		double celsius = (5.0 / 9) * (fahrenheit - 32);
		return celsius;
	}

	// Foot to meters
	public static double feetToMeters(double foot) {
		double meters = 0.305 * foot;
		return meters;
	}

	// Meters to feet
	public static double metersToFeet(double meters) {
		double foot = 3.279 * meters;
		return foot;
	}
	// Tests if number is prime
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				return false; // number is not prime
			}
		}
		return true; // number is prime
	}

	// Lists selected number of primes
	public static void printPrimeNumbers(int numberOfPrimes) {
		final int PRIMES_PER_LINE = 10;

		int count = 0;
		int number = 2;


		while (count < numberOfPrimes) {				
			if (isPrime(number)) {
				count++;

				if (count % PRIMES_PER_LINE == 0) 
					System.out.println(number);
				else 
					System.out.print(number + " ");
			}
			number++;
		}
	}

	// Checks for the leap year
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

	// Prints matrix of n size
	public static void printMatrix(int n) {
		int number = hdR.mtd.getRandomNumber(0, 1);
		for (int c = 1; c <= n; c++) {
			for (int l = 1; l <= n; l++) {
				number = hdR.mtd.getRandomNumber(0, 1);
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}

	// Print calendar for the given month of the year
	public static void printMonth(int year, int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}

	// Print month title
	public static void printMonthTitle(int year, int month) {
		System.out.println("                   " + getMonthName(month) + " " + year);
		System.out.println("   _________________________________________");
		System.out.println("    Mon   Tue   Wed   Thu   Fri   Sat   Sun");
	}

	// Print month body
	public static void printMonthBody(int year, int month) {
		int lineCheck = 0;
		for (int k = 1; k <= getStartDay(year, month); k++) {
			System.out.print("      ");
			lineCheck++;
		}
		for (int i = 1; i <= getNumberOfDaysInMonth(year, month); i++) {
			System.out.printf("%6d", i);
			lineCheck ++;
			if (lineCheck == 7) {
				System.out.println();
				lineCheck = 0;
			}					
		}	

	}

	// Get month name
	public static String getMonthName(int month) {
		String monthName = "";

		switch (month) {
		case 1: monthName = "January"; break;
		case 2: monthName = "February"; break;
		case 3: monthName = "March"; break;
		case 4: monthName = "April"; break;
		case 5: monthName = "May"; break;
		case 6: monthName = "June"; break;
		case 7: monthName = "July"; break;
		case 8: monthName = "August"; break;
		case 9: monthName = "September"; break;
		case 10: monthName = "October"; break;
		case 11: monthName = "November"; break;
		case 12: monthName = "December"; break;
		}
		return monthName;
	}

	// Get start day of 01.MM.YEAR
	public static int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;

		// Get total number of days from 01.01.1800 to 01.MM.YEAR 
		int totalNumberOfDays = getNumberOfDays(year, month);

		// Return the start day of 01.MM.YEAR
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7; 
	}

	// Get total number of days
	public static int getNumberOfDays(int year, int month) {
		int total = 0;

		// Get total number of day since year 1800 to 1.1.YYYY
		for (int i = 1800; i <= year; i++)
			if (isLeapYear(i))
				total = total + 366;
			else 
				total = total + 365;

		// Add days from 1.1. January to the month entered by user
		for (int i = 1; i <= 12; i++)
			total = total + getNumberOfDaysInMonth(year, i);

		return total; // dummy value
	}

	// Get total number of days in month
	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) 
			return 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)			
			return 30;
		if (month == 2)
			return isLeapYear(year) ? 29 : 28;
		else
			return 0; // month is incorrect
	}

	// Counting the number of numbers in integer
	public static int numberOfPos(int numberPos) {
		int countPos = 0;
		while (numberPos != 0) {
			numberPos /= 10;
			countPos++;
		}
		return countPos;
	}

	// Overloading the counting position method for long numbers
	public static int numberOfPos(long numberPos) {
		int countPos = 0;
		while (numberPos != 0) {
			numberPos /= 10;
			countPos++;
		}
		return countPos;
	}

	// Returns k number of digits from long number
	public static long getDigit(long number, int k) {
		long choppedNumber;
		if (hdR.mtd.numberOfPos(number) < k)
			return number;
		else {
			int numberOfDigits = 16 - k;
			choppedNumber = (number / (long)Math.pow(10, numberOfDigits));
		}	
		return choppedNumber;
	}

	// Prints an array
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// Reversing the array
	public static int[] reverse(int[] list) {
		int[] result = new int[list.length];

		for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
			result[j] = list[i];
		}
		return result;
	}

	// Display an array separated into lines per requested number of items
	public static void displayArray(int[] array, int numberOfItemsPerLine) {
		int lineCheck = 0;
		for (int i = 0; i < array.length; i++) {
			if (lineCheck == numberOfItemsPerLine) {
				System.out.println();
				lineCheck = 0;
			} else {
				System.out.print(array[i] + " ");
				lineCheck++;
			}
		}
	}

	// Overloading displayArray
	public static void displayArray(double[] array, int numberOfItemsPerLine) {
		int lineCheck = 0;
		for (int i = 0; i < array.length; i++) {
			if (lineCheck == numberOfItemsPerLine) {
				System.out.println();
				lineCheck = 0;
			} else {
				System.out.print(array[i] + " ");
				lineCheck++;
			}
		}
	}

	// Overloading displayArray
	public static void displayArray(char[] array, int numberOfItemsPerLine) {
		int lineCheck = 0;
		for (int i = 0; i < array.length; i++) {
			if (lineCheck == numberOfItemsPerLine) {
				System.out.println();
				lineCheck = 0;
			} else {
				System.out.print(array[i] + " ");
				lineCheck++;
			}
		}
	}

	// Counts characters in a char array
	public static int[] createCounts(char[] array, int numberOfElements) {
		int[] counts = new int[numberOfElements];

		for (int i = 0; i < array.length; i++)
			counts[array[i] - 'a']++;

		return counts;
	}

	// Linear search method
	public static int linearSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (key == array[i])
				return i;
		}
		return -1;
	}

	// Overloading the linear search method
	public static double linearSearch(double[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (key == array[i])
				return i;
		}
		return -1;
	}

	// Binary search method
	public static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < array[mid])
				high = mid - 1;
			else if (key == array[mid])
				return mid;
			else if (key > array[mid])
				low = mid + 1;
		}

		return -low;
	}

	// OverLoading the binary search method
	public static int binarySearch(double[] array, int key) {
		int low = 0;
		int high = array.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < array[mid])
				high = mid - 1;
			else if (key == array[mid])
				return mid;
			else if (key > array[mid])
				low = mid + 1;
		}

		return -low;
	}

	// OverLoading the binary search method
	public static int binarySearch(char[] array, int key) {
		int low = 0;
		int high = array.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < array[mid])
				high = mid - 1;
			else if (key == array[mid])
				return mid;
			else if (key > array[mid])
				low = mid + 1;
		}

		return -low;
	}

	// Selection sort
	public static int[] selectionSort(int[] array) {
		for (int i = 0; i < array.length  - 1; i++) {
			int minIndex = i;
			int min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		return array;
	}

	// Overloading selection sort
	public static double[] selectionSort(double[] array) {
		for (int i = 0; i < array.length  - 1; i++) {
			int minIndex = i;
			double min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		return array;
	}

	// Overloading selection sort
	public static char[] selectionSort(char[] array) {
		for (int i = 0; i < array.length  - 1; i++) {
			int minIndex = i;
			char min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		return array;
	}

	// Selection sort descending order
	public static char[] selectionSortDescending(char[] array) {
		for (int i = 0; i < array.length  - 1; i++) {
			int minIndex = i;
			char min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j]  > array[minIndex]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		return array;
	}

	// Overloading Selection sort descending order
	public static int[] selectionSortDescending(int[] array) {
		for (int i = 0; i < array.length  - 1; i++) {
			int minIndex = i;
			int min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j]  > array[minIndex]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		return array;
	}

	// Overloading Selection sort descending order
	public static double[] selectionSortDescending(double[] array) {
		for (int i = 0; i < array.length  - 1; i++) {
			int minIndex = i;
			double min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (array[j]  > array[minIndex]) {
					min = array[j];
					minIndex = j;
				}
			}

			// Swap array[i] with array[minIndex] if necessary
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = min;
			}
		}
		return array;
	}

	// Insertion sort
	public static void insertionSort(double[] array) {
		for (int i = 1; i < array.length; i++) {
			// Insert array[i] into a sorted sublist array[0..i-1] so that array[0..i] is sorted
			double currentElement = array[i];
			int k;
			for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
				array[k + 1] = array[k];
			}
			// Insert the current element into array[k + 1]
			array[k + 1] = currentElement;
		}
	}

	// Overloading insertion sort
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			// Insert array[i] into a sorted sublist array[0..i-1] so that array[0..i] is sorted
			int currentElement = array[i];
			int k;
			for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
				array[k + 1] = array[k];
			}
			// Insert the current element into array[k + 1]
			array[k + 1] = currentElement;
		}
	}

	// Overloading insertion sort
	public static void insertionSort(char[] array) {
		for (int i = 1; i < array.length; i++) {
			// Insert array[i] into a sorted sublist array[0..i-1] so that array[0..i] is sorted
			char currentElement = array[i];
			int k;
			for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
				array[k + 1] = array[k];
			}
			// Insert the current element into array[k + 1]
			array[k + 1] = currentElement;
		}
	}

	// Computing average of the passed array
	public static int average(int[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}

		return total / array.length;
	}

	// Overloading average method
	public static double average(double[] array) {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}

		return total / array.length;
	}

	// Finding the minimum value within the passed array
	public static int min(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

	// Overloading a minimum method
	public static double min(double[] array) {
		double min = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

	// Finding the index of the minimum value within the passed array
	public static int minIndex(double[] array) {
		double min = 0;
		int minIndex = 0;
		for (int i = 1; i < array.length - 1; i++) {
			if (min > array[i]) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	// Creating an array by user input with defined number of elements
	@SuppressWarnings("resource")
	public static double[] createArray(double[] array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + array.length + " numbers");
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + 1 + ". number: ");
			array[i] = input.nextDouble();
		}
		return array;
	}

	// Overloading create array method
	@SuppressWarnings("resource")
	public static int[] createArray(int[] array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + array.length + " numbers");
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + 1 + ". number: ");
			array[i] = input.nextInt();
		}
		return array;
	}

	// Reverses the passed array (one Array used)
	public static double[] reversePassedArray(double[] array) {
		double temp = 0;

		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;		

	}

	// Overloading the reversePassedArray
	public static int[] reversePassedArray(int[] array) {
		int temp = 0;

		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
		return array;		

	}

	// Overloading reverse method
	public static double[] reverse(double[] list) {
		double[] result = new double[list.length];

		for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
			result[j] = list[i];
		}
		return result;
	}
	// Finding the greatest common devisor
	public static int gcd(int n1, int n2) {
		int gcd = 1;
		int k = 2;

		while (k <= n1 && k <= n2) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
			k++;
		}
		return gcd;

	}

	// Overloading the greatest common devisor method
	public static int gcd(int... numbers) {
		int gcd = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			gcd = hdR.mtd.gcd(gcd, numbers[i]);
		}

		return gcd;
	}

	// Creates an array with distinct numbers only
	public static int[] distinctNumbers(int[] numbers) {
		int[] array = new int[numbers.length];
		boolean[] isUnique = new boolean[10];
		int counter = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (!isUnique[numbers[i]]) {
				array[counter] = numbers[i];
				isUnique[numbers[i]] = true;
				counter++;
			}
		}
		return array;
	}

	// Overloading the method for distinct numbers
	public static double[] distinctNumbers(double[] numbers) {
		double[] array = new double[numbers.length];
		boolean[] isUnique = new boolean[10];
		int counter = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (!isUnique[(int)numbers[i]]) {
				array[counter] = numbers[i];
				isUnique[(int)numbers[i]] = true;
				counter++;
			}
		}
		return array;
	}

	//Display an array separated into lines per requested number of items
	public static void displayArray(String[] array, int numberOfItemsPerLine) {
		int lineCheck = 1;
		for (int i = 0; i < array.length; i++) {
			if (lineCheck == numberOfItemsPerLine) {
				System.out.println(array[i] + " ");
				lineCheck = 1;
			} else {
				System.out.print(array[i] + " ");
				lineCheck++;
			}
		}
	}

	// Display an array separated into lines per requested number of items
	public static void displayArray(boolean[] array, int numberOfItemsPerLine) {
		int lineCheck = 1;
		for (int i = 0; i < array.length; i++) {
			if (lineCheck == numberOfItemsPerLine) {
				System.out.println(array[i] + " ");
				lineCheck = 1;
			} else {
				System.out.print(array[i] + " ");
				lineCheck++;
			}
		}
	}


	// Creates a two-dimensional array
	@SuppressWarnings("resource")
	public static int[][] createArray2dim(int row, int column) {
		int[][] array = new int[row][column];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + row + " rows and " + column + " columns: ");
		for (int i = 0; i < row; i++) {
			System.out.print((i + 1) + ". row: ");
			for (int j = 0; j < column; j++) {
				array[i][j] = input.nextInt();
			}
		}
		return array;
	}
	// Calculates the sum of the two dimensional array
	public static int sumOf2dimArray(int[][] array) {
		int sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sum += array[row][column];
			}
		}
		return sum;
	}
	// Overloading the sum of the two dimensional array
	public static double sumOf2dimArray(double[][] array) {
		double sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				sum += array[row][column];
			}
		}
		return sum;
	}
	// Checks if two arrays are strictly identical
	public static boolean equalsStrictly(int[] list1, int[] list2) {
		boolean check = true;
		for (int i = 0; i < list1.length && i < list2.length && check; i++) {
			if (list1.length == list2.length && list1[i] == list2[i])
				check = true;
			else
				check = false;
		}
		if (check)
			return true;
		else
			return false;
	}
	// Checks if two arrays are identical
	public static boolean equals(int[] list1, int[] list2) {
		java.util.Arrays.sort(list2);
		boolean[] check = new boolean[list1.length];
		for (int i = 0; i < list1.length && i < list2.length; i++) {
			if (list1.length == list2.length && java.util.Arrays.binarySearch(list2, list1[i]) >= 0)
				check[i] = true;
			else {
				check[i] = false;
				break;
			}
		}
		boolean checkFinal = false;
		for (int i = 0; i < check.length; i++) {
			if (check[i])
				checkFinal = true;
			else
				checkFinal = false;
		}
		return checkFinal;
	}
	// Merges two arrays into one sorted increasingly
	public static int[] merge(int[] array1, int[] array2) {
		int[] result = new int[array1.length + array2.length];
		for (int i = 0; i < result.length; i++) {
			if (i < array1.length)
				result[i] = array1[i];
			if ((i + array1.length) < result.length)
				result[i + array1.length] = array2[i];
		}
		java.util.Arrays.sort(result);
		return result;
	}
	// Creating an array by user input with defined number of elements
	@SuppressWarnings("resource")
	public static double[][] createArray2dim(double[][] array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + array.length + " rows per " + array[0].length + " numbers:");
		for (int row = 0; row < array.length; row++) {
			System.out.print(row + 1 + ". row: ");
			for (int column = 0; column < array[row].length; column++) {
				array[row][column] = input.nextDouble();
			}
		}
		return array;
	}
	// Overloading a method for creating an array by user input with defined number of elements
	@SuppressWarnings("resource")
	public static int[][] createArray2dim(int[][] array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + array.length + " rows per " + array[0].length + " numbers:");
		for (int row = 0; row < array.length; row++) {
			System.out.print(row + 1 + ". row: ");
			for (int column = 0; column < array[row].length; column++) {
				array[row][column] = input.nextInt();
			}
		}
		return array;
	}
	// Overloading a method for creating an array by user input with defined number of elements
	@SuppressWarnings("resource")
	public static String[][] createArray2dim(String[][] array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + array.length + " rows per " + array[0].length + " numbers:");
		for (int row = 0; row < array.length; row++) {
			System.out.print(row + 1 + ". row: ");
			for (int column = 0; column < array[row].length; column++) {
				array[row][column] = input.next();
			}
		}
		return array;
	}
	// Sums the specific column
	public static double sumColumn(double[][] array, int columnIndex) {
		double sum = 0;
		for (int row = 0; row < array.length; row++) {
			sum += array[row][columnIndex];
		}
		return sum;
	}
	// Overloading the sum method
	public static double sumColumn(int[][] array, int columnIndex) {
		double sum = 0;
		for (int row = 0; row < array.length; row++) {
			sum += array[row][columnIndex];
		}
		return sum;
	}	
	// Sums the row in two dimensional array
	public static int sumRow(int[][] array, int rowIndex) {
		int sum = 0;
		for (int column = 0; column < array.length; column++) {
			sum += array[rowIndex][column];
		}
		return sum;
	}
	// Overloading the sum row method
	public static int sumRow(double[][] array, int rowIndex) {
		int sum = 0;
		for (int column = 0; column < array.length; column++) {
			sum += array[rowIndex][column];
		}
		return sum;
	}
	// Overloading the sum row method
	public static int sumRow(char[][] array, int rowIndex) {
		int sum = 0;
		for (int column = 0; column < array.length; column++) {
			sum += array[rowIndex][column];
		}
		return sum;
	}
	// Displays the two dimensional array
	public static void displayArray2dim(double[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}
	// Overloading the method for displaying the two dimensional array
	public static void displayArray2dim(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}
	// Overloading the method for displaying the two dimensional array
	public static void displayArray2dim(String[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}
	// Overloading the method for displaying the two dimensional array
	public static void displayArray2dim(char[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.print(array[row][column] + " ");
			}
			System.out.println();
		}
	}
	// Changes the first character in a string to uppercase
	public static void title(String s) {
		StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < builder.length(); i++) {
			char ch = builder.charAt(i);
			if (i == 0 && Character.isLowerCase(ch) || (i > 0) && builder.charAt(i - 1) == ' ' && Character.isLowerCase(ch)) {
				builder.replace(i,  i + 1, Character.toUpperCase(ch) + "");
			}
		}
		System.out.println(builder.toString());
	}
	// Swaps the lower case to upper case and vice versa
	public static String swapCase(String s) {
		StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < builder.length(); i++) {
			if (Character.isLowerCase(builder.charAt(i)))
				builder.replace(i, (i + 1), Character.toUpperCase(builder.charAt(i)) + "");
			else
				builder.replace(i, (i + 1), Character.toLowerCase(builder.charAt(i)) + "");
		}
		
		return builder.toString();
	}
}

