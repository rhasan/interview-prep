package sedgewick.fundamentals;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class QuickUnionUF {

	private int[] id;
	private int count;
	
	public QuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for(int i = 0;i < N;i++) {
			id[i] = i;
		}
	}
	
	public int find(int i){
		while(i != id[i]) {
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
		if(pid==qid)return;
		id[pid] = qid;
		count--;
	}
	
	public int count() {
		return count;
	}

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);

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
