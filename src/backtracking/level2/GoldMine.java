package backtracking.level2;

import java.util.ArrayList;
import java.util.List;

public class GoldMine {

	private static int getMaxGold(int[][] mat, int row, int col) {
		int maxGold = 0;
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] != 0 && !visited[i][j]) {
					List<Integer> bag = new ArrayList<>();
					travelAndCollectGold(mat, i, j, visited, bag);
					
					int sum = 0;
					for(int val : bag)
						sum += val;
					
					maxGold = Math.max(maxGold, sum);
				}
			}
		}
		
		return maxGold;
	}
	
	private static void travelAndCollectGold(int[][] mat, int row, int col, boolean[][] visited, List<Integer> bag) {
		
		if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length)
			return;
		
		if(mat[row][col] == 0 || visited[row][col])
			return;
		
		visited[row][col] = true;
		bag.add(mat[row][col]);
		
		travelAndCollectGold(mat, row - 1, col, visited, bag);
		travelAndCollectGold(mat, row + 1, col, visited, bag);
		travelAndCollectGold(mat, row, col - 1, visited, bag);
		travelAndCollectGold(mat, row, col + 1, visited, bag);
	}

	public static void main(String[] args) {
		
		int mat[][] = {{1, 3, 3},
		               {2, 1, 0},
		               {0, 0, 4}};
		
		System.out.println(getMaxGold(mat, 0, 0));
	}
}
