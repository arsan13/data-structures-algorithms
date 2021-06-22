package sorting;

public class MergeSort 
{
	public static void mergeSort(int arr[], int low, int high)
	{
		if(low < high)
		{
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) 
	{
		int n1 = mid - low + 1; 
		int n2 = high - mid;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for (int i = 0; i < n1; i++)
			L[i] = arr[low + i];
		for (int j = 0; j < n2; j++)
			R[j] = arr[mid +1 + j];
		
		int i = 0, j = 0;
		
		int k = low;
		while(i < n1 && j < n2)
		{
			if(L[i] <= R[j])
				arr[k] = L[i++];
			else
				arr[k] = R[j++];
			k++;
		}	
		
		while( i < n1)
			arr[k++] = L[i++];
		
		while(j < n2)
			arr[k++] = R[j++];
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		int arr[] = { 4,  6, 1, 8, 2 };
		
		mergeSort(arr, 0, n-1);
		
		for(int i : arr)
			System.out.println(i);
	}
}
