package dp.group4;

public class PrintLongestCommonSubsequence {

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

	public static void main(String[] args) {

		String str1 = "abcdaf";
		String str2 = "acbcf";
		int n = str1.length();
		int m = str2.length();

		String ans = lcs(str1, str2, n, m);
		System.out.println(ans);
	}
}
