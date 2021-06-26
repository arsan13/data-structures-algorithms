package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLaddder {
	
	public static int ladderLength(String beginWord, String endWord, String[] wordList) {
        
		int res = 0;   // number of words required to transform the sequence
        
		Queue<String> queue = new LinkedList<>(); // since, bfs is used
        queue.add(beginWord);
        
        Set<String> words = new HashSet<>();    // for constant time access of words
        for(String s : wordList)
            words.add(s);
        
        if(!words.contains(endWord))      // boundary case
            return 0;
        
        while(!queue.isEmpty()) {
            
            res++;
            
            int size= queue.size();
            for(int i = 0; i < size; i++) {
                String s = queue.poll();   
                
                char[] wordChars = s.toCharArray();
                
                for(int j = 0; j < wordChars.length; j++) {
                    char original = wordChars[j];
                    
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(wordChars[j] == ch)
                            continue;
                        
                        wordChars[j] = ch;
                        String newWord = String.valueOf(wordChars);
                        
                        if(newWord.equals(endWord))
                            return res+1;
                        
                        if(words.contains(newWord)) {
                        	System.out.println(newWord);
                            words.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                    
                    wordChars[j] = original;
                }
                
            }
        }
        
        return 0;
    }
	
	public static void main(String[] args) {
		
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		String beginWord = "hit"; 
		String endWord = "cog";
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
		
//		Start from the given start word.
//		Push the word in the queue
//		Run a loop until the queue is empty
//		Traverse all words that adjacent (differ by one character) to it and push the word in a queue (for BFS)
//		Keep doing so until we find the target word or we have traversed all words.

	}

}
