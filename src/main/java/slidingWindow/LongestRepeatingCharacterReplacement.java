package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    // Formula: length - maxOccuringFreq

    private static int characterReplacementBrute(String s, int k) {
        int n = s.length();
        int res = 0;

         for(int i = 0; i < n; i++) {
             int maxFreq = 0;
             Map<Character, Integer> map = new HashMap<>();

             for(int j = i; j <n; j++) {
                 char ch = s.charAt(j);
                 map.put(ch, map.getOrDefault(ch, 0) + 1);
                 maxFreq = Math.max(maxFreq, map.get(ch));

                 int changes = (j - i + 1) - maxFreq;
                 if(changes <= k) {
                     res = Math.max(res, j - i + 1);
                 } else {
                     break;
                 }
             }
         }

         return res;
    }

    private static int characterReplacementOptimized(String s, int k) {
        int n = s.length();
        int res = 0;

        int maxFreq = 0;
        // int[] freq = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        while(j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            // while((j - i + 1) - maxFreq > k) {
            if((j - i + 1) - maxFreq > k) {
                ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                // for(int l = 0; l < 26; l++) {
                //     maxFreq = Math.max(maxFreq, freq[l]);
                // }
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "AAABBCCD";
        int k = 2;

        int ans = characterReplacementBrute(s, k);
        System.out.println(ans);
    }
}
