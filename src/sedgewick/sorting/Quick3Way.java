package sedgewick.sorting;

import java.util.Comparator;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

public class Quick3Way {


	
	public static void sort(Comparable[] a) {
		Shuffler.shuffel(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int lt = lo;
		int gt = hi;
		Comparable v = a[lo];
		int i = lo;
		
		while(i <= gt) {
			if(less(a[i], v)) { 
				exchange(a, lt, i);
				lt++;
				i++;
			}
			else if(less(v, a[i])) {
				exchange(a, gt, i);
				gt--;
			}
			else i++;
			
		}
		
		
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
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
	
	// print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
	
	public static void main(String[] args) {
    	In in = new In(args[0]);
        String[] a = in.readAllStrings();
        
        System.out.println("Quick 3 way sort:");
        Stopwatch timer = new Stopwatch();
        Quick3Way.sort(a);
        double elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);
	}
}
