package sedgewick.fundamentals;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class QuickUnionPathCompressionUF {

	private int[] id;
	private int[] sz;
	private int count;
	
	public QuickUnionPathCompressionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for(int i = 0;i < N;i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	/**
	 * Finds the root of the tree for the current component
	 * @param i node
	 * @return root node
	 */
	public int find(int i){
		while(i != id[i]) {
			//Make every other node in path point to its grandparent (thereby halving path length).
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	
	public void union(int p,int q) {
		int pid = find(p);
		int qid = find(q);
		if(pid == qid)return;
		
		//Balance by linking root of smaller tree to root of larger tree
		if(sz[pid] < sz[qid]) {
			id[pid] = qid;
			sz[qid] += sz[pid];
		}
		else {
			id[qid] = pid;
			sz[pid] += sz[qid];
		}
		
		
		count--;
	}
	
	public int count() {
		return count;
	}

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
         // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }	
}
