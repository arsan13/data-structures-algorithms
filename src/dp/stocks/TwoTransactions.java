package dp.stocks;

// DP is not needed for this problem
// Maximize profit for non-overlapping two transactions.
public class TwoTransactions {

	private static int maxProfit(int prices[]) {
		int n = prices.length;
		if (n < 2)
			return 0;
		
		// Minimum from the left.
		int minSoFar = prices[0];
		// leftProfit array stores maximum profit on that day and days before that.
		int leftProfit[] = new int[n];
		// Maximum profit when transaction took place on i-th day or days(i-1) before that i.e., best on the left
		// If i-th is the selling point, we find the best buying point before i-th day i.e., to its left.
		for (int i = 1; i < n; i++) {
			minSoFar = Math.min(minSoFar, prices[i]);
			leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minSoFar);
		}

		// Maximum from the right.
		int maxSoFar = prices[n - 1];
		// rightProfit array stores maximum profit on that day and days after that.
		int rightProfit[] = new int[n];
		// Maximum profit when transaction took place on i-th day or days(i+1) after that i.e., best on the right.
		// If i-th is the buying point, we find the best selling point after i-th day i.e., to its right. 
		for (int i = n - 2; i >= 0; i--) {
			maxSoFar = Math.max(maxSoFar, prices[i]);
			rightProfit[i] = Math.max(rightProfit[i + 1], maxSoFar - prices[i]);
		}

//		Every element has two profits: 
//			1. Maximum Profit when transaction took place on that day or days before that.
//			2. Maximum Profit when transaction took place on that day or days after that.
//		Element with maximum sum of two profits is the answer.
		int res = 0;
		for(int i = 0; i < n; i++) {
			res = Math.max(res, leftProfit[i] + rightProfit[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {

		int prices[] = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfit(prices));
	}
}
