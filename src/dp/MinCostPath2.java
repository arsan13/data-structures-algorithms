package dp;

public class MinCostPath2 {

	private static int minCost(int[][] cost) {
		int n = cost.length;
		int m = cost[0].length;
		int[][] dp = new int[n][m];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {

				// last cell
				if (i == n - 1 && j == m - 1) 
					dp[i][j] = cost[i][j];  // need to put 0 in some cases, when this cell acts as destination
				
				// last row
				else if (i == n - 1) 
					dp[i][j] = cost[i][j] + dp[i][j + 1];
				
				//last column
				else if (j == m - 1) 
					dp[i][j] = cost[i][j] + dp[i+1][j];

				// rest of the elements
				else 
					dp[i][j] = cost[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}

		return dp[0][0];
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
