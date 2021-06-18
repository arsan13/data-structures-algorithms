package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphUsingMap {

	Map<Object, LinkedList<Object>> adjList = new HashMap();
    Map<Object, Integer>  indexes = new HashMap<>();
    int index = 0;
	
	public GraphUsingMap(ArrayList<Object> vertices) {
		for(int i = 0; i < vertices.size(); i++) {
			Object vertex = vertices.get(i);
			LinkedList<Object> list = new LinkedList<>();
			adjList.put(vertex, list);
			indexes.put(vertex, index++);
		}
	}

	public void addEdge(Object src, Object dest) {
		
		LinkedList<Object> list;

		// add forward edge
		list = adjList.get(src);
		list.add(dest);
		adjList.put(src, list);
		
		// add backward edge
		list = adjList.get(dest);
		list.add(src);
		adjList.put(dest, list);
	}

	// get min distance
	public int bfs(Object src, Object dest) {
		Queue<Object> queue = new LinkedList<>();

		boolean visited[] = new boolean[adjList.size()];
		Object parent[] = new Object[adjList.size()];

		queue.add(src);
		visited[indexes.get(src)] = true;
		parent[indexes.get(src)] = null;

		while (!queue.isEmpty()) {
			Object current = queue.poll();
			if (current == dest)
				break;

			for (Object neighbour : adjList.get(current)) {
				if (!visited[indexes.get(neighbour)]) {
					queue.add(neighbour);
					visited[indexes.get(neighbour)] = true;
					parent[indexes.get(neighbour)] = current;
				}
			}
		}

		Object current = dest;
		int dist = 0;

		System.out.print("Path : ");
		while (parent[indexes.get(current)] != null) {
			System.out.print(current + " --> ");
			current = parent[indexes.get(current)];
			dist++;
		}
		System.out.print(current + "\n");

		return dist;
	}

//	private boolean dfsUtil(int src, int dest, boolean[] visited) {
//
//		if (src == dest)
//			return true;
//
//		for (int neighbour : adj[src]) {
//			if (!visited[neighbour]) {
//				visited[neighbour] = true;
//				boolean isConnected = dfsUtil(neighbour, dest, visited);
//				if (isConnected)
//					return true;
//			}
//		}
//
//		return false;
//	}
//
//	// check if path exists
//	public boolean dfs(int src, int dest) {
//
//		boolean[] visited = new boolean[adj.length];
//		visited[src] = true;
//
//		return dfsUtil(src, dest, visited);
//	}

	// checkif path exists
	public boolean dfsStack(Object src, Object dest) {
		
		boolean[] visited = new boolean[adjList.size()];
		visited[indexes.get(src)] = true;
		
		Stack<Object> stack = new Stack<>();
		stack.push(src);
		
		while(!stack.isEmpty()) {
			Object current = stack.pop();
			
			if(current == dest)
				return true;
			
			for(Object neighbour : adjList.get(current)) {
				if(!visited[indexes.get(neighbour)]) {
					visited[indexes.get(neighbour)] = true;
					stack.push(neighbour);
				}
			}
		}
		
		return false;
	}
	
	public void printGraph() {
		
		for(Object vertex : adjList.keySet()) {
			
			System.out.print(vertex + " --> ");
			LinkedList<Object> list = adjList.get(vertex);
			
			for(Object neighbour : list) {
				System.out.print(neighbour + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		ArrayList<Object> vertices = new ArrayList<>();
        vertices.add('A');
        vertices.add('B');
        vertices.add('C');
        vertices.add('D');
        vertices.add('E');
        vertices.add('F');
        vertices.add('G');
        GraphUsingMap graph = new GraphUsingMap(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'E');
        graph.addEdge('G', 'E');
        graph.addEdge('A', 'G');
        
        graph.printGraph();
                
        System.out.println("Min distance = " + graph.bfs('A', 'E'));
        System.out.println("Possible? " + graph.dfsStack('A', 'E'));
        
//        System.out.println("---------------Depth First Traversal------------");
//        graph.DFS();
	}

}

/*
 * 
 * 0 1 0 4 1 2 2 3 2 4 3 4
 * 
 */