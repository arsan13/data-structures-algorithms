package sorting;

public class QuickSort 
{
	public static void quickSort(int arr[], int low, int high)
	{
		if(low < high) 
		{
			int pos = partition(arr, low, high);
			quickSort(arr, low, pos-1);
			quickSort(arr, pos+1, high);
		}
	}
	
	private static int partition(int arr[], int low, int high)
	{
		int pivot = arr[low];
		int i = low;
		int j = high;
		
		while(i < j) {
			
			while(arr[i] <= pivot && i < high)
				i++;
			
			while(arr[j] > pivot && j >= 0)
				j--;
			
			if(i < j)
				swap(arr, i, j);
		}
		swap(arr, j, low);
		
		return j;
	}
	
//	private static int partition(int arr[], int low, int high)
//	{
//		int pivot  = arr[high];
//		int i = low - 1;
//		
//		for (int j = low; j < high; j++) 
//		{
//			if(arr[j] <= pivot) {
//				i++;
//				swap(arr, i, j);
//			}
//		}
//		swap(arr, i+1, high);
//		
//		return i+1;
//	}
	
	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		int arr[] = { 4,  6, 1, 8, 2 };
		
		quickSort(arr, 0, n-1);
		
		for(int i : arr)
			System.out.println(i);
	}
}
