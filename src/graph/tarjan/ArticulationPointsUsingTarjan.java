package graph.tarjan;

import java.util.ArrayList;

public class ArticulationPointsUsingTarjan {

	private static void dfs(int src, int parent, boolean[] isArticulation, boolean[] visited, int[] disc, int[] low, ArrayList<ArrayList<Integer>> adj,
			int timer) {
		
		visited[src] = true;
		disc[src] = low[src] = timer++;
		int children = 0;
		
		for(Integer neighbour : adj.get(src)) {
			
			if(neighbour == parent)
				continue;
			
			if(!visited[neighbour]) {
				children++;
				dfs(neighbour, src, isArticulation, visited, disc, low, adj, timer);
				low[src] = Math.min(low[src], low[neighbour]);
				
				if(parent == -1 && children > 1) {  //Case-1: src is root
					isArticulation[src] = true;
				}
				
				if(parent != -1 && low[neighbour] >= disc[src]) {  //Case-2: Atleast 1 component will get separated
					isArticulation[src] = true;
				}
			}
			else {
				low[src] = Math.min(low[src], disc[neighbour]);
			}
		}
	}
	
	private static void findArticulationPoints(ArrayList<ArrayList<Integer>> adj, int n) {
		
		boolean isArticulation[] = new boolean[n];
		boolean visited[] = new boolean[n];
		int disc[] = new int[n];
		int low[] = new int[n];
		int timer = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				dfs(i, -1, isArticulation, visited, disc, low, adj, timer);
		}
		
		for(int i = 0; i < n; i++) {
			if(isArticulation[i])
				System.out.println(i);
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
		
		findArticulationPoints(adj,n);
	}

}
