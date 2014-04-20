package sedgewick.search;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class BST<Key extends Comparable<Key>, Value> {
	Node root = null;
	
	private class Node {
		Node left, right;
		Key key;
		Value val;
		public Node(Key k, Value v) {
			val = v;
			key = k;
		}
	}
	
	public Value get(Key key) {
		Node x = root;
		
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if(cmp < 0) {
				x = x.left;
			} else if(cmp > 0) {
				x = x.right;
			} else {
				return x.val;
			}
		}
		
		return null;
	}

	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if(x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if(cmp < 0) {
			x.left = put(x.left, key, val);
		}
		else if(cmp > 0) {
			x.right = put(x.right, key, val);
		}
		else {
			x.val = val;
		}
		return x;
	}
	
    public static void main(String[] args) { 
        BST<String, Integer> st = new BST<String, Integer>();
        In in = new In("input/tinyST.txt");
        for (int i = 0; !in.isEmpty(); i++) {
            String key = in.readString();
            //StdOut.println("Key:"+key);
            st.put(key, i);
            StdOut.println(key + " " + st.get(key));
        }

//        for (String s : st.levelOrder())
//            StdOut.println(s + " " + st.get(s));
//
//        StdOut.println();
//
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));
    }	
}
