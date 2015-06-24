/**
 * 
 */
package chapter22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author jslapnicka
 * @Date & @Time 11. 12. 2014 2014 16:12:08 
 */
public class PE2204_SortPointsInAPlane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Point> pointsListComparable = new ArrayList<PE2204_SortPointsInAPlane.Point>();
		Point[] pointsArrayComparable = new Point[100];
		System.out.println("****** Not Sorted ! ******");
		for (int i = 0; i < 100; i++) {
			pointsListComparable.add(new Point((int)(Math.random() * (100 - 1 + 1)), (int)(Math.random() * (100 - 1 + 1))));
			pointsArrayComparable[i] = new Point((int)(Math.random() * (100 - 1 + 1)), ((int)(Math.random() * (100 - 1 + 1))));
		}
		
		ArrayList<Point> pointsListComparator = new ArrayList<PE2204_SortPointsInAPlane.Point>();
		Point[] pointsArrayComparator = new Point[100];
		for (int i = 0; i < 100; i++) {
			pointsListComparator.add(new Point((int)(Math.random() * (100 - 1 + 1)), (int)(Math.random() * (100 - 1 + 1))));
			pointsArrayComparator[i] = new Point((int)(Math.random() * (100 - 1 + 1)), ((int)(Math.random() * (100 - 1 + 1))));
			System.out.print("Array: [" + (pointsArrayComparable[i].x < 10 ? "0" + pointsArrayComparable[i].x : pointsArrayComparable[i].x) 
					+ ", " + (pointsArrayComparable[i].y < 10 ? "0" + pointsArrayComparable[i].y : pointsArrayComparable[i].y) + "]");
			System.out.print(" - List: [" + (pointsListComparable.get(i).x < 10 ? "0" + pointsListComparable.get(i).x : pointsListComparable.get(i).x) 
					+ ", " + (pointsListComparable.get(i).y < 10 ? "0" + pointsListComparable.get(i).y : pointsListComparable.get(i).y) + "]");
			System.out.print(" ****** Array2: [" + (pointsArrayComparator[i].x < 10 ? "0" + pointsArrayComparator[i].x : pointsArrayComparator[i].x)
					+ ", " + (pointsArrayComparator[i].y < 10 ? "0" + pointsArrayComparator[i].y : pointsArrayComparator[i].y) + "]");
			System.out.println(" - List2: [" + (pointsListComparator.get(i).x < 10 ? "0" + pointsListComparator.get(i).x : pointsListComparator.get(i).x) 
					+ ", " + (pointsListComparator.get(i).y < 10 ? "0" + pointsListComparator.get(i).y : pointsListComparator.get(i).y) + "]");
		}
		
		Arrays.sort(pointsArrayComparable);
		Collections.sort(pointsListComparable);
		
		PE2204_SortPointsInAPlane main = new PE2204_SortPointsInAPlane();
		PE2204_SortPointsInAPlane.CompareY comparator = main.new CompareY();
		
		Arrays.sort(pointsArrayComparator, comparator);
		Collections.sort(pointsListComparator, comparator);
		
		System.out.println("\n***** Sorted (1 - Comparable, 2 - Comparator) *****");
		for (int i = 0; i < pointsArrayComparable.length; i++) {
			System.out.print("Array: [" + (pointsArrayComparable[i].x < 10 ? "0" + pointsArrayComparable[i].x : pointsArrayComparable[i].x) 
					+ ", " + (pointsArrayComparable[i].y < 10 ? "0" + pointsArrayComparable[i].y : pointsArrayComparable[i].y) + "]");
			System.out.print(" - List: [" + (pointsListComparable.get(i).x < 10 ? "0" + pointsListComparable.get(i).x : pointsListComparable.get(i).x) 
					+ ", " + (pointsListComparable.get(i).y < 10 ? "0" + pointsListComparable.get(i).y : pointsListComparable.get(i).y) + "]");
			System.out.print(" ****** Array2: [" + (pointsArrayComparator[i].x < 10 ? "0" + pointsArrayComparator[i].x : pointsArrayComparator[i].x)
					+ ", " + (pointsArrayComparator[i].y < 10 ? "0" + pointsArrayComparator[i].y : pointsArrayComparator[i].y) + "]");
			System.out.println(" - List2: [" + (pointsListComparator.get(i).x < 10 ? "0" + pointsListComparator.get(i).x : pointsListComparator.get(i).x) 
					+ ", " + (pointsListComparator.get(i).y < 10 ? "0" + pointsListComparator.get(i).y : pointsListComparator.get(i).y) + "]");
		}
		
	}
	

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point p) {
			if (this.x > p.x)
				return 1;
			else if (this.x == p.x) {
				if (this.y > p.y)
					return 1;
				else if (this.y < p.y)
					return -1;
				else
					return 0;
			} else
				return -1;
		}

	}

	class CompareY implements Comparator<Point> {


		public CompareY() {
			// TODO Auto-generated constructor stub
		}
		
		public int compare(Point p1, Point p2) {
			if (p1.y > p2.y)
				return 1;
			else if (p1.y == p2.y) {
				if (p1.x > p2.x)
					return 1;
				else if (p1.x < p2.x)
					return -1;
				else
					return 0;
			} else
				return -1;
		}
	}

}
