package dp.group1;

import java.util.Arrays;
import java.util.PriorityQueue;

// Based on Dijkstra ALgorithm
public class MinCostPath {

	private static class Cell implements Comparable<Cell>{
		int x, y;
		int dist;
		public Cell(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Cell that) {
			return this.dist - that.dist;
		}
	}
	
	private static int minCost(int[][] cost) {
		int n = cost.length;
		int m = cost[0].length;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int[][] dp = new int[n][m];
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		
		for(int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);
		
		dp[0][0] = cost[0][0];
		pq.add(new Cell(0, 0, dp[0][0]));

		while(!pq.isEmpty()) {
			Cell cell = pq.poll();
			int i = cell.x;
			int j = cell.y;
			
			for(int k = 0; k < 4; k++) {
				int x = i + dx[k];
				int y = j + dy[k];
				
				if(x >= 0 && y >= 0 && x < n && y < m) {
					if(dp[x][y] > dp[i][j] + cost[x][y]) {
						dp[x][y] = dp[i][j] + cost[x][y];
						pq.add(new Cell(x, y, dp[x][y]));
					}
				}
			}
		}
		
		return dp[n-1][m-1];
	}

	public static void main(String[] args) {

		int[][] grid = {{9,4,9,9},{6,7,6,4},
				{8,3,3,7},{7,4,9,10}};

		int n = grid.length;
		int[][] dp = new int[n][n];
		dp[0][0] = grid[0][0];

		int ans = minCost(grid);
		System.out.println(ans);
	}
}
