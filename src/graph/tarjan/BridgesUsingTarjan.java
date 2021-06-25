package graph.tarjan;

import java.util.ArrayList;

public class BridgesUsingTarjan {

	private static void dfs(int src, int parent, boolean[] visited, int[] disc, int[] low, ArrayList<ArrayList<Integer>> adj,
			int timer) {
		
		visited[src] = true;
		disc[src] = low[src] = timer;
		timer++;
		
		for(Integer neighbour : adj.get(src)) {
			
			if(neighbour == parent)
				continue;
			
			if(!visited[neighbour]) {
				dfs(neighbour, src, visited, disc, low, adj, timer);
				low[src] = Math.min(low[src], low[neighbour]); //update low of ancestor while backtracking
				
				if(low[neighbour] > disc[src]) // check bridge
					System.out.println(neighbour + " " + src);
			}
			else {
				low[src] = Math.min(low[src], disc[neighbour]);
			}
		}
	}
	
	private static void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
		
		boolean visited[] = new boolean[n];
		int disc[] = new int[n];
		int low[] = new int[n];
		int timer = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				dfs(i, -1, visited, disc, low, adj, timer);
		}
	}

	public static void main(String[] args) {
		int n = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
		
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
		
		printBridges(adj, n);
	}
}
