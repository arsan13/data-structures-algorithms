package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraph {

	public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        
        for(int i = 0; i < V; i++) {

            if(!visited[i]) {
//                if(bfs(i, adj, visited))
                if(dfs(i, -1, adj, visited))
                    return true;
            }
        }
        
        return false;
    }
	
	private static boolean dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
      visited[src] = true;
     
      for(int neighbour : adj.get(src)) {
          if(!visited[neighbour]) {
              if(dfs(neighbour, src, adj, visited))
                  return true;
          }
          else if(neighbour != parent)
              return true; 
      }
     
      return false;
  }
	
	private static boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[adj.size()];
        
        visited[src] = true;
        queue.add(src);
        parent[src] = -1;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int neighbour : adj.get(current)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    parent[neighbour] = current;
                }
                else if(parent[current] != neighbour)
                    return true;
            }
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		
		int V = 3;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(0).add(2);
		adj.get(2).add(0);
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		System.out.println(isCycle(V, adj));
		
	}

}
