package sorting;

public class InsertionSort {
	
	public static void insertionSort(int arr[], int n) {
		
		for(int i = 1; i < n; i++) {
			
			int temp = arr[i];
			int j = i - 1; 
			
			while(j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		int arr[] = { 4,  6, 1, 8, 2 };
		
		insertionSort(arr, n);
		
		for(int i : arr)
			System.out.println(i);
	}
}
