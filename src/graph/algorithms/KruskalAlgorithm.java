package graph.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
	
	static class Node implements Comparable<Node> {
		
		int u, v, weight;
		
		public Node(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node other) {
			return this.weight - other.weight;
		}

		@Override
		public String toString() {
			return "Node [u=" + u + ", v=" + v + ", weight=" + weight + "]";
		}
	}
	
	private static int findParent(int u, int parent[]) {
		if(u == parent[u])
			return u;
		
		return parent[u] = findParent(parent[u], parent);
	}
	
	private static void union(int u, int v, int parent[], int rank[]) {
		
		u = findParent(u, parent);
		v = findParent(v, parent);
		
		if(rank[u] < rank[v]) 
			parent[u] = v;
		else if(rank[v] > rank[u])
			parent[v] = u;
		else {
			parent[v] = u;
			rank[u]++;
		}
	}
	
	private static ArrayList<Node> kruskalAlg(ArrayList<Node> adj, int n) {
		
		Collections.sort(adj);
		int parent[] = new int[n];
		int rank[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int cost = 0;
		ArrayList<Node> mst = new ArrayList<>();
		
		for(Node node : adj) {
			if(findParent(node.u, parent) != findParent(node.v, parent)) {
				cost += node.weight;
				mst.add(node);
				union(node.u, node.v, parent, rank);
			}
		}
		
//		System.out.println(cost);
		return mst;
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		ArrayList<Node> adj = new ArrayList<>();
		
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));
		
		ArrayList<Node> mst = kruskalAlg(adj, n);		
		for(Node node : mst)
			System.out.println(node);
	}
}
