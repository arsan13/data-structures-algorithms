package maths;

public class PalindromeNumber {

	private static boolean palindrome(int n) {
		int temp = n;
		int rev = 0;
		
		while(temp > 0) {
			int rem = temp % 10;
			rev = rev * 10 + rem;
			temp /= 10;
		}
		
		return rev == n;
	}
	
	public static void main(String[] args) {
		
		System.out.println(palindrome(121));
	}

}
