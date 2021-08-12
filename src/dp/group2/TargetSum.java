package dp.group2;

//Return number of different ways of obtaining a sum of elements equal to a given value 
//after putting + or - before each each element of the array.
public class TargetSum {

	//Brute force O(2**n) time
	private static int getWays1(int[] arr, int n, int currSum, int sum) {
		if (n == 0) {
			if (currSum == sum) {
				return 1;
			}
			return 0;
		}

		int positive = getWays1(arr, n - 1, currSum + arr[n - 1], sum);
		int negative = getWays1(arr, n - 1, currSum - arr[n - 1], sum);

		return positive + negative;
	}

	// DP: Tabulation
	// This problem is same as CountSubsetSumDiff with a slight modification,
	private static int getWays2(int[] arr, int n, int k) {
		if(n == 1 && (arr[0] == k || arr[0] == -k))
            return 1;
        if(n == 1 && arr[0] != k) 
            return 0;
        
        int totalSum = 0;
		for (int val : arr) {
			totalSum += val;
		}
		
        if(k > totalSum)
            return 0;
        if((k + totalSum) % 2 != 0)
            return 0;
        
		int subsetSum = (k + totalSum) / 2;
		return countSubsetSum(arr, n, subsetSum);
	}

	// Count number of subsets with sum equal to given value.
	private static int countSubsetSum(int[] arr, int n, int sum) {
		int[][] dp = new int[n + 1][sum + 1];
		
		for(int i = 0; i < dp.length; i++)
			dp[i][0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
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

		int sum = 1;
		int[] arr = { 1, 1, 2, 3 };

		System.out.println(getWays1(arr, arr.length, 0, sum));
		System.out.println(getWays2(arr, arr.length, sum));
	}
}
