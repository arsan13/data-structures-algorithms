package dp.knapsack2;

import java.util.HashMap;

// Coins can be repeated 
public class MinimumCoins {

	// Memoization
	private static int minCoins1(int amt, int[] arr, HashMap<Integer, Integer> dp) {
		if (amt == 0)
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (amt - arr[i] >= 0) {
				int subAns = 0;

				if (dp.containsKey(amt - arr[i]))
					subAns = dp.get(amt - arr[i]);
				else
					subAns = minCoins1(amt - arr[i], arr, dp);

				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans)
					ans = subAns + 1;
			}
		}

		dp.put(amt, ans);
		return ans;
	}

	// Tabulation: O(n*n) Space
	private static int minCoins2(int amt, int[] arr, int n) {
		int[][] dp = new int[n + 1][amt + 1];

		// Initialization
		for (int i = 1; i <= n; i++)
			dp[i][0] = 0;
		for (int j = 0; j <= amt; j++)
			dp[0][j] = Integer.MAX_VALUE - 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - arr[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][amt];
	}

	// Tabulation: O(n) Space
	private static int minCoins3(int amt, int[] arr, int n) {
		int[] dp = new int[amt + 1];
		
		// Initialization
		for(int i = 1; i <= amt; i++)
			dp[i] = Integer.MAX_VALUE - 1;
		
		for (int i = 0; i <= amt; i++) {
			for(int coin : arr) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], 1  + dp[i - coin]);
				}
			}
		}
		
		return dp[amt];
	}

	public static void main(String[] args) {

		int amt = 11;
		int arr[] = { 2, 5, 1, 6 };

		int ans = minCoins1(amt, arr, new HashMap<Integer, Integer>());
		System.out.println("Minimum coins required: " + ans);

		ans = minCoins2(amt, arr, arr.length);
		System.out.println("Minimum coins required: " + ans);
		
		ans = minCoins3(amt, arr, arr.length);
		System.out.println("Minimum coins required: " + ans);
	}
}
