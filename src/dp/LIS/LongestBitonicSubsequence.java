package dp.LIS;

//Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
//A subsequence of array is called Bitonic if it is first increasing, then decreasing.
public class LongestBitonicSubsequence {

	//Longest Bitonic Subsequence(lbs)
	//lbs = max(lis[i] + lds[i] - 1)
	private static int lbs(int[] arr, int n) {
		int lis[] = lis(arr, n);
		int lds[] = lds(arr, n);
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			int temp = lis[i] + lds[i] -1;
			res = Math.max(res, temp);
		}
		
		return res;
	}
	
	//Longest Increasing Subsequence(from 0 to n-1)
	private static int[] lis(int[] arr, int n) {
		int dp[] = new int[n];
		dp[0] = 1;
		
		for(int i = 1; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
		}
		
		return dp;
	}

	//Longest Decreasing Subsequence(from n-1 to 0)
	private static int[] lds(int[] arr, int n) {
		int dp[] = new int[n];
		dp[n-1] = 1;
		
		for(int i = n-2; i >= 0; i--) {
			int max = 0;
			
			for(int j = n-1; j >= 0; j--) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
		}
		
		return dp;
	}

	public static void main(String[] args) {
		
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
		//A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1
		
		System.out.println(lbs(arr, arr.length));
	}
}
