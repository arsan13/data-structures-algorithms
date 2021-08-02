package binarySearch;

public class SearchInNearlySortedArray {

	private static int search(int[] arr, int key) {
		if (arr.length == 0)
			return -1;

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < key) {
				low = mid + 2;
			} else if (mid > low && arr[mid - 1] == key) {
				return mid - 1;
			} else if (arr[mid] == key) {
				return mid;
			} else if (mid < high && arr[mid + 1] == high) {
				return mid + 1;
			} else {
				high = mid - 2;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { 3, 2, 10, 4, 40 };
		int key = 4;
		System.out.println(search(arr, key));
	}

}
