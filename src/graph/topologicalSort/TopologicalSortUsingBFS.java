package graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
	
	public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int n) {
		
		Queue<Integer> queue = new LinkedList<>();
		int inDegree[] = new int[n];
		
		// Find in-degree
		for(int i = 0; i < n; i++) {
			for(int v : adj.get(i)) {
				inDegree[v]++;
			}
		}
		
		// Push 0 degree nodes to queue
		for(int i = 0; i < n; i++) {
			if(inDegree[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.println(u);
			for(Integer v : adj.get(u)) {
				inDegree[v]--;
				if(inDegree[v] == 0)
					queue.add(v);
			}
		}
	}

	public static void main(String[] args) {
		
		int n = 7;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
		
		adj.get(0).add(1);
		adj.get(0).add(3);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(4).add(3);
		adj.get(4).add(5);
		adj.get(4).add(6);
		
		topologicalSort(adj, n);
	}

}
