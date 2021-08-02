package binarySearch;

public class FirstAndLastOccurrence {

	private static void occurrence(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;
		int res = -1;

		// First Occurrence
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < x) {
				low = mid + 1;
			} else if (arr[mid] == x) {
				res = mid;
				high = mid - 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println("First Occurrence: " + res);

		low = 0;
		high = arr.length - 1;
		// Last Occurrence
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < x) {
				low = mid + 1;
			} else if (arr[mid] == x) {
				res = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println("Last Occurrence: " + res);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int x = 5;
		occurrence(arr, x);
	}

}
