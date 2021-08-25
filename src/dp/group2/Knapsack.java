package dp.group2;

//Repitation not allowed i.e., weight once picked cannot be picked again
public class Knapsack {

	// Brute force O(2**n) time complexity
	private static int maxProfit1(int n, int[] weight, int[] price, int capacity) {

		if (n == 0 || capacity == 0)
			return 0;

		if (weight[n - 1] > capacity) {
			return maxProfit1(n - 1, weight, price, capacity); // exclude
		}
		
		int include = price[n - 1] + maxProfit1(n - 1, weight, price, capacity - weight[n - 1]);
		int exclude = maxProfit1(n - 1, weight, price, capacity);

		return Math.max(include, exclude);
	}

	// Memoization | O(n*capacity)
	private static int maxProfit2(int n, int[] weight, int[] price, int capacity, int[][] dp) {

		if (n == 0 || capacity == 0)
			return 0;

		if (dp[n][capacity] != 0)
			return dp[n][capacity];

		if (weight[n - 1] > capacity) {
			return dp[n][capacity] = maxProfit2(n - 1, weight, price, capacity, dp); // exclude
		}
		
		int include = price[n - 1] + maxProfit2(n - 1, weight, price, capacity - weight[n - 1], dp);
		int exclude = maxProfit2(n - 1, weight, price, capacity, dp);

		int res = Math.max(include, exclude);
		return dp[n][capacity] = res;

	}

	// Tabulation | O(n*capacity)
	private static int maxProfit3(int n, int[] weight, int[] price, int capacity) {

		int[][] dp = new int[n + 1][capacity + 1];
		int rows = dp.length;
		int cols = dp[0].length;

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (weight[i - 1] <= j) {
					int include = price[i - 1] + dp[i - 1][j - weight[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {

		int n = 5;
		int[] weight = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 45, 30 };
		int capacity = 7;

		int ans = maxProfit1(n, weight, price, capacity);
		System.out.println(ans);

		ans = maxProfit2(n, weight, price, capacity, new int[n + 1][capacity + 1]);
		System.out.println(ans);

		ans = maxProfit3(n, weight, price, capacity);
		System.out.println(ans);
	}
}
