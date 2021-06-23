package graph;

import java.util.ArrayList;

import graph.BellmanFordAlgorithm.Edge;

public class FloydWarshallAlgorithm {
	
	static int INF = 999;
	
	private static void floydWarshall(int[][] graph, int V) {
		
		int dist[][] = new int[V][V];
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		
		
		// // Pick all vertices as intermediates one by one
		for(int k = 0; k < V; k++) {
//			
//			for(int i = 0; i < V; i++) {
//				for(int j = 0; j < V; j++) {
//					System.out.print(dist[i][j] + "\t");
//				}
//				System.out.println("\n");
//			}
//			System.out.println("===========================");
			
			// Pick all vertices as source one by one
			for(int i = 0; i < V; i++) {
				
				// Pick all vertices as destination one by one
				for(int j = 0; j < V; j++) {
					
					if(dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
//		 Print shortest distances
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				System.out.print(dist[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		int V = 4;
		
		int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
              };
		
		floydWarshall(graph, V);
	}
}
