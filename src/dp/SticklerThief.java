package dp;

//Maximum sum such that no two elements are adjacent
public class SticklerThief {

	// Brute force O(2**n)
	private static int maxSumBrute(int[] arr, int n) {
		
		return maxSumUtil(0, arr, n, false);
	}
	
	private static int maxSumUtil(int index, int[] arr, int n, boolean included) {
		
		if(index == n) {
			return 0;
		}
		
		int inc = 0;
		int exc = 0;
		
		if(!included) 
			inc = arr[index] + maxSumUtil(index + 1, arr, n, true);
		exc = maxSumUtil(index + 1, arr, n, false);
		
		return Math.max(inc, exc);
	}
	
	// DP O(n)
	private static int maxSumOptimal(int[] arr, int n) {
		int oldInc = arr[0];
		int oldExc = 0;
		
		for(int i = 1; i < n; i++) {
			int newInc = arr[i] + oldExc;
			int newExc = Math.max(oldInc, oldExc);
			
			oldInc = newInc;
			oldExc = newExc;
		}
		
		return Math.max(oldInc, oldExc);
	}
	
	public static void main(String[] args) {

		int arr[] = { 5, 5, 10, 100, 5, 5 };
		
		int ans = maxSumBrute(arr, arr.length);
		System.out.println(ans);
		
		ans = maxSumOptimal(arr, arr.length);
		System.out.println(ans);
	}
}
