package dp.knapsack1;

//Count the number of subset sums with a given difference.
//Count number of ways to partition a set into two subsets such that the difference of subset sums is equal to k.
public class CountSubsetSumDiff {

	private static int countSubsetsWithDiff(int[] arr, int n, int k) {
		int totalSum = 0;
		for (int val : arr) {
			totalSum += val;
		}
		
		/* s1=subset1, s2=subset2
		 * sum(s1) - sum(s2) = k 		--- I 
		 * sum(s1) + sum(s2) = sum(arr) --- II 
		 * Adding I and II, 
		 * sum(s1) = (k + sum(arr)) / 2  */
		
		int subsetSum = (k + totalSum) / 2;
		return countSubsetSum(arr, n, subsetSum);
	}

	// Count number of subsets with sum equal to given value.
	private static int countSubsetSum(int[] arr, int n, int sum) {
		int[][] dp = new int[n + 1][sum + 1];
		
		for(int i = 0; i < dp.length; i++)
			dp[i][0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[n][sum];
	}

	public static void main(String[] args) {

		int k = 1;
		int arr[] = { 1, 1, 2, 3 };

		int res = countSubsetsWithDiff(arr, arr.length, k);
		System.out.println(res);
	}
}
