package binarySearch;

// Find the index of first 1 in an infinite sorted binary array.
// This problem is combination of first occurrence in an array and search in an infinite array.
public class First1InInfiniteBinaryArray {

	private static int firstIndex(int[] arr) {
		int low = 0;
		int high = 1;

		while (arr[high] == 0) {
			low = high;

			if (2 * high < arr.length) {
				high = 2 * high;
			} else {
				high = arr.length - 1;
				break;
			}
		}

		return binarySearch(arr, low, high, 1);
	}

	// Returns first occurrence of 1
	private static int binarySearch(int[] arr, int low, int high, int x) {
		int res = -1;

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

		return res;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 0, 0, 0, 0, 0, 0, 1, 1, 1 };
		System.out.println(firstIndex(arr));
	}

}
