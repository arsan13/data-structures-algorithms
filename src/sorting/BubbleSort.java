package sorting;

public class BubbleSort {

    static void bubbleSortIterative(int arr[], int n) 
    {
    	boolean swapped = false;
    	
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                swapped = true;
            }
            if(!swapped) 	// optimising bubble sort
            	break;
        }
    }
	
    static void bubbleSortRecursive(int arr[], int n) 
    {	
    	
        if (n == 1)
            return;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }       
        }
        bubbleSortRecursive(arr, n - 1);
    }
    
	public static void main(String[] args) {
		
		int n = 5;
		int arr[] = { 4,  6, 1, 8, 2 };
		
		bubbleSortIterative(arr, n);
//		bubbleSortRecursive(arr, n);
		
		for(int i : arr)
			System.out.println(i);
	}
}





