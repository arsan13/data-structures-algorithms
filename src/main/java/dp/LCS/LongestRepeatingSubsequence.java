package dp.LCS;

/*
 * Given a string, find the length of the longest repeating subsequence such that 
 * the two subsequences don’t have same string character at the same position,i.e., 
 * any i’th character in the two subsequences shouldn’t have the same index in the original string. 
*/
public class LongestRepeatingSubsequence {

//	LRS(str) = LCS(str, str) && i != j
	private static int lrs(String str1) {
		int n = str1.length();
		String str2 = str1;
		int[][] dp = new int[n + 1][n + 1];

		// Initialization
		// 0th row and 0th column cells by default contains value 0.

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1) && i != j) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n][n];
	}

	public static void main(String[] args) {

		String str = "aabebcdd";
		int ans = lrs(str);
		System.out.println(ans);
	}
}
