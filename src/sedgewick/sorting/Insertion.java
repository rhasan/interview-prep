package sedgewick.sorting;

import java.util.Comparator;

public class Insertion {
    // This class should not be instantiated.
    private Insertion() { }
	
	public static void sort(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j > 0; j--) {
				if(less(a[j],a[j-1])) {
					exchange(a, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
	public static void sort(Object[] a, Comparator cmp) {
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j > 0; j--) {
				if(less(cmp, a[j],a[j-1])) {
					exchange(a, j, j-1);
				} else {
					break;
				}
			}
		}
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
