package dp.stocks;

// DP is not needed for this problem
// Maximize profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// This problem is maximum difference between two elements
public class OneTransaction {

	// O(N) time, O(N) Space
	private static int maxProfit1(int prices[]) {
		if(prices.length == 0 || prices.length == 1)
			return 0;
		
		int n = prices.length;
        int maxRight[] = new int[n];
        
        maxRight[n-1] = prices[n-1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(prices[i], maxRight[i+1]);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, maxRight[i] - prices[i]);
        }
        
        return maxProfit;
	}
	
	// O(N) time, O(1) Space
	private static int maxProfit2(int prices[]) {
		if(prices.length < 2)
			return 0;
		
		int minSoFar = prices[0];
		int maxProfit = 0;
		int bought = 0;
		int sold = -1;
		
		for(int i = 0; i < prices.length; i++) {
//			minSoFar = Math.min(minSoFar, prices[i]);
//			maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
			
			if(prices[i] < minSoFar) {
				bought = i + 1;
				minSoFar = prices[i];
			}
			
			if(maxProfit < (prices[i] - minSoFar)) {
				sold = i + 1;
				maxProfit = prices[i] - minSoFar;
			}
		}
		
		System.out.printf("Bought: day %d -- sold: day %d \n", bought, sold);
		return maxProfit;
	}
	
	public static void main(String[] args) {
		
		int prices[] = {7, 1, 5, 3, 6, 4};
		
		int ans = maxProfit1(prices);
//		System.out.println(ans);
		
		ans = maxProfit2(prices);
		System.out.println(ans);
	}
}
