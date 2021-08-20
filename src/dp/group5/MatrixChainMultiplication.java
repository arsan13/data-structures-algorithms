package dp.group5;

import java.util.Arrays;

/* Given an array p[] which represents the chain of matrices such that the i-th matrix Ai is of dimension p[i-1] x p[i]. 
 * Return the minimum number of multiplications needed to multiply the chain. 
 */
public class MatrixChainMultiplication {
	
	private static int matrixMultiplication(int[] p) {
		int n = p.length;
		int[][] dp = new int[n][n];
		
		for(int[] a : dp) {
			Arrays.fill(a, -1);
		}
		
		return solve(p, 1, n - 1, dp);
	}

	private static int solve(int[] arr, int i, int j, int[][] dp) {
		if (i >= j)
			return 0;
		if(dp[i][j] != -1) 
			return dp[i][j];
		
		int ans = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int cost1 = solve(arr, i, k, dp);
			int cost2 = solve(arr, k + 1, j, dp);
			int extraCost = arr[i - 1] * arr[k] * arr[j];
			
			int subAns = cost1 + cost2 + extraCost;
			ans = Math.min(ans, subAns);
		}
		
		return dp[i][j] = ans;
	}

	public static void main(String[] args) {

		// There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
		int p[] = { 40, 20, 30, 10, 30 };
		
		int ans = matrixMultiplication(p);
		System.out.println(ans);

		
	}

}
