package graph.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDAG {
	
	static class Pair {
		int vertex;
		int weight;
		
		public Pair(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	private static void shortestPath(int src, ArrayList<ArrayList<Pair>> adj, int n) {
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n];
		int dist[] = new int[n];
		
//		1. Topological Sorting
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				topologicalSort(i, adj, stack, visited);
		}
		
//		2. Initialize dist array to INF except src which is to be 0
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
//		3. Traverse each element in the stack and update dist. 
//			Traverse a element only if its dist is updated by its previous nodes i.e., dist[u] != INF
		while(!stack.isEmpty()) {
			int u = stack.pop();
			
			if(dist[u] != Integer.MAX_VALUE) {
				for(Pair v : adj.get(u)) {
					if(dist[u] + v.weight < dist[v.vertex])
						dist[v.vertex] = dist[u] + v.weight;
				}
			}
		}
		
//		4. Print Distance
		for(int i = 0; i < n; i++) {
			System.out.println(i + " " + dist[i]);
		}
	}
	
	private static void topologicalSort(int u, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack,
			boolean[] visited) {
		
		visited[u] = true;
		
		for(Pair v : adj.get(u)) {
			if(!visited[v.vertex]) {
				visited[v.vertex] = true;
				topologicalSort(v.vertex, adj, stack, visited);
			}
		}
		
		stack.add(u);
	}

	public static void main(String[] args) {
		
		int n = 6;
        ArrayList<ArrayList<Pair> > adj = new ArrayList<ArrayList<Pair> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Pair>());
			
		adj.get(0).add(new Pair(1, 2));
		adj.get(0).add(new Pair(4, 1));
		adj.get(1).add(new Pair(2, 3));
		adj.get(2).add(new Pair(3, 6));
		adj.get(4).add(new Pair(2, 2));
		adj.get(4).add(new Pair(5, 4));
		adj.get(5).add(new Pair(3, 1));
		
		shortestPath(0, adj, n);
	}
}
