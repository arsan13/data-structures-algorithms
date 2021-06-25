package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPaths {

	private static void findPaths(int src, ArrayList<ArrayList<Integer>> adj, int v) {
		HashSet<Integer> visited = new HashSet<>();
		findPathsUtil(src, adj, visited, src+"", src);
	}
	
	private static void findPathsUtil(int src, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited,
			String path, int origin) {
		
		// base
		if(visited.size() == adj.size() - 1) {	// visisted.size == adj.size - 1, and not visited.size 
			System.out.println(path);			// because vertex is appended in path before adding it in visited vertex
												// visited set is one step behind
			// Check hamiltonian cycle
			for(Integer neighbour : adj.get(src)) {
				if(neighbour == origin) {
					System.out.println("Closing edge is found.");
					break;
				}
			}
			
			return;								
		}
		
		visited.add(src);
		for(Integer neighbour : adj.get(src)) {
			if(!visited.contains(neighbour))
				findPathsUtil(neighbour, adj, visited, path+ " -> " + neighbour, origin);
		}
		visited.remove(src);
	}

	public static void main(String[] args) {

		int V = 4;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(1);
		adj.get(1).add(0);
	
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(1).add(3);
		adj.get(3).add(1);
		
//		adj.get(0).add(3);
//		adj.get(3).add(0);
		
		findPaths(0, adj, V);
	}
}
