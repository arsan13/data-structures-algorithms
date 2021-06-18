package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WeightedGraphUsingList {

	static class Edge {
		int src;
		int dest;
		int weight;
		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return src + " " + dest;
		}
	}
	
	private LinkedList<Edge> adj[];

	public WeightedGraphUsingList(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Edge>();
	}

	public void addEdge(int src, int dest, int weight) {
		Edge edge = new Edge(src, dest,weight);
		adj[src].add(edge);
	}
	
	public void printGraph() {
		System.out.println("Src \t Dest \t Weight");
		for(int i = 0; i < adj.length; i++) {
			LinkedList<Edge> list = adj[i];
			for(Edge edge : list) {
				System.out.print(edge.src + "\t " + edge.dest + "\t " + edge.weight);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {

		int vertices = 6;
        
		WeightedGraphUsingList graph = new WeightedGraphUsingList(vertices);
        
		graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);
        
//        graph.printGraph();
        		
	}
}