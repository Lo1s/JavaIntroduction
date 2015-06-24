/**
 * 
 */
package chapter07;
import java.util.Scanner;
/**
 * @author jslapnicka
 *
 */
public class PE735 {

	/**
	 * 
	 */
	public PE735() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows in the matrix: ");
		int numberOfRows = input.nextInt();
		int[][] matrix = new int[numberOfRows][numberOfRows];
		System.out.println("Enter the matrix row by row: ");
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = input.nextInt();
			}
		}
		
		int[] result = findLargestBlock(matrix);
		System.out.println("The maximum square submatrix is at (" + result[0] + ", " + result[1] + ")" + " with size " + result[2]);

	}
	public static int[] findLargestBlock(int[][] matrix) {
		// Search for the 1s
		int[] largest = new int[3];
		int subRow = 0;
		int subColumn = 0;
		int sumSubMatrix = 0;
		int result = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				// If the 1 is found, look how big sub matrix is
				if (matrix[row][column] == 1) {
					// Count 1s in a row
					int sumRow = matrix.length;
					boolean firstLine = true;
					for (subRow = row; subRow < sumRow; subRow++) {
						if (matrix[subRow][column] != 1)
							break;
						for (subColumn = column; subColumn < matrix[row].length && matrix[subRow][subColumn] == 1; subColumn++) {
							if (matrix[subRow][subColumn] == 1) {
								sumSubMatrix += matrix[subRow][subColumn];
							} else
								break;
							// Sums the length of the first valid row
							if (firstLine)
								sumRow = sumSubMatrix;							
						}
						firstLine = false;	
					}							
					// Check if the sum of the 1s is proper for square matrix
					if (sumSubMatrix > 2 && subRow > 0 && sumSubMatrix % (subRow) == 0 && sumSubMatrix > result) {
						result = sumSubMatrix;
						largest[0] = row;
						largest[1] = column;
						largest[2] = subRow;
					}
					sumSubMatrix = 0;
				}
			}
		}
		return largest;
	}
}
