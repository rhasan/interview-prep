package sedgewick.sorting;

public class Shell {
	
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		int h = 1;
		
		while(h <=  N/3) h = 3*h + 1;
		
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= h; j -= h) {
					if(less(a[j],a[j-h])) {
						exchange(a, j, j-h);
					} else {
						break;
					}
				}
			}
			h = h/3;
		}
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
	
}