package dp;

//Largest sum subarray with at-least k numbers
public class MaxSumK {

	public static long maxSumWithK(long arr[], long n, long k) {
		long maxSum[] = new long[arr.length];

		long currSum = arr[0];
		maxSum[0] = currSum;
		for (int i = 1; i < n; i++) {
			// if(currSum < 0) {
			// currSum = arr[i];
			// } else {
			// currSum += arr[i];
			// }
			currSum = Math.max(arr[i], currSum + arr[i]);
			maxSum[i] = currSum;
		}

		long kSum = 0;
		for (int i = 0; i < k; i++) {
			kSum += arr[i];
		}

		long ans = kSum;
		for (int i = (int) k; i < n; i++) {
			kSum = kSum + arr[i] - arr[i - 1]; // sliding window
			ans = Math.max(ans, kSum);
			ans = Math.max(ans, kSum + maxSum[(int) (i - k)]);
		}

		if (ans < 0)
			return -1;
		return ans;
	}

	public static void main(String[] args) {

		long arr[] = { 1, 2, 3, -10, -3 };
		long k = 4;
		System.out.println(maxSumWithK(arr, arr.length, k));
		;
	}

}
