package binarySearch;

public class CountOfAnElement {
	
	private static int count(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		int firstOccurence = -1;

		// First Occurrence
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < x) {
				low = mid + 1;
			} else if (arr[mid] == x) {
				firstOccurence = mid;
				high = mid - 1;
			} else {
				high = mid - 1;
			}
		}

		if(firstOccurence == -1)
			return 0;
		
		low = 0;
		high = arr.length - 1;
		int lastOccurence = -1;
		// Last Occurrence
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < x) {
				low = mid + 1;
			} else if (arr[mid] == x) {
				lastOccurence = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		int count = lastOccurence - firstOccurence + 1;
		return count;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int x = 5;
		System.out.println(count(arr, x));
	}

}
