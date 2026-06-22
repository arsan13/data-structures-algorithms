package greedy;

/*
1. If there are even number of negative numbers and no zeros, result is simply product of all
2. If there are odd number of negative numbers and no zeros, result is product of all except maximum negative number.
3. If there are zeros, result is product of all except these zeros with one exceptional case. 
   The exceptional case is when there is one negative number and all other elements are 0. In this case, result is 0.
*/
public class MaximumProduct {

	private static int maxProductSubset(int[] arr, int n) {
		
		if(n == 1)
			return arr[0];
		
		int product = 1;
		
		int maxNegative = Integer.MIN_VALUE;
		int negativeCount = 0;
		int zeroCount = 0;
		
		for(int item : arr) {
			
			if(item == 0) {
				zeroCount++;
				continue;
			}
			
			if(item < 0) {
				negativeCount++;
				maxNegative = Math.max(maxNegative, item);
			}
			
			product *= item;
		}
		
		if(zeroCount == n)
			return 0;
		
//		One negative number and all other elements are 0
		if(negativeCount == 1 && zeroCount+negativeCount == n)
			return 0;
		
		if(negativeCount % 2 != 0)
			product /= maxNegative;
		
		return product;
	}
	
	public static void main(String[] args) {

		int a[] = {-1, -1, -2, 4, 3};
        int n = a.length;
        
        System.out.println(maxProductSubset(a, n));
 
	}
}
