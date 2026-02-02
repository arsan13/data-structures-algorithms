package dp.stocks;

// Maximum profit if stocks can be bought and sold any number of times.
// Simultaneous transactions are not allowed i.e., stock must be sold before buying again.
// DP is not needed for this problem.
public class InfiniteTransactions {

	private static int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;

		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxProfit += prices[i] - prices[i - 1];
		}

		return maxProfit;
	}

	public static void main(String[] args) {

		int prices[] = { 100, 180, 260, 310, 40, 535, 695 };
		System.out.println(maxProfit(prices));
	}

}
