package graph;

public class NumberOfTriangles {

	private static int countTriangles(int[][] graph, boolean isDirected) {
		
		int count = 0;
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph.length; k++) {
					if(graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1)
						count++;
				}
			}
		}
		
		if(isDirected)
			count = count / 3;
		else
			count = count / 6;
		
		return count;
	}
	
	public static void main(String[] args) {
			
		int graph[][] = {{0, 1, 1, 0},
		                {1, 0, 1, 1},
		                {1, 1, 0, 1},
		                {0, 1, 1, 0}};
		
		int digraph[][] = { {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0}};
		
		System.out.println(countTriangles(graph, false));
		System.out.println(countTriangles(digraph, true));
	}
}
