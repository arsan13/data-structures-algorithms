package dp.group1;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static int fibonacci(int n, Map<Integer, Integer> dp) {
		
		if(n == 1 || n == 0)
			return n;
		
		if(dp.containsKey(n))
			return dp.get(n);
		
		int ans = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
		dp.put(n, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		Map<Integer, Integer> dp = new HashMap<>();
		
		int ans = fibonacci(n, dp);
		System.out.println(ans);
//		System.out.println(dp);
	}
}
