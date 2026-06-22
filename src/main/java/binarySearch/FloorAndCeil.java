package binarySearch;

// Find floor and ceil of the given element in a sorted array.
public class FloorAndCeil {

	private static void find1(int arr[], int key) {
		int ceil = 0;
		int floor = 0;
		
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < key) {
				floor = arr[mid];
				low = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("Floor: " + arr[mid]);
				System.out.println("Ceil: " + arr[mid]);
				return;
			} else {
				ceil = arr[mid];
				high = mid - 1;
			}
		}
		
		System.out.println("Floor: " + floor);
		System.out.println("Ceil: " + ceil);
	}

	// At the end of the while loop, if key is not present in the array,
	// low pointer would be pointing to the index of ceil value of the key and high
	// pointer to the floor value.
	private static void find2(int arr[], int key) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] < key) {
				low = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("Floor: " + arr[mid]);
				System.out.println("Ceil: " + arr[mid]);
				return;
			} else {
				high = mid - 1;
			}
		}

		System.out.println("Floor: " + arr[high]);
		System.out.println("Ceil: " + arr[low]);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int key = 5;

		find1(arr, key);
		find2(arr, key);
	}

}
