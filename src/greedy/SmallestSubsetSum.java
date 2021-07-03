package greedy;

import java.util.Arrays;
import java.util.Collections;

public class SmallestSubsetSum {

	private static int getSubset(int[] arr, int n) {
		
		int res = 0;
		int subsetSum = 0;
		int totalSum = 0;
		
		for(int val : arr)
			totalSum += val;
				
		Arrays.sort(arr);   // Array is sorted in increasing order
					
		// traverse in reverse to get decreasing order of array
		for (int i = n-1; i >= 0; i-- ) {
			subsetSum += arr[i];
			totalSum -= arr[i];
			res++;
			
			if(subsetSum > totalSum)
				break;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3, 1, 7, 1};
		
		System.out.println(getSubset(arr, arr.length));
	}
}
