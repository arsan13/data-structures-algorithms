package dp.LCS;

/*Given two strings X and Y of lengths m and n respectively, 
  find the length of the smallest string which has both, X and Y as its sub-sequences.*/
public class ShortestCommonSupersequence {

	// Brute Force. Shortest common super-sequence. O(2 power(min(m, n))) time. 
	private static int scs1(String str1, String str2, int n, int m) {
		if (n == 0)
			return m;
		if (m == 0)
			return n;

		if (str1.charAt(n - 1) == str2.charAt(m - 1))
			return 1 + scs1(str1, str2, n - 1, m - 1);

		int subAns = Math.min(scs1(str1, str2, n - 1, m), scs1(str1, str2, n, m - 1));
		return 1 + subAns;
	}

	// Optimal. Shortest common super-sequence.
	private static int scs2(String str1, String str2, int n, int m) {
		/*
		 * Length of the shortest super-sequence = 
		 *  (Sum of lengths of given two strings)
		 * -(Length of LCS of two given strings)
		 */
		int lcs = lcs(str1, str2, n, m);
		return n + m - lcs;
	}

	// Longest common subsequence
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

		String str1 = "abcd";
		String str2 = "xycd";

		int ans = scs1(str1, str2, str1.length(), str2.length());
		System.out.println(ans);

		ans = scs2(str1, str2, str1.length(), str2.length());
		System.out.println(ans);
	}
}
