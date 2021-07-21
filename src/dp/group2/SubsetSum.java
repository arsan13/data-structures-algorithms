package dp.group2;

public class SubsetSum {

	// Plain recursion, 2**n time complexity 
//	private static boolean isSubsetSum(int[] arr, int n, int sum) {
//		
//		if(sum == 0)
//			return true;
//		if( n == 0)
//			return false;
//		
//		// If last element is greater then sum, then ignore it -> removes unnecesarry calls
//      if (arr[n - 1] > sum)
//        	return isSubsetSum(arr, n - 1, sum);
	
//      boolean include = isSubsetSum(arr, n-1, sum-arr[n-1]);
//      boolean exclude = isSubsetSum(arr, n-1, sum);
//        
//      return include || exclude;
//	}
	
	private static boolean isSubsetSum(int[] arr, int n, int sum) {
		boolean[][] dp = new boolean[n+1][sum+1];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				
				if(i == 0 && j == 0) 	// first cell
					dp[i][j] = true;
				else if(i == 0) 		// all cols of first row except first col
					dp[i][j] = false;	
				else if(j == 0)			// all rows of first col
					dp[i][j] = true; 	
				else { 					// rest of the elements
					if(dp[i-1][j] == true)							// exclude
						dp[i][j] = dp[i-1][j];
					else {
						int val = arr[i-1]; // Since, i of dp is aligned with i-1 of arr
						if(j >= val && dp[i-1][j-val] == true)    	// include
							dp[i][j] = true;
					}
				}
			}
		}
		
		return dp[dp.length-1][dp[0].length-1];
	}
	
	public static void main(String[] args) {

		/* Element should not be repeated
		 * Each element has two choices, either participate or not  */
		
		int sum = 10;
		int arr[] = { 4, 2, 7, 3 };
		
		boolean ans = isSubsetSum(arr, arr.length, sum);
		System.out.println(ans);
	}
}
