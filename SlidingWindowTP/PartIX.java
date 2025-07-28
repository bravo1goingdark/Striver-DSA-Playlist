package SlidingWindowTP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PartIX {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 2));
    }

    public static int characterReplacement(String s, int k) {

        int len = 0;
        int count = 0;


        for (int i = 0; i < s.length(); i++) {
            int maxFreq = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                maxFreq = Math.max(maxFreq, map.get(ch));
                int changes = (j - i + 1) - maxFreq;

                if (changes <= k) {
                    len = Math.max(len, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return len;
    }
    public static int characterReplacementOpt(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowSize = right - left + 1;
            int replacementsNeeded = windowSize - maxFreq;

            if (replacementsNeeded > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
