package dp.stocks;

// Maximum profit if multiple transactions are allowed  but, a certain fee must be paid for each transaction.
// Simultaneous transactions are not allowed i.e., stock must be sold before buying again.
// DP is used to solve for this problem.
public class InfiniteTransactionsWithFee {

	private static int maxProfit(int[] prices, int fee) {
		if (prices.length < 2)
			return 0;

		// Initial values -> Day 1
		int obsp = -prices[0]; // old bought state profit....profit is negative since stock is bought and haven't sold yet.
		int ossp = 0; 		   // old sold state profit

		for (int i = 1; i < prices.length; i++) {
			int nbsp = Math.max(obsp, ossp - prices[i]); 		// new bought state profit
			int nssp = Math.max(ossp, prices[i] + obsp - fee);  // new sold state profit

			obsp = nbsp;
			ossp = nssp;
		}

		return ossp;
	}

	public static void main(String[] args) {

		int fee = 2;
		int prices[] = { 1, 3, 2, 8, 4, 9 };
		System.out.println(maxProfit(prices, fee));
	}

}
