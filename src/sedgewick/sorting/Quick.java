package sedgewick.sorting;

import java.util.Comparator;

public class Quick {

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		while(true) {
			
			while(less(a[++i], a[lo]))
				if(i == hi) break;
			
			while(less(a[lo], a[--j]))
				if(j == lo) break;
			
			if(i >= j) break;
			
			exchange(a, i, j);
		}
		exchange(a, lo, j);
		return j;
	}
	
	public static void sort(Comparable[] a) {
		Shuffler.shuffel(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	
	/****************************************
	 * Sorting helper functions
	 ****************************************/
	
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
	private static boolean less(Comparator cmp, Object v, Object w) {
		return (cmp.compare(v, w) < 0);
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	private static void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}	

}
