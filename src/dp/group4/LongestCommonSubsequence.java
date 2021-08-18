package dp.group4;

import java.util.Arrays;

public class LongestCommonSubsequence {

	// Brute Force. O(2 power(min(m, n))) time
	private static int lcs1(String str1, String str2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;

		if (str1.charAt(n - 1) == str2.charAt(m - 1))
			return 1 + lcs1(str1, str2, n - 1, m - 1);

		return Math.max(lcs1(str1, str2, n - 1, m), lcs1(str1, str2, n, m - 1));
	}

	// Optimal. Memoization. Time: O(n*m). Space: O(n*m) + auxillary(recursive stack)
	private static int lcs2(String str1, String str2, int n, int m, int[][] dp) {
		if (n == 0 || m == 0)
			return 0;
		if (dp[n][m] != -1)
			return dp[n][m];

		if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
			dp[n][m] = 1 + lcs2(str1, str2, n - 1, m - 1, dp);
			return dp[n][m];
		}

		dp[n][m] = Math.max(lcs2(str1, str2, n - 1, m, dp), lcs2(str1, str2, n, m - 1, dp));
		return dp[n][m];
	}

	// Optimal. Tabulation. Time: O(n*m). Space: O(n*m)
	private static int lcs3(String str1, String str2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		// Initialization 
		// 0th row and 0th column cells by default contains value 0.

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {

		String str1 = "abcdaf";
		String str2 = "acbcf";
		int n = str1.length();
		int m = str2.length();
		int ans = 0;

		ans = lcs1(str1, str2, n, m);
		System.out.println("Length: " + ans);

		int[][] dp = new int[n + 1][m + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);
		ans = lcs2(str1, str2, n, m, dp);
		System.out.println("Length: " + ans);

		ans = lcs3(str1, str2, n, m);
		System.out.println("Length: " + ans);
	}
}
