package SlidingWindowTP;

import java.util.HashMap;
import java.util.Map;

public class PartIV {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            if (map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
            }
            max = Math.max(max, r - l + 1);
            map.put(ch, r);
            r++;
        }
        return max;
    }
}
