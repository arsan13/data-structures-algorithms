package dp;

/*
 * Find out the total number of ways in which friends can remain single or can be paired up.
 * f(n) = ways n people can remain single or pair up.
 * For n-th person there are two choices:
 *   1) n-th person remains single, we recur for f(n - 1)
 *   2) n-th person pairs up with any of the remaining n - 1 persons. We get (n - 1) * f(n - 2)
 * Therefore we can recursively write f(n) as:
 * f(n) = f(n - 1) + (n - 1) * f(n - 2)
 */

public class FriendsPairing {

	private static int count(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int dp[] = new int[n + 1];
		dp[1] = 1; // Remains single
		dp[2] = 2; // Two friends can either pair up or both remain single, so 2 ways

		for (int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];

		return dp[n];
	}

	public static void main(String[] args) {

		int n = 4;
		System.out.println(count(n));
	}

}
