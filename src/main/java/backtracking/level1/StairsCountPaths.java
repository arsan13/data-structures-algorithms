package backtracking.level1;

public class StairsCountPaths {

	/*
	 * The person can reach nth stair from either (n-1)th stair or from (n-2)th
	 * stair. Hence, for each stair n, we try to find out the number of ways to
	 * reach n-1th stair and n-2th stair and add them to give the answer for the nth
	 * stair. Therefore the expression for such an approach comes out to be :
	 * ways(n) = ways(n-1) + ways(n-1) Which is actually a fibonacci formula.
	 */
	
	// Upto 2 steps allowed
	public static int countForMaxOfTwo(int n) {
		return fibForTwo(n + 1);
		
//		int mod = 1000000007; // Passing for all test cases
//        int a = 0;
//        int b = 1;
//        int c;
//        
//        for(int i = 2; i <= n+1; i++) {
//            c = (a % mod + b % mod) % mod;
//            a = b;
//            b = c;
//        }
//        
//        return b;
	}

	private static int fibForTwo(int n) {
		if (n <= 1)
			return n;
		return fibForTwo(n - 1) + fibForTwo(n - 2);
	}
	
	public static int countForMaxOfThree(int n) {
		if(n == 1 || n == 0)
			return 1;
		if( n == 2)
			return 2;
		return countForMaxOfThree(n-3) + countForMaxOfThree(n-2) + countForMaxOfThree(n-1); 
	}
	
	// Upto m steps are allowed
	static int countWaysforMaxUptoM(int n, int m)
    {
        return fibForM(n + 1, m);
    }
	
	static int fibForM(int n, int m)
    {
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += fibForM(n - i, m);
        return res;
    }    

	public static void main(String[] args) {

		System.out.println("Number of ways if 2 skips are allowed: " + countForMaxOfTwo(4));
		System.out.println("Number of ways if 3 skips are allowed: " + countForMaxOfThree(4));
		System.out.println("Number of ways if m skips are allowed: " + countWaysforMaxUptoM(4, 3));

	}

}
