package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

import graph.PrimAlgorithm.Pair;

public class MinimumCost {

	static class Pair implements Comparable<Pair>{
		int vertex;
		int parent;
		int weight;
		
		public Pair(int vertex, int parent, int weight) {
			this.vertex = vertex;
			this.parent = parent;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair other) {
			return this.weight - other.weight; // min heap
		}
	}
	
	private static int findcost(int n, int[][] city) {
		
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		ArrayList<Pair> list = new ArrayList<>();
		boolean[] visited = new boolean[n];
		
		minHeap.add(new Pair(0, -1, 0));
		
		while(!minHeap.isEmpty()) {
			Pair u = minHeap.poll();
			
			if(visited[u.vertex])
				continue;
			
			list.add(u);
			visited[u.vertex] = true;
			
			for(int v = 0; v < n; v++) {
				if(city[u.vertex][v] > 0 && !visited[v])
					minHeap.add(new Pair(v, u.vertex, city[u.vertex][v]));
			}
		}
		
//		System.out.println("Vertex|Parent|Weight");
//		for(Pair pair : list)
//			System.out.println(pair.vertex + "\t" + pair.parent + "\t" + pair.weight);
		
		int cost = 0;
		for(Pair p : list)
			cost += p.weight;
		
		return cost;
	}
	
	public static void main(String[] args) {
		
		int n = 5;
	    int[][] city = { { 0, 1, 2, 3, 4 },
	                     { 1, 0, 5, 0, 7 },
	                     { 2, 5, 0, 6, 0 },
	                     { 3, 0, 6, 0, 0 },
	                     { 4, 7, 0, 0, 0 } };
	    
//	    int n = 6;
//	    int city[][] = { { 0, 1, 1, 100, 0, 0 },
//                		 { 1, 0, 1, 0, 0, 0 },
//                		 { 1, 1, 0, 0, 0, 0 },  
//				         { 100, 0, 0, 0, 2, 2 },
//				         { 0, 0, 0, 2, 0, 2 },  
//				         { 0, 0, 0, 2, 2, 0 } };
	 
	    System.out.println("Cost = " + findcost(n, city));
	}
}
