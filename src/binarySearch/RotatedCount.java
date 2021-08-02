package binarySearch;

//Find number of times a sorted array is rotated.
//Find minimum in a rotated sorted array.
public class RotatedCount {

	// Rotation count = index of the minimum element.
	// If array is rotated zero times, then minimum element will be at the 0th index. Hence, count = 0;
	// Linear Search: O(N), Binary Search: O(logN)
	private static int getCount(int[] arr, int n) {		
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
			if(arr[mid] > arr[high]) {	//low to mid is sorted, then move to unsorted sort(mid + 1 to high). 
				low = mid + 1;
			} else if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) { // Element is minimum if it is less than its adjacent neighbors.
				return mid;
			} else if(arr[mid] < arr[high]) {	//mid to high is sorted, then move to unsorted sort(low to mid - 1).	
				high = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		int arr[] = {15, 18, 20, 2, 3, 6, 12};
		System.out.println(getCount(arr, arr.length));
	}

}
