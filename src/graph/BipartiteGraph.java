package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph
{
    private boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int u, int[] color) {
		
		if(color[u] == -1)
		    color[u] = 1;
		
		for(Integer v : adj.get(u)) {
		    
		    if(color[v] == -1) {
		        color[v] = 1 - color[u];  // adjacent vertices should have complement colors -> 1, 0
		        
		        if(!dfsCheck(adj, v, color))
		            return false;
		    }
		    else if(color[v] == color[u]) {
		        return false;
		    }   
		}	
		return true;
	}

    private boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int src, int[] color) {
		
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(src);
    	color[src] = 1;
    	
    	while(!queue.isEmpty()) {
    		int u = queue.poll();
    		
    		for(Integer v : adj.get(u)) {
    			if(color[v] == -1) {
    				color[v] = 1 - color[u]; // adjacent vertices should have complement colors -> 1, 0
    				queue.add(v);
    			}
    			else if(color[v] == color[u])
    				return false;
    		}
    	}
    	
    	return true;
	}
    
    boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int color[] = new int[n];  // it also acts as visited array
        for(int i = 0;i<n;i++) {
        	color[i] = -1; 
        }
        
        for(int i = 0;i<n;i++) {
        	if(color[i] == -1) {
//        		if(!dfsCheck(adj, i, color)) {
        		if(!bfsCheck(adj, i, color)) {
        			return false; 
        		}
        	}
        }
        return true; 
    }
    
    

	public static void main(String args[])
    {
        int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);

		adj.get(1).add(6);
		adj.get(6).add(1);
		
			
		BipartiteGraph obj = new BipartiteGraph(); 
		
		if(obj.checkBipartite(adj, n)) 
			System.out.println("Yes Bipartite"); 
		else
			System.out.println("Not Bipartite"); 
		
    }
}
