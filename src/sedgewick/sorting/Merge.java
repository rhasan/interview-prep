package sedgewick.sorting;

public class Merge {
	private static Comparable[] aux;
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo;
		int j = mid+1;
		for(int k = lo; k <= hi; k++) {
			
			if(i > mid) {
				a[k] = aux[j++];
			}
			else if(j > hi) {
				a[k] = aux[i++];
			}
			else if(less(aux[j],aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
		assert isSorted(a, lo, hi);
	}
	
	
	private static void sort(Comparable[] a, int lo, int hi) {
		
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		
		sort(a, 0, a.length-1);
	}
	
	
	/****************************************
	 * Sorting helper functions
	 ****************************************/
	
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean isSorted(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			if(less(a[i],a[i-1])) return false;
		}
		return true;
	}
    
	// is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }	
}
