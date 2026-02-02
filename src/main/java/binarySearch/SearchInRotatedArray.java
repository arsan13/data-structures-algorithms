package binarySearch;


//Search for an element in a rotated sorted array.
public class SearchInRotatedArray {
	
	// Search for rotation pivot and perform binary search on either sides of thayt pivot.
	private static int search(int arr[], int n, int key) {
		if(n == 0)
			return -1;
		
		// Zero rotations: Array is sorted, so binary search can be directly applied
		if(arr[0] <= arr[n - 1]) {
			return binarySearch(arr, 0, n - 1, key);
		}
		
		// Find number of times a sorted array is rotated -> Index of rotation point.
		int index = getRotationCount(arr, n);
	
		// low to index - 1 is one sorted array and index to high in another sorted array.
		int res = -1;
		res = binarySearch(arr, 0, index - 1, key);
		if(res < 0) {
			res = binarySearch(arr, index, n - 1, key);
		}
		
		return res;
	}
	
	// Rotation count = index of the minimum element.
	// If array is rotated zero times, then minimum element will be at the 0th index. Hence, count = 0;
	private static int getRotationCount(int[] arr, int n) {		
		int low = 0;
		int high = n - 1;
		
		// Sorted array with zero rotations
		if(arr[low] <= arr[high])
			return 0;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			// To handle out of bound
			int prev = (mid + n -1) % n; 	// Equals to mid -1
			int next = (mid + 1) % n; 		// Equals to mid + 1
			
			// Minimum element will always be present in unsorted part of the array.
			if(arr[mid] >= arr[high]) {	//low to mid is sorted, then move to unsorted sort(mid + 1 to high). 
				low = mid + 1;
			} else if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) { // Element is minimum if it is less than its adjacent neighbors.
				return mid;
			} else if(arr[mid] < arr[high]) {	//mid to high is sorted, then move to unsorted sort(low to mid - 1).	
				high = mid - 1;
			}
		}
		return 0;
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

//		int arr[] = {15, 18, 20, 2, 3, 6, 12};
		int arr[] = {1,0,1,1,1};
		System.out.println(search(arr, arr.length, 0));
	}

}
