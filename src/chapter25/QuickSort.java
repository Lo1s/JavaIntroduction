/**
 * 
 */
package chapter25;

/**
 * @author jslapnicka
 * @Date & @Time 1. 7. 2015 2015 10:30:00 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Source - http://stackoverflow.com/questions/14907334/stackoverflow-with-quicksort-java-implementation
	public static void qsort(int[] a, int si, int ei){
		//base case
		if(ei<=si || si>=ei){}

		else{ 
			int pivot = a[si]; 
			int i = si+1; int tmp; 

			//partition array 
			for(int j = si+1; j<= ei; j++){
				if(pivot > a[j]){
					tmp = a[j]; 
					a[j] = a[i]; 
					a[i] = tmp; 

					i++; 
				}
			}

			//put pivot in right position
			a[si] = a[i-1]; 
			a[i-1] = pivot; 

			//call qsort on right and left sides of pivot
			qsort(a, si, i-2); 
			qsort(a, i, ei); 
		}
	}

	public static int pivot(int[] a, int lo, int hi){
		int mid = (lo+hi)/2;
		int pivot = a[lo] + a[hi] + a[mid] - Math.min(Math.min(a[lo], a[hi]), a[mid]) - Math.max(Math.max(a[lo], a[hi]), a[mid]);

		if(pivot == a[lo])
			return lo;
		else if(pivot == a[hi])
			return hi;
		return mid;
	}

	public static int partition(int[] a, int lo, int hi){

		int k = pivot(a, lo, hi);
		//System.out.println(k);
		swap(a, lo, k);
		//System.out.println(a);
		int j = hi + 1;
		int i = lo;
		while(true){

			while(a[lo] < a[--j])
				if(j==lo)   break;

			while(a[++i] < a[lo])
				if(i==hi) break;

			if(i >= j)  break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	public static void sort(int[] a, int lo, int hi){
		if(hi<=lo)  return;
		int p = partition(a, lo, hi);
		sort(a, lo, p-1);
		sort(a, p+1, hi);
	}

	public static void swap(int[] a, int b, int c){
		int swap = a[b];
		a[b] = a[c];
		a[c] = swap;
	}

	public static void sort(int[] a){
		sort(a, 0, a.length - 1);
	}

}
