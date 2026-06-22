package graph.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class DijkstraAlgorithm {
	
	private static class Node {
	    private int vertex;
	    private int weight;
	    
	    Node(int v, int w) { 
	    	vertex = v; 
	    	weight = w; 
	    }
	    
	}
	
	//O(V + ElogV) Time
	public void shortestPath(int src, ArrayList<ArrayList<Node>> adj, int n) {
		
		int dist[] = new int[n];
		int parent[] = new int[n];
		
//		O(V) Time
		for(int i = 0; i < n; i++)
			dist[i] = Integer.MAX_VALUE;
		
		PriorityQueue<Node> minQueue = new PriorityQueue<Node>((a, b) -> a.weight - b.weight);
		
		dist[src] = 0;
		parent[src] = -1;
		minQueue.add(new Node(src, 0));
	 	
//		O(ElogV) Time
		while(!minQueue.isEmpty()) {
			Node node = minQueue.poll();
			
			for(Node neighbour : adj.get(node.vertex)) {
				if(dist[node.vertex] + neighbour.weight < dist[neighbour.vertex]) {
					dist[neighbour.vertex] = dist[node.vertex] + neighbour.weight;
					parent[neighbour.vertex] = node.vertex;
					minQueue.add(new Node(neighbour.vertex, dist[neighbour.vertex]));
				}
			}
		}
		
		System.out.print("Vertex:   ");
		for(int i = 0; i < n; i++) 
			System.out.print(i + " ");
		System.out.println();
		
		System.out.print("Distance: ");
		for(int i = 0; i < n; i++) 
			System.out.print(dist[i] + " ");
		System.out.println();
		
		System.out.print("Parent:  ");
		for(int i = 0; i < n; i++)
			System.out.print(parent[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		
		ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<Node>());
		
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 4));
		adj.get(2).add(new Node(1, 4));
		
		adj.get(0).add(new Node(3, 1));
		adj.get(3).add(new Node(0, 1));
		
		adj.get(3).add(new Node(2, 3));
		adj.get(2).add(new Node(3, 3));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 1));
		adj.get(4).add(new Node(2, 1));
		
		DijkstraAlgorithm obj = new DijkstraAlgorithm();
		obj.shortestPath(0, adj, n);
	}
}
