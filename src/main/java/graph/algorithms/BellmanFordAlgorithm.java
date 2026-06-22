package graph.algorithms;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
	
	static class Edge{
		int u;
		int v;
		int weight;
		
		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}
	
	private static void bellmanFord(int src, ArrayList<Edge> adj, int V) {
		
		int dist[] = new int[V];
		
		for(int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		
		dist[src] = 0;
		
		// Relaxing edges for V-1 times
		for(int i = 0; i < V-1; i++) {
			for(Edge edge : adj) {
				if(dist[edge.u] + edge.weight < dist[edge.v])
					dist[edge.v] = dist[edge.u] + edge.weight;
			}
		}
		
		// Check for negative cycle
		boolean flag = false;
		for(Edge edge : adj) {
			if(dist[edge.u] + edge.weight < dist[edge.v]) {
				System.out.println("Graph contains negative weight cycle");
				flag = true;
				break;
			}
		}
		
		// Print distances of edges if there are no negative edges
		if(flag == false) {
		System.out.println("Vertex | Distance");
		for(int i = 0; i < V; i++)
			System.out.println(i + "\t " + dist[i]);
		}
	}
	
	public static void main(String[] args) {
		
		int V = 5;
		
		ArrayList<Edge> adj = new ArrayList<>();
		
		adj.add(new Edge(0, 1, -1));
		adj.add(new Edge(0, 2, 4));
		adj.add(new Edge(1, 2, 3));
		adj.add(new Edge(1, 3, 2));
		adj.add(new Edge(1, 4, 2));
		adj.add(new Edge(3, 2, 5));
		adj.add(new Edge(3, 1, 1));
		adj.add(new Edge(4, 3, -3));
		
		bellmanFord(0, adj, V);
	}
}
