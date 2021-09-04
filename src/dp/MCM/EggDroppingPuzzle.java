package dp.MCM;

import java.util.Arrays;

public class EggDroppingPuzzle {

	private static int minMoves(int e, int f, int[][] dp) {
		if (f == 0 || f == 1)
			return f;
		if (e == 1)
			return f;

		if (dp[e][f] != -1)
			return dp[e][f];

		int ans = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {
			int temp = 1 + Math.max(minMoves(e - 1, k - 1, dp), minMoves(e, f - k, dp));
			ans = Math.min(ans, temp);
		}

		return dp[e][f] = ans;
	}

	public static void main(String[] args) {

		int e = 2;
		int f = 10;
		int[][] dp = new int[e + 1][f + 1];

		for (int[] arr : dp)
			Arrays.fill(arr, -1);

		System.out.println(minMoves(e, f, dp));
	}
}
