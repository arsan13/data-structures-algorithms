package graph.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
	
	static class Node {
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
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
	
	static ArrayList<Pair> primAlgUsingHeap(ArrayList<ArrayList<Node>> adj, int n) {
	
		ArrayList<Pair> result = new ArrayList<>();
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		boolean visited[] = new boolean[n];
		
		minHeap.add(new Pair(0, -1, 0));
	
		while(!minHeap.isEmpty()) {
			Pair u = minHeap.poll();
			
			if(visited[u.vertex])
				continue;
			
			result.add(u);
			visited[u.vertex] = true;
			
			for(Node v : adj.get(u.vertex)) {
				if(!visited[v.vertex]) {
					minHeap.add(new Pair(v.vertex, u.vertex, v.weight));
				}	
			}
		}  
		
		return result;
	}
	
	static void primAlgUsingBrute(ArrayList<ArrayList<Node>> adj, int n) {
		
		int weight[] = new int[n];
		int parent[] = new int[n];
		boolean mst[] = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			weight[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			mst[i] = false;
		}
		
		weight[0] = 0; //source
		
		for(int i = 0; i < n-1; i++) {  // traverse for n-1 times, since a spanning tree has that many edges
			
			// get vertex with least weight
			int min = Integer.MAX_VALUE;
			int u = 0;
			for(int v = 0; v < n; v++) {
				if(mst[v] == false && weight[v] < min) { // if not visited and has least weight
					min = weight[v];
					u = v;
				}
			}
			
			mst[u] = true; 	// mark selected vertex as visited
			
			// explore neighbours
			for(Node v : adj.get(u)) {
				if(mst[v.vertex] == false && v.weight < weight[v.vertex]) {
					parent[v.vertex] = u;			// update weight
					weight[v.vertex] = v.weight;		// update parent
				}
			}
		}
		
		System.out.println("Vertex|Parent|Weight");
		for(int i = 0; i < n; i++)
			System.out.println(i + "\t" + parent[i] + "\t" + weight[i]);
	}
	
	public static void main(String[] args) {

		int n = 7;
		ArrayList<ArrayList<Node>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(new Node(1, 10));
		adj.get(0).add(new Node(3, 40));
		
		adj.get(1).add(new Node(2, 10));
		
		adj.get(2).add(new Node(3, 10));
		
		adj.get(3).add(new Node(4, 2));
		
		adj.get(4).add(new Node(5, 3));
		
		adj.get(4).add(new Node(6, 8));
		
		adj.get(5).add(new Node(6, 3));
		
		ArrayList<Pair> result = primAlgUsingHeap(adj, n);
		System.out.println("Vertex|Parent|Weight");
		for(Pair pair : result)
			System.out.println(pair.vertex + "\t" + pair.parent + "\t" + pair.weight);
		
		System.out.println();
	
		primAlgUsingBrute(adj, n);;
	}

}
