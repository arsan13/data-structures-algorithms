package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TwoClique {
	
	/*
	 * 1. Create complement of given graph.
	 * 2. Given graph is two clique if the complement graph is bipartite.
	 * 
	 * If complement is Bipartite, then graph can be divided into two sets U and V such that 
	 * there is no edge connecting to vertices of same set. This means in original graph, these 
	 * sets U and V are completely connected. Hence original graph could be divided in two Cliques.
	 */
	
	private static boolean isTwoCliques(ArrayList<ArrayList<Integer>> adj, int V) {
		
		ArrayList<ArrayList<Integer>> complement = getComplementGraph(adj, V);
		
		return checkBipartite(complement, V);
	}
	
    private static ArrayList<ArrayList<Integer>> getComplementGraph(ArrayList<ArrayList<Integer>> adj, int V) {
    	
    	ArrayList<ArrayList<Integer>> complement = new ArrayList<>();
		for(int i = 0; i < V; i++)
			complement.add(new ArrayList<>());
		
		int[] temp = new int[V];
		
		for(int u = 0; u < V; u++) {
			temp[u] = 1;
			
			for(Integer neighbour : adj.get(u)) {
				temp[neighbour] = 1;
			}
			
			for(int v = 0; v < V; v++) {
				if(temp[v] == 0) {
					complement.get(u).add(v);
				}
			}
			
			Arrays.fill(temp, 0); // Clear array for next vertices
		}
		
		return complement;
	}

	static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int color[] = new int[n];  // it also acts as visited array
        for(int i = 0;i<n;i++) {
        	color[i] = -1; 
        }
        
        for(int i = 0;i<n;i++) {
        	if(color[i] == -1) {
        		if(!checkBipartiteUtil(adj, i, color)) {
        			return false; 
        		}
        	}
        }
        return true; 
    }
	
    private static boolean checkBipartiteUtil(ArrayList<ArrayList<Integer>> adj, int src, int[] color) {
		
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
	
	public static void main(String[] args) {

		int V = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<>());
		
		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(0).add(3);
		
		adj.get(1).add(0);
		adj.get(1).add(2);
		
		adj.get(2).add(0);
		adj.get(2).add(1);
		
		adj.get(3).add(0);
		adj.get(3).add(4);
		
		adj.get(4).add(3);
				
		System.out.println(isTwoCliques(adj, V));
	}
}
