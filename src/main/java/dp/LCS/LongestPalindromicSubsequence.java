package dp.LCS;

public class LongestPalindromicSubsequence {

	// Brute Force
	private static int lps1(String str, int n, String ans) {
		if (n == 0) {
			if (isPalindrome(ans)) {
				return ans.length();
			}
			return -1;
		}

		int include = lps1(str, n - 1, ans + str.charAt(n - 1));
		int exclude = lps1(str, n - 1, ans);
		return Math.max(include, exclude);
	}

	private static boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

	// Optimal
	// LPS(string) = LCS(string, reverse(string))
	private static int lps2(String str1) {
		int n = str1.length();
		String str2 = reverse(str1);
		
		return lcs(str1, str2, n, n);
	}

	//LCS
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

		String str = "agbcba";
		int n = str.length();
		
		int ans = lps1(str, n, "");
		System.out.println(ans);

		ans = lps2(str);
		System.out.println(ans);
	}

}
