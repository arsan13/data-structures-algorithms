package dp.MCM;

import java.util.Arrays;

//Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true. 
public class BooleanParentherization {

	private static int countWays(char[] arr, int n) {	
		int[][][] dp = new int[n][n][2];
		for(int[][] matrix : dp) {
			for(int[] a : matrix) {
				Arrays.fill(a, -1);
			}
		}
		
//		return solve1(arr, 0, n - 1, true);
		return solve2(arr, 0, n - 1, 1, dp);
	}
	
	private static int solve1(char[] arr, int i, int j, boolean isTrue) {
		if (i > j)
			return 0;
		
		if (i == j) {
			if (isTrue) {
				return (arr[i] == 'T') ? 1 : 0;
			} else {
				return (arr[i] == 'F') ? 1 : 0;
			}
		}
		
		int ans = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {
			int lt = solve1(arr, i, k - 1, true); // Left True
			int lf = solve1(arr, i, k - 1, false); // Left False
			int rt = solve1(arr, k + 1, j, true); // Right True
			int rf = solve1(arr, k + 1, j, false); // Right False
			
			if (arr[k] == '&') {
				if (isTrue) {
					ans += (lt * rt);
				} else {
					ans += (lt * rf) + (lf * rt) + (lf * rf);
				}
			} else if (arr[k] == '|') {
				if (isTrue) {
					ans += (lt * rt) + (lt * rf) + (lf * rt);
				} else {
					ans += (lf * rf);
				}
			} else { //xor(^)
				if (isTrue) {
					ans += (lt * rf) + (lf * rt);
				} else {
					ans += (lt * rt) + (lf * rf);
				}
			}
		}
		
		return ans;
	}
	
	// Memoization
	private static int solve2(char[] arr, int i, int j, int isTrue, int[][][] dp) {
		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == 1) {
				return (arr[i] == 'T') ? 1 : 0;
			} else {
				return (arr[i] == 'F') ? 1 : 0;
			}
		}
		
		if(dp[i][j][isTrue] != -1)
			return dp[i][j][isTrue];
		
		int ans = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {
			int lt = solve2(arr, i, k - 1, 1, dp); // Left True
			int lf = solve2(arr, i, k - 1, 0, dp); // Left False
			int rt = solve2(arr, k + 1, j, 1, dp); // Right True
			int rf = solve2(arr, k + 1, j, 0, dp); // Right False

			if (arr[k] == '&') {
				if (isTrue == 1) {
					ans += (lt * rt);
				} else {
					ans += (lt * rf) + (lf * rt) + (lf * rf);
				}
			} else if (arr[k] == '|') {
				if (isTrue == 1) {
					ans += (lt * rt) + (lt * rf) + (lf * rt);
				} else {
					ans += (lf * rf);
				}
			} else { //xor(^)
				if (isTrue == 1) {
					ans += (lt * rf) + (lf * rt);
				} else {
					ans += (lt * rt) + (lf * rf);
				}
			}
		}
		
		dp[i][j][isTrue] = ans;
		return ans;
	}
	
	public static void main(String[] args) {

//		char[] arr = { 'T', '^', 'F', '|', 'F' };
		char[] arr = { 'T', '|', 'T', '&', 'F', '^', 'T' };
		int n = arr.length;

		// There are 4 ways
		// ((T|T)&(F^T)), (T|(T&(F^T))),
		// (((T|T)&F)^T) and (T|((T&F)^T))

		int ans = countWays(arr, n);
		System.out.println(ans);
	}
}
