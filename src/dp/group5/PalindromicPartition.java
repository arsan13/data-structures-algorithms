package dp.group5;

import java.util.Arrays;

// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return the minimum cuts needed for a palindrome partitioning of s.
public class PalindromicPartition {

	private static int minCuts(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		 return solve(str, 0, n - 1, dp);
	}
	
	// Memoization
	private static int solve(String str, int i, int j, int[][] dp) {
		if (i >= j) //Empty string or string with length 1 is always palindrome, so no cut is required.
			return 0;
		if (isPalindrome(str, i, j)) //Palindromic string does not require any cuts.
			return 0;
		
		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int left = solve(str, i, k, dp);
			int right = solve(str, k + 1, j, dp);
			
			int subAns = 1 + left + right;
			ans = Math.min(ans, subAns);
		}

		return dp[i][j] = ans;
	}

	private static boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {

		String str = "geek";

		int ans = minCuts(str);
		System.out.println(ans);
	}

}
