package graph;

import java.util.ArrayList;

public class WiredConnections {
	
	public static int makeConnected(int n, int[][] connections) {
        
        // (n-1) number of edges is required to connect n components
        
        int edges = connections.length; 
        
        if(edges < n-1)     // n vertices must have  >= n-1 edges
            return -1;
        
        // create graph
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < edges; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        // find number of components;
    
        int components = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i <n; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                components++;
            }
        }
        
        return components - 1;
    }
    
    private static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        
        for(Integer v : adj.get(u)) {
            if(!visited[v]) {
                visited[v] = true;
                dfs(v, adj, visited);
            }
        }
    }
	
	public static void main(String[] args) {
		int n = 4; 
		int[][] connections = {{0,1},{0,2},{1,2}};
		
//		0 - 1
//		| / 
//		2   3
		
		System.out.println(makeConnected(n, connections));
	}

}
