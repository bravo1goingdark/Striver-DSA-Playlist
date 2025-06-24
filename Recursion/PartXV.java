package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PartXV {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void partition(String s, int index, List<String> curr, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                partition(s, i + 1, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str, int f, int s) {
        while (f <= s) {
            if (str.charAt(f) != str.charAt(s)) {
                return false;
            }
            f++;
            s--;
        }
        return true;
    }
}
