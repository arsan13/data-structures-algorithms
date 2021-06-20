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