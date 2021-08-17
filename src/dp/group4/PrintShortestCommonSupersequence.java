package dp.group4;

/*Given two strings X and Y of lengths m and n respectively, 
  print the smallest string which has both, X and Y as its sub-sequences.*/
public class PrintShortestCommonSupersequence {

	private static String scs(String str1, String str2, int n, int m) {

		return lcs(str1, str2, n, m);
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
		StringBuilder str = new StringBuilder();

		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				str.insert(0, str1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					str.insert(0, str2.charAt(j - 1));
					j--;
				} else {
					str.insert(0, str1.charAt(i - 1));
					i--;
				}
			}
		}

		while (i > 0) {
			str.insert(0, str1.charAt(i - 1));
			i--;
		}

		while (j > 0) {
			str.insert(0, str2.charAt(j - 1));
			j--;
		}

		return str.toString();
	}

	public static void main(String[] args) {

		String str1 = "abcd";
		String str2 = "xycd";
		int n = str1.length();
		int m = str2.length();

		String ans = scs(str1, str2, n, m);
		System.out.println(ans);
	}
}
