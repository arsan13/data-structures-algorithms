package dp.knapsack1;

//Partition a set into two subsets such that the difference of subset sums is minimum.
public class MinSubsetSumDiff {

	// Brute Force O(2**N) Time
	private static int minDiff1(int[] arr, int n, int sum1, int sum2) {
		if (n == 0) {
			return Math.abs(sum1 - sum2);
		}

		int set1 = minDiff1(arr, n - 1, sum1 + arr[n - 1], sum2);
		int set2 = minDiff1(arr, n - 1, sum1, sum2 + arr[n - 1]);

		return Math.min(set1, set2);
	}

	// Efficient O(n*sum) time
	private static int minDiff2(int arr[], int n) {
//		if (n == 0)
//			return 0;
//		if (n == 1)
//			return arr[0];

		int totalSum = 0;
		for (int val : arr) {
			totalSum += val;
		}

//		int min = Integer.MAX_VALUE;
//		boolean[] potentialSubsets = getSubsetSum(arr, n, totalSum / 2);
//		for (int i = 0; i < potentialSubsets.length; i++) {
//			if (potentialSubsets[i] == true) {
//				min = Math.min(min, totalSum - 2 * i);
//			}
//		}
//		return min;
		
		int subsetSum = getSubsetSum(arr, n, totalSum / 2);
		return totalSum - 2 * subsetSum;
	}

	
	private static int getSubsetSum(int[] arr, int n, int sum) {
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

//		return dp[n];
		
		int subsetSum = 0;
		for(int i = dp[0].length - 1; i >= 0; i--) {
			if(dp[n][i] == true) {
				subsetSum = i;
				break;
			}
		}
		return subsetSum;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 6, 11, 5 };
		System.out.println(minDiff1(arr, arr.length, 0, 0));
		System.out.println(minDiff2(arr, arr.length));
	}
}
