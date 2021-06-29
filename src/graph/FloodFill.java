package graph;

import java.util.*;

// Flood fill | Rat in a Maze | Fill Color

public class FloodFill {

	private static void dfs(int i, int j, int[][] m, int n, boolean[][] visited, String str, ArrayList<String> list) {

		if (i < 0 || i >= n || j < 0 || j >= n)
			return;

		if (m[i][j] == 0 || visited[i][j])
			return;

		if (i == n - 1 && j == n - 1) {
			list.add(str);
			return;
		}

		visited[i][j] = true;

		dfs(i - 1, j, m, n, visited, str + 'U', list);
		dfs(i + 1, j, m, n, visited, str + 'D', list);
		dfs(i, j - 1, m, n, visited, str + 'L', list);
		dfs(i, j + 1, m, n, visited, str + 'R', list);

		visited[i][j] = false;

	}
	
	public static ArrayList<String> findPath(int[][] m, int n) {

		ArrayList<String> list = new ArrayList<>();
		boolean[][] visited = new boolean[n][n];

		if (m[0][0] != 0 || m[n - 1][n - 1] != 0) {
			dfs(0, 0, m, n, visited, "", list);
			Collections.sort(list);
		}
		
		return list;
	}

	public static void main(String[] args) {
    	
		int n = 4;
    	int m[][] = {{1, 0, 0, 0},
    	         {1, 1, 0, 1}, 
    	         {1, 1, 0, 0},
    	         {0, 1, 1, 1}};
    			
    	ArrayList<String> res = findPath(m, n);
    	
    	System.out.println(res);
    }
}