package sedgewick.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class DepthFirstPaths {
	
	private boolean[] marked;
	private int[] parent;
	private int start;
	
	public DepthFirstPaths(Graph G, int start) {
		marked = new boolean[G.V()];
		parent = new int[G.V()];
		this.start = start;
		dfs(G, start);
		
	}
	
	private void dfs(Graph G, int u) {
		marked[u] = true;
		for(int v:G.adj(u)) {
			if(marked[v] == false) {
				parent[v] = u;
				dfs(G,v);
			}
		}
	}
	
	public boolean hasPathTo(int u) {
		return marked[u];
	}
	
	public Iterable<Integer> pathTo(int u) {
		if(!hasPathTo(u)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int v = u; v != start; v = parent[v]) {
			stack.push(v);
			//System.out.println("push:"+v);
		}
		stack.push(start);
		//System.out.println("push:"+start);
		List<Integer> list = new ArrayList<Integer>();
		int len = stack.size();
		for(int i = 0; i < len; i++) {
			list.add(stack.pop());
		}
		return list;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[1]);
		 DepthFirstPaths dfs = new DepthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:  ", s, v);
				for (int x : dfs.pathTo(v)) {
					if (x == s)
						StdOut.print(x);
					else
						StdOut.print("-" + x);
				}
				StdOut.println();
			}

			else {
				StdOut.printf("%d to %d:  not connected\n", s, v);
			}

		}

	}

}
