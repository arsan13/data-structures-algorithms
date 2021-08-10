package dp.group2;

/* Calculate sum of the array. 
 * 1) If sum is odd, there can not be two subsets with equal sum, so return false. 
 * 2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2. */
public class EqualPartitionSubsetSum {
	
	private static boolean isPossible(int[] arr) {
		int sum = 0;
        for(int val : arr)
            sum += val;
        
        if(sum % 2 != 0)
            return false;
        
        return isSubsetExists(arr, arr.length, sum/2);
    }
	
    //Target sum subset
    static boolean isSubsetExists(int arr[], int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for(int j = 0; j < dp[0].length; j++)
            dp[0][j] = false;
        
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = true;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(dp[i - 1][j] == true) {		//exclude
                    dp[i][j] = true;
                } else {						//include
                    if(arr[i - 1] <= j) {
                        dp[i][j] = dp[i-1][j - arr[i - 1]];
                    }
                }
            }
        }
        
        return dp[n][sum];
	}
	
	public static void main(String[] args) {
		
		int arr[] = { 1, 5 , 11, 5 };
		System.out.println(isPossible(arr));
	}
}
