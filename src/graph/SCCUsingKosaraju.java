package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SCCUsingKosaraju {

	private static void dfs(int u, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		
		visited[u] = true;
		
		for(Integer v : adj.get(u)) {
			if(!visited[v])
				dfs(v, stack, adj, visited);	
		}
		
		stack.push(u);
	}
	
	private static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj, int n) {

		ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			transpose.add(new ArrayList<Integer>());
		
		for(int i = 0; i < n; i++) {
			for(Integer u : adj.get(i))
				transpose.get(u).add(i);
		}
		
		return transpose;
	}
	
	private static void reverseDfs(int u, ArrayList<ArrayList<Integer>> transpose, boolean[] visited) {
		visited[u] = true;
		System.out.print(u + " ");
		for(Integer v : transpose.get(u)) {
			if(!visited[v])
				reverseDfs(v, transpose, visited);
		}
	}
	
	private static void findComponents(ArrayList<ArrayList<Integer>> adj, int n) {
		
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[n];

		// Step 1: Topological sort
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				dfs(i, stack, adj, visited);
		}
		
		// Step 2: Transpose graph
		ArrayList<ArrayList<Integer>> transpose = getTranspose(adj, n);
		
		// Step 3: Reset visited array
		Arrays.fill(visited, false);
		
		// Step 4: Do reverse dfs i.e dfs of transpose
		while(!stack.isEmpty()) {
			int u = stack.pop();
			if(!visited[u]) {
				System.out.print("SCC : ");
				reverseDfs(u, transpose, visited);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		int n = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);
		
		findComponents(adj,n);
	}
}
