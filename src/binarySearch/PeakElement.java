package binarySearch;

/*Given an integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks.
A peak element is an element that is strictly greater than its neighbors.*/
public class PeakElement {

	private static int peakElement(int[] arr, int n) {
		if (n == 1)
			return 0;

		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (mid > 0 && mid < n - 1) {
				if (arr[mid] < arr[mid + 1]) {
					low = mid + 1;
				} else if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
					return mid;
				} else if (arr[mid] < arr[mid - 1]) {
					high = mid - 1;
				}
			} else if (mid == 0) {
				return (arr[0] > arr[1] ? 0 : 1);
			} else if (mid == n - 1) {
				return (arr[n - 1] > arr[n - 2] ? n - 1 : n - 2);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		
		int arr[] = {10, 20, 15, 2, 23, 90, 67};
		System.out.println(peakElement(arr, arr.length));
	}

}
