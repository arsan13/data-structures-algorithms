package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUsingBFS {

	private LinkedList<Integer> adj[];

	public ShortestDistanceUsingBFS(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}

	public void betweenTwoNodes(int src, int dest) {
		Queue<Integer> queue = new LinkedList<>();

		boolean visited[] = new boolean[adj.length];
		int parent[] = new int[adj.length];

		queue.add(src);
		visited[src] = true;
		parent[src] = -1;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == dest)
				break;

			for (int neighbour : adj[current]) {
				if (!visited[neighbour]) {
					queue.add(neighbour);
					visited[neighbour] = true;
					parent[neighbour] = current;
				}
			}
		}

		int current = dest;
		int dist = 0;

		while (parent[current] != -1) {
			System.out.print(current + " --> ");
			current = parent[current];
			dist++;
		}
		System.out.print(current + "\n");

		System.out.println("Minimum distance = " + dist);
	}

	public void fromSorceNode(int src) {

		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[adj.length];
		int dist[] = new int[adj.length];

		for (int i = 0; i < dist.length; i++)
			dist[i] = Integer.MAX_VALUE;

		queue.add(src);
		visited[src] = true;
		dist[src] = 0;

		while (!queue.isEmpty()) {

			int current = queue.poll();

			for (int neighbour : adj[current]) {
				if (!visited[neighbour]) {
					visited[neighbour] = true;
					if (dist[current] + 1 < dist[neighbour])
						dist[neighbour] = dist[current] + 1;
					queue.add(neighbour);
				}
			}
		}

		System.out.println("\nMinimum distance from " + src);
		System.out.println("Vertex  Distance");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + "\t" + dist[i]);
	}

	public static void main(String[] args) {

		ShortestDistanceUsingBFS graph = new ShortestDistanceUsingBFS(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);

		graph.betweenTwoNodes(0, 3);

		graph.fromSorceNode(0);
	}

}
