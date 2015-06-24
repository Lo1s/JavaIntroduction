/**
 * 
 */
package chapter24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



/**
 * @author jslapnicka
 * @Date & @Time 30. 1. 2015 2015 8:38:22 
 */
public class PE2411_GrahamAlgorithmForConvexHull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int LEARN_IT = 0;		
		/*Enter 6 points: 1 2,4 2,5 2 1,5 34,5 5,5 6 6 2,4 5,5 9
		The convex hull is
		(1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)*/
		Scanner input = new Scanner(System.in);
		System.out.print("How many points are in the set ? ");
		int numberOfPoints = input.nextInt();
		System.out.print("Enter " + numberOfPoints + " points: ");
		double[][] s = new double[numberOfPoints][2];
		for (int i = 0; i < s.length; i++) {
			s[i][0] = input.nextDouble();
			s[i][1] = input.nextDouble();
		}
		ArrayList<MyPoint> convexHull = getConvexHull(s);
		System.out.println("The convex hull is:");
		for (int i = 0; i < convexHull.size(); i++) {
			System.out.println(convexHull.get(i).toString());
		}
		input.close();
	}

	public static ArrayList<MyPoint> getConvexHull(double[][] s) {
		ArrayList<MyPoint> H = new ArrayList<MyPoint>();
		
		ArrayList<MyPoint> P = new ArrayList<MyPoint>();
		for (int i = 0; i < s.length; i++) {
			P.add(new MyPoint(s[i][0], s[i][1]));
		}
		placeP0(P);
		for (int i = 0; i < P.size(); i++) {
			P.get(i).setRightMostLowestPoint(P.get(0));
		}
		
		Collections.sort(P);
		P = discardTies(P);
		if(P.size() < 3) {
            return null;
        }
		
		H.add(P.get(0));
		H.add(P.get(1));
		H.add(P.get(2));
		
		int i = 3;
		while (i < P.size()) {
			MyPoint t2 = (MyPoint)H.get(H.size() - 1);
            MyPoint t1 = (MyPoint)H.get(H.size() - 2);
			
			MyPoint p = P.get(i);
			double status = whichSide(t1.x, t1.y, t2.x, t2.y, p.x, p.y);
			if (status >= 0) {
				H.remove(H.size() - 1);
			} else {
				H.add(p);
				i++;
			}
		}
		
		return new ArrayList<PE2411_GrahamAlgorithmForConvexHull.MyPoint>(H);		
	}
	
	 private static ArrayList<MyPoint> discardTies(ArrayList<MyPoint> p) {
	        ArrayList<MyPoint> list = new ArrayList<MyPoint>();
	        list.add((MyPoint)p.get(0));
	        int k;
	        for(int i = 1; i < p.size(); i = k)
	        {
	            double d = distance(((MyPoint)p.get(0)).x, ((MyPoint)p.get(0)).y, ((MyPoint)p.get(i)).x, ((MyPoint)p.get(i)).y);
	            int indexOfLargest = i;
	            for(k = i + 1; k < p.size() && ((MyPoint)p.get(i)).compareTo((MyPoint)p.get(k)) == 0; k++)
	            {
	                if(d < distance(((MyPoint)p.get(0)).x, ((MyPoint)p.get(0)).y, ((MyPoint)p.get(k)).x, ((MyPoint)p.get(k)).y))
	                {
	                    d = distance(((MyPoint)p.get(0)).x, ((MyPoint)p.get(0)).y, ((MyPoint)p.get(k)).x, ((MyPoint)p.get(k)).y);
	                    indexOfLargest = k;
	                }
	            }

	            list.add((MyPoint)p.get(indexOfLargest));
	        }

	        return list;
	    }
	
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
		return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
	}
	
	private static void placeP0(ArrayList<MyPoint> p) {
        int rightMostIndex = 0;
        double rightMostX = ((MyPoint)p.get(0)).x;
        double rightMostY = ((MyPoint)p.get(0)).y;
        for(int i = 1; i < p.size(); i++)
        {
            if(rightMostY < ((MyPoint)p.get(i)).y)
            {
                rightMostY = ((MyPoint)p.get(i)).y;
                rightMostX = ((MyPoint)p.get(i)).x;
                rightMostIndex = i;
            } else
            if(rightMostY == ((MyPoint)p.get(i)).y && rightMostX < ((MyPoint)p.get(i)).x)
            {
                rightMostX = ((MyPoint)p.get(i)).x;
                rightMostIndex = i;
            }
        }

        if(rightMostIndex != 0)
        {
            MyPoint temp = (MyPoint)p.get(0);
            p.set(0, (MyPoint)p.get(rightMostIndex));
            p.set(rightMostIndex, temp);
        }
    }

	public static class MyPoint implements Comparable<MyPoint> {
		double x, y;
		MyPoint rightMostLowestPoint;


		public MyPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public void setRightMostLowestPoint(MyPoint p) {
			rightMostLowestPoint = p;
		}

		@Override
		public int compareTo(MyPoint o) {
			if (o == this.rightMostLowestPoint && y == this.rightMostLowestPoint.y)
				return 1;
			
			double status = whichSide(rightMostLowestPoint.x, rightMostLowestPoint.y, o.x, o.y, this.x, this.y);
			if (status < 0.0D) {
				return 1;
			}
			return status != 0.0D ? -1 : 0;
		}
		
		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}
	}
	
}
