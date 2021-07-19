package dp;

public class CountStairsPaths {

//	MEMOIZATION
	private static int count1(int n, int[] dp) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (dp[n] != 0)
			return dp[n];

		int ans = count1(n - 1, dp) + count1(n - 2, dp) + count1(n - 3, dp);
		dp[n] = ans;
		return ans;
	}

//	TABULATION: Atmost 3 jumps
	private static int count2(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i < n + 1; i++) {
			if (i == 1)
				dp[i] = dp[i - 1];
			else if (i == 2)
				dp[i] = dp[i - 1] + dp[i - 2];
			else
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		return dp[n];
	}

//	TABULATION: Varying jumps
	private static int count3(int n, int[] jumps) {
		int[] dp = new int[n + 1];
		dp[n] = 1; // 1 step required

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= jumps[i] && i + j <= n; j++) {
				dp[i] += dp[i + j];
			}
		}

		return dp[0];
	}

	// TABULATION: Varying jumps | Minimum moves
	private static int minCount(int n, Integer[] jumps) {
		Integer[] dp = new Integer[n + 1];
		dp[n] = 0; // 0 moves required,

		for (int i = n - 1; i >= 0; i--) {
			if (jumps[i] == null)
				continue;
			
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= jumps[i] && i + j <= n; j++) {
				if (dp[i + j] != null)
					min = Math.min(min, dp[i + j]);
			}
			if (min != Integer.MAX_VALUE)
				dp[i] = min + 1;
		}

		return dp[0];
	}

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

		int n = 6;

		int ans = count1(n, new int[n + 1]);
		System.out.println("Atmost 3 jumps: " + ans);

		ans = count2(n);
		System.out.println("Atmost 3 jumps: " + ans);

		n = 6;
		int[] jumps = { 2, 3, 1, 2, 2, 3 };
		ans = count3(n, jumps);
		System.out.println("Varying jumps: " + ans);

		n = 9;
		Integer[] skips = { 3, 2, 4, null, 2, 3, 1, 2, 2 };
		ans = minCount(n, skips);
		System.out.println("Minumum moves: " + ans);
		
		n = 5;
	    int cost[] = { 16, 19, 10, 12, 18 };
	    ans = minCost(n, cost);
	    System.out.println("Minimum Cost: " + ans);
	}

}
