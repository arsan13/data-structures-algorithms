package dp.knapsack1;

// Check if a subset of ans array has sum equal to given value.
public class SubsetSum {

	// Plain recursion, 2**n time complexity
//	private static boolean isSubsetSum(int[] arr, int n, int sum) {
//		
//		if(sum == 0)
//			return true;
//		if( n == 0)
//			return false;
//		
//		// If last element is greater then sum, then ignore it -> removes unnecesarry calls
//      if (arr[n - 1] > sum)
//        	return isSubsetSum(arr, n - 1, sum);

//      boolean include = isSubsetSum(arr, n-1, sum-arr[n-1]);
//      boolean exclude = isSubsetSum(arr, n-1, sum);
//        
//      return include || exclude;
//	}

	private static boolean isSubsetSum(int[] arr, int n, int k) {
		boolean[][] dp = new boolean[n + 1][k + 1];
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (arr[i - 1] <= j) { // exclude || include
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				} else { // only exclude
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][k];
	}

	public static void main(String[] args) {

		/*
		 * Element should not be repeated. 
		 * Each element has two choices, either it participates or it doesn't.
		 */

		int sum = 10;
		int arr[] = { 4, 2, 7, 3 };

		boolean ans = isSubsetSum(arr, arr.length, sum);
		System.out.println(ans);
	}
}
