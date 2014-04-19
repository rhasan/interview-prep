package sedgewick.sorting;

public class Heap {
	
	
	
	private Heap() {
		
	}
	
	
	public static void sort(Comparable[] pq) {
		int N = pq.length;
		for(int k = N/2; k >= 1; k--) {
			sink(pq, k, N);
		}
		
		assert isMaxHeap(pq, N);
		
		while(N > 1) {
			exchange(pq, 1, N--);
			sink(pq, 1, N);
		}
		assert isSorted(pq);
	}
	

	private static void sink(Comparable[] pq, int k, int N) {
		while (2 * k <= N) {
			int left = 2 * k;
			int right = left + 1;
			int selectedChild = left;
			if (right <= N && less(pq, left, right))
				selectedChild = right;
			if (!less(pq, k, selectedChild))
				break;
			exchange(pq, selectedChild, k);
			k = selectedChild;
		}
	}

	
	
	// is pq[1..N] a max heap?
	private static boolean isMaxHeap(Comparable[] pq, int N) {
		return isMaxHeap(pq, N, 1);
	}

	// is subtree of pq[1..N] rooted at k a max heap?
	private static boolean isMaxHeap(Comparable[] pq, int N, int k) {
		if (k > N)
			return true;
		int left = 2 * k, right = 2 * k + 1;
		if (left <= N && less(pq, k, left))
			return false;
		if (right <= N && less(pq, k, right))
			return false;
		return isMaxHeap(pq, N, left) && isMaxHeap(pq, N, right);
	}	
	
	/****************************************
	 * Sorting helper functions
	 ****************************************/

	private static boolean less(Comparable[] a, int i, int j) {
		return (a[i-1].compareTo(a[j-1]) < 0);
	}
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable swap = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = swap;
	}
	private static boolean isSorted(Comparable[] a) {
		for(int i=1;i < a.length;i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}	

}
