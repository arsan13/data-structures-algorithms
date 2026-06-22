package dp.group2;


// Count number of binary strings possible without consecutive 0's
public class BinaryStrings {

//	O(2**n complexity)
	private static long binaryString(long n, String ans) {

		if (n == 0) {
//			System.out.print(ans + " ");
			return 1;
		}
		
		long zeroes = 0;
		if (ans.length() == 0)
			zeroes = binaryString(n - 1, ans + '0');
		else if (ans.charAt(ans.length() - 1) != '0')
			zeroes = binaryString(n - 1, ans + '0');
		
		long ones = binaryString(n - 1, ans + '1');

		return ones + zeroes;  
	}

	// O(n) Time & Extra space
//	private static int binaryString(int n) {
//		int dp0[] = new int[n + 1];
//		int dp1[] = new int[n + 1];
//		dp0[1] = 1;
//		dp1[1] = 1;
//		
//		for (int i = 2; i <= n; i++) {
//			dp0[i] = dp1[i - 1];
//			dp1[i] = dp0[i - 1] + dp1[i - 1];
//		}
//		
//		return dp0[n] + dp1[n];
//	}
	
	// O(n) Time & Constant space
	private static long binaryString(long n) {
		
		long mod = (long) (Math.pow(10, 9) + 7);
		long oldCount0 = 1;
		long oldCount1 = 1;
		
		for (int i = 2; i <= n; i++) {
			long newCount0 = oldCount1;
			long newCount1 = (oldCount0 + oldCount1) % mod;
			
			oldCount0 = newCount0;
			oldCount1 = newCount1;
		}
		
		return (oldCount0 + oldCount1) % mod;
	}

	public static void main(String[] args) {

		long n = 3;
		long ans = 0;
		
		ans = binaryString(n, "");
		System.out.println("Count = " + ans);

		ans = binaryString(n);
		System.out.println("Count = " + ans);
	}
}
