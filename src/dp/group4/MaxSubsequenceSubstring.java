package dp.group4;

import java.util.Arrays;

//Find the length of longest subsequence of one string which is substring of another string.
public class MaxSubsequenceSubstring {

	// Brute Force. O(2pow(n)) Time
	// Find all the subsequences of str1 and for each subsequence
	// check whether it is a substring of str2 or not.
	private static int isMatching1(int index, String str1, String str2, String sub) {
		if (index == str1.length()) {
			if (str2.contains(sub)) {
				return sub.length();
			}
			return 0;
		}

		int include = isMatching1(index + 1, str1, str2, sub + str1.charAt(index));
		int exclude = isMatching1(index + 1, str1, str2, sub);

		return Math.max(include, exclude);
	}

	// Optimal. O(n*m) Time
	// For every call in recursion function we are decreasing n,
	// base case will be reached exactly and recursive calls is made for m times
	// in the loop for the different lengths of string 2.
	private static int isMatching2(String str1, String str2, int n, int m) {
		int ans = 0; // if no matching found

		int[][] dp = new int[n + 1][m + 1];
		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		// traversing for every length of str2.
		for (int i = 0; i <= m; i++) {
//			int temp = isMatching2Rec(str1, str2, n, i);
			int temp = isMatching2Memo(str1, str2, n, i, dp);
			ans = Math.max(ans, temp);
		}

		return ans;
	}

	// Plain recursion
	private static int isMatching2Rec(String str1, String str2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;

		if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
			return 1 + isMatching2Rec(str1, str2, n - 1, m - 1);
		} else {
			return isMatching2Rec(str1, str2, n - 1, m);
		}
	}

	// Memoization. Better than isMatching2Rec
	private static int isMatching2Memo(String str1, String str2, int n, int m, int[][] dp) {
		if (n == 0 || m == 0)
			return 0;
		if (dp[n][m] != -1)
			return dp[n][m];

		if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
			return dp[n][m] = 1 + isMatching2Memo(str1, str2, n - 1, m - 1, dp);
		} else {
			return dp[n][m] = isMatching2Memo(str1, str2, n - 1, m, dp);
		}
	}

	// Optimal. Tabulation. O(n*m) Time
	private static int isMatching3(String str1, String str2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		// Initialization
		// 0th row and 0th column cells by default contains value 0.

		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

				max = Math.max(max, dp[i][j]);
			}
		}

		return max;
	}

	public static void main(String[] args) {

		String str1 = "ABCD";
		String str2 = "BACDBDCD";
		int n = str1.length();
		int m = str2.length();

		int ans = isMatching1(0, str1, str2, "");
		System.out.println(ans);

		ans = isMatching2(str1, str2, n, m);
		System.out.println(ans);

		ans = isMatching3(str1, str2, n, m);
		System.out.println(ans);

	}

}
