package graph;

import java.util.ArrayList;

public class PathMoreThanK {
	
	static class Edge {
        int vertex;
        int weight;
        
        Edge(int v, int w) {
            vertex = v;
            weight = w;
        }
    }
	
	public static boolean isPresent(int src, ArrayList<ArrayList<Edge>> adj, int V, int k) {
		
		boolean[] visited = new boolean[V]; 
		return isPresentUtil(src, adj, k, visited);
	}
	
	private static boolean isPresentUtil(int src, ArrayList<ArrayList<Edge>> adj, int k, boolean[] visited) {
		
		visited[src] = true;
		
		if(k <= 0)	// Path possible
			return true;
		
		for(Edge edge : adj.get(src)) {
			int v = edge.vertex;
			int w = edge.weight;
			
			if(visited[v])	// skip vertex if it leads to cycle
				continue;
			
			if(w >= k)		// if weight of edge is greater than k
				return true;
			
			if(isPresentUtil(v, adj, k-w, visited))
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int V = 6;
		int k = 15;
		
		
		ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        
//      0 -- 1 -- 2 -- 3
//        		   \    \
//         	 		4 -- 5
        
        adj.get(0).add(new Edge(1, 5));
        adj.get(1).add(new Edge(0, 5));
        
        adj.get(1).add(new Edge(2, 1));
        adj.get(2).add(new Edge(1, 1));
        
        adj.get(2).add(new Edge(3, 1));
        adj.get(3).add(new Edge(2, 1));
        
        adj.get(2).add(new Edge(4, 4));
        adj.get(4).add(new Edge(2, 4));
        
        adj.get(3).add(new Edge(5, 3));
        adj.get(5).add(new Edge(3, 3));
        
        adj.get(4).add(new Edge(5, 5));
        adj.get(5).add(new Edge(4, 5));
        
        System.out.println(isPresent(0, adj, V, k));
	}
}
