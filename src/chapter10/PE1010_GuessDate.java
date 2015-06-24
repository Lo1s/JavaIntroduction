/**
 * 
 */
package chapter10;

/**
 * @author jslapnicka
 * @Date & @Time 10. 7. 2014 2014 17:28:19 
 */
public class PE1010_GuessDate {
	private static int[][] set1 = {
		{ 1, 3, 5, 7},
		{ 9, 11, 13, 15},
		{17, 19, 21, 23},
		{25, 27, 29, 31}};
	private static int[][] set2 = {
		{ 2, 3, 6, 7},	
		{10, 11, 14, 15},
		{18, 19, 22, 23},
		{26, 27, 30, 31}};
	private static int[][] set3 = {	
		{ 4, 5, 6, 7},
		{12, 13, 14, 15},
		{20, 21, 22, 23},
		{28, 29, 30, 31}};
	private static int[][] set4 = {			
		{ 8, 9, 10, 11},
		{12, 13, 14, 15},
		{24, 25, 26, 27},
		{28, 29, 30, 31}};
	private static int[][] set5 = {
		{16, 17, 18, 19},
		{20, 21, 22, 23},
		{24, 25, 26, 27},
		{28, 29, 30, 31}};

	private PE1010_GuessDate() {
	}

	public static int getValue(int set, int i, int j) {
		switch (set) {
		case 1: return set1[i][j];
		case 2: return set2[i][j];
		case 3: return set3[i][j];
		case 4: return set4[i][j];
		case 5: return set5[i][j];
		}
		return 0;
	}
}