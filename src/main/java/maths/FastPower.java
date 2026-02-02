package maths;

public class FastPower {

	private static long power(int a, int b) {
//		int res = 1;
//		while(a > 0) {
//			if((b&1) != 0 )	// b is odd
//				res = res * a;
//			a = a* a;
//			b = b >> 1;		// b divide by 2
//		}
//		return res;
		
		if(b == 0)
			return 1;
		
		if((b&1) != 0) { // b is odd
			return a * power(a, b >> 1) * power(a, b >> 1);
		} else {
			return power(a, b >> 1) * power(a, b >> 1);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(power(3, 5));
	}

}
