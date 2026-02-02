package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph {

	public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        boolean[] activeVisited = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!visited[i])
              if(dfsCycleCheck(i, adj, visited, activeVisited))
//              if(bfsCycleCheck(adj, i))
                    return true;
        }
        
        return false;
    }
    
    private static boolean dfsCycleCheck(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] activeVisited) {

        visited[src] = true;
        activeVisited[src] = true;
        
        for(int neighbour : adj.get(src)) {
            if(!visited[neighbour]) {
                if(dfsCycleCheck(neighbour, adj, visited, activeVisited))
                    return true;
            }
            else if(activeVisited[neighbour])
                return true;
        }
        
        activeVisited[src] = false;
        
        return false;
    }
    
    // Uses topological Sort
    public static boolean bfsCycleCheck(ArrayList<ArrayList<Integer>> adj, int n) {
		
		Queue<Integer> queue = new LinkedList<>();
		int inDegree[] = new int[n];
		
		// Find in-degree
		for(int i = 0; i < n; i++) {
			for(int v : adj.get(i)) {
				inDegree[v]++;
			}
		}
		
		// Push 0 degree nodes to queue
		for(int i = 0; i < n; i++) {
			if(inDegree[i] == 0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.println(u);
			for(Integer v : adj.get(u)) {
				inDegree[v]--;
				if(inDegree[v] == 0)
					queue.add(v);
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(inDegree[i] != 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int V = 3;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
				
		System.out.println(isCyclic(V, adj));
		
	}

}
