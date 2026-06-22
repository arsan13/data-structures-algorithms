package binarySearch;

public class SearchInInfiniteArray {

	private static int search(int[] arr, int key) {
		int low = 0;
		int high = 1;
		int val = arr[0];
		
		while(val < key) {
			low = high;
			
			if(2*high < arr.length) {
				high = 2 * high;
			} else {
				high = arr.length - 1;
			}
			
			val = arr[high];
		}
		
		return binarySearch(arr, low, high, key);
	}
	
	// Standard binary search
	private static int binarySearch(int[] arr, int low, int high, int x) {
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
	
	public static void main(String[] args) {

		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int key = 100;
		System.out.println(search(arr, key));
	}

}
