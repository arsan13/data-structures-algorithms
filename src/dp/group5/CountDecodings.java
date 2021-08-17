package dp.group5;

public class CountDecodings {

	private static int getCount(String str) {
		int n = str.length();
		int[] dp = new int[n];
		dp[0] = 1;

		if(str.charAt(0) == '0')
            return 0;
		
		// Atmost last two elements is checked i.e., [i-1] & [i-2],
		// bcz a character can be represented by atmost two digits
		for (int i = 1; i < n; i++) {

			if (str.charAt(i-1) == '0' && str.charAt(i) == '0') { 				// both zeroes
				dp[i] = 0;
			} else if (str.charAt(i-1) == '0' && str.charAt(i) != '0') { 		// zero and non-zero
				dp[i] = dp[i - 1];
			} else if (str.charAt(i-1) != '0' && str.charAt(i) == '0') { 		// non-zero and zero
				if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
					dp[i] = i - 2 >= 0 ? dp[i - 2] : 1;
				} else {
					dp[i] = 0;
				}
			} else { 															// both non-zeroes
				if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
					dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}
		
		return dp[n - 1];
	}

	public static void main(String[] args) {

		String str = "21123";
		int n = str.length();
		System.out.println(getCount(str));
	}
}
