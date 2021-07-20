package dp;
import java.util.HashMap;
import java.util.Map;

// Coins can be repeated 
public class CoinChange {

	private static int minCoins(int n, int[] arr, HashMap<Integer, Integer> dp) {

		if (n == 0)
			return 0;

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (n - arr[i] >= 0) {
				int subAns = 0;

				if (dp.containsKey(n - arr[i]))
					subAns = dp.get(n - arr[i]);
				else
					subAns = minCoins(n - arr[i], arr, dp);

				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans)
					ans = subAns + 1;
			}
		}

		dp.put(n, ans);
		return ans;
	}

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
		
		ans = minCoins(amt, arr, new HashMap<Integer, Integer>());
		System.out.println("Minimum coins required: " + ans);
		
		ans = combinations(amt, arr);
		System.out.println("Number of combinations: " + ans);

		ans = permutations(amt, arr);
		System.out.println("Number of permutations: " + ans);
	}
}
