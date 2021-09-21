package stack;

import java.util.Stack;

// Link of the problem statement: 
// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
public class CelebrityProblem {

	static int celebrity(int M[][], int n){
        
        Stack<Integer>stack = new Stack<>();
        
        for(int i = 0; i < n; i++)
            stack.push(i);
        
        while(stack.size() >=2 )
        {
            int i = stack.pop();
            int j = stack.pop();
            
            if(M[i][j] == 1)
               stack.push(j);   // if i knows j, i is not a celebrity
            else
                stack.push(i);   // if i doesn't know j, j is not a celebrity
        }
        
        int potential = stack.pop();
        
        for(int i = 0; i < n; i++)
        {
            if(i == potential)
                continue;
            if(M[potential][i] == 1 || M[i][potential] == 0)
                return -1;
        }
        
        return potential;
    }
	
	public static void main(String[] args) {
		
		int n = 3;
		int M[][] = {{0, 1, 0},
			         {0, 0, 0}, 
			         {0, 1, 0}};
		
		System.out.println(celebrity(M, n));
	}
}
