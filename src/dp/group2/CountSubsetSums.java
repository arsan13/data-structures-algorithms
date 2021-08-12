package dp.group2;

/* Count of subsets with sum equal to X.
 * Given an array arr[] of length N and an integer k, 
 * the task is to find the number of subsets with a sum equal to k.*/

//Same as coin change problem where duplication of coins are not allowed.

public class CountSubsetSums {

	// Memoization
	private static int getWays1(int[] arr, int n, int k, int[][] dp) {
		if (n == 0)
			return 0;
		if (k == 0)
			return 1;
		if(dp[n][k] > 0)
			return dp[n][k];
		
		if (arr[n - 1] > k) {  // Exclude
			return getWays1(arr, n - 1, k, dp);
		}
		// include + exclude
		int include = getWays1(arr, n - 1, k - arr[n - 1], dp);
		int	exclude = getWays1(arr, n - 1, k, dp);
		
		dp[n][k] = include + exclude;
		return dp[n][k];
	}

	// Tabulation
	private static int getWays2(int[] arr, int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (arr[i - 1] <= j) { // exclude + include
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				} else { // only exclude
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][k];
	}

	public static void main(String[] args) {

		int k = 6;
		int arr[] = { 2, 5, 1, 6 };
		System.out.println(getWays1(arr, arr.length, k, new int[arr.length + 1][k + 1]));
		System.out.println(getWays2(arr, arr.length, k));
	}
}