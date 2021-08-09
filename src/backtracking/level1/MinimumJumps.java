package backtracking.level1;

public class MinimumJumps {

	private static int minJumps(int src, int dest, int arr[]) {
		if (src == dest)
			return 0;
		if (arr[src] == 0)
			return Integer.MAX_VALUE;
		
		int res = Integer.MAX_VALUE;
		for (int i = src + 1; i <= src + arr[src] && i <= dest; i++) {
			int jumps = minJumps(i, dest, arr);
			res = Math.min(res, jumps + 1);
		}
		return res;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(minJumps(0, arr.length - 1, arr));
	}

}
