package maths;

public class CountTrailingZeroes {

	private static int count(int n) {
		int count = 0;
		for (int i = 5; i <= n; i = i * 5) {
			count += n / i;
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(count(25));
	}

}
