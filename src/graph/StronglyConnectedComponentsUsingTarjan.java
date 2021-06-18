package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnectedComponentsUsingTarjan {

	
	private static void dfs(int u, int[] disc, int[] low, Stack<Integer> stack, boolean[] presentInStack, ArrayList<ArrayList<Integer>> adj, int time) {
		
		disc[u] = low[u] = time++;
		stack.push(u);
		presentInStack[u] = true;
		
		for(int v : adj.get(u)) {
			
			if(disc[v] == -1) {  // if v is not visited
				dfs(v, disc, low, stack, presentInStack, adj, time);
				low[u] = Math.max(low[u], low[v]);
			}
			else if(presentInStack[v]) {  // differentiate between back-edge and cross-edge
				low[u] = Math.min(low[u], disc[v]);
			}
		}
		
		if(low[u] == disc[u]) {	// It is cross edge..if u is head node of SCC
			
			System.out.print("SCC is: ");
			
			while(stack.peek() != u) {
				System.out.print(stack.peek() + " ");
				presentInStack[stack.peek()] = false;
				stack.pop();
			}
			
			System.out.print(stack.peek() + "\n");
			presentInStack[stack.peek()] = false;
			stack.pop();
		}
	}
	
	private static void findComponents(ArrayList<ArrayList<Integer>> adj, int n) {
		
		Stack<Integer> stack = new Stack<>();
		boolean presentInStack[] = new boolean[n];
		int disc[] = new int[n];
		int low[] = new int[n];
		int time = 0;
		
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		
		for(int i = 0; i < n; i++) {
			if(disc[i] == -1)
				dfs(i, disc, low, stack, presentInStack, adj, time);
		}
		
	}

	public static void main(String[] args) {

		int n = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
		
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
		
		findComponents(adj,n);
	}
}
