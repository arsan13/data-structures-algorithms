package dp;

// Number of ways in which these n elements can be partitioned into k non-empty subsets.
// Number of ways of forming k teams from n players.
// f(n) = k * f(n-1, k) + f(n-1, k-1)
public class PartitionSubsets {

	// Brute
	private static long count1(int n, int k) {

		if (n == 0 || k == 0 || n < k)
			return 0;
		if (n == k || k == 1)
			return 1;

		return k * count1(n - 1, k) + count1(n - 1, k - 1);
	}

	// Optimal
	private static long count2(int n, int k) {
		if (n == 0 || k == 0 || n < k)
			return 0;

		long[][] dp = new long[k + 1][n + 1];

		// t -> team, p -> player
		for (int t = 1; t <= k; t++) {
			for (int p = 1; p <= n; p++) {
				if (p < t)
					dp[t][p] = 0;
				else if (t == p)
					dp[t][p] = 1;
				else
					dp[t][p] = (t * dp[t][p - 1]) + dp[t - 1][p - 1];
			}
		}
		
		return dp[k][n];
	}

	public static void main(String[] args) {

		int n = 5;
		int k = 4;

		long ans = count1(n, k);
		System.out.println(ans);

		ans = count2(n, k);
		System.out.println(ans);
	}

}
