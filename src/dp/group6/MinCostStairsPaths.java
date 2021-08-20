package dp.group6;

public class MinCostStairsPaths {

	// TABULATION: Atmost 2 jumps | Minimum cost to climb n-th floor
	
	/*
	 * If modifying of array is allowed, then
	 * Arrays.sort(cost); 
	 * for(int i = 2; i < n; i++) 
	 *     cost[i] += Math.min(cost[i-1], cost[i-2]); 
	 * return Math.min(cost[n-1],cost[n-2]);
	 */
	
	// O(N) Space, O(N) time
//	private static int minCost(int n, int[] cost) {
//		int[] dp = new int[n+1];
//		dp[0] = cost[0];
//		dp[1] = cost[1];
//		
//		for(int i = 2; i < n; i++)
//			dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
//		
//		dp[n] = Math.min(dp[n-1], dp[n-2]);  //Since, nth floor can be climbed from last floor or second-last floor
//		return dp[n];
//	}
	
	// O(1) Space, O(N) time
	private static int minCost(int n, int[] cost) {
		int step1 = 0;
		int step2 = 0;
		
		for(int i = n-1; i >= 0; i--) {
			int currStep = cost[i] + Math.min(step1, step2);
			step1 = step2;
			step2 = currStep;
		}
		
		return Math.min(step1,  step2);
	}
	
	public static void main(String[] args) {

		int n = 5;
	    int cost[] = { 16, 19, 10, 12, 18 };
	    
	    int ans = minCost(n, cost);
	    System.out.println("Minimum Cost: " + ans);
	}

}
