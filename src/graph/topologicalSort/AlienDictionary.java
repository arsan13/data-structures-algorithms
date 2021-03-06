package graph.topologicalSort;

import java.util.ArrayList;

//Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. 
//Find the order of characters in the alien language.
public class AlienDictionary {
	
	public static String findOrder(String [] dict, int n, int k)
    {
        // build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < k; i++)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < n-1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];
            
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        // do topological sort
        boolean visited[] = new boolean[k];
        String ans = "";
        
        for(int i = 0; i < k; i++) {
            if(!visited[i])
                dfs(i, adj, visited, ans);
        }
        
        return ans;
    }
    
    private static void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, String ans) {
        
        visited[src] = true;
        
        for(int neighbour : adj.get(src)) {
            if(!visited[neighbour])
                dfs(neighbour, adj, visited, ans);
        }
        
        char ch = (char)(src + 'a');
        ans = ans + ch;
        System.out.println(ans);
    }
    
		
    public static void main(String[] args) {
		
    	int n = 5;
		int k = 4;
		
		String[] dict = {"baa","abcd","abca","cab","cad"};
		
		String ans = findOrder(dict, n, k);
		
		System.out.println(ans);
	}

}
