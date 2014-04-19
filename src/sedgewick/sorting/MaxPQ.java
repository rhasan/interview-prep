package sedgewick.sorting;

import java.io.File;
import java.util.Comparator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;




public class MaxPQ<Key> {

	private Key[] pq;
	private int N;
	private Comparator<Key> cmp;
	
	public MaxPQ( Comparator<Key> cmp) {
		this(1, cmp);
	}

	
	public MaxPQ(int capacity, Comparator<Key> cmp) {
		pq = (Key[]) new Object[capacity+1];
		N = 0;
		this.cmp = cmp;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key key) {

		if((N+1) == pq.length) {
			resize(2*pq.length);
		}
		assert pq.length > N+1;
		
		pq[++N] = key;
		swim(N);
		
		assert isMaxHeap();
	}
	
	public Object delMax() {
		
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		assert isEmpty() == false;
				
		Key max = pq[1];
		exchange( 1, N);
		pq[N] = null;
		N--;
		
		sink(1);

		if((N+1) == pq.length/4) {
			resize( pq.length/2);
		}
		
		assert isMaxHeap();
		return max;
		
	
	}
	
	
	private void swim(int k) {
	
		while(k > 1 && less(cmp, pq[k/2], pq[k])) {
			exchange(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while( 2*k <= N ) {
			int left = 2 * k;
			int right = left+1;
			int selectedChild  = left;
			if(right <= N && less(cmp, pq[left], pq[right]))selectedChild = right;
			if(!less(cmp, pq[k], pq[selectedChild])) break;
			exchange(selectedChild, k);
			k = selectedChild;
		}
	}
	
    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && less(k, left))  return false;
        if (right <= N && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
	
    private boolean less(int i, int j) {
    	return (cmp.compare(pq[i], pq[j]) < 0);
    }	
    
    public int size() {
    	return N;
    }
	
	/****************************************
	 * Sorting helper functions
	 ****************************************/
	private static boolean less(Comparator cmp, Object v, Object w) {
		return (cmp.compare(v, w) < 0);
	}
	

	private void exchange( int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	
	/****************************************
	 * Array helper functions
	 ****************************************/
	 
	 
	private void resize( int size) {
		Key[] tmp = (Key[]) new Object[size];
		for(int i = 0; i < pq.length; i++) {
			tmp[i] = pq[i];
		}
		pq = tmp;
	}
	
    /**
     * Unit tests the <tt>MaxPQ</tt> data type.
     */
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
        
        In in = new In(new File("input/tinyPQ.txt"));
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }	
}
