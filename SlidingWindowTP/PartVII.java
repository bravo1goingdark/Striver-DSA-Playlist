package SlidingWindowTP;

import java.util.HashMap;
import java.util.Map;

public class PartVII {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinctBetter("aaaabbccd", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            map.clear();

            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstringKDistinctBetter(String s, int k) {
        if (k == 0 || s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char chleft = s.charAt(left);
                map.put(chleft, map.get(chleft) -1);
                if (map.get(chleft) == 0) {
                    map.remove(chleft);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }
    public static int lengthOfLongestSubstringKDistinctOpt(String s, int k) {
        if (k == 0 || s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() > k) {
                char chleft = s.charAt(left);
                map.put(chleft, map.get(chleft) -1);
                if (map.get(chleft) == 0) {
                    map.remove(chleft);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }

}
