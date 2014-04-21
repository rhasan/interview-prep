package sedgewick.search;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class SequentialSearchST<Key, Value> {

	Node first;
	int N;
	private class Node {
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
    public SequentialSearchST() {
    	N = 0;
    	first = null;
    }
	
	public void put(Key key, Value val) {
		if(val == null) {
			delete(key);
			return;
		}
		Node x = first;
		while(x != null) {
			if(x.key.equals(key)) {
				x.val = val;
				return;
			}
			x = x.next;
		}
		first = new Node(key, val, first);
		N++;
	}
	
	
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	
	public Value get(Key key) {
		for(Node x = first; x!=null; x = x.next) {
			if(x.key.equals(key)) {
				return x.val;
			}
		}
		return null;
	}
	public void delete(Key key) {
		first = delete(first, key);
	}
	
	private Node delete(Node x, Key key) {
		if(x == null) return null;
		
		if(x.key.equals(key)) {
			N--;
			Node t = x.next;
			x = null; // Avoid loitering
			return t;
		}
		x.next = delete(x.next, key);
		return x;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> keys = new LinkedList<Key>();
		for(Node x = first; x!=null; x = x.next) {
			keys.add(x.key);
		}
		return keys;
	}
	
    public static void main(String[] args) { 
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
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
