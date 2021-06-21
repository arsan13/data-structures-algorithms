package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
	static class Node implements Comparable<Node>
	{
	    private int vertex;
	    private int weight;
	    
	    Node(int _v, int _w) { 
	    	vertex = _v; 
	    	weight = _w; 
	    }
	    	    
	    int getVertex() { return vertex; }
	    int getWeight() { return weight; }
	    
	    @Override
	    public int compareTo(Node other) 	    { 
	    	return this.weight - other.weight;
	    } 
	}
	
	void shortestPath(int src, ArrayList<ArrayList<Node>> adj, int n) {
		
		int dist[] = new int[n];
		int parent[] = new int[n];
		
		for(int i = 0; i < n; i++)
			dist[i] = Integer.MAX_VALUE;
		
		PriorityQueue<Node> minQueue = new PriorityQueue<Node>();
		
		dist[src] = 0;
		parent[src] = -1;
		minQueue.add(new Node(src, 0));
	 	
		while(!minQueue.isEmpty()) {
			Node node = minQueue.poll();
			
			for(Node neighbour : adj.get(node.getVertex())) {
				if(dist[node.getVertex()] + neighbour.getWeight() < dist[neighbour.getVertex()]) {
					dist[neighbour.getVertex()] = dist[node.getVertex()] + neighbour.getWeight();
					parent[neighbour.getVertex()] = node.getVertex();
					minQueue.add(new Node(neighbour.getVertex(), dist[neighbour.getVertex()]));
				}
			}
		}
		
		System.out.print("Distance: ");
		for(int i = 0; i < n; i++) 
			System.out.print(dist[i] + " ");
		
		System.out.println();
		
		System.out.print("Parent:  ");
		for(int i = 0; i < n; i++)
			System.out.print(parent[i] + " ");
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
