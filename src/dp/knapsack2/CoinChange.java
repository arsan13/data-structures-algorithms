package dp.knapsack2;

// Coins can be repeated 
public class CoinChange {

	private static int combinations(int target, int[] arr) {
		int[] dp =  new int[target+1];
		dp[0] = 1;
		
		// For each coin, we traverse from amt = 0 to amt = 1
		for (int coin = 0; coin < arr.length; coin++) {
			for (int amt = arr[coin]; amt <= target; amt++) {
				int remAmt = amt - arr[coin];
				dp[amt] += dp[remAmt];
			}
		}
		
		return dp[target];
	}

	private static int permutations(int target, int[] arr) {
		int[] dp =  new int[target+1];
		dp[0] = 1;
		
		// For each amt, we make payment of all the coins one by one
		for(int amt = 1; amt <= target; amt++) {
			for(int coin : arr) {
				if(coin <= amt) {
					int remAmt = amt - coin;
					dp[amt] += dp[remAmt];
				}
			}
		}
		
		return dp[target];
	}
	
	public static void main(String[] args) {

		int amt = 11;
		int arr[] = { 2, 5, 1};
		int ans = 0;
		
		ans = combinations(amt, arr);
		System.out.println("Number of combinations: " + ans);

		ans = permutations(amt, arr);
		System.out.println("Number of permutations: " + ans);
	}
}
