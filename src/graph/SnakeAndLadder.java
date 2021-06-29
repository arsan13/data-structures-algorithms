package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeAndLadder {

	static int minThrow(int N, int arr[]){
        
        Map<Integer, Integer> snakeOrLadder = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[31];
        
        for(int i = 0; i < 2*N; i = i+2)
            snakeOrLadder.put(arr[i], arr[i+1]);
        
        visited[1] = true;
        queue.add(1);
        
        int moves = 0;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                if(curr == 30)
                    return moves;
                    
                for(int j = curr+1; j <= curr+6; j++) {
                    
                    if(j > 30)
                        break;
                        
                    if(!visited[j]) {
                        visited[j] = true;
                        
                        if(snakeOrLadder.containsKey(j))
                            queue.add(snakeOrLadder.get(j));
                        else
                            queue.add(j);
                    }
                }
            }
            
            moves++;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {

		// N: number of snakes and ladders
		// arr: an array of 2*N size where 2*i and (2*i + 1)th values denote the 
		// 		starting and ending point respectively of ith snake or ladder.
		
		int N = 8;
		int[] arr = {3, 22, 5, 8, 11, 26, 20, 29, 
			       17, 4, 19, 7, 27, 1, 21, 9};
		
		System.out.println(minThrow(N, arr));
	}
}
