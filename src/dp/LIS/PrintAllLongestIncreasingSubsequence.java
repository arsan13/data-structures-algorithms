package dp.LIS;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllLongestIncreasingSubsequence {

	private static class Node {
		int index;
		int length;
		int value;
		String path;
		
		public Node(int index, int length, int value, String path) {
			this.index = index;
			this.length = length;
			this.value = value;
			this.path = path;
		}
	}
	
	private static void lis(int[] arr, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		
		int resValue = dp[0];
		int resIndex = 0;
		for(int i = 1; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			
			if(resValue < dp[i]) {
				resValue = dp[i];
				resIndex = i;
			}
		}
		
		//BFS
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(resIndex, resValue, arr[resIndex], arr[resIndex] + " "));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.length == 1)
				System.out.println(node.path);
			
			for(int i = 0; i < node.index; i++) {
				if(dp[i] == node.length - 1 && arr[i] < node.value) {
					queue.add(new Node(i, dp[i], arr[i], arr[i] + "->" + node.path));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {50, 3, 10, 7, 40, 80};
		int n = arr.length;
		
		lis(arr, n);
	}

}
