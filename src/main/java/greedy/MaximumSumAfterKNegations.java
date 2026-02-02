package greedy;

import java.util.Arrays;

public class MaximumSumAfterKNegations {

	// Extra space and time complexity
	// public static long maximizeSum(long arr[], int n, int k) {

	// long sum = 0;
	// PriorityQueue<Long> pq = new PriorityQueue<>();

	// for(long val : arr)
	// pq.add(val);

	// while(k-- > 0) {
	// long val = pq.poll();
	// val = -val;
	// pq.add(val);
	// }

	// for(long val : pq)
	// sum += val;

	// }
	// return sum;

	// Efficient
	public static long maximizeSum(long arr[], int n, int k) {
		long sum = 0;

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if(k < 1)
				break;
			
			if (arr[i] < 0) {
				arr[i] = -arr[i];
				k--;
			}
		}

		for (int i = 0; i < n; i++)
			sum += arr[i];

		long min = getMin(arr, n);

		if (k % 2 != 0) // if k is odd
			sum -= 2 * min;

		return sum;
	}

	private static long getMin(long[] arr, int n) {
		long min = Integer.MAX_VALUE;
		for (long i : arr)
			min = Math.min(min, i);
		return min;
	}

	public static void main(String[] args) {

		int N = 10, K = 5;
		long arr[] = { 5, -2, 5, -4, 5, -12, 5, 5, 5, 20 };
		
		System.out.println(maximizeSum(arr, N, K));
	}
}
