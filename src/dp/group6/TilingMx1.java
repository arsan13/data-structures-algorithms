package dp.group6;

// Tiling with Dominoes. 
// Tiling Mx1 tiles in MxN board.
public class TilingMx1 {

//	Answer may be very large, return it modulo 10**9 + 7 for large numbers

	// Brute Force
	private static int count1(int m, int n) {
		if (n < m)
			return 1;
		if (n == m)
			return 2;

		return count1(m, n - 1) + count1(m, n - m);
	}

	// Optimal DP
	private static int count2(int m, int n) {
		int dp[] = new int[n + 1]; 
		
		for (int i = 1; i <= n; i++) {
			if (i < m)
				dp[i] = 1;		// only vertical
			else if (i == m)
				dp[i] = 2;		// 1 vertical + 1 horizontal = 2
			else
				dp[i] = dp[i - 1] + dp[i - m];
		}

		return dp[n];
	}

	public static void main(String[] args) {

		int m = 2;
		int n = 4;

		int ans = count1(m, n);
		System.out.println(ans);

		ans = count2(m, n);
		System.out.println(ans);
	}

}
