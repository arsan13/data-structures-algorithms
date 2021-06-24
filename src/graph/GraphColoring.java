package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GraphColoring {
	
	private static int mColoringOptimization(ArrayList<ArrayList<Integer>> adj, int V) {
		
		int res = 0;
		boolean[] available = new boolean[V];
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		color[0] = 1;
		
		for(int i = 0; i < V; i++) {
			
			// reset for each vertex
			Arrays.fill(available, true);
			
			// update taken colors 
			for(Integer neighbour : adj.get(i)) {
				if(color[neighbour] != -1)
					available[neighbour] = false;
			}
			
			// find the first available color
			int c;
			for(c = 1; c <= V; c++) {
				if(available[c] == true)
					break;
			}
			
			res = Math.max(res, c);
			
			color[i] = c;	// Assign the color;	
		}
		
		// Maximum in the color array is the
		System.out.println("Color array :");
		for(int i = 0; i < V; i++)
			System.out.print(color[i] + " ");
		System.out.println();
		
		return res;
	}
	
	private static boolean mColoringDecison(ArrayList<ArrayList<Integer>> adj, int[] color, int m, int v, int V) {
		
		if(v == V)
			return true;
		
		for(int c = 1; c <= m; c++) {
			if(isValid(adj, color, c, v)) {
				color[v] = c;
				if(mColoringDecison(adj, color, m, v+1, V))
					return true;
				color[v] = 0;
			}
		}
		
		return false;
	}
	
	private static void mColoringPermutation(ArrayList<ArrayList<Integer>> adj, int[] color, int m, int v, int V) {
		
		if(v == V) {
			for(int i = 0; i < V; i++)
				System.out.print(color[i] + " ");
			System.out.println();
			return;
		}
		
		for(int c = 1; c <= m; c++) {
			if(isValid(adj, color, c, v)) {
				color[v] = c;
				mColoringPermutation(adj, color, m, v+1, V);
				color[v] = 0;
			}
		}
	}
	
	private static boolean isValid(ArrayList<ArrayList<Integer>> adj, int[] color, int c, int v) {
		for(Integer neighbour : adj.get(v)) {
			if(color[neighbour] == c)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int V = 4;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<>());
		
		int color[] = new int[V];
		
		adj.get(0).add(1);
		adj.get(0).add(2);
		
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(1).add(3);
		
		adj.get(2).add(0);
		adj.get(2).add(1);
		adj.get(2).add(3);
		
		adj.get(3).add(1);
		adj.get(3).add(2);
		
//		0 - 1
//		| / |
//		2 - 3

		//m-coloring decision
		System.out.println("Is coloring possible using 1 color: " + 
							mColoringDecison(adj, color, 1, 0, V));
		System.out.println("Is coloring possible using 2 colors: " + 
							mColoringDecison(adj, color, 2, 0, V));
		System.out.println("Is coloring possible using 3 colors: " + 
							mColoringDecison(adj, color, 3, 0, V));
		
		System.out.println("=======================================");
		
		// m-coloring permutation
		System.out.println("Valid permutations using 3 colors: ");
		mColoringPermutation(adj, color, 3, 0, V);
		
		System.out.println("=======================================");
		
		// m-coloring optimization
		System.out.println("Chromatic number / Minimum number of colors required: " + mColoringOptimization(adj, V));
	}
}
