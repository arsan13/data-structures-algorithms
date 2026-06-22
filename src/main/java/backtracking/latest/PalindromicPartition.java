package backtracking.latest;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {

    public static void main(String[] args) {
        String str = "aabb";
        System.out.println(palindromePartition(str));
    }

    public static List<List<String>> palindromePartition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        palindromePartition(s, 0, list, res);

        return res;
    }

    private static void palindromePartition(String str, int index, List<String> list, List<List<String>> res) {
        if (index == str.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            String prefix = str.substring(index, i + 1);
            if (isPalindrome(prefix)) {
                list.add(prefix);
                palindromePartition(str, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String prefix) {
        int left = 0;
        int right = prefix.length() - 1;
        while (left < right) {
            if (prefix.charAt(left++) != prefix.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
