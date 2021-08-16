package dp.group3;

// Similar to count of target sum subset but with repitation of elements allowed.
public class CoinChangeWays {

	// Brute force
	private static int getWays1(int index, int amt, int arr[], int n) {
		if (amt < 0)
			return 0;

		if (index == arr.length) {
			if (amt == 0) {
				return 1;
			}
			return 0;
		}

		int include = 0;
		int exclude = getWays1(index + 1, amt, arr, n);
		for (int i = index; i < n; i++) {
			include = getWays1(index, amt - arr[index], arr, n);
		}

		return include + exclude;
	}

	// Optimal. O(n*n) Space
	private static int getWays2(int amt, int[] coin, int n) {
		int[][] dp = new int[n + 1][amt + 1];

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (coin[i - 1] <= j) {
					dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][amt];
	}
	
	// Optimal. O(n) space. Same as combinations.
	private static int getWays3(int target, int[] arr, int n) {
		int[] dp =  new int[target+1];
		dp[0] = 1;
		
		// For each coin, we traverse from amt = 0 to amt = 1
		for (int coin = 0; coin < n; coin++) {
			for (int amt = arr[coin]; amt <= target; amt++) {
				int remAmt = amt - arr[coin];
				dp[amt] += dp[remAmt];
			}
		}
		
		return dp[target];
	}

	public static void main(String[] args) {

		int amt = 11;
		int arr[] = { 2, 5, 1 };
		int ans = 0;

		ans = getWays1(0, amt, arr, arr.length);
		System.out.println("Number of ways: " + ans);

		ans = getWays2(amt, arr, arr.length);
		System.out.println("Number of ways: " + ans);
		
		ans = getWays3(amt, arr, arr.length);
		System.out.println("Number of ways: " + ans);
	}

}
