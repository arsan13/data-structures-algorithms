package maths;

import java.util.Arrays;

public class PrimeNumber {

	private static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

//	Sieve of Eratosthenes | O(n*log(log n)) time
	private static void primesTillN(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, 2, primes.length, true);

		for (int i = 2; i * i <= n; i++) {
			if (primes[i] == true) {

				for (int j = 2 * i; j <= n; j = j + i) {
					primes[j] = false;
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			if (primes[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {

		int n = 24;
		System.out.println(isPrime(n));
		System.out.println("Prime numbers till " + n);
		primesTillN(n);
	}

}
