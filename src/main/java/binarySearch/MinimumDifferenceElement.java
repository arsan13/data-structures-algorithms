package binarySearch;

//Find the element in the sorted array which has minimum difference with the given number.
public class MinimumDifferenceElement {

	// If the key is present in the array, then the minimum difference will be 0.
	// Else, the minimum difference will be the difference between key and minimum
	// of floor and ceil of the key;
	private static int minDiff(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < key) {
				low = mid + 1;
			} else if (arr[mid] == key) {
				return 0;
			} else {
				high = mid - 1;
			}
		}

		int diffWithFloor = Math.abs(arr[high] - key);
		int diffWithCeil = Math.abs(arr[low] - key);

		return Math.min(diffWithFloor, diffWithCeil);
	}

	public static void main(String[] args) {

		int key = 12;
		int arr[] = { 2, 5, 8, 10, 15, 16 };
		System.out.println(minDiff(arr, key));
	}

}
