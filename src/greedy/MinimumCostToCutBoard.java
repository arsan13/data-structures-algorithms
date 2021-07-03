package greedy;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCostToCutBoard {

	private static int minimumCostOfBreaking(Integer[] x, Integer[] y, int m, int n) {
		int res = 0;
		int vertical = 1;
		int horizontal = 1;
		
		Arrays.sort(x, Collections.reverseOrder());
		Arrays.sort(y, Collections.reverseOrder());
		
		int i = 0;
		int j = 0;
		
		while(i < m && j < n) {
			if(x[i] > y[j]) {
				res += x[i] * vertical;
				horizontal++;
				i++;
			}
			else {
				res += y[j] * horizontal;
				vertical++;
				j++;
			}
		}
		
		int temp = 0;
		while(i < m)
			temp += x[i++];
		res += temp * vertical;
		
		temp = 0;
		while(j < n)
			temp += y[j++];
		res += temp * horizontal;
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int m = 6, n = 4;
        Integer X[] = {2, 1, 3, 1, 4};
        Integer Y[] = {4, 1, 2};
        System.out.print(minimumCostOfBreaking(X, Y, m-1, n-1));
	}
}
