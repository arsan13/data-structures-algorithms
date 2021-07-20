package dp;

//Repitation not allowed i.e., weight once picked cannot be picked again
public class Kanapsack1 {

	// O(2**n) time complexity
//	private static int maxProfit(int n, int[] weight, int[] price, int capacity) {
//
//		if (n == 0 || capacity == 0)
//			return 0;
//
//		if (weight[n - 1] > capacity) { // removes unnecessary calls
//			return maxProfit(n - 1, weight, price, capacity);
//		}
//
//		int include = price[n - 1] + maxProfit(n - 1, weight, price, capacity - weight[n - 1]);
//		int exclude = maxProfit(n - 1, weight, price, capacity);
//
//		return Math.max(include, exclude);
//	}

	// O(n*capacity)
	private static int maxProfit(int n, int[] weight, int[] price, int capacity) {

		int[][] dp = new int[n + 1][capacity + 1];
		int rows = dp.length;
		int cols = dp[0].length;

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				int exclude = dp[i - 1][j];
				int include = 0;

				if (j >= weight[i - 1]) {
					int remCapacity = j - weight[i - 1];
					include = price[i - 1] + dp[i - 1][remCapacity];
				}

				dp[i][j] = Math.max(include, exclude);
			}
		}

		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {

		int n = 5;
		int[] weight = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 45, 30 };
		int capacity = 7;

		int ans = maxProfit(n, weight, price, capacity);
		System.out.println(ans);
	}
}
