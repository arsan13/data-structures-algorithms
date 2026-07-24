package graph;


public class NumberOfIslands {

	public static int numIslands(int[][] grid)
    {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    traverse(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    private static void traverse(int[][] grid, int i, int j) {
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;
        
        if(grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        traverse(grid, i+1, j);
        traverse(grid, i-1, j);
        traverse(grid, i, j-1);
        traverse(grid, i, j+1);
    }

    // Without mutating given grid
    public int numIslands(char[][] grid) {

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row - 1, col, grid, visited);
        dfs(row, col + 1, grid, visited);
        dfs(row + 1, col, grid, visited);
        dfs(row, col - 1, grid, visited);
    }
	
	public static void main(String[] args) {
    	
    	int m[][] = {
    			{1, 0, 0, 0},
    	        {1, 1, 0, 1}, 
    	        {1, 1, 0, 0},
    	        {0, 0, 1, 1}
    	       };
    			    	
    	System.out.println(numIslands(m));
    }
}