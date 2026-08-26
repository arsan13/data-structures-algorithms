package graph.group3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Collections.singleton(beginWord)));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> visited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> list = queue.poll();
                String word = list.getLast();

                if (word.equals(endWord)) {
                    result.add(list);
                    continue;
                }

                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        if (c == original) {
                            continue;
                        }

                        String newWord = String.valueOf(chars);
                        if (wordSet.contains(newWord)) {
                            visited.add(newWord);
                            List<String> newPath = new ArrayList<>(list);
                            newPath.add(newWord);
                            queue.add(newPath);
                        }
                    }

                    chars[j] = original;
                }
            }

            wordSet.removeAll(visited);
        }

        return result;
    }

    public static void main(String[] args) {
        final List<List<String>> ladders = new WordLadder2().findLadders(
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladders);
    }
}
