package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimunEdgesToReverse {

	/*
	 * 1. Make a reverse edge corresponding to every edge and we assign that a
	 * weight 1 and assign a weight 0 to original edge. 2. Apply Dijsktra Algorithm
	 * : if we move towards original edge, no cost is incurred, but if we move
	 * toward reverse edge 1 cost is added.
	 */

	static class Edge implements Comparable<Edge> {
		int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	private static int findMinEdges(int src, int dest, ArrayList<ArrayList<Integer>> adj, int V) {
		
		// Modify graph
		ArrayList<ArrayList<Edge>> myAdj =  modifyGraph(adj, V);
		
		// Dijkstra's Algorithm
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		pq.add(new Edge(src, 0));
		
		while(!pq.isEmpty()) {
			Edge u = pq.poll();
			
			for(Edge v : myAdj.get(u.vertex)) {
				if(dist[u.vertex] + v.weight < dist[v.vertex]) {
					dist[v.vertex] = dist[u.vertex] + v.weight;
					pq.add(new Edge(v.vertex, dist[v.vertex]));
				}
			}	
		}
		
		return dist[dest];
	}

	private static ArrayList<ArrayList<Edge>> modifyGraph(ArrayList<ArrayList<Integer>> adj, int V) {
		
		ArrayList<ArrayList<Edge>> myAdj = new ArrayList<>();

		for (int i = 0; i < V; i++)
			myAdj.add(new ArrayList<>());
		
		for(int u = 0; u < V; u++) {
			for(Integer v : adj.get(u)) {
				myAdj.get(u).add(new Edge(v, 0));
				myAdj.get(v).add(new Edge(u, 1));
			}
		}
		
		return myAdj;
	}

	public static void main(String[] args) {

		int V = 7;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<>());

		adj.get(0).add(1);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(5).add(1);
		adj.get(4).add(5);
		adj.get(6).add(4);
		adj.get(6).add(3);

		System.out.println(findMinEdges(0, 6, adj, V));
	}
}
