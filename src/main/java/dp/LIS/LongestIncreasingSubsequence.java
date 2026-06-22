package dp.LIS;

//Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
public class LongestIncreasingSubsequence {

	private static int lis(int[] arr, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		
		int result = dp[0];
		for(int i = 1; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {50, 3, 10, 7, 40, 80};
		int n = arr.length;
		
		int ans = lis(arr, n);
		System.out.println(ans);
	}

}
