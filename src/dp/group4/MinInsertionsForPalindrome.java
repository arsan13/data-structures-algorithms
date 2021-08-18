package dp.group4;

//Find the minimum number of insertions to make a string palindrome.
public class MinInsertionsForPalindrome {

	// min(insertions) = min(deletions)
	// minimum # of deletions = str.length() - LPS(str)
	private static int minInsertions(String str) {
		int lps = lps(str);
		int res = str.length() - lps;

		return res;
	}

	// LPS(str) = LCS(str, reverse(str))
	private static int lps(String str1) {
		int n = str1.length();
		String str2 = reverse(str1);

		return lcs(str1, str2, n, n);
	}

	// LCS
	private static int lcs(String str1, String str2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		// Initialization
		// 0th row and 0th column cells by default contains value 0.

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n][m];
	}

	private static String reverse(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--)
			rev += str.charAt(i);
		return rev;
	}

	public static void main(String[] args) {

		// insert d(before e) and e(before d) to make the str palindrome.
		String str = "aebcbda";

		int ans = minInsertions(str);
		System.out.println(ans);
	}
}
