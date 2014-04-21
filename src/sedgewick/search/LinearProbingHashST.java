package sedgewick.search;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class LinearProbingHashST<Key, Value> {
	public static int INIT_CAPACITY = 4;
	private int M;
	int N;
	private Key[] keys;
	private Value[] values;
	
	
	public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}

	public LinearProbingHashST(int capacity) {
		M = capacity;
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}
	
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	public Value get(Key key) {
		
		int i;
		for(i = hash(key); keys[i]!=null; i = (i+1)%M) {
			if(keys[i].equals(key)) return values[i];
		}
		
		return null;
	}
	
	public void put(Key key, Value val) {
		
		if(val == null) {
			delete(key);
			return;
		}
		// double table size if 50% full
		if(N >= M/2) {
			resize(2*M);
		}
		
		
		int i;
		for(i = hash(key); keys[i]!=null; i = (i+1)%M) {
			if(keys[i].equals(key)) {
				keys[i] = key;
				values[i] = val;
				return;
			}
		}
		keys[i] = key;
		values[i] = val;
		N++;
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;
		
		int i = hash(key);
		while(!keys[i].equals(key)) {
			i = (i + 1) % M;
		}
		keys[i] = null;
		values[i] = null;
		
		// rehash all keys in same cluster
		i = (i + 1) % M;
		while(keys[i] != null) {
			Key rhk = keys[i];
			Value rhv = values[i];
			
			keys[i] = null;
			values[i] = null;
			
			N--;
			put(rhk, rhv);
			i = (i + 1) % M;
		}
		N--;
		
		// halves size of array if it's 12.5% full or less
		if(N>0 && N <= M/8) {
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
		
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        M    = temp.M;
	}
	public Iterable<Key> keys() {
		Queue<Key> q = new LinkedList<Key>();
		for(int i = 0; i < M; i++) {
			if(keys[i] != null) {
				q.add(keys[i]);
			}
		}
		return q;
	}

	public static void main(String[] args) {
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
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
