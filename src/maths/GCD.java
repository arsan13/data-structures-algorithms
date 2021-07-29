package maths;

public class GCD {

	private static int gcd(int a, int b) {

//		if (b == 0)
//			return a;
//		return gcd(b, a % b);
		
		int res = 0;
		while(b > 0) {
			res = a;
			a = b;
			b = a % b;
		}
		return res;
	}

	public static void main(String[] args) {

		System.out.println(gcd(5, 15));
	}

}
