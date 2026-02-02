package dp.group1;

public class MaxGoldPath {

//	private static int maxGold(int[][] grid) {
//		int n = grid.length;
//		int m = grid[0].length;
//		int[][] dp = new int[n][m];
//
//		for (int i = 0; i < n; i++) // fill all rows of last column same as that of grid
//			dp[i][m - 1] = grid[i][m - 1];
//
//		for (int j = m - 2; j >= 0; j--) {
//			for (int i = 0; i < n; i++) {
//
//				int r = dp[i][j + 1]; // right
//				int ru = 0, rd = 0;
//				if (i + 1 < n)
//					ru = dp[i + 1][j + 1]; // right-down
//				if (i - 1 >= 0)
//					rd = dp[i - 1][j + 1]; // right-up
//
//				dp[i][j] = grid[i][j] + Math.max(r, Math.max(ru, rd));
//			}
//		}
//
//		printMatrix(dp);
//
//		int max = 0;
//		for (int i = 0; i < m; i++)
//			max = Math.max(max, dp[i][0]);
//		return max;
//	}
	
	private static int maxGold(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];

		for (int j = m - 1; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				
				if(j == m - 1) // last column
					dp[i][j] = grid[i][j];
				
				else if(i == 0) // first row
					dp[i][j] = grid[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
		
				else if(i == n - 1) // last row
					dp[i][j] = grid[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
				
				else // rest of the elements 
					dp[i][j] = grid[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
				
			}
		}

		printMatrix(dp);

		int max = dp[0][0];
		for (int i = 1; i < m; i++)
			max = Math.max(max, dp[i][0]);
		return max;
	}

	private static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] grid = { {1, 3, 1, 5},
			            {2, 2, 4, 1},
			            {5, 0, 2, 3},
			            {0, 6, 1, 2}};

		int ans = maxGold(grid);
		System.out.println("Maximum Gold: " + ans);
	}
}
