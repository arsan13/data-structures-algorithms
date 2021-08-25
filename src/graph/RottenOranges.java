package graph;

import java.util.LinkedList;
import java.util.Queue;

//Determine what is the minimum time required so that all the oranges become rotten. 
//A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). 
//If it is impossible to rot every orange then simply return -1.
public class RottenOranges {

	private static int minTime(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int totalOranges = 0;

		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
				if (grid[i][j] != 0) {
					totalOranges++;
				}
			}
		}

		if (totalOranges == 0)
			return 0;

		int time = 0;
		int rottenOranges = 0;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int size = queue.size(); // current number of rotten oranges
			rottenOranges += size;

			for (int i = 0; i < size; i++) { // rot adjacent oranges of all rotten oranges one by one.
				int[] point = queue.poll();

				for (int j = 0; j < 4; j++) { // travel adjacent sides(up,down,left, right)
					int x = point[0] + dx[j];
					int y = point[1] + dy[j];

					if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || grid[x][y] == 2)
						continue;

					grid[x][y] = 2;
					queue.offer(new int[] { x, y });
				}
			}

			if (!queue.isEmpty()) {
				time++;
			}
		}

		return totalOranges == rottenOranges ? time : -1;
	}

	public static void main(String[] args) {

//		0: Empty cell
//		1: Cells have fresh oranges
//		2: Cells have rotten oranges	
		int grid[][] = { { 2, 1, 0, 2, 1 }, 
						 { 1, 0, 1, 2, 1 }, 
						 { 1, 0, 0, 2, 1 } };

		System.out.println(minTime(grid));

	}
}
