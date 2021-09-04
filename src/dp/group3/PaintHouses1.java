package dp.group3;

//For 3 colors, minimize cost of painting N houses such that adjacent houses have different colors
public class PaintHouses1 {
	
	// Modification of input array not allowed. O(N*N) Space
	private static int minCost1(int[][] cost, int n) {
		if(n == 0)
			return 0;
		
		int[][] dp = new int[n][cost[0].length];
		dp[0][0] = cost[0][0];  //red
		dp[0][1] = cost[0][1];  //green
		dp[0][2] = cost[0][2];	//blue
		
		for(int i = 1; i < n; i++) {
			// Reduce to subproblem: min of the other 2 colors for the previous house
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
	}
	
	// Modification of input array allowed. O(1) Space
	private static int minCost2(int[][] cost, int n) {
//		Use the input matrix itself as DP table; DP[i][j] = min{other 2 DP[i - 1][j']}
		if(n == 0)
			return 0;
		
		for(int i = 1; i < n; i++) {
			// Reduce to subproblem: min of the other 2 colors for the previous house
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		return Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2]));
	}
	
	public static void main(String[] args) {

		int n = 3; // number of houses
//		row -> houses, col -> colors
		int cost[][] = { { 14, 2, 11 }, 
						 { 11, 14, 5 }, 
						 { 14, 3, 10 } };
		
		int ans = minCost1(cost, n);			
		System.out.println(ans);
		
		ans = minCost2(cost, n);
		System.out.println(ans);
	}
}
