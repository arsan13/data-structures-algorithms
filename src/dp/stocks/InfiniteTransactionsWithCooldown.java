package dp.stocks;

// Maximum profit if multiple transactions are allowed  with a cool-down period of 1 day.
// Simultaneous transactions are not allowed i.e., stock must be sold before buying again.
// DP is used to solve for this problem.
public class InfiniteTransactionsWithCooldown {

	private static int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		
		// Initial values -> Day 1
		int obsp = -prices[0]; // old bought state profit....profit is negative since stock is bought and haven't sold yet.
		int ossp = 0; 		   // old sold state profit......profit is zero is since stock isn't sold yet. Stock can't be sold on same day of purchace.
		int ocsp = 0;		   // old cool-down state profit
		
		for (int i = 1; i < prices.length; i++) {
			int nbsp = Math.max(obsp, ocsp - prices[i]); 		// new bought state profit
			int nssp = Math.max(ossp, prices[i] + obsp);  		// new sold state profit
			int ncsp = Math.max(ossp, ocsp);					// new cool-down state profit

			obsp = nbsp;
			ossp = nssp;
			ocsp = ncsp;
		}

		return ossp;
	}

	public static void main(String[] args) {

		int prices[] = { 1, 2, 3, 0, 2 };
		System.out.println(maxProfit(prices));
	}

}
