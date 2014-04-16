package sedgewick.sorting;

import java.util.Random;

public class Shuffler {
	
	private static long seed;
	private static Random random;
	
	static {
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}
	
	//uniformly chosen random integer between 0 (inclusive) and i (exclusive)
	private static int uniform(int i) {
		return random.nextInt(i);
	}
	
	public static void shuffel(Object[] a) {
		
		for(int i = 0; i < a.length; i++) {
			int r = uniform(i+1);
			exchange(a, i, r);
		}
	}
	
	private static void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}	
}
