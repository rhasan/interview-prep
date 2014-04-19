package sedgewick.sorting;

import java.util.Comparator;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

public class SortingClient {

   // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    public static void main(String[] args) {
    	In in = new In(args[0]);
        String[] a = in.readAllStrings();
        
        System.out.println("Insertion sort:");
        Stopwatch timer = new Stopwatch();
        Insertion.sort(a);
        double elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);
        
        Shuffler.shuffel(a);
        System.out.println("Insertion sort (Comparator):");
        timer = new Stopwatch();
        Insertion.sort(a, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);        
        
        Shuffler.shuffel(a);
        System.out.println("Shell sort:");
        timer = new Stopwatch();
        Shell.sort(a);
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);
        
        
        Shuffler.shuffel(a);
        System.out.println("Merge sort:");
        timer = new Stopwatch();
        Merge.sort(a);
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);

        Shuffler.shuffel(a);
        System.out.println("MergeBU sort:");
        timer = new Stopwatch();
        MergeBU.sort(a);
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);    
        
        
        Shuffler.shuffel(a);
        System.out.println("Quick sort:");
        timer = new Stopwatch();
        Quick.sort(a);
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);     
        
        
        Shuffler.shuffel(a);
        System.out.println("Heap sort:");
        timer = new Stopwatch();
        Heap.sort(a);
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);          
    
    }
}
