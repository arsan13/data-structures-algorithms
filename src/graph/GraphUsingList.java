package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingList {

	private LinkedList<Integer> adj[];

	public GraphUsingList(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public void bfs() {

		int src = adj[0].getFirst();
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[adj.length];

		queue.add(src);
		visited[src] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			System.out.print(current + " --> ");

			for (int neighbour : adj[current]) {
				if (!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}

	public boolean dfsStack() {

		int src = adj[0].getFirst();

		boolean[] visited = new boolean[adj.length];
		visited[src] = true;

		Stack<Integer> stack = new Stack<>();
		stack.push(src);

		while (!stack.isEmpty()) {
			int current = stack.pop();

			System.out.print(current + " --> ");

			for (int neighbour : adj[current]) {
				if (!visited[neighbour]) {
					visited[neighbour] = true;
					stack.push(neighbour);
				}
			}
		}

		return false;
	}
	

	private boolean dfsUtil(int src, int dest, boolean[] visited) {

		if (src == dest)
			return true;

		for (int neighbour : adj[src]) {
			if (!visited[neighbour]) {
				visited[neighbour] = true;
				boolean isConnected = dfsUtil(neighbour, dest, visited);
				if (isConnected)
					return true;
			}
		}

		return false;
	}

	// check if path exists
	public boolean dfs(int src, int dest) {

		boolean[] visited = new boolean[adj.length];
		visited[src] = true;

		return dfsUtil(src, dest, visited);
	}

	public boolean dfsStack(int src, int dest) {

		boolean[] visited = new boolean[adj.length];
		visited[src] = true;

		Stack<Integer> stack = new Stack<>();
		stack.push(src);

		while (!stack.isEmpty()) {
			int current = stack.pop();

			if (current == dest)
				return true;

			for (int neighbour : adj[current]) {
				if (!visited[neighbour]) {
					visited[neighbour] = true;
					stack.push(neighbour);
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

//		Scanner in = new Scanner(System.in);
//
//		System.out.println("Enter number of vertices and edges:");
//
//		int v = in.nextInt();
//		int e = in.nextInt();
//
//		GraphUsingList graph = new GraphUsingList(v);
//
//		System.out.println("Enter src and dest " + e + " edges");
//		for (int i = 0; i < e; i++) {
//			int src = in.nextInt();
//			int dest = in.nextInt();
//
//			graph.addEdge(src, dest);
//		}

		GraphUsingList graph = new GraphUsingList(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		
//		System.out.println("Min distance = " + graph.bfs(0, 3));
//		System.out.println("Possible = " + graph.dfs(0, 3));
//		System.out.println("Possible = " + graph.dfsStack(0, 3));
		
//		System.out.println("\nBFS TRAVERSAL");
//		graph.bfs();
//
		System.out.println("\nDFS TRAVERSAL");
		graph.dfsStack();
		
	}

}

/*
 * 
 * 0 1 0 4 1 2 2 3 2 4 3 4
 * 
 */