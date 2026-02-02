package binarySearch;

public class BinarySearch {

	private static int iterative(int[] arr, int x) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < x) {
				low = mid + 1;
			} else if (arr[mid] == x) {
				return mid;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private static int recursive(int[] arr, int low, int high, int x) {
		if (low > high)
			return -1;

		int mid = low + (high - low) / 2;
		if (arr[mid] < x) {
			return recursive(arr, mid + 1, high, x);
		} else if (arr[mid] == x) {
			return mid;
		} else {
			return recursive(arr, low, mid - 1, x);
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		int x = 5;

		System.out.println(iterative(arr, x));
		System.out.println(recursive(arr, 0, arr.length - 1, x));
	}
}
