package sorting;

public class SelectionSort {
	
	private static void selectionSort(int[] arr, int n) {
		
		for(int i = 0; i < n-1; i++) {
			int min = i;
			for(int j = i+1; j < n; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			
			if(min != i)	// if condition is optional, used to optimize alg by avoiding swap if minimum remains same
				swap(arr, i, min);
		}
	}
	
	private static void swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}

	public static void main(String[] args) {
		
		int n = 5;
		int arr[] = { 4,  6, 1, 8, 2 };
		
		selectionSort(arr, n);
		
		for(int i : arr)
			System.out.println(i);
	}
}
