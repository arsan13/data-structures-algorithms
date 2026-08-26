package graph.group3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

    // Time: wordList.len * word.len * 26
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        if(!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int steps = pair.step;

            if (word.equals(endWord)) {
                return steps;
            }

            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) {
                        continue;
                    }
                    chars[i] = c;
                    String newWord = String.valueOf(chars);

                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        queue.add(new Pair(newWord, steps + 1));
                    }
                }
                chars[i] = original;
            }
        }

        return 0;
    }

    private record Pair(String word, int step) {}
}
