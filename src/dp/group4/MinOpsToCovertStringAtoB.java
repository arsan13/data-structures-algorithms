package dp.group4;

//Find the minimum number of insertions and deletions to transform one string 1 into string 2.
public class MinOpsToCovertStringAtoB {

	private static int[] minimumOperations(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		int lcs = lcs(str1, str2, n, m);
		int insertions = str2.length() - lcs;
		int deletions = str1.length() - lcs;

		return new int[] { insertions, deletions };
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

		String str1 = "heap";
		String str2 = "pea";

		int[] ans = minimumOperations(str1, str2);
		System.out.println("Insertions: " + ans[0]);
		System.out.println("Deletions: " + ans[1]);
	}
}
