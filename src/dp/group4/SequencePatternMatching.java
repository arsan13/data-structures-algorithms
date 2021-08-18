package dp.group4;

// Check if a string is a subsequence of another string.
public class SequencePatternMatching {

	// Brute force
	private static boolean isMatching1(int index, String str1, String str2, String sub) {
		if (index == str2.length()) {
			if (str1.equals(sub)) {
				return true;
			}
			return false;
		}

		boolean include = isMatching1(index + 1, str1, str2, sub + str2.charAt(index));
		boolean exclude = isMatching1(index + 1, str1, str2, sub);

		return include || exclude;
	}

	// Optimal. Compare lcs(str1, str2) with len(str1)
	private static boolean isMatching2(String str1, String str2) {
		int lcs = lcs(str1, str2, str1.length(), str2.length());

		if (str1.length() == lcs)
			return true;
		else
			return false;
	}

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

	public static void main(String[] args) {

		String str1 = "axy";
		String str2 = "adxcpy";

		boolean ans = isMatching1(0, str1, str2, "");
		System.out.println(ans);

		ans = isMatching2(str1, str2);
		System.out.println(ans);
	}

}
