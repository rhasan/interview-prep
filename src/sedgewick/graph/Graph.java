package sedgewick.graph;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;

public class Graph {

	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		adj = (ArrayList<Integer>[])new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();		
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	
	
    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }	

}
