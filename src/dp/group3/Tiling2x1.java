package dp.group3;

// Tiling with Dominoes. 
// Tiling 2x1 tiles in 2xN board.
// This is same as Fibonacci. 
public class Tiling2x1 {

//	Answer may be very large, return it modulo 10**9 + 7 for large numbers
	
	// Brute Force.
	private static int count1(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		
		return count1(n - 1) + count1(n - 2);
	}

	// Optimal DP
	private static int count2(int n) {
		int dp[] = new int[n+1];	// Space can be optimized by using two + two variables instead of an array.
		dp[1] = 1;  // no of ways to tile up 2x1 board
		dp[2] = 2;  // no of ways to tile up 2x2 board
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {

		int n = 4;
		
		int ans = count1(n);
		System.out.println(ans);

		ans = count2(n);
		System.out.println(ans);
	}

}
