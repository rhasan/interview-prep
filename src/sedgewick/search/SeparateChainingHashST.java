package sedgewick.search;

import java.util.LinkedList;
import java.util.Queue;


import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class SeparateChainingHashST<Key, Value> {
	
	private static final int INIT_CAPACITY = 4;
	int M;
	int N;
	
	SequentialSearchST<Key, Value> st[];
	
	public SeparateChainingHashST() {
		this(INIT_CAPACITY);
	}
	
	
	public SeparateChainingHashST(int capacity) {
		M = capacity;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	private int hash(Key key) {
		
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(Key key, Value val) {
		//handle key == null
		if(val == null) {
			delete(key);
			return;
		}
		
		//handle: double the array size when average length of list>= 10
		if(N >= 10*M) {
			resize(M * 2);
		}
		
		int i = hash(key);
		if(!st[i].contains(key)) N++;
		st[i].put(key, val);
	}
	
	
	public Value get(Key key) {
		int i = hash(key);
		return st[i].get(key);
	}
	
	public void delete(Key key) {
		int i = hash(key);
		if(st[i].contains(key)) N--;
		st[i].delete(key);
		//handle array resize: halve table size if average length of list <= 2
		if(M > INIT_CAPACITY && N <= 2*M) {
			resize(M/2);
		}
		
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int capacity) {
		SeparateChainingHashST<Key, Value> tmp = new SeparateChainingHashST<Key, Value>();
		for(int i = 0; i < M; i++) {
			for(Key key:st[i].keys()) {
				tmp.put(key, st[i].get(key));
			}
		}
		
		this.M = tmp.M;
		this.N = tmp.N;
		this.st = tmp.st;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> keys = new LinkedList<Key>();
		for(int i = 0; i < M; i++) {
			
			for(Key key:st[i].keys()) {
				keys.add(key);
			}
		}
		return keys;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>(); 
        In in = new In("input/tinyST.txt");
        for (int i = 0; !in.isEmpty(); i++) {
            String key = in.readString();
            //StdOut.println("Key:"+key);
            st.put(key, i);
            StdOut.println(key + " " + st.get(key));
        }
        
        StdOut.println();       
        //st.delete("S");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        
        StdOut.println();       
        st.delete("C");        
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

	}

}
