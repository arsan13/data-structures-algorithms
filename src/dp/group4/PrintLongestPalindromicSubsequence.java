package dp.group4;

public class PrintLongestPalindromicSubsequence {

	// LPS(str) = LCS(str, reverse(str))
	private static String lps(String str1) {
		int n = str1.length();
		String str2 = reverse(str1);

		return lcs(str1, str2, n, n);
	}

	private static String lcs(String str1, String str2, int n, int m) {
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

		return getString(str1, str2, n, m, dp);
	}

	// Trace from the last cell
	private static String getString(String str1, String str2, int n, int m, int[][] dp) {
		int i = n;
		int j = m;
		String str = "";

		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				str = str1.charAt(i - 1) + str;
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}

		return str;
	}

	private static String reverse(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--)
			rev += str.charAt(i);
		return rev;
	}
	
	public static void main(String[] args) {

		String str1 = "aebcbda";

		String ans = lps(str1);
		System.out.println(ans);
	}
}
