package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Minimum time taken by each job to be completed given by a Directed Acyclic Graph

public class JobCompletion {

	private static void minTime(ArrayList<ArrayList<Integer>> adj, int n) {
		
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[n+1];
		int res[] = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int v : adj.get(i)) {
				inDegree[v]++;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
				res[i] = 1;
			}
		}
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			
			for(int v : adj.get(u)) {
				inDegree[v]--;
				if(inDegree[v] == 0) {
					queue.add(v);
					res[v] = res[u] + 1;
				}
			}
		}
		
		for(int i = 1; i <= n; i++)
			System.out.println(i + "  " + res[i]);
	}
	
	public static void main(String[] args) {
		
//		int n = 10;
//		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//		
//		for(int i = 0; i <= n; i++)
//			adj.add(new ArrayList<>());
//		
//		adj.get(1).add(3);
//		adj.get(1).add(4);
//		adj.get(1).add(5);
//		
//		adj.get(2).add(3);
//		adj.get(2).add(8);
//		adj.get(2).add(9);
//		
//		adj.get(3).add(6);
//		
//		adj.get(4).add(6);
//		adj.get(4).add(8);
//		
//		adj.get(5).add(8);
//		
//		adj.get(6).add(7);
//		
//		adj.get(7).add(8);
//		
//		adj.get(8).add(10);
		
		int n = 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		
		adj.get(1).add(2);
		
		adj.get(2).add(3);
		adj.get(2).add(4);
		adj.get(2).add(5);
		
		adj.get(3).add(6);
		adj.get(4).add(7);
		
		adj.get(5).add(7);
		
		minTime(adj, n);
	}
}
