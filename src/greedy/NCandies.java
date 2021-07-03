package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class NCandies {

	static ArrayList<Integer> candyStore(int candies[], int N, int K) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int minAmt = 0;
		int maxAmt = 0;

		// Min
		Arrays.sort(candies);

		int start = 0;
		int end = N - 1;
		while (start <= end) {
			minAmt += candies[start];
			start++;
			end = end - K;
		}

		// Max
		// Reverse the above sorted array
		for (int i = 0, j = N - 1; i < j; i++, j--) {
			int tmp = candies[i];
			candies[i] = candies[j];
			candies[j] = tmp;
		}

		start = 0;
		end = N - 1;
		while (start <= end) {
			maxAmt += candies[start];
			start++;
			end = end - K;
		}

		list.add(minAmt);
		list.add(maxAmt);

		return list;
	}

	public static void main(String[] args) {

		int N = 4;
		int K = 2;
		int candies[] = { 3, 2, 1, 4 };
		
		ArrayList<Integer> list = candyStore(candies, N, K);
		System.out.println(list);
	}

}
