package dp.stocks;

//Maximum profit if k transactions are allowed.
//Simultaneous transactions are not allowed i.e., stock must be sold before buying again.
//DP is used to solve for this problem.
public class KTransactions {

//	O(n*n*n) Time
	private static int maxProfit1(int[] prices, int k) {

		int[][] dp = new int[k + 1][prices.length];
		int n = dp.length;
		int m = dp[0].length;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				
				// Find maximum profit of previous transaction and all transactions till j-th transaction of previous day.
				int max = dp[i][j - 1]; // same day, previous transaction
				// find previous transactions of all the days to left
				for (int prev = 0; prev < j; prev++) {
					int profitTillTm1 = dp[i - 1][prev]; // profit till (t-1) transactions.
					int profitOfTth = prices[j] - prices[prev]; // profit of Tth transaction.

					max = Math.max(max, profitTillTm1 + profitOfTth);
				}
				
				dp[i][j] = max;
			}
		}

		return dp[n - 1][m - 1];
	}
	
//	Optimal: O(n*n) Time
	private static int maxProfit2(int[] prices, int k) {
		if(prices.length < 2 || k == 0)
            return 0;
		
		int[][] dp = new int[k + 1][prices.length];
		int n = dp.length;
		int m = dp[0].length;
		
		for (int i = 1; i < n; i++) {
			int max = Integer.MIN_VALUE;
			
			for (int j = 1; j < m; j++) {
				max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
			}
		}
		
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {

		int k = 2;
        int[] prices = { 10, 22, 5, 75, 65, 80 };
		
        System.out.println(maxProfit1(prices, k));
        System.out.println(maxProfit2(prices, k));
	}

}
