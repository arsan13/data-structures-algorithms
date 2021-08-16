package dp.group3;

public class RodCutting {

	// rod can be cut into any length from 0 to n
	private static int maxProfit1(int n, int[] price) {
		int dp[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
			}
		}

		return dp[n];
	}

	// rod must be cut into given lengths
	// Same as unbounded knapsack
	private static int maxProfit2(int n, int[] length, int[] price) {
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < length.length; j++) {
				if (i >= length[j]) {
					dp[i] = Math.max(dp[i], price[j] + dp[i - length[j]]);
				}
			}
		}
		
		return dp[n];
	}

	public static void main(String[] args) {

		// length of the rod
		int n = 8;
		// i-th position contains price of selling rod of length (i+1)
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(maxProfit1(n, price));

		int[] length = { 2, 3, 5, 6 };
		int[] price2 = { 5, 9, 12, 13 };
		System.out.println(maxProfit2(n, length, price2));
	}

}
