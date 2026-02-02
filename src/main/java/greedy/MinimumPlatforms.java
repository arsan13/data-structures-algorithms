package greedy;

import java.util.Arrays;

public class MinimumPlatforms {

	private static int platforms(int[] arr, int[] dep, int n) {
		
		// Atleast 1 platform is needed
		int platforms = 1; 
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int i = 1; // for arrival
		int j = 0; // for departure
		while(i < n) {
			if(arr[i] <= dep[j]) 
				platforms++;
			else
				j++;
			
			i++;
		}
		
		return platforms;
	}
	
	public static void main(String[] args) {

		int n = 6;
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		
		System.out.println(platforms(arr, dep, n));
	}
}
