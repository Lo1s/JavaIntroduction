/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;




/**
 * @author jslapnicka
 * @Date & @Time 27. 1. 2015 2015 14:41:55 
 */
public class PE2407_ClosestPairOfPoints {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int LEARN_IT = 0;
		
		double points[][] = new double[1000][2];
		for(int i = 0; i < points.length; i++) {
			points[i][0] = Math.random() * 100D;
			points[i][1] = Math.random() * 100D;
		}

		long startTime = System.currentTimeMillis();
		Pair pair = closestPairBruteForce(points);
		System.out.println((new StringBuilder("shortest distance is ")).append(pair.getDistance()).toString());
		System.out.println(pair);
		long endTime = System.currentTimeMillis();
		System.out.println((new StringBuilder("Time spent on the brute-force algorithm is ")).append(endTime - startTime).append(" milliseconds").toString());
		startTime = System.currentTimeMillis();
		Pair closestPair = getClosestPair(points);
		System.out.println((new StringBuilder("shortest distance is ")).append(closestPair.getDistance()).toString());
		System.out.println(closestPair);
		endTime = System.currentTimeMillis();
		System.out.println((new StringBuilder("Time spent on the divide-and-conquer algorithm is ")).append(endTime - startTime).append(" milliseconds").toString());
	}

	public static Pair closestPairBruteForce(double[][] points) {
		Point[] p = new Point[points.length];

		for (int i = 0; i < p.length; i++) {
			p[i] = new Point(points[i][0], points[i][1]);
		}

		return closestPairBruteForce(p);
	}

	public static Pair closestPairBruteForce(Point[] points) {
		Pair pair = new Pair();
		if (points.length < 2)
			return null;

		pair.p1 = points[0];
		pair.p2 = points[1];
		double shortestDistances = distance(pair.p1, pair.p2);
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i], points[j]);
				if (distance < shortestDistances) {
					pair.p1 = points[i];
					pair.p2 = points[j];
					shortestDistances = distance;
				}
			}
		}

		return pair;
	}

	/** Return the distance of the closest pair of points  */
	public static Pair getClosestPair(double[][] points) {
		Point[] pointsOrderedOnX = new Point[points.length];

		for (int i = 0; i < pointsOrderedOnX.length; i++) {
			pointsOrderedOnX[i] = new Point(points[i][0], points[i][1]);
		}

		return getClosestPair(pointsOrderedOnX);
	}

	/** Return the distance of the closest pair of points */
	public static Pair getClosestPair(Point[] points) {
		Arrays.sort(points);

		Pair pair = checkIdentical(points);
		if (pair != null)
			return pair;
		else {
			Point[] pointsOrderedOnY = points.clone();
			Arrays.sort(points);
			return distance(points, 0, points.length - 1, pointsOrderedOnY);
		}
	}

	public static Pair checkIdentical(Point[] pointsOrderedOnX) {
		Pair pair = new Pair();
		for (int i = 0; i < pointsOrderedOnX.length - 1; i++) {
			if (pointsOrderedOnX[i].compareTo(pointsOrderedOnX[i + 1]) == 0) {
				pair.p1 = pointsOrderedOnX[i];
				pair.p2 = pointsOrderedOnX[i + 1];
				return pair;
			}
		}
		return null;
	}

	/** Return the distance of the closest pair of points
	 * in pointsOrderedOnX[low...high]. This is recursive method.
	 * pointsOrderedOnX and pointsOrderedOnY are not changed in the subsequent recursive calls.
	 */
	public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY) {
		if (low >= high)
			return null;

		if (low + 1 == high) {
			Pair pair = new Pair();
			pair.p1 = pointsOrderedOnX[low];
			pair.p2 = pointsOrderedOnX[high];
			return pair;
		}

		int mid = (low + high) / 2;
		Pair pair1 = distance(pointsOrderedOnX, low, mid, pointsOrderedOnY);
		Pair pair2 = distance(pointsOrderedOnX, mid + 1, high, pointsOrderedOnY);
		Pair pair = null;
		double d;

		if (pair1 == null && pair2 == null) {
			d = 1.7976931348623157E+308D;
		} else if (pair1 == null) {
			d = pair2.getDistance();
			pair = pair2;			
		} else if (pair2 == null) {
			d = pair1.getDistance();
			pair = pair1;
		} else {
			d = Math.min(pair1.getDistance(), pair2.getDistance());
			if (pair1.getDistance() <= pair2.getDistance()) {
				pair = pair1;
			} else {
				pair = pair2;
			}
		}
		ArrayList<Point> stripL	= new ArrayList<Point>();
		ArrayList<Point> stripR = new ArrayList<Point>();

		for (int i = 0; i < pointsOrderedOnY.length; i++) {
			if (pointsOrderedOnY[i].x <= pointsOrderedOnX[mid].x
					&& pointsOrderedOnY[i].x >= pointsOrderedOnX[mid].x - d) {
				stripL.add(pointsOrderedOnY[i]);
			} else {
				stripR.add(pointsOrderedOnY[i]);
			}
		}
		
		double d3 = d;
		int r = 0; 
		for (int i = 0; i < stripL.size(); i++) {
			while (r < stripR.size() && stripL.get(i).y > stripR.get(r).y + d) {
				r++;
			}
			for (int r1 = r; r1 < stripR.size() && stripR.get(r1).y <= stripL.get(i).y + d; r1++) {
				if (d3 > distance(stripL.get(i), stripR.get(r1))) {
					d3 = distance(stripL.get(i), stripR.get(r1));
					pair.p1 = stripL.get(i);
					pair.p2 = stripR.get(r1);
				}
			}
		}
		
		return pair;
	}

	/** Compute the distance between two points p1 and p2 */
	public static double distance(Point p1, Point p2) {
		return distance(p1.x, p1.y, p2.x, p2.y);
	}

	/** Compute the distance between points (x1, y1) and (x2, y2) */
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	public static class Pair {
		private Point p1;
		private Point p2;

		public Pair() {
			// TODO Auto-generated constructor stub
		}

		public Pair(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}

		public double getDistance() {
			return distance(p1, p2);
		}
		
		public String toString() {
            return (new StringBuilder("(")).append(p1.x).append(", ").append(p1.y).append(") and (").append(p2.x).append(", ").append(p2.y).append(")").toString();
        }
	}


	static class Point implements Comparable<Point> {
		private double x;
		private double y;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point p) {
			if (this.x > p.x)
				return 1;
			else if (this.x == p.x) {
				if (this.y > p.y)
					return 1;
				else if (this.y == p.y)
					return 0;
				else
					return -1;
			} else
				return -1;
		}
	}

	static class CompareY implements Comparator<Point> {

		public CompareY() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compare(Point p1, Point p2) {
			if (p1.y > p2.y)
				return 1;
			else if  (p1.y == p2.y) {
				if (p1.x > p2.x)
					return 1;
				else if (p1.x == p2.x)
					return 0;
				else
					return -1;
			} else
				return -1;
		}
		
	}

}
