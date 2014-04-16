package sedgewick.sorting;

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
        
        
        Shuffeler.shuffel(a);
        System.out.println("Shell sort:");
        timer = new Stopwatch();
        Shell.sort(a);
        elapsed = timer.elapsedTime();
        System.out.println("Time:"+elapsed);
        show(a);
        
    }
}
