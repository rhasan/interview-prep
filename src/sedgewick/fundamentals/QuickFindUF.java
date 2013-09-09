package sedgewick.fundamentals;

import edu.princeton.cs.introcs.*;

public class QuickFindUF {

	private int[] id;
	private int count;
	
	
	public QuickFindUF(int N) {
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i] = i;
		}
		count = N;
	}
	
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	
	public int find(int p) {
		return id[p];
	}
	
	public void union(int p, int q) {
		if(connected(p,q)) return;
		int pid = id[p];
		int qid = id[q];
		
		for(int i=0;i<id.length;i++) {
			if(id[i]==pid) { 
				id[i]=qid;
			}
		}
		count--;
		
	}
	public int count() {
		return count;
	}
    
	public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);

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
