package sedgewick.sorting;

import java.util.Comparator;
import java.util.Scanner;

public class QuickSelect {

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
	
	public static Comparable select(Comparable[] a, int k) {
		Shuffler.shuffel(a);
		return select(a, 0, a.length-1, k);
	}
	
	private static Comparable select(Comparable[] a, int lo, int hi, int k) {
		
		while(hi > lo) {
			int j = partition(a, lo, hi);
			if(k < j) hi = j-1;
			else if(j < k) lo = j+1;
			else return a[k];
		}
		return a[lo];
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
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("How many numbers:");
		int N = in.nextInt();
		Comparable<Integer>[] a = new Comparable[N];
		for(int i = 0; i < N; i++) {
			int x = in.nextInt();
			a[i] = x;
		}
		System.out.println("k:");
		int k = in.nextInt();
		Comparable<Integer> kth = QuickSelect.select(a, k-1);
		System.out.print(kth);
	}


}
