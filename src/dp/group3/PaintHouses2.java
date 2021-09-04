package dp.group3;

//For any number of colors, minimize cost of painting N houses such that adjacent houses have different colors.
public class PaintHouses2 {
	
	// O(N*N*N) Time
	// Modification of input array not allowed. O(N*N) Space
	private static int minCost1(int[][] cost) {
		int n = cost.length;
		int m = cost[0].length;
		
		if(n == 0)
			return 0;
		
		int[][] dp = new int[n][m];
		for(int j = 0; j < m; j++)
			dp[0][j] = cost[0][j];
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < cost[0].length; j++) {
				dp[i][j] = cost[i][j] + getMin(dp, i-1, j);
			}
		}
		
		return getMin(dp, n - 1, -1);
	}
	
	// Optimal: O(N*N) Time
	// Modification of input array not allowed. O(N*N) Space
	private static int minCost2(int[][] cost) {
		int n = cost.length;
		int m = cost[0].length;
		
		if(n == 0)
			return 0;
		
		int[][] dp = new int[n][m];
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for(int j = 0; j < m; j++) {
			int val = cost[0][j];
			dp[0][j] = cost[0][j];
			
			if(val <= min1) {
				min2 = min1;
				min1 = val;
			}
			else if(val <= min2) {
				min2 = val;
			}
		}
				
		for(int i = 1; i < n; i++) {
			int newMin1 = Integer.MAX_VALUE;
			int newMin2 = Integer.MAX_VALUE;
			
			for(int j = 0; j < cost[0].length; j++) {
				
				if(min1 == dp[i-1][j])
					dp[i][j] = cost[i][j] + min2;
				else
					dp[i][j] = cost[i][j] + min1;
				
				if(dp[i][j] <= newMin1) {
					newMin2 = newMin1;
					newMin1 = dp[i][j];
				}
				else if(dp[i][j] <= newMin2) {
					newMin2 = dp[i][j];
				}
			}
			min1 = newMin1;
			min2 = newMin2;
		}
		
		return min1;
	}
	
	// O(N*N*N) Time
	// Modification of input array allowed. O(1) Space
	private static int minCost3(int[][] cost) {
//		Use the input matrix itself as DP table; DP[i][j] = min{other 2 DP[i - 1][j']}
		int n = cost.length;
		int m = cost[0].length;
		
		if(n == 0)
			return 0;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < m; j++) {
				cost[i][j] += getMin(cost, i-1, j);
			}
		}
		
		return getMin(cost, n-1, -1);
	}
	
	private static int  getMin(int[][] cost, int row, int except) {
		int min = Integer.MAX_VALUE;
		for(int j = 0; j < cost[0].length; j++) {
			if(j != except)
				min = Math.min(min, cost[row][j]);
		}
		return min;
	}
	
	public static void main(String[] args) {

		int n = 3; // number of houses
//		row -> houses, col -> colors
		int cost[][] = { { 14, 2, 11 }, 
						 { 11, 14, 5 }, 
						 { 14, 3, 10 } };
		
		int ans = minCost1(cost);			
		System.out.println(ans);
		
		//Optimal time complexity
		ans = minCost2(cost);
		System.out.println(ans);

		ans = minCost3(cost);
		System.out.println(ans);
	}
}
