package dp.group4;

public class LongestCommonSubstring {

	private static int lcs(String str1, String str2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		// Initialization 
		// 0th row and 0th column cells by default contains value 0.
		
		int max = -1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}

				max = Math.max(max, dp[i][j]);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {

		String str1 = "abbacd";
		String str2 = "abbcda";
		int n = str1.length();
		int m = str2.length();
		int ans = 0;

		ans = lcs(str1, str2, n, m);
		System.out.println(ans);
	}
}
