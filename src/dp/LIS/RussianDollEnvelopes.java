package dp.LIS;

import java.util.Arrays;

/*
 * - You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * - One envelope can fit into another if and only if both the width and height of one envelope
 *   are STRICTLY greater than the other envelope's width and height.
 * - Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * - Note: You cannot rotate an envelope. 
 */
public class RussianDollEnvelopes {

	private static class Envelope implements Comparable<Envelope> {
		int width;
		int height;

		public Envelope(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public int compareTo(Envelope that) {
			return this.width - that.width;
		}

	}

	// Sort width and find LIS on the basis of height. Reverse will also fetch the same answer.
	private static int maxEnvelopes(int[][] env) {
		int n = env.length;
		
		Envelope[] envelopes = new Envelope[n];
		for(int i = 0; i < n; i++) {
			envelopes[i] = new Envelope(env[i][0], env[i][1]);
		}
		
		Arrays.sort(envelopes);
		
		return lis(envelopes, n);
	}

	// Longest Increasing Subsequence
	private static int lis(Envelope[] envelopes, int n) {
		int dp[] = new int[n];
		dp[0] = 1;
		
		int res = dp[0];
		for(int i = 1; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(envelopes[i].height > envelopes[j].height && envelopes[i].width > envelopes[j].width) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			res = Math.max(res, dp[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {

		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		System.out.println(maxEnvelopes(envelopes));
	}
}