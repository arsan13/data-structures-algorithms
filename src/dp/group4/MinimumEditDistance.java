package dp.group4;

//Given two strings str1 and str2 and INSERT, DELETE, REPLACE operations can be performed on str1. 
//Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.  
public class MinimumEditDistance {

	private static int minOperations1(String str1, String str2, int n, int m) {
		// If first string is empty, insert all characters of second string into first
		if (n == 0)
			return m;	// m number of insertions
		
		// If second string is empty, remove all characters of first string
		if (m == 0) 
			return n;	// n number of deletions

		if (str1.charAt(n - 1) == str2.charAt(m - 1))
			return minOperations1(str1, str2, n - 1, m - 1);

		int insert = minOperations1(str1, str2, n, m - 1);
		int delete = minOperations1(str1, str2, n - 1, m);
		int replace = minOperations1(str1, str2, n - 1, m - 1);
		return 1 + Math.min(insert, Math.min(delete, replace));
	}

	// Optimal
	private static int minOperations2(String str1, String str2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		// Initialization
		for (int i = 1; i <= n; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= m; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {

		String str1 = "sunday";
		String str2 = "saturday";

		int ans = minOperations1(str1, str2, str1.length(), str2.length());
		System.out.println(ans);

		ans = minOperations2(str1, str2, str1.length(), str2.length());
		System.out.println(ans);
	}

}
