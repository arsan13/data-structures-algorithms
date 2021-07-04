package sorting;

public class HeapSort {

	// Max-heap: increasing order
	// Min-heap: decreasing order

	public static void heapSort(int[] arr, int n) {

		for (int i = n / 2 - 1; i >= 0; i--) { // Heapify only parent nodes
			heapify(arr, i, n);
		}

		for (int i = n - 1; i >= 0; i--) {
			swap(arr, i, 0);
			heapify(arr, 0, i);
		}
	}

	private static void heapify(int[] arr, int i, int n) {
		int largest = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		if (leftChild < n && arr[largest] < arr[leftChild])
			largest = leftChild;
		if (rightChild < n && arr[largest] < arr[rightChild])
			largest = rightChild;

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, n);
		}
	}

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {

		int n = 5;
		int arr[] = { 4, 6, 1, 8, 2 };

		heapSort(arr, n);

		for (int i : arr)
			System.out.print(i + " ");
	}
}
